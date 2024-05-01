package helpers;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class BaseHelper {
    WebDriver driver;

    public BaseHelper(WebDriver driver) {
        this.driver = driver;
    }

    public WebElement getTextBaseByLocator(By by) {
        return driver.findElement(by);

    }

    protected void typeText(String text, By by) {
        WebElement element = getTextBaseByLocator(by);
        element.click();
        element.clear();
        element.sendKeys(text);
    }
    public void pause(int time) {
        try {
            Thread.sleep(time);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
