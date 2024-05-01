package tests;

import config.ApplicationManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

public class CreateAccountTest extends BaseTest{

    @Test
    public void positiveRegistrationTest() {

        clickRegisterOnNavBar();
        String email = "kmnvljsn1@mnvl.jhn";
        String password = "Qwerty123!";
        registration(email, password);
        WebElement accountInfo = getAccountInfoElement();
        pause(3000);
        String actualRes = accountInfo.getText().trim();
        System.out.println(actualRes);

        Assert.assertEquals(actualRes, email);
    }

    public static void pause(int time) {
        try {
            Thread.sleep(time);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
    @AfterMethod
    public void methodPostCondition() {
        navigateToHomePage();
    }

    public void registration(String email, String password) {
        fillFirstnameOnRegistration("kjnfergl");
        fillLastnameOnRegistration("jklegojerhy;");
        fillEmailOnRegistration(email);
        fillPasswordOnRegistration(password);
        confirmPasswordOnRegistration(password);
        clickOnRegisterBtn();
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

    public void typeText(String text, By by) {
        WebElement element = ApplicationManager.getDriver().findElement(by);
        element.click();
        element.clear();
        element.sendKeys(text);
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
