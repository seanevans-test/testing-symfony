package Java.base;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeTest;

import java.HomePage;

public class BaseTest {

    private WebDriver driver;
    protected HomePage homePage;

    @BeforeTest
    public void setUp(){

    }

}
