package blackjack.service;

import blackjack.model.CardDeck;
import blackjack.model.Dealer;
import blackjack.model.Player;
import blackjack.model.Score;

public class BlackjackGame {

    private static final int INITIAL_VALUE = 0;
    private static final String GAME_ROUND_FORMAT = "Game %d";
    private static final String PLAYER_WIN_MESSAGE = "당신의 승리입니다.";
    private static final String DEALER_WIN_MESSAGE = "당신의 패배입니다.";
    private static final String DRAW_MESSAGE = "비겼습니다.";

    private final Player player;
    private final Dealer dealer;
    private final CardDeck cardDeck;
    private final Score score;
    private int gameRound;

    public BlackjackGame(Player player, Dealer dealer, CardDeck cardDeck, Score score) {
        this.player = player;
        this.dealer = dealer;
        this.cardDeck = cardDeck;
        this.score = score;
        this.gameRound = INITIAL_VALUE;
    }

    public void resetPlayerCards() {
        player.resetPlayerCards();
    }

    public String getCurrentProperty() {
        return player.getCurrentProperty();
    }

    public void bet(int bettingAmount) {
        gameRound++;
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

    public void resetDealerCards() {
        dealer.resetDealerCards();
    }

    public void pullDealerCard() {
        while (dealer.calculateCardNumbersSum() <= 16) {
            dealer.addCard(cardDeck.pullCard());
        }
    }

    public String getDealerNumbers() {
        return dealer.toString();
    }

    public String getDealerCardSum() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("딜러의 카드 합계는 ")
                .append(dealer.calculateCardNumbersSum())
                .append("입니다.");
        return stringBuilder.toString();
    }

    public void judgeGetNewDeck() {
        if (cardDeck.count() <= 10) {
            cardDeck.setUp();
        }
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(String.format(GAME_ROUND_FORMAT, gameRound));
        return stringBuilder.toString();
    }

    public String compareCardNumbersSum(int bettingAmount) {
        if (dealer.calculateCardNumbersSum() == 21) {
            player.minusBettingAmount(bettingAmount);
            score.addDefeat();
            return DEALER_WIN_MESSAGE;
        }
        if (dealer.calculateCardNumbersSum() >= 22) {
            player.plusBettingAmount(bettingAmount);
            score.addVictory();
            return PLAYER_WIN_MESSAGE;
        }
        if (player.calculateCardNumbersSum() > dealer.calculateCardNumbersSum()) {
            if (player.calculateCardNumbersSum() == 21) {
                player.plusTwiceBettingAmount(bettingAmount);
                score.addVictory();
                return PLAYER_WIN_MESSAGE;
            }
            player.plusBettingAmount(bettingAmount);
            score.addVictory();
            return PLAYER_WIN_MESSAGE;
        }
        if (player.calculateCardNumbersSum() < dealer.calculateCardNumbersSum()) {
            player.minusBettingAmount(bettingAmount);
            score.addDefeat();
            return DEALER_WIN_MESSAGE;
        }
        score.addDraw();
        return DRAW_MESSAGE;
    }

    public boolean shouldGetMoreCard(String answer) {
        if (answer.equals("Y")) {
            player.addCard(cardDeck.pullCard());
            return true;
        }
        return false;
    }
}
