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

//      Added ChromeOptions argument below to fix websocket error
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");

        WebDriver driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        String url = "https://qa.koel.app/";
        driver.get(url);
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
        WebElement homepageLogo = driver.findElement(By.cssSelector("[class='logo'] "));
        Assert.assertTrue(homepageLogo.isDisplayed());

    }
}
