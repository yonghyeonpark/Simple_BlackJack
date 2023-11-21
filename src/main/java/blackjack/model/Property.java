package blackjack.model;

public class Property {

    private static final String PROPERTY_FORMAT_START = "현재 재산: ";

    private int property;

    public Property() {
        this.property = 1000;
    }

    public void bet(int bettingAmount) {
        validateRange(bettingAmount);
        validateUnit(bettingAmount);
    }

    private void validateRange(int bettingAmount) {
        if (bettingAmount < 100) {
            throw new IllegalArgumentException("잘못 입력하셨습니다.");
        }
        if (property - bettingAmount < 0) {
            throw new IllegalArgumentException("잘못 입력하셨습니다.");
        }
    }

    private void validateUnit(int bettingAmount) {
        if (bettingAmount % 100 != 0) {
            throw new IllegalArgumentException("잘못 입력하셨습니다.");
        }
    }

    public void plusBettingAmount(int bettingAmount) {
        property += bettingAmount;
    }

    public void plusTwiceBettingAmount(int bettingAmount) {
        property += (bettingAmount * 2);
    }

    public void minusBettingAmount(int bettingAmount) {
        property -= bettingAmount;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(PROPERTY_FORMAT_START)
                .append(property);
        return stringBuilder.toString();
    }
}
