package blackjack.model;

import java.util.ArrayList;
import java.util.List;

public class Dealer {

    private static final String CARD_NUMBERS_FORMAT_START = "딜러: ";
    private static final String CARD_NUMBER_FORMAT = "[%d]";

    private final CardDeck cardDeck;
    private final List<Integer> cardNumbers;

    public Dealer(CardDeck cardDeck) {
        this.cardDeck = cardDeck;
        this.cardNumbers = new ArrayList<>();
    }

    public void pullCard() {
        cardNumbers.add(cardDeck.pullCard());
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
        for (int cardNumber : cardNumbers) {
            stringBuilder.append(CARD_NUMBERS_FORMAT_START)
                    .append(String.format(CARD_NUMBER_FORMAT, cardNumber));
        }
        return stringBuilder.toString();
    }
}
