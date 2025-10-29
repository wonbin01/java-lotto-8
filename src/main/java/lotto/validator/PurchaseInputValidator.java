package lotto.validator;


public class PurchaseInputValidator {
    public void isBlank(String input) {
        if (input.trim().equals("")) {
            throw new IllegalArgumentException("입력값이 비어있습니다.");
        }
    }
}
