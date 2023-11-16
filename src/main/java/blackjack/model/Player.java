package blackjack.model;

import blackjack.util.CardNumberGenerator;
import java.util.ArrayList;
import java.util.List;

public class Player {

    private final List<Integer> cardNumbers;
    private final Score score;

    public Player() {
        this.cardNumbers = new ArrayList<>();
        this.score = new Score();
    }

    public int getCardNumber() {
        CardNumberGenerator cardNumberGenerator = new CardNumberGenerator();
        int cardNumber = cardNumberGenerator.generateCardNumber();
        cardNumbers.add(cardNumber);
        return cardNumber;
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

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("You   :");
        for (int cardNumber : cardNumbers) {
            stringBuilder.append(" [")
                    .append(cardNumber)
                    .append("]");
        }
        return stringBuilder.toString();
    }
}
