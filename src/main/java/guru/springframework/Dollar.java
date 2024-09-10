package guru.springframework;

public class Dollar {

    private final int amount;

    public Dollar(int amount) {
        this.amount = amount;
    }

    Dollar times(int multiplier) {
        return new Dollar(multiplier * amount);
    }

    @Override
    public boolean equals(Object obj) {
        Dollar dollar = (Dollar) obj;
        return dollar.amount == amount;
    }
}
