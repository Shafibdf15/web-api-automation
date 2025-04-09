package web.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class Registration {

    // Webdriver instance
    WebDriver driver;
    private WebDriverWait wait;
    //Locators
    By userInputUsername = By.id("sign-username");
    By userInputPassword = By.id("sign-password");
    By registerSubmitButton = By.xpath("//*[@id=\"signInModal\"]/div/div/div[3]/button[2]");

    //Constructor
    public Registration(WebDriver driver){
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofMillis(5000));
    }

    // Enter username to input field
    public void enterUsername(String newUsername){
        driver.findElement(userInputUsername).sendKeys(newUsername);
    }

    // Enter password to input field
    public void enterPassword(String newPassword){
        driver.findElement(userInputPassword).sendKeys(newPassword);
    }

    // Clicking registration submission button
    public void submitRegis(){
        driver.findElement(registerSubmitButton).click();
        this.wait.until(ExpectedConditions.alertIsPresent());
    }

    // Entering pre existing account info to register
    public void enterExistingUsername(){
        driver.findElement(userInputUsername).sendKeys("DemoAccount15");
        driver.findElement((userInputPassword)).sendKeys("DemoAccount15");
    }


}
