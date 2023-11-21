package blackjack.view;

public class OutputView {

    private static final String GAME_START_MESSAGE = "간단 카드 게임을 시작합니다.";
    private static final String GAME_END_MESSAGE = "플레이 해 주셔서 감사합니다.";

    public void printGameStartMessage() {
        System.out.println(GAME_START_MESSAGE);
    }

    public void printGameProgressInformation(String information) {
        System.out.println(information);
    }

    public void printPlayerCardSum(int playerCardSum) {
        System.out.print("총합: ");
        System.out.println(playerCardSum);
    }

    public void printGameResult(String gameResult) {
        System.out.println(gameResult);
        System.out.println(GAME_END_MESSAGE);
    }
}
