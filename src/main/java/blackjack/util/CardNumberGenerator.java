package blackjack.util;

import java.util.Random;

public class CardNumberGenerator {

    private final static int INDEX_RANGE = 11;
    private final static int FOR_REAL_VALUE = 1;

    public int generateCardNumber() {
        Random random = new Random();
        return random.nextInt(INDEX_RANGE) + FOR_REAL_VALUE;
    }
}
