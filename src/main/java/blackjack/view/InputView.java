package blackjack.view;

import blackjack.util.Convert;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class InputView {

    private static final String YES = "Y";
    private static final String NO = "N";
    private static final String ERROR_MESSAGE = "잘못 입력하셨습니다.";

    public int readBettingAmount() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        return Convert.stringToInteger(reader.readLine());
    }

    public String readGameOrCardDecision() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String gameOrCardDecision = reader.readLine().toUpperCase();
        validate(gameOrCardDecision);
        System.out.println();
        return gameOrCardDecision;
    }

    private void validate(String gameOrCardDecision) {
        if (!gameOrCardDecision.equals(YES) && !gameOrCardDecision.equals(NO)) {
            throw new IllegalArgumentException(ERROR_MESSAGE);
        }
    }
}
