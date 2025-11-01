package lotto.service;

import java.util.List;
import lotto.domain.Lotto;
import lotto.domain.LottoMatchResult;
import lotto.dto.BonusNumberDto;
import lotto.dto.LottoListDto;
import lotto.dto.PurchaseDto;
import lotto.dto.WinningNumbersDto;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class LottoServiceTest {
    @Test
    public void 로또_번호_정상_생성() {
        PurchaseDto dto = new PurchaseDto(5000, 5);
        LottoService service = new LottoService();
        LottoListDto lottoListDto = service.generateLottos(dto);

        Assertions.assertThat(lottoListDto.getLottolist()).hasSize(5);
    }

    @Test
    public void 당첨_결과_정상_검증() {
        LottoService service = new LottoService();

        Lotto lotto1 = new Lotto(List.of(1, 2, 3, 4, 5, 6)); //6개 맞음
        Lotto lotto2 = new Lotto(List.of(1, 2, 3, 4, 5, 7)); //5개 맞음 + 보너스
        Lotto lotto3 = new Lotto(List.of(1, 2, 3, 4, 5, 8)); //5개 맞음 + 보너스 x
        LottoListDto lottoListDto = new LottoListDto(List.of(lotto1, lotto2, lotto3));
        WinningNumbersDto winningNumbersDto = new WinningNumbersDto(List.of(1, 2, 3, 4, 5, 6));
        BonusNumberDto bonusNumberDto = new BonusNumberDto(7);

        List<LottoMatchResult> results = service.validateResult(lottoListDto, winningNumbersDto,
                bonusNumberDto);
        Assertions.assertThat(results);

        Assertions.assertThat(results.get(0).getMatchCount()).isEqualTo(6);
        Assertions.assertThat(results.get(0).getIsBonusMatch()).isFalse();

        Assertions.assertThat(results.get(1).getMatchCount()).isEqualTo(5);
        Assertions.assertThat(results.get(1).getIsBonusMatch()).isTrue();

        Assertions.assertThat(results.get(2).getMatchCount()).isEqualTo(5);
        Assertions.assertThat(results.get(2).getIsBonusMatch()).isFalse();
    }

    @Test
    public void getPrizeIndex_1등_테스트() {
        LottoService service = new LottoService();
        int result = service.getPrizeIndex(6, false);
        Assertions.assertThat(result).isEqualTo(1);
    }

    @Test
    public void getPrizeIndex_2등_테스트() {
        LottoService service = new LottoService();
        int result = service.getPrizeIndex(5, true);
        Assertions.assertThat(result).isEqualTo(2);
    }

    @Test
    public void getPrizeIndex_3등_테스트() {
        LottoService service = new LottoService();
        int result = service.getPrizeIndex(5, false);
        Assertions.assertThat(result).isEqualTo(3);
    }

    @Test
    public void getPrizeIndex_4등_테스트() {
        LottoService service = new LottoService();
        int result = service.getPrizeIndex(4, false);
        Assertions.assertThat(result).isEqualTo(4);
    }

    @Test
    public void getPrizeIndex_5등_테스트() {
        LottoService service = new LottoService();
        int result = service.getPrizeIndex(3, false);
        Assertions.assertThat(result).isEqualTo(5);
    }

    @Test
    public void getPrizeIndex_당첨안됨_테스트() {
        LottoService service = new LottoService();
        int result = service.getPrizeIndex(2, false);
        Assertions.assertThat(result).isEqualTo(0);
    }
}
