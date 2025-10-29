package lotto.validator;


public class PurchaseInputValidator {
    public void checkBlank(String input) {
        if (input.equals("")) {
            throw new IllegalArgumentException("입력값이 비어있습니다.");
        }
    }

    public void checkNumber(String input) {
        if (!input.matches("-?\\d+")) {
            throw new IllegalArgumentException("정수를 입력해야 합니다.");
        }
    }

    public long checkRange(String input) {
        try {
            return Long.parseLong(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("범위를 벗어났습니다. 입력범위 : 약 9경까지");
        }
    }

    public void checkPositive(Long purchaseAmount) {
        if (purchaseAmount < 0) {
            throw new IllegalArgumentException("양수를 입력해야 합니다.");
        }
    }
}
