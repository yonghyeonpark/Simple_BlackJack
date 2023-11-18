package blackjack.service;

import blackjack.model.Dealer;
import blackjack.model.Player;

public class BlackjackGame {

    private static final int INITIAL_VALUE = 1;
    private static final String PLAYER_WIN_MESSAGE = "당신이 이겼습니다.";
    private static final String DEALER_WIN_MESSAGE = "딜러가 이겼습니다.";
    private static final String DRAW_MESSAGE = "비겼습니다.";
    private static final String YES = "Y";
    private static final String GAME_ROUND_FORMAT = "Game %d";

    private final Player player;
    private final Dealer dealer;
    private int gameRound;

    public BlackjackGame(Player player, Dealer dealer) {
        this.player = player;
        this.dealer = dealer;
        this.gameRound = INITIAL_VALUE;
    }

    public String getPlayerNumbers() {
        return player.toString();
    }

    public String getDealerNumbers() {
        return dealer.toString();
    }

    public String getScore() {
        return player.getScore();
    }

    public void pickCard() {
        player.pickCard();
        dealer.pickCard();
    }

    public String compareCardNumber() {
        int playerCurrentCardNumber = player.getCurrentCardNumber(gameRound);
        int dealerCurrentCardNumber = dealer.getCurrentCardNumber(gameRound);
        gameRound++;
        if (playerCurrentCardNumber > dealerCurrentCardNumber) {
            player.win();
            return PLAYER_WIN_MESSAGE;
        }
        if (playerCurrentCardNumber < dealerCurrentCardNumber) {
            player.defeated();
            return DEALER_WIN_MESSAGE;
        }
        player.tie();
        return DRAW_MESSAGE;
    }

    public boolean judgeGameContinue(String gameDecision) {
        if (gameDecision.equals(YES)) {
            return true;
        }
        return false;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(String.format(GAME_ROUND_FORMAT, gameRound));
        return stringBuilder.toString();
    }
}
