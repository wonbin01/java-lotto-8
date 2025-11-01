package lotto.service;

import lotto.dto.LottoListDto;
import lotto.dto.PurchaseDto;
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
}
