package guru.springframework;

import java.util.HashMap;

public class Bank {

    private final HashMap<Pair, Integer> rateMap;

    public Bank() {
        rateMap = new HashMap<>();
    }

    public Money reduce(Expression expression, String toCurrency) {
        return expression.reduce(this, toCurrency);
    }

    public int rate(String from, String to) {
        if (from.equals(to))
            return 1;
        return rateMap.get(new Pair(from, to));
    }

    public void addRate(String from, String to, int rate) {
        rateMap.put(new Pair(from, to), rate);
    }
}
