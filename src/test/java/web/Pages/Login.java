package web.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;


import java.time.Duration;

public class Login {

    //Calling web driver and homepage instance
    WebDriver driver;
    private WebDriverWait wait;
    HomePage homePage;

    //Locators for login
    By UName = By.id("loginusername");
    By Upassword = By.id("loginpassword");
    By getLoginButton = By.xpath("//*[@id=\"logInModal\"]/div/div/div[3]/button[2]");

    // Constructor
    public Login(WebDriver driver){
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofMillis(5000));
    }

    // Enter username to input field
    public void enterUsername(String username){
        driver.findElement(UName).sendKeys(username);
    }

    //Enter password to input field
    public void enterPassword(String password){
        driver.findElement(Upassword).sendKeys(password);
    }

    //Click login button
    public void setLoginButton(){
        driver.findElement(getLoginButton).click();

    }


}
