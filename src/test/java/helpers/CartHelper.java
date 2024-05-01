package helpers;

import config.ApplicationManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CartHelper extends BaseHelper{
    public CartHelper(WebDriver driver) {
        super(driver);
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
