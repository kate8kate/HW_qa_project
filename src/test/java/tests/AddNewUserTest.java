package tests;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import dto.UserDTO;
import utils.DataProviders;


public class AddNewUserTest extends BaseTest{

    @Test(dataProvider = "addNewUser", dataProviderClass = DataProviders.class)
    public void positiveRegistrationUser(String firstName, String lastName, String email, String password) {

        app.getUserHelper().clickRegisterOnNavBar();
        UserDTO userDTO = new UserDTO()
                .setFirstName(firstName)
                .setLastName(lastName)
                .setEmail(email)
                .setPassword(password);
        app.getUserHelper().getAccountInfoElement();
        app.getHomePageHelper().pause(2000);
        String actualRes = app.getUserHelper().getAccountInfoElement().getText().trim();
        Assert.assertEquals(actualRes, email);
    }

    @AfterMethod
    public void methodPostCondition() {
        app.getHomePageHelper().navigateToHomePage();
    }

    public void registration(String firstName, String lastName, String email, String password) {
        app.getUserHelper().fillFirstnameOnRegistration(firstName);
        app.getUserHelper().fillLastnameOnRegistration(lastName);
        app.getUserHelper().fillEmailOnRegistration(email);
        app.getUserHelper().fillPasswordOnRegistration(password);
        app.getUserHelper().confirmPasswordOnRegistration(password);
        app.getUserHelper().clickOnRegisterBtn();
    }
}
