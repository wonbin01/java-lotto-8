package lotto.input;

import camp.nextstep.edu.missionutils.Console;
import java.util.List;
import lotto.validator.InputValidator;

public class WinningNumberInput {
    static InputValidator validator = new InputValidator();

    public static void winningNumberHandler() {
        List<Integer> winningNumbers = getValidWinningNumbers();
    }

    public static List<Integer> getValidWinningNumbers() {
        while (true) {
            System.out.println("당첨 번호를 입력해 주세요.");
            String input = Console.readLine().trim();
            try {
                validator.checkBlank(input);
                List<Integer> candidate = validator.commaSeparatedNumbers(input);
                validator.checkLottoCount(candidate);
                validator.checkInLottoRange(candidate);
                validator.checkhasDuplicates(candidate);
                return candidate;
            } catch (IllegalArgumentException e) {
                System.out.println("[ERROR] " + e.getMessage());
            }
        }
    }

    public static int getBonusNumber() {
        System.out.println("보너스 번호를 입력해 주세요.");
        String input = Console.readLine().trim();
        try {
            validator.checkBlank(input);
            validator.checkNumber(input);
            int bonus = validator.checkBonusRange(input);

        } catch (IllegalArgumentException e) {
            System.out.println("[ERROR] " + e.getMessage());
        }
    }
}
