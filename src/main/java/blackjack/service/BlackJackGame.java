package blackjack.service;

import blackjack.model.Dealer;
import blackjack.model.Player;

public class BlackJackGame {

    private final Player player;
    private final Dealer dealer;

    public BlackJackGame(Player player, Dealer dealer) {
        this.player = player;
        this.dealer = dealer;
    }

    public String compareCardNumber() {
        if (player.getCardNumber() > dealer.getCardNumber()) {
            return "당신이 이겼습니다.";
        }
        if (player.getCardNumber() < dealer.getCardNumber()) {
            return "딜러가 이겼습니다.";
        }
        return "비겼습니다.";
    }
}
