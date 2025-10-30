package lotto.controller;

import lotto.dto.BonusNumberDto;
import lotto.dto.LottoListDto;
import lotto.dto.PurchaseDto;
import lotto.dto.WinningNumbersDto;
import lotto.input.BonusNumberInput;
import lotto.input.PurchaseInput;
import lotto.input.WinningNumberInput;
import lotto.service.LottoService;

public class LottoController {
    private final LottoService lottoService = new LottoService();
    private final WinningNumberInput winningNumberInput = new WinningNumberInput();
    private final BonusNumberInput bonusNumberInput = new BonusNumberInput();

    public void run() {
        PurchaseDto dto = PurchaseInput.getValidPurchaseDto();
        LottoListDto lottoListDto = lottoService.generateLottos(dto);
        lottoService.printLottos(lottoListDto);
        WinningNumbersDto validWinningNumbers = winningNumberInput.getValidWinningNumbers();
        BonusNumberDto bonusNumber = bonusNumberInput.getBonusNumber(validWinningNumbers);
    }
}
