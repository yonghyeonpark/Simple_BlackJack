package blackjack.model;

import blackjack.util.CardNumberGenerator;
import java.util.ArrayList;
import java.util.List;

public class Player {

    private final List<Integer> cardNumbers;

    public Player() {
        this.cardNumbers = new ArrayList<>();
    }

    public int getCardNumber() {
        CardNumberGenerator cardNumberGenerator = new CardNumberGenerator();
        int cardNumber = cardNumberGenerator.generateCardNumber();
        cardNumbers.add(cardNumber);
        return cardNumber;
    }
}
