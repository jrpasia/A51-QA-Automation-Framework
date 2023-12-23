import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class LoginTests extends BaseTest {

    @Test
    public void loginEmptyEmailPassword() {
      navigateToLoginPage();
      clickLoginButton();
      Assert.assertEquals(driver.getCurrentUrl(), url);
    }

    @Test
    public void loginValidPassword(){
        //Steps
        navigateToLoginPage();
        provideEmail("john.pasia@testpro.io");
        providePassword("B3n@iah2013");
        clickLoginButton();
        WebElement userAvatar = driver.findElement(By.cssSelector("[class='avatar']"));

        //Expected Result
        Assert.assertTrue(userAvatar.isDisplayed());

    }

    @Test
    public void loginInvalidPassword(){
        navigateToLoginPage();
        provideEmail("john.pasia@testpro.io");
        providePassword("skljsdf");
        clickLoginButton();
        Assert.assertEquals(driver.getCurrentUrl(), url);

    }
    @Test
    public void loginInvalidEmail(){
        navigateToLoginPage();
        provideEmail("johnpasia@testpro.com");
        providePassword("B3n@iah2013");
        clickLoginButton();
        Assert.assertEquals(driver.getCurrentUrl(), url);
    }
    @Test
    public void loginEmptyEmail(){
        navigateToLoginPage();
        providePassword("B3n@iah2013");
        clickLoginButton();
        Assert.assertEquals(driver.getCurrentUrl(), url);
    }
    @Test
    public void loginEmptyPassword(){
        navigateToLoginPage();
        provideEmail("johnpasia@testpro.com");
        clickLoginButton();
        Assert.assertEquals(driver.getCurrentUrl(), url);

    }
}
