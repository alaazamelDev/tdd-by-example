package guru.springframework;

public class Money implements Expression {

    protected final int amount;
    protected final String currency;

    protected Money(int amount, String currency) {
        this.amount = amount;
        this.currency = currency;
    }

    public String currency() {
        return currency;
    }

    public static Money dollar(int amount) {
        return new Money(amount, "USD");
    }

    public static Money franc(int amount) {
        return new Money(amount, "CHF");
    }

    public Expression times(int multiplier) {
        return new Money(amount * multiplier, currency);
    }

    public Expression plus(Expression money) {
        return new Sum(this, money);
    }

    @Override
    public boolean equals(Object obj) {
        Money money = (Money) obj;
        return money.amount == amount && ((Money) obj).currency().equals(this.currency());
    }

    @Override
    public Money reduce(Bank bank, String to) {
        int rate = bank.rate(currency, to);
        return new Money(amount / rate, to);
    }

    @Override
    public String toString() {
        return "Money{" +
                "amount=" + amount +
                ", currency='" + currency + '\'' +
                '}';
    }
}
