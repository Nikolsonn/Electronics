import static com.codeborne.selenide.Selenide.open;

public class CommonPage {
    public void goToCart() {
        open(EnvironmentVariables.getHostUrl() + "cart/lv/");
    }
}
