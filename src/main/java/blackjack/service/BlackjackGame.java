package blackjack.service;

import blackjack.model.CardDeck;
import blackjack.model.Dealer;
import blackjack.model.Player;
import blackjack.model.Score;

public class BlackjackGame {

    private static final int INITIAL_VALUE = 1;
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

    public int getCurrentProperty() {
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

    public int getPlayerCardSum() {
        return player.calculateCardNumbersSum();
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

    public String processInvalidPlayerCardSum(int bettingAmount) {
        player.minusBettingAmount(bettingAmount);
        score.addDefeat();
        return DEALER_WIN_MESSAGE;
    }

    public String compareCardNumbersSum(int bettingAmount) {
        if (dealer.calculateCardNumbersSum() == 21) {
            return winDealer(bettingAmount);
        }
        if (dealer.calculateCardNumbersSum() >= 22) {
            return winPlayer(bettingAmount);
        }
        if (player.calculateCardNumbersSum() > dealer.calculateCardNumbersSum()) {
            if (player.calculateCardNumbersSum() == 21) {
                return winPlayerWithBlackjack(bettingAmount);
            }
            return winPlayer(bettingAmount);
        }
        if (player.calculateCardNumbersSum() < dealer.calculateCardNumbersSum()) {
            return winDealer(bettingAmount);
        }
        return draw();
    }

    private String winPlayer(int bettingAmount) {
        player.plusBettingAmount(bettingAmount);
        score.addVictory();
        return PLAYER_WIN_MESSAGE;
    }

    private String winPlayerWithBlackjack(int bettingAmount) {
        player.plusTwiceBettingAmount(bettingAmount);
        score.addVictory();
        return PLAYER_WIN_MESSAGE;
    }

    private String winDealer(int bettingAmount) {
        player.minusBettingAmount(bettingAmount);
        score.addDefeat();
        return DEALER_WIN_MESSAGE;
    }

    private String draw() {
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

    public boolean shouldGameContinue(String gameDecision) {
        if (gameDecision.equals("Y")) {
            return true;
        }
        return false;
    }

    public String getGameResult() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(score.toString())
                .append("로 ")
                .append(String.format("%d원의 자산이 남았습니다.", player.getCurrentProperty()));
        return stringBuilder.toString();
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("\n")
                .append(String.format(GAME_ROUND_FORMAT, gameRound));
        gameRound++;
        return stringBuilder.toString();
    }
}
