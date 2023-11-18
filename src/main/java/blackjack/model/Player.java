package blackjack.model;

import blackjack.util.CardNumberGenerator;
import java.util.ArrayList;
import java.util.List;

public class Player {

    private static final int DECREASE_VALUE = 1;
    private static final String CARD_NUMBERS_FORMAT_START = "You   : ";
    private static final String CARD_NUMBER_FORMAT = "[%d]";

    private final List<Integer> cardNumbers;
    private final Score score;

    public Player() {
        this.cardNumbers = new ArrayList<>();
        this.score = new Score();
    }

    public void pickCard() {
        CardNumberGenerator cardNumberGenerator = new CardNumberGenerator();
        int cardNumber = cardNumberGenerator.generateCardNumber();
        cardNumbers.add(cardNumber);
    }

    public int getCurrentCardNumber(int round) {
        return cardNumbers.get(round - DECREASE_VALUE);
    }

    public void win() {
        score.addVictory();
    }

    public void defeated() {
        score.addDefeat();
    }

    public void tie() {
        score.addDraw();
    }

    public String getScore() {
        return score.toString();
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
