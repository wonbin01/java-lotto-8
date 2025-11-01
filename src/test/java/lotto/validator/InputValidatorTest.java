package lotto.validator;

import java.util.List;
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

    @Test
    public void long_범위_안으로_들어오는_입력이_주어지면_통과() {
        String input = "5000";
        Assertions.assertThatCode(() -> validator.checkRange(input))
                .doesNotThrowAnyException();
    }

    @Test
    public void 음수가_주어지면_예외_발생() {
        long input = -1000;
        Assertions.assertThatThrownBy(() -> validator.checkPositive(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ExceptionMessage.CHECK_POSIVITE.getMessage());
    }

    @Test
    public void 양수가_입력되면_통과() {
        long input = 5000;
        Assertions.assertThatCode(() -> validator.checkPositive(input))
                .doesNotThrowAnyException();
    }

    @Test
    public void 천원_단위로_주어지지않으면_예외_발생() {
        long input = 5001;
        Assertions.assertThatThrownBy(() -> validator.checkThousandUnit(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ExceptionMessage.CHECK_THOUSAND_UNIT.getMessage());
    }

    @Test
    public void 천원_단위로_주어지면_통과() {
        long input = 10000;
        Assertions.assertThatCode(() -> validator.checkThousandUnit(input))
                .doesNotThrowAnyException();
    }

    @Test
    public void 정상_콤마_구분_정수_변환() {
        String input = "1, 2,3, 4,5";
        List<Integer> result = validator.commaSeparatedNumbers(input);
        Assertions.assertThat(result).containsExactly(1, 2, 3, 4, 5);
    }

    @Test
    public void 숫자가_아닌값_포함시_예외발생() {
        String input = "1,2,3,사,5";
        Assertions.assertThatThrownBy(() -> validator.commaSeparatedNumbers(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ExceptionMessage.COMMA_SEPARATE_NUMBERS.getMessage());
    }
}
