package lotto.validator;


import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import lotto.domain.LottoRange;
import lotto.dto.WinningNumbersDto;
import lotto.exception.ExceptionMessage;

public class InputValidator {

    public void checkBlank(String input) {
        if (input.equals("")) {
            throw new IllegalArgumentException(ExceptionMessage.CHECK_BLANK.getMessage());
        }
    }

    public void checkNumber(String input) {
        if (!input.matches("-?\\d+")) {
            throw new IllegalArgumentException(ExceptionMessage.CHECK_NUMBER.getMessage());
        }
    }

    public long checkRange(String input) {
        try {
            return Long.parseLong(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ExceptionMessage.CHECK_RANGE.getMessage());
        }
    }

    public void checkPositive(Long purchaseAmount) {
        if (purchaseAmount <= 0) {
            throw new IllegalArgumentException(ExceptionMessage.CHECK_POSIVITE.getMessage());
        }
    }

    public Long checkThousandUnit(Long purchaseAmount) {
        if (purchaseAmount % LottoRange.UNIT.getValue() != 0) {
            throw new IllegalArgumentException(ExceptionMessage.CHECK_THOUSAND_UNIT.getMessage());
        }
        return purchaseAmount / LottoRange.UNIT.getValue();
    }

    public List<Integer> commaSeparatedNumbers(String input) {
        List<Integer> list = new ArrayList<>();
        String[] tokens = input.split(",");
        for (String token : tokens) {
            try {
                String changed = token.replaceAll(" ", "");
                list.add(Integer.parseInt(changed));
            } catch (NumberFormatException e) {
                throw new IllegalArgumentException(ExceptionMessage.COMMA_SEPARATE_NUMBERS.getMessage());
            }
        }
        return list;
    }

    public void checkInLottoRange(List<Integer> list) {
        for (int num : list) {
            if (num < LottoRange.MIN.getValue() || num > LottoRange.MAX.getValue()) {
                throw new IllegalArgumentException(ExceptionMessage.CHECK_IN_LOTTO_RANGE.getMessage());
            }
        }
    }

    public int checkBonusRange(String input) {
        int num;
        try {
            num = Integer.parseInt(input.trim());
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ExceptionMessage.CHECK_BONUS_NUMBER.getMessage());
        }
        if (num < LottoRange.MIN.getValue() || num > LottoRange.MAX.getValue()) {
            throw new IllegalArgumentException(ExceptionMessage.CHECK_BONUS_NUMBER.getMessage());
        }
        return num;
    }


    public void checkLottoCount(List<Integer> list) {
        if (list.size() != 6) {
            throw new IllegalArgumentException(ExceptionMessage.CHECK_LOTTO_COUNT.getMessage());
        }
    }

    public void checkhHasDuplicates(List<Integer> list) {
        if (list.size() != new HashSet<>(list).size()) {
            throw new IllegalArgumentException(ExceptionMessage.CHECK_HAS_DUPLICATE_NUMBERS.getMessage());
        }
    }

    public void checkDuplicateWithWinningNumber(WinningNumbersDto winningNumbersDto, int bonus) {
        if (winningNumbersDto.getWinningNumbers().contains(bonus)) {
            throw new IllegalArgumentException(
                    ExceptionMessage.CHECK_DUPLICATE_NUMBERS_WITH_WINNING_NUMBERS.getMessage());
        }
    }
}
