package helpers;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class UserHelper extends BaseHelper{
    public UserHelper(WebDriver driver) {
        super(driver);
    }
    public void clickOnLoginBtnOnNavBar() {
        driver.findElement(By.xpath("//a[@href='/login']")).click();
    }
    public void clickOnLoginBtn() {
        driver.findElement(By.xpath("//*[@type='submit' and @class='button-1 login-button']")).click();
    }
    public void fillEmailOnLogin(String Email) {
        typeText("//input[@name='Email']", Email);
    }
    public void fillPasswordOnLogin(String Password) {
        typeText("//input[@name='Password']", Password);
    }

    public void typeText(String xpathExpression, String Password) {
        WebElement element = driver.findElement(By
                .xpath(xpathExpression));
        element.click();
        element.clear();
        element.sendKeys(Password);
    }

    public void login(String email, String password) {

        fillEmailOnLogin(email);
        fillPasswordOnLogin(password);
        clickOnLoginBtn();
    }
    public WebElement getAccountInfoElement() {
        WebElement accountInfo = driver.findElement(
                By.xpath("//a[@href='/customer/info' and @class='account']")
        );
        return accountInfo;
    }

    public void clickRegisterOnNavBar() {
        driver.findElement(By.xpath("//a[@href='/register'and @class='ico-register']")).click();
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
        driver.findElement(By.xpath("//input[@name='register-button']")).click();
    }
}
