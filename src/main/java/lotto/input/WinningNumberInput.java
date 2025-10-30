package lotto.input;

import camp.nextstep.edu.missionutils.Console;
import java.util.List;
import lotto.dto.WinningNumbersDto;
import lotto.validator.InputValidator;

public class WinningNumberInput {
    static InputValidator validator = new InputValidator();

    public WinningNumbersDto getValidWinningNumbers() {
        while (true) {
            System.out.println("당첨 번호를 입력해 주세요.");
            String input = Console.readLine().trim();
            try {
                validator.checkBlank(input);
                List<Integer> candidate = validator.commaSeparatedNumbers(input);
                validator.checkLottoCount(candidate);
                validator.checkInLottoRange(candidate);
                validator.checkhHasDuplicates(candidate);
                return new WinningNumbersDto(candidate);
            } catch (IllegalArgumentException e) {
                System.out.println("[ERROR] " + e.getMessage());
            }
        }
    }
}
