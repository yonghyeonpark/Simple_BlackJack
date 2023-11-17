package blackjack.view;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class InputView {

    public String readGameDecision() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String gameDecision = reader.readLine().toUpperCase();
        validate(gameDecision);
        System.out.println();
        return gameDecision;
    }

    private void validate(String gameDecision) {
        if (!gameDecision.equals("Y") && !gameDecision.equals("N")) {
            throw new IllegalArgumentException();
        }
    }
}
