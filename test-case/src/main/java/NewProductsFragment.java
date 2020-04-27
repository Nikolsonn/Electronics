import lombok.val;

import java.util.List;

import static com.codeborne.selenide.Selenide.$$;

public class NewProductsFragment extends ProductsFragment {

    protected String getRootElement() {
        return "#new-product-panel";
    }

    public List<Product> getNewProducts() {
        val newProducts = $$(getRootElement() + " li.product");
        return getProducts(newProducts);
    }

}
