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

        app.getUserHelper().clickRegisterOnNavBar();
        String email = "kmnvljsn1@mnvl.jhn";
        String password = "Qwerty123!";
        registration(email, password);
        WebElement accountInfo = app.getUserHelper().getAccountInfoElement();
        app.getHomePageHelper().pause(3000);
        String actualRes = accountInfo.getText().trim();
        System.out.println(actualRes);

        Assert.assertEquals(actualRes, email);
    }


    @AfterMethod
    public void methodPostCondition() {
        app.getHomePageHelper().navigateToHomePage();
    }

    public void registration(String email, String password) {
        app.getUserHelper().fillFirstnameOnRegistration("kjnfergl");
        app.getUserHelper().fillLastnameOnRegistration("jklegojerhy;");
        app.getUserHelper().fillEmailOnRegistration(email);
        app.getUserHelper().fillPasswordOnRegistration(password);
        app.getUserHelper().confirmPasswordOnRegistration(password);
        app.getUserHelper().clickOnRegisterBtn();
    }
}
