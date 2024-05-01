package tests;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class AddItemToCartTest extends BaseTest {
    @BeforeClass
    public void preconditions() {

        app.getUserHelper().clickOnLoginBtnOnNavBar();
        app.getUserHelper().login(user.getEmail(), user.getPassword());

    }

    @Test
    public void addItemToCart() {

        app.getCartHelper().addItemToCartBtn();
        app.getCartHelper().checkYourCartBtn();
        WebElement сartInfo = app.getCartHelper().getElementCartInfoText();
        String actualRes = app.getCartHelper().getTextCart(сartInfo);
        System.out.println(actualRes);

        Assert.assertEquals(actualRes, "14.1-inch Laptop");

    }
}
