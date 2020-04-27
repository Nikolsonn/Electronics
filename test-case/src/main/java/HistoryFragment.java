import lombok.val;

import java.util.List;

import static com.codeborne.selenide.Selenide.$$;

public class HistoryFragment extends ProductsFragment {

    protected String getRootElement() {
        return "#seen-product-panel";
    }

    public List<Product> getHistory() {
        val history = $$(getRootElement() +" li.product");
        return getProducts(history);
    }


}
