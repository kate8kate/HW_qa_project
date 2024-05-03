package helpers;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CartHelper extends BaseHelper {
    public CartHelper(WebDriver driver) {
        super(driver);
    }
    /*public boolean isSerNumberDisplays(String serialNumberStr) {
    serNum = serialNumberStr;
    return isElementExist(serNumber);
}
    public String getTextCart(WebElement element) {
лучше сделать базовые методы по поиску элемента и получению текста в бейс хелпере*/
    public String getTextCart(WebElement element) {
        return element.getText().trim();
    }

    public WebElement getElementCartInfoText() {
        return driver.findElement(
                By.xpath("//a[text()='14.1-inch Laptop' and @class='product-name']")
        );
    }

    public void addItemToCartBtn() {
        driver.findElements(By.xpath("//input[@value='Add to cart']"))
                .get(1).click();
    }

    public void checkYourCartBtn() {
        driver.findElement(By.xpath("//div[@class='footer']//a[@class='ico-cart']")).click();
    }
}
