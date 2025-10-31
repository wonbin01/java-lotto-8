package lotto.domain;

public class LottoMatchResult {
    private final int matchCount;
    private final boolean isBonusMatch;

    public LottoMatchResult(int matchCount, boolean isBonusMatch) {
        this.matchCount = matchCount;
        this.isBonusMatch = isBonusMatch;
    }

    public int getMatchCount() {
        return matchCount;
    }

    public boolean getIsBonusMatch() {
        return isBonusMatch;
    }
}
