package blackjack.model;

public class Property {

    private static final int INITIAL_PROPERTY = 1000;
    private static final int MIN_BETTING_AMOUNT = 100;
    private static final int BETTING_AMOUNT_UNIT = 100;
    private static final int ZERO = 0;
    private static final int TWICE = 2;

    private int property;

    public Property() {
        this.property = INITIAL_PROPERTY;
    }

    public int getProperty() {
        return property;
    }

    public void bet(int bettingAmount) {
        validateRange(bettingAmount);
        validateUnit(bettingAmount);
    }

    private void validateRange(int bettingAmount) {
        if (bettingAmount < MIN_BETTING_AMOUNT) {
            throw new IllegalArgumentException("잘못 입력하셨습니다.");
        }
        if (property - bettingAmount < ZERO) {
            throw new IllegalArgumentException("잘못 입력하셨습니다.");
        }
    }

    private void validateUnit(int bettingAmount) {
        if (bettingAmount % BETTING_AMOUNT_UNIT != ZERO) {
            throw new IllegalArgumentException("잘못 입력하셨습니다.");
        }
    }

    public void plusBettingAmount(int bettingAmount) {
        property += bettingAmount;
    }

    public void plusTwiceBettingAmount(int bettingAmount) {
        property += (bettingAmount * TWICE);
    }

    public void minusBettingAmount(int bettingAmount) {
        property -= bettingAmount;
    }
}
