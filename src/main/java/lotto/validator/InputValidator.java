package lotto.validator;


import java.util.ArrayList;
import java.util.List;

public class InputValidator {
    Long unit = 1000L;

    public void checkBlank(String input) {
        if (input.equals("")) {
            throw new IllegalArgumentException("입력값이 비어있습니다.");
        }
    }

    public void checkNumber(String input) {
        if (!input.matches("-?\\d+")) {
            throw new IllegalArgumentException("정수를 입력해야 합니다.");
        }
    }

    public long checkRange(String input) {
        try {
            return Long.parseLong(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("범위를 벗어났습니다. 입력범위 : 약 9경까지");
        }
    }

    public void checkPositive(Long purchaseAmount) {
        if (purchaseAmount <= 0) {
            throw new IllegalArgumentException("양수를 입력해야 합니다.");
        }
    }

    public Long checkThousandUnit(Long purchaseAmount) {
        if (purchaseAmount % unit != 0) {
            throw new IllegalArgumentException("1000원 단위로 입력해야 합니다.");
        }
        return purchaseAmount / unit;
    }

    public List<Integer> commaSeparatedNumbers(String input) {
        List<Integer> list = new ArrayList<>();
        String[] tokens = input.split(",");
        for (String token : tokens) {
            try {
                list.add(Integer.parseInt(token.trim()));
            } catch (NumberFormatException e) {
                throw new IllegalArgumentException("정수를 입력해야합니다.");
            }
        }
        return list;
    }

    public void checkInLottoRange(List<Integer> list) {
        for (int num : list) {
            if (num < 1 || num > 45) {
                throw new IllegalArgumentException("로또 번호는 1~45 사이여야 합니다.");
            }
        }
    }
}
