package lotto.entity;

public class LottoMatchResult {
    private final int matchCount;
    private final int matchBonusCount;

    public LottoMatchResult(int matchCount, int matchBonusCount) {
        this.matchCount = matchCount;
        this.matchBonusCount = matchBonusCount;
    }

    public int getMatchCount() {
        return matchCount;
    }

    public int getMatchBonusCount() {
        return matchBonusCount;
    }
}
