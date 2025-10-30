package lotto.controller;

import lotto.dto.LottoListDto;
import lotto.dto.PurchaseDto;
import lotto.input.PurchaseInput;
import lotto.service.LottoService;

public class LottoController {
    private final LottoService lottoService = new LottoService();

    public void run() {
        PurchaseDto dto = PurchaseInput.getValidPurchaseDto();
        LottoListDto lottoListDto = lottoService.generateLottos(dto);
    }
}
