package blackjack.model;

import blackjack.util.CardNumberGenerator;

public class Dealer {

    private final int cardNumber;

    public Dealer() {
        CardNumberGenerator cardNumberGenerator = new CardNumberGenerator();
        this.cardNumber = cardNumberGenerator.generateCardNumber();
    }

    public int getCardNumber() {
        return cardNumber;
    }
}
