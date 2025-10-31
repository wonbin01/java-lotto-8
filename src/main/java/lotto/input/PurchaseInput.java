package lotto.input;

import camp.nextstep.edu.missionutils.Console;
import lotto.dto.PurchaseDto;
import lotto.validator.InputValidator;

public class PurchaseInput {

    static InputValidator purchaseValidator = new InputValidator();

    public static PurchaseDto getValidPurchaseDto() {
        long purchaseAmount;
        long purchaseCount;
        while (true) {
            System.out.println("구입금액을 입력해 주세요.");
            String input = Console.readLine().trim();
            try {
                purchaseValidator.checkBlank(input);
                purchaseValidator.checkNumber(input);
                purchaseAmount = purchaseValidator.checkRange(input);
                purchaseValidator.checkPositive(purchaseAmount);
                purchaseCount = purchaseValidator.checkThousandUnit(purchaseAmount);
                System.out.println();
                return new PurchaseDto(purchaseAmount, purchaseCount);
            } catch (IllegalArgumentException e) {
                System.out.println("[ERROR] " + e.getMessage());
            }
        }
    }

}

