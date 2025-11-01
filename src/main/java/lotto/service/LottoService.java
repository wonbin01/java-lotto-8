package lotto.service;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import lotto.domain.Lotto;
import lotto.domain.LottoMatchResult;
import lotto.domain.LottoPrize;
import lotto.dto.BonusNumberDto;
import lotto.dto.LottoListDto;
import lotto.dto.PurchaseDto;
import lotto.dto.WinningNumbersDto;
import lotto.exception.ExceptionMessage;

public class LottoService {

    public LottoListDto generateLottos(PurchaseDto dto) {
        List<Lotto> lottoList = new ArrayList<>();
        while (true) {
            try {
                for (long i = 0; i < dto.getPurchaseCount(); i++) {
                    List<Integer> candidates = new ArrayList<>(generateNumbers());
                    Collections.sort(candidates);
                    Lotto lotto = new Lotto(candidates);
                    lottoList.add(lotto);
                }
                break;
            } catch (IllegalArgumentException e) {
                System.out.println(ExceptionMessage.ERROR_DURING_GENERATE.getMessage());
            }
        }
        return new LottoListDto(lottoList);
    }

    private List<Integer> generateNumbers() {
        return Randoms.pickUniqueNumbersInRange(1, 45, 6);
    }

    public List<LottoMatchResult> validateResult(LottoListDto lottoListDto, WinningNumbersDto winningNumbersDto,
                                                 BonusNumberDto bonusNumberDto) { // 당첨 로또 번호 확인
        List<LottoMatchResult> results = new ArrayList<>();
        for (Lotto lotto : lottoListDto.getLottolist()) {
            int matchCount = 0;
            boolean bonusBall = false;
            for (int num : lotto.getNumbers()) {
                if (winningNumbersDto.getWinningNumbers().contains(num)) {
                    matchCount++;
                }
                if (bonusNumberDto.getBonusNumber() == num) {
                    bonusBall = true;
                }
            }
            results.add(new LottoMatchResult(matchCount, bonusBall));
        }
        return results;
    }

    public int getPrizeIndex(int matchCount, boolean isBonus) {
        if (matchCount == 6) {
            return 1;           // 1등
        }
        if (matchCount == 5 && isBonus) {
            return 2; // 2등
        }
        if (matchCount == 5) {
            return 3;           // 3등
        }
        if (matchCount == 4) {
            return 4;           // 4등
        }
        if (matchCount == 3) {
            return 5;           // 5등
        }
        return 0;                                // 당첨 없음
    }

    public int[] getMatchResult(List<LottoMatchResult> results) {
        int[] matchResult = new int[6];

        for (LottoMatchResult result : results) {
            int index = getPrizeIndex(result.getMatchCount(), result.getIsBonusMatch());
            if (index != 0) {
                matchResult[index]++;
            }
        }

        return matchResult;
    }


    public float calculateMoney(int[] matchResult, PurchaseDto dto) {
        long purchaseAmount = dto.getPurchaseAmount();

        long firstWinnerPrice = (long) matchResult[1] * LottoPrize.FIRST.getAmount();
        long secondWinnerPrice = (long) matchResult[2] * LottoPrize.SECOND.getAmount();
        long thirdWinnerPrice = (long) matchResult[3] * LottoPrize.THIRD.getAmount();
        long fourthWinnerPrice = (long) matchResult[4] * LottoPrize.FOURTH.getAmount();
        long fifthWinnerPrice = (long) matchResult[5] * LottoPrize.FIFTH.getAmount();

        long totalPrice =
                firstWinnerPrice + secondWinnerPrice + thirdWinnerPrice + fourthWinnerPrice + fifthWinnerPrice;
        float positiveRate = ((float) totalPrice / purchaseAmount) * 100;
        positiveRate = Math.round(positiveRate * 10) / 10.0f; // 둘째 자리에서 반올림
        return positiveRate;

    }
}
