package helpers;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class UserHelper extends BaseHelper{
    public UserHelper(WebDriver driver) {
        super(driver);
    }
    By btnLoginNB = By.xpath("//a[@href='/login']");
    By btnLogin = By.xpath("//input[@type='submit' and contains(@class,'login')]");
    By btnRegisterNB = By.xpath("//a[text()='Register' and @class='ico-register']");
    By btnRegister = By.xpath("//input[@id='register-button']");
    public void clickOnLoginBtnOnNavBar() {
        driver.findElement(btnLoginNB).click();
    }
    public void fillEmailOnLogin(String Email) {
        typeText("//input[@name='Email']", Email);
    }
    public void fillPasswordOnLogin(String Password) {
        typeText("//input[@name='Password']", Password);
    }
    public void clickOnLoginBtn() {
        driver.findElement(btnLogin).click();
    }
    public void login(String email, String password) {
        fillEmailOnLogin(email);
        fillPasswordOnLogin(password);
        clickOnLoginBtn();
    }

    public void clickRegisterOnNavBar() {
        driver.findElement(btnRegisterNB).click();
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
        driver.findElement(btnRegister).click();
    }
    public WebElement getAccountInfoElement() {
        WebElement accountInfo = driver.findElement(
                By.xpath("//a[@href='/customer/info' and @class='account']")
        );
        return accountInfo;
    }
}
