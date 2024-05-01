package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

public class CreateAccountTest extends BaseTest{
    @AfterMethod
    public void methodPostCondition() {
        navigateToHomePage();
    }

    public void navigateToHomePage() {
        driver.navigate().to("https://demowebshop.tricentis.com/");
    }

    @Test
    public void positiveRegistrationTest() throws InterruptedException {

        clickRegisterOnNavBar();
        String email = "kmnvljsn1@mnvl.jhn";
        String password = "Qwerty123!";
        registration(email, password);

        // validation-verification by checking account info: //a[@href='/customer/info' and @class='account']
        // text: jfnwig@jngut3.nvh
        WebElement accountInfo = getAccountInfoElement();
        Thread.sleep(10000);
        String actualRes = accountInfo.getText().trim();
        System.out.println(actualRes);

        Assert.assertEquals(actualRes, email);
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
        WebElement accountInfo = driver.findElement(
                By.xpath("//a[@href='/customer/info' and @class='account']")
        );
        return accountInfo;
    }

    public void clickRegisterOnNavBar() {
        driver.findElement(By.xpath("//a[@href='/register']")).click();
    }
    public void clickOnRegisterBtn() {
        driver.findElement(By.xpath("//input[@name='register-button']")).click();
    }
    public void fillFirstnameOnRegistration(String Firstname) {
        WebElement inputFirstname = driver.findElement(By.xpath(
                "//input[@name='FirstName']"));
        inputFirstname.click();
        inputFirstname.clear();
        inputFirstname.sendKeys(Firstname);
    }
    public void fillEmailOnRegistration(String Email) {
        WebElement inputEmail = driver.findElement(By.xpath(
                "//input[@name='Email']"));
        inputEmail.click();
        inputEmail.clear();
        inputEmail.sendKeys(Email);
    }

    public void fillLastnameOnRegistration(String Lastname) {
        WebElement inputLastname = driver.findElement(By.xpath(
                "//input[@name='LastName']"));
        inputLastname.click();
        inputLastname.clear();
        inputLastname.sendKeys(Lastname);
    }
    public void fillPasswordOnRegistration(String Password) {
        WebElement inputPassword = driver.findElement(By.xpath(
                "//input[@name='Password']"));
        inputPassword.click();
        inputPassword.clear();
        inputPassword.sendKeys(Password);
    }
    public void confirmPasswordOnRegistration(String Password) {
        WebElement confirmPassword = driver.findElement(By.xpath(
                "//input[@name='ConfirmPassword']"));
        confirmPassword.click();
        confirmPassword.clear();
        confirmPassword.sendKeys(Password);
    }
}
