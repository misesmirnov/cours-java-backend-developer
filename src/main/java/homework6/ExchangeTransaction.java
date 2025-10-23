package homework6;

import homework6.type.Currency;
import homework6.type.TransactionType;

public class ExchangeTransaction extends Transaction {
    final Currency from;
    final Currency to;

    public ExchangeTransaction(int clientId,
                               double amount,
                               Currency from,
                               Currency to) {
        super(clientId, amount, TransactionType.EXCHANGE);
        this.from = from;
        this.to = to;
    }

    @Override
    public void process(Bank bank) {
        bank.exchange(clientId, from, to, amount);
        bank.notifyObservers("Обмен валют: клиент " + clientId + ", " +
                from.name() + ", " + to.name() + ", сумма: " + amount);
    }
}
