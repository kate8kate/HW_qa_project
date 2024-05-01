package helpers;

import config.ApplicationManager;
import org.openqa.selenium.WebDriver;

public class HomePageHelper extends BaseHelper{
    public HomePageHelper(WebDriver driver) {
        super(driver);
    }
    public void navigateToHomePage() {
        ApplicationManager.getDriver().navigate().to("https://demowebshop.tricentis.com/");
    }
}
