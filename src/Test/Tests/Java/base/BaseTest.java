package Java.base;

import org.openqa.selenium.WebDriver;

import java.HomePage;

public class BaseTest {

    private WebDriver driver;

    protected HomePage homePage;

    public BaseTest(WebDriver driver) {
        this.driver = driver;
    }
}
