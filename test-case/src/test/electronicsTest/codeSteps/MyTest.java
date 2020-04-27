import lombok.val;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

import java.math.BigDecimal;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static org.testng.Assert.assertEquals;

public class MyTest extends TestBase {

    @Test
    public void testProductHistory() {
        val productList = new NewProductsFragment().getNewProducts();
        val product1 = productList.get(0);
        val product2 = productList.get(1);
        open(product1.getProductLink());
        open(product2.getProductLink());
        val historyList = new HistoryFragment().getHistory();
        assertEquals(historyList.get(0), product2, "Wrong product");
        assertEquals(historyList.get(1), product1, "Wrong product");
    }

    @Test
    public void testPurchasePriceCalculation() {
        val newProductsFragment = new NewProductsFragment();
        val productList = newProductsFragment.getNewProducts().subList(0, 5);
        productList.forEach(newProductsFragment::addToCart);
        val sum = productList.stream().map(Product::getProductPrice).reduce(BigDecimal.ZERO, BigDecimal::add);
        new CommonPage().goToCart();
        $(By.id("total_products_num_price")).should(text(String.valueOf(sum)));
    }

    @Test
    public void testProductRemoveFromCart() {
        val newProductsFragment = new NewProductsFragment();
        val productList = newProductsFragment.getNewProducts().subList(0, 5);
        productList.forEach(newProductsFragment::addToCart);
        val sum = productList.stream().map(Product::getProductPrice).reduce(BigDecimal.ZERO, BigDecimal::add);
        new CommonPage().goToCart();
        $(By.id("total_products_num_price")).should(text(String.valueOf(sum)));
        val cartPage = new CartPage();
        cartPage.removeFirstCart();
        cartPage.removeFirstCart();
        val productListCartAfterRemove = productList.subList(0, 3);
        val cartSum = productListCartAfterRemove.stream().map(Product::getProductPrice).reduce(BigDecimal.ZERO, BigDecimal::add);
        $(By.id("total_products_num_price")).should(text(String.valueOf(cartSum)));
    }
}
