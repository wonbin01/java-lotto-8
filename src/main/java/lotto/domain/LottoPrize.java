package lotto.domain;

public enum LottoPrize {
    FIRST(2000000000),       // 6개 일치
    SECOND(30000000),        // 5개 + 보너스
    THIRD(1500000),          // 5개
    FOURTH(50000),           // 4개
    FIFTH(5000);             // 3개

    private final int amount;

    LottoPrize(int amount) {
        this.amount = amount;
    }

    public int getAmount() {
        return amount;
    }
}
