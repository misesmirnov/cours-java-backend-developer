package homework6;

import homework6.type.Currency;

import static homework6.type.Currency.EUR;
import static homework6.type.Currency.USD;

public class BankDemo {
    public static void main(String[] args) throws InterruptedException {
        // Создаем банк с 3 кассами
        Bank bank = new Bank(3);

        //добавляем клиентов
        bank.addClient(new Client(1, USD, 1000.0));
        bank.addClient(new Client(2, USD, 2000.0));
        bank.addClient(new Client(3, EUR, 3000.0));
        bank.addClient(new Client(4, EUR, 4000.0));


        // Добавляем транзакции
        bank.addTransaction(new DepositTransaction(1, 200.0));
        bank.addTransaction(new TakeOffTransaction(2, 100.0));
        bank.addTransaction(new DepositTransaction(3, 200.0));
        bank.addTransaction(new TakeOffTransaction(4, 100.0));
        bank.addTransaction(new TransferTransaction(1, 150.0, 2));
        bank.addTransaction(new TransferTransaction(2, 250.0, 1));
        bank.addTransaction(new TransferTransaction(3, 350.0, 4));
        bank.addTransaction(new TransferTransaction(4, 350.0, 3));
        bank.addTransaction(new ExchangeTransaction(3, 100.0, Currency.EUR, Currency.USD));
        bank.addTransaction(new ExchangeTransaction(4, 10.0, Currency.USD, Currency.EUR));

        //Время работы банка
        Thread.sleep(10000);

        //закрываем банк
        bank.closeBank();
    }
}
