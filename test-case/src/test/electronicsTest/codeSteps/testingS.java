import org.testng.annotations.Test;

import static com.codeborne.selenide.Condition.attribute;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;


public class testingS extends testBaseClass {
    Purchase product1 = new Purchase(175625);
    Purchase product2 = new Purchase(257743);


    @Test
    public void testPurchaseHistory() {
        open(product1.getPurchaseLink());
        open(product2.getPurchaseLink());
        $(firstPurchaseName).shouldHave(text(product2.getPurchaseName()));
        $(secondPurchaseName).shouldHave(text(product1.getPurchaseName()));
        $(firstHistoryElem).shouldHave(attribute(linkAttribute, product2.getPurchaseLink()));
        $(secondHistoryElem).shouldHave(attribute(linkAttribute, product1.getPurchaseLink()));

    }

}
