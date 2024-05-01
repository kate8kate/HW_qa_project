package tests;

import config.ApplicationManager;
import dto.UserDTO;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.Browser;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import java.time.Duration;

public class BaseTest {
    static ApplicationManager app =
            new ApplicationManager(System.getProperty("browser", Browser.CHROME.browserName()));
    UserDTO user = new UserDTO().setEmail("kmnvljsn@mnvl.jhn").setPassword("Qwerty123!");

    @BeforeSuite
    public void startBrowser() {
        app.init();
    }
    @AfterSuite
    public void tearDown() {
        app.quit();

    }

    public void clickOnLoginBtnOnNavBar() {
        ApplicationManager.getDriver().findElement(By.xpath("//a[@href='/login']")).click();
    }

    public void clickOnLoginBtn() {
        ApplicationManager.getDriver().findElement(By.xpath("//*[@type='submit' and @class='button-1 login-button']")).click();
    }

    public void fillPasswordOnLogin(String Password) {
        WebElement inputPassword = ApplicationManager.getDriver().findElement(By
                .xpath("//input[@name='Password']"));
        inputPassword.click();
        inputPassword.clear();
        inputPassword.sendKeys(Password);
    }

    public void fillEmailOnLogin(String Email) {
        WebElement inputEmail = ApplicationManager.getDriver().findElement(By
                .xpath("//input[@name='Email']"));
        inputEmail.click();
        inputEmail.clear();
        inputEmail.sendKeys(Email);
    }

    public void login(String email, String password) {

        fillEmailOnLogin(email);
        fillPasswordOnLogin(password);
        clickOnLoginBtn();
    }

    public void navigateToHomePage() {
        ApplicationManager.getDriver().navigate().to("https://demowebshop.tricentis.com/");
    }
}
