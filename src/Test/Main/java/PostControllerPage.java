package java;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class PostControllerPage {

    private WebDriver driver;
    private By checkTitle = By.id("title");

    public PostControllerPage(WebDriver driver){this.driver = driver;}

    public String getTitleText(){return driver.findElement(checkTitle).getText();}
}
