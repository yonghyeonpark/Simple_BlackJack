package blackjack.service;

import blackjack.model.CardDeck;
import blackjack.model.Dealer;
import blackjack.model.Player;

public class BlackjackGame {

    private static final int INITIAL_VALUE = 1;

    private final Player player;
    private final Dealer dealer;
    private final CardDeck cardDeck;
    private int gameRound;

    public BlackjackGame(Player player, Dealer dealer, CardDeck cardDeck) {
        this.player = player;
        this.dealer = dealer;
        this.cardDeck = cardDeck;
        this.gameRound = INITIAL_VALUE;
    }

    public String getCurrentProperty() {
        return player.getCurrentProperty();
    }

    public void bet(int bettingAmount) {
        player.bet(bettingAmount);
    }

    public void pullPlayerCard() {
        player.addCard(cardDeck.pullCard());
    }

    public String getPlayerNumbers() {
        return player.toString();
    }

    public String getPlayerCardSum() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("총합: ")
                .append(player.calculateCardNumbersSum());
        return stringBuilder.toString();
    }
}
