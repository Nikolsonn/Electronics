import java.math.BigDecimal;

public class Purchase extends testBaseClass {
    private BigDecimal purchasePrice;
    private int purchaseId;
    private String purchaseName;
    private String purchaseLink;

    public Purchase(int purchaseId) {
        this.setPurchaseId(purchaseId);
        getPurchaseLink(this);
    }

    public String getPurchaseLink() {
        return this.purchaseLink;
    }

    public void setPurchaseLink(String link) {
        this.purchaseLink = link;
    }

    public BigDecimal getPurchasePrice() {
        return this.purchasePrice;
    }

    public void setPurchasePrice(BigDecimal purchasePrice) {
        this.purchasePrice = purchasePrice;
    }

    public int getPurchaseId() {
        return this.purchaseId;
    }

    public void setPurchaseId(int purchaseId) {
        this.purchaseId = purchaseId;
    }

    public String getPurchaseName() {
        return this.purchaseName;
    }

    public void setPurchaseName(String purchaseName) {
        this.purchaseName = purchaseName;
    }

}