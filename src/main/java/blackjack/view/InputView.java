package blackjack.view;

import blackjack.util.Convert;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class InputView {

    public int readBettingAmount() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        return Convert.stringToInteger(reader.readLine());
    }
}
