package lotto.validator;


public class PurchaseInputValidator {
    public void isBlank(String input) {
        if (input.equals("")) {
            throw new IllegalArgumentException("입력값이 비어있습니다.");
        }
    }

    public void isNumber(String input) {
        try {
            Long.parseLong(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("숫자를 입력해야합니다.");
        }
    }
}
