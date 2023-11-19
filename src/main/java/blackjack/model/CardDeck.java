package blackjack.model;

import blackjack.util.CardNumberGenerator;
import java.util.HashMap;
import java.util.Map;

public class CardDeck {

    private final Map<Integer, Integer> cardDeck;

    public CardDeck() {
        this.cardDeck = setUp();
    }

    private Map<Integer, Integer> setUp() {
        Map<Integer, Integer> cardDeck = new HashMap<>();
        for (int i = 1; i < 11; i++) {
            cardDeck.put(i, 4);
        }
        cardDeck.put(11, 12);
        return cardDeck;
    }

    public int pullCard() {
        CardNumberGenerator cardNumberGenerator = new CardNumberGenerator();
        while (true) {
            int cardNumber = cardNumberGenerator.generateCardNumber();
            if (cardDeck.get(cardNumber) >= 1) {
                cardDeck.put(cardNumber, cardDeck.get(cardNumber) - 1);
                return cardNumber;
            }
        }
    }
}
