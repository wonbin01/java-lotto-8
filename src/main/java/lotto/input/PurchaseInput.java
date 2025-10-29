package lotto.input;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import lotto.Lotto;
import lotto.validator.InputValidator;

public class PurchaseInput {

    static InputValidator purchaseValidator = new InputValidator();
    static List<Lotto> lottoList = new ArrayList<>();

    public static void purchaseInputHandler() {
        long purchaseCount = getValidPurchaseCount();
        lottoList = generateLottos(purchaseCount);
        printLottos(lottoList);
    }

    private static long getValidPurchaseCount() {
        long purchaseAmount;
        long purchaseCount;
        while (true) {
            System.out.println("구입금액을 입력해 주세요.");
            String input = Console.readLine().trim();
            try {
                purchaseValidator.checkBlank(input);
                purchaseValidator.checkNumber(input);
                purchaseAmount = purchaseValidator.checkRange(input);
                purchaseValidator.checkPositive(purchaseAmount);
                purchaseCount = purchaseValidator.checkThousandUnit(purchaseAmount);
                return purchaseCount;
            } catch (IllegalArgumentException e) {
                System.out.println("[ERROR] " + e.getMessage());
            }
        }
    }

    private static List<Lotto> generateLottos(long purchaseCount) {
        List<Lotto> lottoList = new ArrayList<>();
        while (true) {
            lottoList.clear();
            List<Lotto> lottocandidate = getLottos(purchaseCount, lottoList);
            if (lottocandidate != null) {
                return lottocandidate;
            }
        }
    }

    private static List<Lotto> getLottos(long purchaseCount, List<Lotto> lottoList) {
        try {
            for (long i = 0; i < purchaseCount; i++) {
                List<Integer> candidates = generateNumbers();
                Collections.sort(candidates);
                Lotto lotto = new Lotto(candidates);
                lottoList.add(lotto);
            }
            return lottoList;
        } catch (IllegalArgumentException e) {
            System.out.println("[ERROR] 로또 생성 중 오류가 발생했습니다. 처음부터 다시 생성합니다.");
        }
        return null;
    }

    private static void printLottos(List<Lotto> lottoList) {
        System.out.println(lottoList.size() + "개를 구매했습니다.");
        for (Lotto lotto : lottoList) {
            System.out.println(lotto);
        }
    }

    private static List<Integer> generateNumbers() {
        return Randoms.pickUniqueNumbersInRange(1, 45, 6);
    }

    public static List<Lotto> getLottos() {
        return lottoList;
    }
}

