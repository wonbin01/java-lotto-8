package lotto.input;

import static camp.nextstep.edu.missionutils.Console.readLine;

import lotto.validator.PurchaseInputHandler;

public class PurchaseInput {
    static PurchaseInputHandler inputHandler = new PurchaseInputHandler();

    public static void purchaseInputHadnler() {
        while (true) {
            System.out.println("구입금액을 입력해 주세요.");
            String input = readLine();
            try {
                inputHandler.isBlank(input);
                
                break;
            } catch (IllegalArgumentException e) {
                System.out.println("[ERROR] " + e.getMessage());
            }
        }
    }
}
