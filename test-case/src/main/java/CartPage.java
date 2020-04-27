import static com.codeborne.selenide.Selenide.$;

public class CartPage extends CommonPage {
    public void removeFirstCart() {
        $("li:nth-child(1) > div > div.product__info__part.product__controls.product__controls--small > a")
                .click();
    }

}
