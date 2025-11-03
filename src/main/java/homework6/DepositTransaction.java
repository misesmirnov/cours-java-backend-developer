package homework6;

import homework6.type.TransactionType;

public class DepositTransaction extends Transaction {

    public DepositTransaction(int clientId,
                              double amount) {
        super(clientId, amount, TransactionType.DEPOSIT);
    }

    @Override
    public void process(Bank bank) {
        Client client = bank.getClient(clientId);
        client.deposit(amount);
        bank.notifyObservers("Пополнение: клиент " + clientId + ", сумма: " + amount);
    }
}
