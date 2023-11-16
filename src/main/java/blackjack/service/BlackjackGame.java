package blackjack.service;

import blackjack.model.Player;

public class BlackjackGame {

    private final Player player;

    public BlackjackGame(Player player) {
        this.player = player;
    }

    public String compareCardNumber(int playerCardNumber, int dealerCardNumber) {
        if (playerCardNumber > dealerCardNumber) {
            player.win();
            return "당신이 이겼습니다.";
        }
        if (playerCardNumber < dealerCardNumber) {
            player.defeated();
            return "딜러가 이겼습니다.";
        }
        player.tie();
        return "비겼습니다.";
    }
}
