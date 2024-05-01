package tests;

import config.ApplicationManager;
import dto.UserDTO;
import org.openqa.selenium.remote.Browser;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import java.time.Duration;

public class BaseTest {
    static ApplicationManager app =
            new ApplicationManager(System.getProperty("browser", Browser.CHROME.browserName()));
    UserDTO user = new UserDTO().setEmail("kmnvljsn@mnvl.jhn").setPassword("Qwerty123!");

    @BeforeSuite
    public void startBrowser() {
        app.init();
    }
    @AfterSuite
    public void tearDown() {
        app.quit();
    }
}
