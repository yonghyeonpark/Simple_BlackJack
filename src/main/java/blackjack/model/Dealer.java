package blackjack.model;

import java.util.ArrayList;
import java.util.List;

public class Dealer {

    private static final String CARD_NUMBERS_FORMAT_START = "딜러: ";
    private static final String CARD_NUMBER_FORMAT = "[%d]";

    private final List<Integer> cardNumbers;

    public Dealer() {
        this.cardNumbers = new ArrayList<>();
    }

    public void addCard(int cardNumber) {
        cardNumbers.add(cardNumber);
    }

    public int calculateCardNumbersSum() {
        int sum = 0;
        for (int cardNumber : cardNumbers) {
            sum += cardNumber;
        }
        return sum;
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
