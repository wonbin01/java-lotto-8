package lotto.view;

import java.util.List;
import lotto.domain.Lotto;
import lotto.domain.LottoMatchResult;
import lotto.dto.LottoListDto;
import lotto.service.LottoService;

public class PrintResult {
    LottoService lottoService = new LottoService();

    public PrintResult() {
    }

    public void printLottos(LottoListDto lottoListDto) {
        System.out.println(lottoListDto.getLottolist().size() + "개를 구매했습니다.");
        for (Lotto lotto : lottoListDto.getLottolist()) {
            System.out.println(lotto);
        }
        System.out.println();
    }

    public void printResults(List<LottoMatchResult> results) {
        int[] matchResult = lottoService.getMatchResult(results);

        System.out.println("당첨 통계");
        System.out.println("---");
        System.out.println("3개 일치 (5,000원) - " + matchResult[5] + "개");
        System.out.println("4개 일치 (50,000원) - " + matchResult[4] + "개");
        System.out.println("5개 일치 (1,500,000원) - " + matchResult[3] + "개");
        System.out.println("5개 일치, 보너스 볼 일치 (30,000,000원) - " + matchResult[2] + "개");
        System.out.println("6개 일치 (2,000,000,000원) - " + matchResult[1] + "개");
    }
}
