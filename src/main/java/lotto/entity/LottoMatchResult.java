package lotto.entity;

public class LottoMatchResult {
    private final int matchCount;
    private final boolean matchBonusCount;

    public LottoMatchResult(int matchCount, boolean matchBonusCount) {
        this.matchCount = matchCount;
        this.matchBonusCount = matchBonusCount;
    }

    public int getMatchCount() {
        return matchCount;
    }

    public boolean getMatchBonusCount() {
        return matchBonusCount;
    }
}
