package lotto.exception;

public enum ExceptionMessage {
    INVALID_LOTTO_COUNT("[ERROR] 로또 번호는 6개여야 합니다."),
    DUPLICATE_IN_LOTTO("[ERROR] 로또 번호에 중복이 있습니다."),

    ERROR_DURING_GENERATE("[ERROR] 로또 생성 중 오류가 발생했습니다. 처음부터 다시 생성합니다.");

    private final String message;

    ExceptionMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
