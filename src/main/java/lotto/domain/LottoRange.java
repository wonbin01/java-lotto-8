package lotto.domain;

public enum LottoRange {
    MAX(45),
    MIN(1),
    UNIT(1000);

    private final int value;

    private LottoRange(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
