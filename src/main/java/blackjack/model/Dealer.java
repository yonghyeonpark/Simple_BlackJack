package blackjack.model;

import blackjack.util.CardNumberGenerator;
import java.util.ArrayList;
import java.util.List;

public class Dealer {

    private final List<Integer> cardNumbers;

    public Dealer() {
        this.cardNumbers = new ArrayList<>();
    }

    public int getCardNumber() {
        CardNumberGenerator cardNumberGenerator = new CardNumberGenerator();
        int cardNumber = cardNumberGenerator.generateCardNumber();
        cardNumbers.add(cardNumber);
        return cardNumber;
    }
}
