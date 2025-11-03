package homework6;

import homework6.type.TransactionType;

public abstract class Transaction {
    final int clientId;
    final double amount;
    final TransactionType transactionType;

    public Transaction(int clientId,
                       double amount,
                       TransactionType transactionType) {
        this.amount = amount;
        this.clientId = clientId;
        this.transactionType = transactionType;
    }

    public abstract void process(Bank bank);
}
