package blackjack.view;

public class OutputView {

    public void printStartMessage() {
        System.out.println("간단 블랙잭 게임을 시작합니다.");
        System.out.println();
    }

    public void printGameProgressInformation(String information) {
        System.out.println(information);
    }

    public void printIsGameContinueMessage() {
        System.out.print("한 게임 더 하시겠습니까? (Y / N) ");
    }

    public void printExitMessage() {
        System.out.println("게임을 종료합니다.");
        System.out.println("플레이해주셔서 감사합니다.");
    }
}
