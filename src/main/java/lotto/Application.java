package lotto;

import lotto.input.PurchaseInput;
import lotto.input.WinningNumberInput;

public class Application {
    public static void main(String[] args) {
        PurchaseInput.purchaseInputHandler();
        WinningNumberInput.winningNumberHandler();
    }
}
