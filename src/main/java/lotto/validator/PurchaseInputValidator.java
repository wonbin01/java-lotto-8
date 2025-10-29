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

}
