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
        //pre-conditions
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");

        WebDriver driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        //Steps 1: Go to website
        String url = "https://qa.koel.app/";
        driver.get(url);

        //Step 2: Find email text box
        WebElement emailField = driver.findElement(By.cssSelector("[type='email']"));
        emailField.click();
        emailField.clear();
        emailField.sendKeys("john.pasia@testpro.io");

        //Step 3: Find password text box
        WebElement passwordField = driver.findElement(By.cssSelector("[type='password']"));
        passwordField.click();
        passwordField.clear();
        passwordField.sendKeys("B3n@iah2013");

        //Step 4: Find and click Login button
        WebElement loginButton = driver.findElement(By.cssSelector("[type='submit']"));
        loginButton.click();

        //Expected Result
        WebElement userAvatar = driver.findElement(By.cssSelector("[class='avatar']"));

        Assert.assertTrue(userAvatar.isDisplayed());
        // driver.quit();
    }
}
