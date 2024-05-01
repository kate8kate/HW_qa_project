package config;

import helpers.CartHelper;
import helpers.HomePageHelper;
import helpers.UserHelper;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.time.Duration;

public class ApplicationManager {
    static WebDriver driver;
    String browser;
    HomePageHelper homePageHelper;
    UserHelper userHelper;
    CartHelper cartHelper;

    public HomePageHelper getHomePageHelper() {
        return homePageHelper;
    }

    public UserHelper getUserHelper() {
        return userHelper;
    }

    public CartHelper getCartHelper() {
        return cartHelper;
    }

    public ApplicationManager(String browser) {
        this.browser = browser;
    }
    public void init(){
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--lange=en");
        WebDriverManager.chromedriver().setup();

        driver = new ChromeDriver(chromeOptions);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(60));
        driver.navigate().to("https://demowebshop.tricentis.com/");

        userHelper = new UserHelper(driver);
        cartHelper = new CartHelper(driver);
    }

    public void quit() {
        driver.quit();
    }

    public static WebDriver getDriver() {
        return driver;
    }
}
