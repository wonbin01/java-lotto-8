package lotto;

import lotto.controller.LottoController;
import lotto.input.WinningNumberInput;

public class Application {
    static LottoController lottoController = new LottoController();

    public static void main(String[] args) {
        lottoController.run();
        WinningNumberInput.winningNumberHandler();
    }
}
