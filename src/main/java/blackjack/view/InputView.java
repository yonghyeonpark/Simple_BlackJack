package blackjack.view;

import blackjack.util.Convert;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class InputView {

    private static final String YES = "Y";
    private static final String NO = "N";
    private static final String INPUT_BETTING_AMOUNT_MESSAGE = "얼마를 거시겠습니까? ";
    private static final String INPUT_CARD_RECEIPT_DECISION_MESSAGE = "카드를 더 받겠습니까? (Y / N) ";
    private static final String INPUT_GAME_DECISION_MESSAGE = "한 게임 더 하시겠습니까? (Y / N) ";
    private static final String ERROR_MESSAGE = "잘못 입력하셨습니다.";
    private static final String CARD_PREVIEW_COMMAND = "CODESQUAD";

    public int readBettingAmount() throws IOException {
        try {
            System.out.print(INPUT_BETTING_AMOUNT_MESSAGE);
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            int bettingAmount = Convert.stringToInteger(reader.readLine());
            return bettingAmount;
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ERROR_MESSAGE);
        }
    }

    public String readCardReceiptDecision() throws IOException {
        System.out.print(INPUT_CARD_RECEIPT_DECISION_MESSAGE);
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String cardReceiptDecision = reader.readLine().toUpperCase();
        validateCardReceiptDecisionFormat(cardReceiptDecision);
        return cardReceiptDecision;
    }

    public String readGameDecision() throws IOException {
        System.out.print(INPUT_GAME_DECISION_MESSAGE);
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String gameDecision = reader.readLine().toUpperCase();
        validateGameDecisionFormat(gameDecision);
        return gameDecision;
    }

    private void validateCardReceiptDecisionFormat(String cardReceiptDecision) {
        if (!cardReceiptDecision.equals(YES)
                && !cardReceiptDecision.equals(NO)
                && !cardReceiptDecision.equals(CARD_PREVIEW_COMMAND)) {
            throw new IllegalArgumentException(ERROR_MESSAGE);
        }
    }

    private void validateGameDecisionFormat(String gameDecision) {
        if (!gameDecision.equals(YES) && !gameDecision.equals(NO)) {
            throw new IllegalArgumentException(ERROR_MESSAGE);
        }
    }
}
