package lotto.input;

import camp.nextstep.edu.missionutils.Console;
import lotto.validator.InputValidator;

public class WinningNumberInput {
    static InputValidator validator = new InputValidator();

    public static void getWinningNumbers() {
        while (true) {
            System.out.println("당첨 번호를 입력해 주세요.");
            String input = Console.readLine().trim();
            try {
                validator.checkBlank(input);

                break;
            } catch (IllegalArgumentException e) {
                System.out.println("[ERROR] " + e.getMessage());
            }
        }
    }
}
