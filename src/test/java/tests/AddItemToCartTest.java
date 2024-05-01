package tests;

import config.ApplicationManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class AddItemToCartTest extends BaseTest{
    @BeforeClass
    public void preconditions() {

        clickOnLoginBtnOnNavBar();
        login(user.getEmail(), user.getPassword());

    }

    @Test
    public void addItemToCart() {

        addItemToCartBtn();
        checkYourCartBtn();
        WebElement сartInfo = getElementCartInfoText();
        String actualRes = getTextCart(сartInfo);
        System.out.println(actualRes);

        Assert.assertEquals(actualRes, "14.1-inch Laptop");

    }

    public String getTextCart(WebElement element) {
        return element.getText().trim();
    }

    public WebElement getElementCartInfoText() {
        return ApplicationManager.getDriver().findElement(
                By.xpath("//a[text()='14.1-inch Laptop' and @class='product-name']")
        );
    }

    public void addItemToCartBtn() {
        ApplicationManager.getDriver().findElements(By.xpath("//input[@value='Add to cart']"))
                .get(1).click();
    }
    public void checkYourCartBtn() {
        ApplicationManager.getDriver().findElement(By.xpath("//div[@class='footer']//a[@class='ico-cart']")).click();
    }
}
