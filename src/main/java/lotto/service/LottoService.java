package lotto.service;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import lotto.Lotto;
import lotto.dto.LottoListDto;
import lotto.dto.PurchaseDto;

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

}
