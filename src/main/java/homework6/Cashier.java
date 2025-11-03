package homework6;

public class Cashier extends Thread {
    private final int id;
    private final Bank bank;
    private volatile boolean running;

    public Cashier(int id,
                   Bank bank) {
        this.id = id;
        this.bank = bank;
        this.running = true;
    }

    @Override
    public void run() {
        bank.notifyObservers("Касса с id " + id + " начала работу");

        while (running) {
            try {
                Transaction transaction = bank.getNextTransaction();
                transaction.process(bank);
            } catch (InterruptedException e) {
                bank.notifyObservers("Касса " + id + " была прервана");
                break;
            } catch (Exception e) {
                bank.notifyObservers("Касса " + id + " ошибка: " + e.getMessage());
            }
        }
        bank.notifyObservers("Касса " + id + " завершила работу");
    }

    public void stopCashier() {
        running = false;
        this.interrupt();
    }
}
