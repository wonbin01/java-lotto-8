package lotto.entity;

import java.util.List;

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

    public int[] getMatchResult(List<LottoMatchResult> results) {
        int[] matchResult = new int[6];
        for (LottoMatchResult result : results) {
            int count = result.getMatchCount();
            boolean bonus = result.getIsBonusMatch();
            if (count == 6) {
                matchResult[1]++; //1등
            } else if (count == 5 && bonus) {
                matchResult[2]++; //2등
            } else if (count == 5) {
                matchResult[3]++; //3등
            } else if (count == 4) {
                matchResult[4]++; //4등
            } else if (count == 3) {
                matchResult[5]++;
            }
        }
        return matchResult;
    }
}
