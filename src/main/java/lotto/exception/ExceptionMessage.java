package lotto.exception;

public enum ExceptionMessage {
    INVALID_LOTTO_COUNT("[ERROR] 로또 번호는 6개여야 합니다."),
    DUPLICATE_IN_LOTTO("[ERROR] 로또 번호에 중복이 있습니다.");

    private final String message;

    ExceptionMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
