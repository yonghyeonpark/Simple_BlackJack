package blackjack;

import blackjack.controller.Controller;
import blackjack.model.Dealer;
import blackjack.model.Player;
import blackjack.service.BlackjackGame;
import blackjack.view.InputView;
import blackjack.view.OutputView;
import java.io.IOException;

public class Application {

    public static void main(String[] args) throws IOException {
        InputView inputView = new InputView();
        OutputView outputView = new OutputView();
        Player player = new Player();
        Dealer dealer = new Dealer();
        BlackjackGame blackJackGame = new BlackjackGame(player, dealer);
        Controller controller = new Controller(inputView, outputView, blackJackGame);
        controller.play();
    }
}
