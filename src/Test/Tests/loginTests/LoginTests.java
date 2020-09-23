package loginTests;

import Java.base.BaseTest;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

import java.LoginPage;
import java.PostControllerPage;

public class LoginTests extends BaseTest {

    @Test
    public void testSuccessfulLogin(){
        LoginPage loginPage = homePage.clickLogin();
        loginPage.setUsername("admin");
        loginPage.setPassword("000000");
        PostControllerPage postControllerPage = loginPage.ClickLoginButton();
        assertTrue(postControllerPage().findElement(By.linkText("Hello PostController!"), "Invalid Credentials");
    }
}
