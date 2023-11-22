package blackjack.view;

public class OutputView {

    private static final String GAME_START_MESSAGE = "간단 카드 게임을 시작합니다.";
    private static final String GAME_END_MESSAGE = "플레이 해 주셔서 감사합니다.";
    private static final String PLAYER_CARD_SUM_FORMAT_START = "총합: ";
    private static final String CURRENT_PROPERTY_FORMAT_START = "현재 재산: ";

    public void printGameStartMessage() {
        System.out.println(GAME_START_MESSAGE);
    }

    public void printGameProgressInformation(String information) {
        System.out.println(information);
    }

    public void printPlayerCardSum(int playerCardSum) {
        System.out.print(PLAYER_CARD_SUM_FORMAT_START);
        System.out.println(playerCardSum);
    }

    public void printCurrentProperty(int currentProperty) {
        System.out.print(CURRENT_PROPERTY_FORMAT_START);
        System.out.println(currentProperty);
    }

    public void printGameResult(String gameResult) {
        System.out.println();
        System.out.println(gameResult);
        System.out.println(GAME_END_MESSAGE);
    }
}
