package blackjack.view;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class InputView {

    private static final String ERROR_MESSAGE = "Y 혹은 N으로 입력해 주세요.(대소문자를 구분하지 않습니다.)";
    private static final String YES = "Y";
    private static final String NO = "N";

    public String readGameDecision() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String gameDecision = reader.readLine().toUpperCase();
        validate(gameDecision);
        System.out.println();
        return gameDecision;
    }

    private void validate(String gameDecision) {
        if (!gameDecision.equals(YES) && !gameDecision.equals(NO)) {
            throw new IllegalArgumentException(ERROR_MESSAGE);
        }
    }
}
