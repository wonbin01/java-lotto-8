package lotto.dto;

import java.util.List;
import lotto.domain.Lotto;

public class LottoListDto {
    private final List<Lotto> lottolist;

    public LottoListDto(List<Lotto> lottolist) {
        this.lottolist = lottolist;
    }

    public List<Lotto> getLottolist() {
        return lottolist;
    }
}
