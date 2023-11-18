package blackjack.controller;

import blackjack.service.BlackjackGame;
import blackjack.view.InputView;
import blackjack.view.OutputView;
import java.io.IOException;

public class Controller {

    private final InputView inputView;
    private final OutputView outputView;
    private final BlackjackGame blackjackGame;

    public Controller(InputView inputView, OutputView outputView, BlackjackGame blackjackGame) {
        this.inputView = inputView;
        this.outputView = outputView;
        this.blackjackGame = blackjackGame;
    }

    public void play() throws IOException {
        boolean continueGame = true;
        printStartMessage();
        while (continueGame) {
            printGameRound();
            pickCard();
            getResult();
            continueGame = shouldGameContinue();
        }
    }

    private void printStartMessage() {
        outputView.printStartMessage();
    }

    private void printGameRound() {
        outputView.printGameProgressInformation(blackjackGame.toString());
    }

    private void pickCard() {
        blackjackGame.pickCard();
        outputView.printGameProgressInformation(blackjackGame.getPlayerNumbers());
        outputView.printGameProgressInformation(blackjackGame.getDealerNumbers());
    }

    private void getResult() {
        outputView.printGameProgressInformation(blackjackGame.compareCardNumber());
        outputView.printGameProgressInformation(blackjackGame.getScore());
    }

    private boolean shouldGameContinue() throws IOException {
        outputView.printShouldGameContinueMessage();
        boolean continueGame = blackjackGame.judgeGameContinue(getGameDecision());
        if (!continueGame) {
            outputView.printExitMessage();
        }
        return continueGame;
    }

    private String getGameDecision() throws IOException {
        while (true) {
            try {
                return inputView.readGameDecision();
            } catch (IllegalArgumentException e) {
                System.out.println("Y 혹은 N으로 입력해 주세요.(대소문자를 구분하지 않습니다.)");
            }
        }
    }
}
