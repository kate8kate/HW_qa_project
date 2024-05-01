package helpers;

import config.ApplicationManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class BaseHelper {
    WebDriver driver;

    public BaseHelper(WebDriver driver) {
        this.driver = driver;
    }
    public static void pause(int time) {
        try {
            Thread.sleep(time);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
    public void typeText(String text, By by) {
        WebElement element = ApplicationManager.getDriver().findElement(by);
        element.click();
        element.clear();
        element.sendKeys(text);
    }
}
