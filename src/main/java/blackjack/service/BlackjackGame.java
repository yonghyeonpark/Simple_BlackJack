package blackjack.service;

import blackjack.model.Dealer;
import blackjack.model.Player;

public class BlackjackGame {

    private final Player player;
    private final Dealer dealer;
    private int gameRound;

    public BlackjackGame(Player player, Dealer dealer) {
        this.player = player;
        this.dealer = dealer;
        this.gameRound = 1;
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
            return "당신이 이겼습니다.";
        }
        if (playerCurrentCardNumber < dealerCurrentCardNumber) {
            player.defeated();
            return "딜러가 이겼습니다.";
        }
        player.tie();
        return "비겼습니다.";
    }
}
