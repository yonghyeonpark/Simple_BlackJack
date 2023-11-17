package blackjack.view;

public class OutputView {

    public void printStartMessage() {
        System.out.println("간단 블랙잭 게임을 시작합니다.");
        System.out.println();
    }

    public void printGameProgressInformation(String information) {
        System.out.println(information);
    }

    public void printIsGameContinue() {
        System.out.print("한 게임 더 하시겠습니까? (Y / N) ");
    }
}
