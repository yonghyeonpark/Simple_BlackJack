package blackjack.model;

import blackjack.util.CardNumberGenerator;

public class Player {

    private final int cardNumber;

    public Player() {
        CardNumberGenerator cardNumberGenerator = new CardNumberGenerator();
        this.cardNumber = cardNumberGenerator.generateCardNumber();
    }

    public int getCardNumber() {
        return cardNumber;
    }
}
