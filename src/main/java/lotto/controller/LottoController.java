package lotto.controller;

import java.util.List;
import lotto.domain.LottoMatchResult;
import lotto.dto.BonusNumberDto;
import lotto.dto.LottoListDto;
import lotto.dto.PurchaseDto;
import lotto.dto.WinningNumbersDto;
import lotto.input.BonusNumberInput;
import lotto.input.PurchaseInput;
import lotto.input.WinningNumberInput;
import lotto.service.LottoService;
import lotto.view.PrintResult;

public class LottoController {
    private final LottoService lottoService = new LottoService();
    private final WinningNumberInput winningNumberInput = new WinningNumberInput();
    private final BonusNumberInput bonusNumberInput = new BonusNumberInput();
    private final PrintResult printResult = new PrintResult();

    public void run() {
        PurchaseDto purchaseDto = PurchaseInput.getValidPurchaseDto();
        LottoListDto lottoListDto = lottoService.generateLottos(purchaseDto);
        printResult.printLottos(lottoListDto);
        WinningNumbersDto validWinningNumbers = winningNumberInput.getValidWinningNumbers();
        BonusNumberDto bonusNumber = bonusNumberInput.getBonusNumber(validWinningNumbers);
        List<LottoMatchResult> matchResults = lottoService.validateResult(lottoListDto, validWinningNumbers,
                bonusNumber);

        int[] results = printResult.printResults(matchResults);
    }
}
