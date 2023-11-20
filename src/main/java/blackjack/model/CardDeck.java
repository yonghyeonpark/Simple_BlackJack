package blackjack.model;

import blackjack.util.CardNumberGenerator;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class CardDeck {

    private static final String CARD_DECK_NUMBERS_FORMAT_START = "덱의 카드 ";
    private static final String CARD_DECK_NUMBER_FORMAT = "[%d]";

    private final Queue<Integer> cardDeck;

    public CardDeck() {
        this.cardDeck = new LinkedList(setUp());
    }

    public List<Integer> setUp() {
        List<Integer> cardDeck = new ArrayList<>();
        CardNumberGenerator cardNumberGenerator = new CardNumberGenerator();
        for (int i = 1; i <= 10; i++) {
            repeatFour(i);
        }
        for (int i = 0; i < 12; i++) {
            cardDeck.add(11);
        }
        Collections.shuffle(cardDeck);
        return cardDeck;
    }

    private void repeatFour(int cardNumber) {
        for (int i = 0; i < 4; i++) {
            cardDeck.add(cardNumber);
        }
    }

    public int pullCard() {
        return cardDeck.poll();
    }

    public int count() {
        return cardDeck.size();
    }

    public String showSixCardsInOrder() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(CARD_DECK_NUMBERS_FORMAT_START);
        for (int i = 0; i < 6; i++) {
            stringBuilder.append(String.format(CARD_DECK_NUMBER_FORMAT, cardDeck.peek()));
        }
        return stringBuilder.toString();
    }
}
