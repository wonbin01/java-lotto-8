package lotto.validator;


import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class InputValidator {
    Long unit = 1000L;
    int min = 1;
    int max = 45;

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
            if (num < min || num > max) {
                throw new IllegalArgumentException("로또 번호는 1~45 사이여야 합니다.");
            }
        }
    }

    public void checkLottoCount(List<Integer> list) {
        if (list.size() != 6) {
            throw new IllegalArgumentException("로또 번호는 6개 입력되어야합니다.");
        }
    }

    public void checkhasDuplicates(List<Integer> list) {
        if (list.size() != new HashSet<>(list).size()) {
            throw new IllegalArgumentException("중복된 숫자가 존재합니다.");
        }
    }
}
