package blackjack.view;

public class OutputView {

    private static final String GAME_START_MESSAGE = "간단 블랙잭 게임을 시작합니다.";
    private static final String CONTINUE_MESSAGE = "한 게임 더 하시겠습니까? (Y / N) ";
    private static final String GAME_OVER_MESSAGE = "게임을 종료합니다.";
    private static final String THANK_YOU_MESSAGE = "플레이해주셔서 감사합니다.";

    public void printStartMessage() {
        System.out.println(GAME_START_MESSAGE);
        System.out.println();
    }

    public void printGameProgressInformation(String information) {
        System.out.println(information);
    }

    public void printShouldGameContinueMessage() {
        System.out.print(CONTINUE_MESSAGE);
    }

    public void printExitMessage() {
        System.out.println(GAME_OVER_MESSAGE);
        System.out.println(THANK_YOU_MESSAGE);
    }
}
