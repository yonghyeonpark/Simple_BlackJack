package blackjack.util;

public class Convert {

    public static int stringToInteger(String input) {
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("잘못 입력하셨습니다.");
        }
    }
}
