package java;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class PostsPage {

    private WebDriver driver;

    public PostsPage(WebDriver driver) {
    }

    public CreatePostPage clickDropdown(){
        clickLink("Create new Post");
        return new CreatePostPage(driver);
    }

    private void clickLink(String linkText){
        driver.findElement(By.linkText(linkText)).click();

    }
}
