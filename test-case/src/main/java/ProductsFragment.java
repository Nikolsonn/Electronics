import com.codeborne.selenide.ElementsCollection;
import lombok.val;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public abstract class ProductsFragment {

    public void addToCart(Product product) {
        open(product.getProductLink());
        $("div.product-info__buttons > a[data-product-id='" + product.getProductId() + "']").click();
        $("#in-cart a.btn.js-close").click();
    }

    protected List<Product> getProducts(ElementsCollection productsContainers) {
        return productsContainers.stream().map(h -> {
                    val href = h.find("a.overlay").attr("href");
                    val id = href.split("/")[6];
                    return new Product(
                            id,
                            h.find(".product__title").text(),
                            new BigDecimal(h.find(".price b").text()),
                            href);
                }
        ).collect(Collectors.toList());
    }
}
