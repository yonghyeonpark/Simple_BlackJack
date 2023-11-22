package blackjack.controller;

import blackjack.model.CardDeck;
import blackjack.model.Dealer;
import blackjack.model.Player;
import blackjack.model.Property;
import blackjack.model.Score;
import blackjack.service.BlackjackGame;
import blackjack.view.InputView;
import blackjack.view.OutputView;
import java.io.IOException;

public class Controller {

    private static final int ZERO = 0;
    private static final int BLACKJACK = 21;
    private static final String CARD_PREVIEW_COMMAND = "CODESQUAD";

    private final InputView inputView;
    private final OutputView outputView;
    private BlackjackGame blackjackGame;

    public Controller(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
        setUp();
    }

    private void setUp() {
        Property property = new Property();
        CardDeck cardDeck = new CardDeck();
        Score score = new Score();
        Player player = new Player(property);
        Dealer dealer = new Dealer();
        blackjackGame = new BlackjackGame(player, dealer, cardDeck, score);
    }

    public void play() throws IOException {
        guideGame();
        gamePlay();
        printGameResult();
    }

    private void guideGame() {
        outputView.printGameStartMessage();
        outputView.printCurrentProperty(blackjackGame.getCurrentProperty());
    }

    private void gamePlay() throws IOException {
        boolean isContinue = true;
        while (isContinue) {
            manageCard();
            int bettingAmount = getBettingAmount();
            gameSetUp();
            processPlayerCardDecision(bettingAmount);
            compareCardSum(bettingAmount);
            outputView.printCurrentProperty(blackjackGame.getCurrentProperty());
            if (blackjackGame.getCurrentProperty() == ZERO) {
                break;
            }
            isContinue = shouldGameContinue();
        }
    }

    private void manageCard() {
        blackjackGame.judgeGetNewDeck();
        blackjackGame.resetPlayerCards();
        blackjackGame.resetDealerCards();
    }

    private int getBettingAmount() throws IOException {
        while (true) {
            try {
                int bettingAmount = inputView.readBettingAmount();
                blackjackGame.bet(bettingAmount);
                return bettingAmount;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private void gameSetUp() {
        outputView.printGameProgressInformation(blackjackGame.toString());
        blackjackGame.pullPlayerCard();
        outputView.printGameProgressInformation(blackjackGame.getPlayerNumbers());
        outputView.printPlayerCardSum(blackjackGame.getPlayerCardSum());
    }

    private void processPlayerCardDecision(int bettingAmount) throws IOException {
        boolean isGetCard = true;
        while (isGetCard) {
            String cardReceiptDecision = getCardReceiptDecision();
            checkCommand(cardReceiptDecision);
            isGetCard = blackjackGame.shouldGetMoreCard(cardReceiptDecision);
            whenGetCard(isGetCard);
            if (isPlayerCardSumOutOfRange()) {
                outputView.printGameProgressInformation(blackjackGame.processInvalidPlayerCardSum(bettingAmount));
                isGetCard = false;
            }
        }
    }

    private void whenGetCard(boolean isGetCard) {
        if (isGetCard) {
            outputView.printGameProgressInformation(blackjackGame.getPlayerNumbers());
            outputView.printPlayerCardSum(blackjackGame.getPlayerCardSum());
        }
    }

    private void checkCommand(String cardReceiptDecision) {
        if (cardReceiptDecision.equals(CARD_PREVIEW_COMMAND)) {
            outputView.printGameProgressInformation(blackjackGame.respondToCommand());
        }
    }

    private String getCardReceiptDecision() throws IOException {
        while (true) {
            try {
                return inputView.readCardReceiptDecision();
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private void compareCardSum(int bettingAmount) {
        if (!isPlayerCardSumOutOfRange()) {
            blackjackGame.pullDealerCard();
            outputView.printGameProgressInformation(blackjackGame.getDealerNumbers());
            outputView.printGameProgressInformation(blackjackGame.getDealerCardSum());
            outputView.printGameProgressInformation(blackjackGame.compareCardNumbersSum(bettingAmount));
        }
    }

    private boolean isPlayerCardSumOutOfRange() {
        return blackjackGame.getPlayerCardSum() > BLACKJACK;
    }

    private boolean shouldGameContinue() throws IOException {
        while (true) {
            try {
                String gameDecision = inputView.readGameDecision();
                return blackjackGame.shouldGameContinue(gameDecision);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private void printGameResult() {
        outputView.printGameResult(blackjackGame.getGameResult());
    }
}
