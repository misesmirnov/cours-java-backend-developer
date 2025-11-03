package homework6;

import homework6.type.TransactionType;

public class TakeOffTransaction extends Transaction {

    public TakeOffTransaction(int clientId,
                              double amount) {
        super(clientId, amount, TransactionType.TAKE_OFF);
    }

    @Override
    public void process(Bank bank) {
        Client client = bank.getClient(clientId);
        client.takeOff(amount);
        bank.notifyObservers("Списание: клиент " + clientId + ", сумма: " + amount);
    }
}
