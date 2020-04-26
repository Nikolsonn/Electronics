import org.openqa.selenium.By;
import org.testng.annotations.Test;

import java.math.BigDecimal;
import java.util.LinkedList;
import java.util.List;

import static com.codeborne.selenide.Condition.attribute;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;


public class testingS extends testBaseClass {
    Purchase phone1 = new Purchase(175625);
    Purchase phone2 = new Purchase(257743);
    Purchase phone3 = new Purchase(175626);
    Purchase phone4 = new Purchase(156402);
    Purchase phone5 = new Purchase(120350);

    @Test
    public void testPurchaseHistory() {
        open(phone1.getPurchaseLink());
        open(phone2.getPurchaseLink());
        $(firstPurchaseName).shouldHave(text(phone2.getPurchaseName()));
        $(secondPurchaseName).shouldHave(text(phone1.getPurchaseName()));
        $(firstHistoryElem).shouldHave(attribute(linkAttribute, phone2.getPurchaseLink()));
        $(secondHistoryElem).shouldHave(attribute(linkAttribute, phone1.getPurchaseLink()));
    }

    @Test
    public void testPurchasePriceCalculation() {
        addToCart(phone1.getPurchaseLink());
        addToCart(phone2.getPurchaseLink());
        addToCart(phone3.getPurchaseLink());
        addToCart(phone4.getPurchaseLink());
        addToCart(phone5.getPurchaseLink());
        open(webSiteHost + "cart/lv/");
        $(By.id("total_products_num_price")).should(text(purchasesSum()));
    }

    public String purchasesSum() {

        List<BigDecimal> purchaseSum = new LinkedList<>();
        purchaseSum.add(phone1.getPurchasePrice());
        purchaseSum.add(phone2.getPurchasePrice());
        purchaseSum.add(phone3.getPurchasePrice());
        purchaseSum.add(phone4.getPurchasePrice());
        purchaseSum.add(phone5.getPurchasePrice());

        BigDecimal sum = purchaseSum.stream().reduce(BigDecimal.ZERO, BigDecimal::add);
        return sum.toString();
    }
}
