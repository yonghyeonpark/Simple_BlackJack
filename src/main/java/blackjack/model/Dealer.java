package blackjack.model;

import blackjack.util.CardNumberGenerator;
import java.util.ArrayList;
import java.util.List;

public class Dealer {

    private final List<Integer> cardNumbers;

    public Dealer() {
        this.cardNumbers = new ArrayList<>();
    }

    public void pickCard() {
        CardNumberGenerator cardNumberGenerator = new CardNumberGenerator();
        int cardNumber = cardNumberGenerator.generateCardNumber();
        cardNumbers.add(cardNumber);
    }

    public int getCurrentCardNumber(int round) {
        return cardNumbers.get(round - 1);
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Dealer:");
        for (int cardNumber : cardNumbers) {
            stringBuilder.append(" [")
                    .append(cardNumber)
                    .append("]");
        }
        return stringBuilder.toString();
    }
}
