package java;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CreatePostPage {

    private WebDriver driver;
    private By inputField = By.id("post_attachment");
    private By uploadButton = By.id("post_token");
    private By uploadedFiles = By.id("uploaded-files");

    public CreatePostPage (WebDriver driver){this.driver = driver;}

    public void clickUploadButton(){
        driver.findElement(uploadButton).click();
    }

    public void uploadFile(String absolutePathOfFile){
        driver.findElement(inputField).sendKeys(absolutePathOfFile);
        clickUploadButton();
    }

    public String getUploadedFiles(){
        return driver.findElement(uploadedFiles).getText();
    }
}
