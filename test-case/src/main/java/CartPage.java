import lombok.val;
import org.testng.Assert;

import static com.codeborne.selenide.Selenide.*;

public class CartPage extends CommonPage {
    public void removeFirstCart() {
        val elementSelector = "li:nth-child(1) > div > div:nth-child(1) > h3 > a";
        val elementToRevome = $(elementSelector).getText();
        $("li:nth-child(1) > div > div.product__info__part.product__controls.product__controls--small > a").click();
        val currentElement = $(elementSelector).getText();
        Assert.assertNotEquals(currentElement, elementToRevome, "Element not deleted from cart");
    }

}
