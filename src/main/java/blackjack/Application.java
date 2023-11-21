package blackjack;

import blackjack.controller.Controller;
import blackjack.view.InputView;
import blackjack.view.OutputView;
import java.io.IOException;

public class Application {

    public static void main(String[] args) throws IOException {
        InputView inputView = new InputView();
        OutputView outputView = new OutputView();
        Controller controller = new Controller(inputView, outputView);
        controller.play();
    }
}
