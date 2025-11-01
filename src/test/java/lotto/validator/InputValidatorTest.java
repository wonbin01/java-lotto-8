package lotto.validator;

import lotto.exception.ExceptionMessage;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class InputValidatorTest {
    private final InputValidator validator = new InputValidator();

    @Test
    public void 빈칸이_주어지면_오류_발생() {
        String input = "";
        Assertions.assertThatThrownBy(() -> validator.checkBlank(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ExceptionMessage.CHECK_BLANK.getMessage());
    }

    @Test
    public void 정상입력_통과_테스트() {
        String input = "로또";
        Assertions.assertThatCode(() -> validator.checkBlank(input))
                .doesNotThrowAnyException();
    }
}
