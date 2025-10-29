package lotto.input;

import static camp.nextstep.edu.missionutils.Console.readLine;

import lotto.validator.PurchaseInputValidator;

public class PurchaseInput {
    static PurchaseInputValidator purchseValidator = new PurchaseInputValidator();
    static Long purchaseAmount;

    public static void purchaseInputHadnler() {
        while (true) {
            System.out.println("구입금액을 입력해 주세요.");
            String input = readLine().trim();
            try {
                purchseValidator.checkBlank(input);
                purchseValidator.checkNumber(input);
                break;
            } catch (IllegalArgumentException e) {
                System.out.println("[ERROR] " + e.getMessage());
            }
        }
    }
}
