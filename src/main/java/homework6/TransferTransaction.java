package homework6;

import homework6.type.TransactionType;

public class TransferTransaction extends Transaction {
    final int receiverId;

    public TransferTransaction(int clientId, double amount, int receiverId) {
        super(clientId, amount, TransactionType.TRANSFER);
        this.receiverId = receiverId;
    }

    @Override
    public void process(Bank bank) {
        bank.transfer(clientId, receiverId, amount);
        bank.notifyObservers("Перевод средств: Отправитель: " + clientId +
                ", Получатель: " + receiverId + ", сумма: " + amount);
    }
}
