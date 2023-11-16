package blackjack.util;

import java.util.Random;

public class CardNumberGenerator {

    public int generateCardNumber() {
        Random random = new Random();
        return random.nextInt(10) + 1;
    }
}
