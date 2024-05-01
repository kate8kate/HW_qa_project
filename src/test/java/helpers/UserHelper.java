package helpers;

import config.ApplicationManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class UserHelper extends BaseHelper{
    public UserHelper(WebDriver driver) {
        super(driver);
    }
    public void clickOnLoginBtnOnNavBar() {
        ApplicationManager.getDriver().findElement(By.xpath("//a[@href='/login']")).click();
    }
    public void clickOnLoginBtn() {
        ApplicationManager.getDriver().findElement(By.xpath("//*[@type='submit' and @class='button-1 login-button']")).click();
    }
    public void fillEmailOnLogin(String Email) {
        WebElement inputEmail = ApplicationManager.getDriver().findElement(By
                .xpath("//input[@name='Email']"));
        inputEmail.click();
        inputEmail.clear();
        inputEmail.sendKeys(Email);
    }
    public void fillPasswordOnLogin(String Password) {
        WebElement inputPassword = ApplicationManager.getDriver().findElement(By
                .xpath("//input[@name='Password']"));
        inputPassword.click();
        inputPassword.clear();
        inputPassword.sendKeys(Password);
    }
    public void login(String email, String password) {

        fillEmailOnLogin(email);
        fillPasswordOnLogin(password);
        clickOnLoginBtn();
    }
    public WebElement getAccountInfoElement() {
        WebElement accountInfo = ApplicationManager.getDriver().findElement(
                By.xpath("//a[@href='/customer/info' and @class='account']")
        );
        return accountInfo;
    }

    public void clickRegisterOnNavBar() {
        ApplicationManager.getDriver().findElement(By.xpath("//a[@href='/register']")).click();
    }


    public void fillFirstnameOnRegistration(String Firstname) {
        typeText(Firstname, By.xpath("//input[@name='FirstName']"));
    }
    public void fillEmailOnRegistration(String Email) {
        typeText(Email, By.xpath( "//input[@name='Email']"));
    }

    public void fillLastnameOnRegistration(String Lastname) {
        typeText(Lastname, By.xpath("//input[@name='LastName']"));
    }
    public void fillPasswordOnRegistration(String Password) {
        typeText(Password, By.xpath("//input[@name='Password']"));
    }
    public void confirmPasswordOnRegistration(String Password) {
        typeText(Password, By.xpath("//input[@name='ConfirmPassword']"));
    }
    public void clickOnRegisterBtn() {
        ApplicationManager.getDriver().findElement(By.xpath("//input[@name='register-button']")).click();
    }
}
