package java;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage {

    private WebDriver driver;

    public HomePage(WebDriver driver){
        this.driver = driver;
    }

    public LoginPage clickLogin(){
        clickLink("login");
        return new LoginPage(driver);
    }

    public PostsPage clickDropdown(){
        clickLink("Posts");
        return new PostsPage(driver);
    }

    private void clickLink(String linkText){
        driver.findElement(By.linkText(linkText)).click();
    }

}

