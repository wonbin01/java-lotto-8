package lotto.input;


import camp.nextstep.edu.missionutils.Console;
import lotto.dto.BonusNumberDto;
import lotto.dto.WinningNumbersDto;
import lotto.validator.InputValidator;

public class BonusNumberInput {
    static InputValidator validator = new InputValidator();

    public BonusNumberDto getBonusNumber(WinningNumbersDto winningNumbers) {
        while (true) {
            System.out.println("보너스 번호를 입력해 주세요.");
            String input = Console.readLine().trim();
            try {
                validator.checkBlank(input);
                validator.checkNumber(input);
                int bonus = validator.checkBonusRange(input);
                validator.checkDuplicateWithWinningNumber(winningNumbers, bonus);
                return new BonusNumberDto(bonus);
            } catch (IllegalArgumentException e) {
                System.out.println("[ERROR] " + e.getMessage());
            }
        }
    }
}
