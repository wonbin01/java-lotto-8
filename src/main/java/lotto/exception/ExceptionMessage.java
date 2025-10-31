package lotto.exception;

public enum ExceptionMessage {
    //Lotto
    INVALID_LOTTO_COUNT("[ERROR] 로또 번호는 6개여야 합니다."),
    DUPLICATE_IN_LOTTO("[ERROR] 로또 번호에 중복이 있습니다."),

    //LottoService
    ERROR_DURING_GENERATE("[ERROR] 로또 생성 중 오류가 발생했습니다. 처음부터 다시 생성합니다."),

    //InputValidator
    CHECK_BLANK("입력값이 비어있습니다."),
    CHECK_NUMBER("정수를 입력해야 합니다."),
    CHECK_RANGE("범위를 벗어났습니다. 입력범위 : 약 9경까지"),
    CHECK_POSIVITE("양수를 입력해야 합니다."),
    CHECK_THOUSAND_UNIT("1000원 단위로 입력해야 합니다."),
    COMMA_SEPARATE_NUMBERS("1~45 사이의 정수 6개를 입력해야 합니다."),
    CHECK_IN_LOTTO_RANGE("로또 번호는 1~45 사이여야 합니다."),
    CHECK_BONUS_NUMBER("보너스 번호는 1~45 사이여야 합니다."),
    CHECK_LOTTO_COUNT("로또 번호는 6개 입력되어야합니다."),
    CHECK_HAS_DUPLICATE_NUMBERS("중복된 숫자가 존재합니다."),
    CHECK_DUPLICATE_NUMBERS_WITH_WINNING_NUMBERS("당첨 번호와 보너스 번호사이에서 중복된 숫자가 존재합니다.");

    private final String message;

    ExceptionMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
