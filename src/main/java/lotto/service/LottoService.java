package lotto.service;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import lotto.dto.BonusNumberDto;
import lotto.dto.LottoListDto;
import lotto.dto.PurchaseDto;
import lotto.dto.WinningNumbersDto;
import lotto.entity.Lotto;
import lotto.entity.LottoMatchResult;

public class LottoService {
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

    public void printLottos(LottoListDto lottoListDto) {
        System.out.println(lottoListDto.getLottolist().size() + "개를 구매했습니다.");
        for (Lotto lotto : lottoListDto.getLottolist()) {
            System.out.println(lotto);
        }
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
}
