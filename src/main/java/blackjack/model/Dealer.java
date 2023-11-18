package blackjack.model;

import blackjack.util.CardNumberGenerator;
import java.util.ArrayList;
import java.util.List;

public class Dealer {

    private static final int FOR_INDEX_VALUE = 1;
    private static final String CARD_NUMBERS_FORMAT_START = "Dealer: ";
    private static final String CARD_NUMBER_FORMAT = "[%d]";

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
        return cardNumbers.get(round - FOR_INDEX_VALUE);
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(CARD_NUMBERS_FORMAT_START);
        for (int cardNumber : cardNumbers) {
            stringBuilder.append(String.format(CARD_NUMBER_FORMAT, cardNumber));
        }
        return stringBuilder.toString();
    }
}
