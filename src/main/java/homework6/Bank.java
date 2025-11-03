package homework6;

import homework6.type.Currency;

import java.util.List;
import java.util.concurrent.*;

import static homework6.type.Currency.EUR;
import static homework6.type.Currency.USD;

public class Bank implements Subject {

    private final ConcurrentHashMap<Integer, Client> clients;
    private final ConcurrentHashMap<String, Double> exchangeRates;
    private final BlockingQueue<Transaction> transactionQueue;
    private final List<Cashier> cashiers;
    private final List<Observer> observers;
    private final ScheduledExecutorService scheduler;

    public Bank(int cashiersCount) {
        this.clients = new ConcurrentHashMap<>();
        this.exchangeRates = new ConcurrentHashMap<>();
        this.transactionQueue = new LinkedBlockingQueue<>();
        this.cashiers = new CopyOnWriteArrayList<>();
        this.observers = new CopyOnWriteArrayList<>();

        //Устанавливаем исходные курсы валют
        initializeExchangeRates();
        this.scheduler = Executors.newScheduledThreadPool(1);
        scheduler.scheduleAtFixedRate(this::updateExchangeRates,
                0,
                1,
                TimeUnit.SECONDS);

        //логирование
        registerObserver(new Logger());

        //Кассы
        for (int i = 1; i <= cashiersCount; i++) {
            Cashier cashier = new Cashier(i, this);
            cashiers.add(cashier);
            cashier.start();
        }

    }

    public Client getClient(int clientId) {
        Client client = clients.get(clientId);
        if (client == null) {
            throw new IllegalArgumentException("Клиент с ID " + clientId + " не найден");
        }
        return client;
    }

    @Override
    public void notifyObservers(String message) {
        observers.forEach(x -> x.update(message));
    }

    @Override
    public void registerObserver(Observer o) {
        observers.add(o);
    }

    @Override
    public void removeObserver(Observer o) {
        observers.remove(o);
    }

    public void transfer(int clientId, int receiverId, double amount) {
        Client sender = getClient(clientId);
        Client receiver = getClient(receiverId);

        Object firstLock = clientId > receiverId ? sender : receiver;
        Object secondLock = clientId > receiverId ? receiver : sender;

        synchronized (firstLock) {
            synchronized (secondLock) {
                sender.takeOff(amount);
                receiver.deposit(amount);
            }
        }

        notifyObservers("Перевод выполнен: клиент " + clientId + " -> клиент " + receiverId + ", сумма: " + amount);
    }

    public void addTransaction(Transaction transaction) {
        transactionQueue.add(transaction);
        notifyObservers("Транзакция добавлена в очередь: " + transaction.transactionType);
    }

    public void addClient(Client client) {
        clients.put(client.getId(), client);
        notifyObservers("Добавлен Клиент : " + client.getId());
    }

    public double getExchangeRate(Currency from, Currency to) {
        return exchangeRates.get(from.name() + to.name());
    }

    public void exchange(int clientId,
                         Currency from,
                         Currency to,
                         double amount) {
        //поиск клиента
        Client client = getClient(clientId);
        //запрос курса
        double rate = getExchangeRate(from, to);
        //расчет суммы после конвертации валют
        double convertedAmount = amount * rate;
        //меняем баланс клиента
        synchronized (client) {
            if (client.getBalance() < amount) {
                throw new ArithmeticException("Недостаточно средств для обмена");
            }
            client.takeOff(amount);
            client.deposit(convertedAmount);
        }

        notifyObservers("Обмен валют: клиент " + clientId + " конвертировал " + amount +
                " " + from + " в " + convertedAmount + " " + to + " по курсу " + rate);


    }

    public Transaction getNextTransaction() throws InterruptedException {
        return transactionQueue.take();
    }

    public void closeBank() {
        notifyObservers("Запуск процедуры закрытия банка...");
        //останавливаем кассы
        cashiers.forEach(Cashier::stopCashier);
        //закрываем обновление курсов
        scheduler.shutdown();
        notifyObservers("Банк закрыт");
    }

    private void initializeExchangeRates() {
        exchangeRates.put(USD.name() + EUR.name(), 0.9);
        exchangeRates.put(EUR.name() + USD.name(), 1.1);
    }

    private void updateExchangeRates() {
        try {
            exchangeRates.replaceAll((x, value) -> value + 0.001);
            notifyObservers("Курсы валют обновлены: " + exchangeRates);
        } catch (Exception e) {
            notifyObservers("Ошибка при обновлении курса валют: " + e.getMessage());
        }
    }
}
