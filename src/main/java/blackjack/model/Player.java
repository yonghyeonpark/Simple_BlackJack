package blackjack.model;

import java.util.ArrayList;
import java.util.List;

public class Player {

    private static final String CARD_NUMBERS_FORMAT_START = "플레이어: ";
    private static final String CARD_NUMBER_FORMAT = "[%d]";

    private final Property property;
    private final List<Integer> cardNumbers;

    public Player(Property property) {
        this.property = property;
        this.cardNumbers = new ArrayList<>();
    }

    public void bet(int bettingAmount) {
        property.bet(bettingAmount);
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

    public void plusBettingAmount(int bettingAmount) {
        property.plusBettingAmount(bettingAmount);
    }

    public void plusTwiceBettingAmount(int bettingAmount) {
        property.plusTwiceBettingAmount(bettingAmount);
    }

    public void minusBettingAmount(int bettingAmount) {
        property.minusBettingAmount(bettingAmount);
    }

    public String getCurrentProperty() {
        return property.toString();
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
