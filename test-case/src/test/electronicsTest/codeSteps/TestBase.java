import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import static com.codeborne.selenide.Selenide.closeWebDriver;
import static com.codeborne.selenide.Selenide.open;

public class TestBase {
    @BeforeMethod
    protected void beforeMethod() {
        open(EnvironmentVariables.getHostUrl());
    }

    @AfterMethod
    protected void afterMethod() {
        closeWebDriver();
    }
}
