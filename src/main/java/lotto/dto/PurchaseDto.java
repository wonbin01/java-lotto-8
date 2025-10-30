package lotto.dto;

public class PurchaseDto {
    private final long purchaseAmount;
    private final long purchaseCount;

    public PurchaseDto(long purchaseAmount, long purchaseCount) {
        this.purchaseAmount = purchaseAmount;
        this.purchaseCount = purchaseCount;
    }

    public long getPurchaseAmount() {
        return purchaseAmount;
    }

    public long getPurchaseCount() {
        return purchaseCount;
    }
}
