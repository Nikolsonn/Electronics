import lombok.Value;

import java.math.BigDecimal;

@Value
public class Product {
    String productId;
    String productName;
    BigDecimal productPrice;
    String productLink;
}