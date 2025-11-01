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

    @Test
    public void 숫자가_입력되면_통과() {
        String input = "123";
        Assertions.assertThatCode(() -> validator.checkNumber(input))
                .doesNotThrowAnyException();
    }

    @Test
    public void 다른문자가_입력되면_오류발생() {
        String input = "천원";
        Assertions.assertThatThrownBy(() -> validator.checkNumber(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ExceptionMessage.CHECK_NUMBER.getMessage());
    }

    @Test
    public void long_범위를_벗어나는_입력이_주어지면_오류발생() {
        String input = "13215641612168432154613216845132164";
        Assertions.assertThatThrownBy(() -> validator.checkRange(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ExceptionMessage.CHECK_RANGE.getMessage());
    }
}
