package lotto.controller;

import java.util.List;
import lotto.dto.BonusNumberDto;
import lotto.dto.LottoListDto;
import lotto.dto.PurchaseDto;
import lotto.dto.WinningNumbersDto;
import lotto.entity.LottoMatchResult;
import lotto.input.BonusNumberInput;
import lotto.input.PurchaseInput;
import lotto.input.WinningNumberInput;
import lotto.service.LottoService;

public class LottoController {
    private final LottoService lottoService = new LottoService();
    private final WinningNumberInput winningNumberInput = new WinningNumberInput();
    private final BonusNumberInput bonusNumberInput = new BonusNumberInput();

    public void run() {
        PurchaseDto purchaseDto = PurchaseInput.getValidPurchaseDto();
        LottoListDto lottoListDto = lottoService.generateLottos(purchaseDto);
        lottoService.printLottos(lottoListDto);
        WinningNumbersDto validWinningNumbers = winningNumberInput.getValidWinningNumbers();
        BonusNumberDto bonusNumber = bonusNumberInput.getBonusNumber(validWinningNumbers);
        List<LottoMatchResult> mathResults = lottoService.validateResult(lottoListDto, validWinningNumbers,
                bonusNumber);
    }
}
