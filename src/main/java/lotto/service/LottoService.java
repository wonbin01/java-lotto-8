package lotto.service;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import lotto.domain.Lotto;
import lotto.domain.LottoMatchResult;
import lotto.dto.BonusNumberDto;
import lotto.dto.LottoListDto;
import lotto.dto.PurchaseDto;
import lotto.dto.WinningNumbersDto;

public class LottoService {
    int firstPrice = 2000000000;
    int secondPrice = 30000000;
    int thridPrice = 1500000;
    int forthPrice = 50000;
    int fifthPrice = 5000;

    public LottoListDto generateLottos(PurchaseDto dto) {
        List<Lotto> lottoList = new ArrayList<>();
        while (true) {
            try {
                for (long i = 0; i < dto.getPurchaseCount(); i++) {
                    List<Integer> candidates = generateNumbers();
                    Collections.sort(candidates);
                    Lotto lotto = new Lotto(candidates);
                    lottoList.add(lotto);
                }
                break;
            } catch (IllegalArgumentException e) {
                System.out.println("[ERROR] 로또 생성 중 오류가 발생했습니다. 처음부터 다시 생성합니다.");
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

    public float calculateMoney(int[] matchResult, PurchaseDto dto) {
        long purchaseAmount = dto.getPurchaseAmount();

        long firstWinnerPrice = (long) matchResult[1] * firstPrice;
        long secondWinnerPrice = (long) matchResult[2] * secondPrice;
        long thirdWinnerPrice = (long) matchResult[3] * thridPrice;
        long fourthWinnerPrice = (long) matchResult[4] * forthPrice;
        long fifthWinnerPrice = (long) matchResult[5] * fifthPrice;

        long totalPrice =
                firstWinnerPrice + secondWinnerPrice + thirdWinnerPrice + fourthWinnerPrice + fifthWinnerPrice;
        float positiveRate = (float) (totalPrice - purchaseAmount) / purchaseAmount * 100;
        positiveRate = Math.round(positiveRate * 10) / 10.0f;
        return positiveRate;
    }
}
