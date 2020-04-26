import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.openqa.selenium.By;

import java.io.IOException;

class testBaseClass {
    public static final String webSiteHost = "https://www.rdveikals.lv/";
    public static final String linkAttribute = "href";
    public static final String historyPanelSelector = "#seen-product-panel > ul > li:nth-child";
    By firstHistoryElem = By.cssSelector(historyPanelSelector + "(1) > a");
    By firstPurchaseName = By.cssSelector(historyPanelSelector + "(1) > div.product__info > div > h3 > a");
    By secondHistoryElem = By.cssSelector(historyPanelSelector + "(2) > a");
    By secondPurchaseName = By.cssSelector(historyPanelSelector + "(2) > div.product__info > div > h3 > a");

    public void getPurchaseLink(Purchase purchase) {
        String purchaseWebHost = webSiteHost + "products/lv/388/" + purchase.getPurchaseId();
        Document doc = null;
        try {
            doc = Jsoup.connect(purchaseWebHost + "/sort/1/filter/0_0_0_0/purchase.html")
                    .get();
        } catch (IOException e) {
            e.printStackTrace();
        }

        purchase.setPurchaseLink(doc.getElementsByAttributeValueContaining("content", purchaseWebHost)
                .attr("content"));
        String productName = doc.select("meta[name=keywords]").attr("content");
        purchase.setPurchaseName(productName.replaceAll(".*,", ""));
    }
}

