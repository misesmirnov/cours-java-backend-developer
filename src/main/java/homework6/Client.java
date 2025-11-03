package homework6;

import homework6.type.Currency;

public class Client {
    final int id;
    final Currency currency;
    double balance;

    public Client(int id, Currency currency, double balance) {
        this.balance = balance;
        this.currency = currency;
        this.id = id;
    }

    synchronized void deposit(double amount) {
        balance = balance + amount;
    }

    synchronized void takeOff(double amount) {
        if (balance >= amount) {
            balance = balance - amount;
        } else {
            throw new ArithmeticException("Баланс клинта меньше суммы списания");
        }
    }

    public double getBalance() {
        return balance;
    }

    public Currency getCurrency() {
        return currency;
    }

    public int getId() {
        return id;
    }

}
