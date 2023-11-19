package blackjack.model;

public class Property {

    private int property;

    public Property() {
        this.property = 1000;
    }

    public void bet(int bettingAmount) {
        if (property - bettingAmount < 0) {
            throw new IllegalArgumentException("잘못 입력하셨습니다.");
        }
        property -= bettingAmount;
    }

    public void plusBettingAmount(int bettingAmount) {
        property += bettingAmount;
    }

    public void minusBettingAmount(int bettingAmount) {
        property -= bettingAmount;
    }
}
