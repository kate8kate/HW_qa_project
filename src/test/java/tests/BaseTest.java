package tests;

import dto.UserDTO;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import java.time.Duration;

public class BaseTest {
    static WebDriver driver;
    UserDTO user = new UserDTO().setEmail("kmnvljsn@mnvl.jhn").setPassword("Qwerty123!");

    @BeforeSuite
    public void init() {
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--lange=en");
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver(chromeOptions);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(60));
        driver.navigate().to("https://demowebshop.tricentis.com/");
    }
    @AfterSuite
    public void tearDown() { driver.quit(); }

    public void startToLoginBtn() {
        driver.findElement(By.xpath("//a[@href='/login']")).click();
    }

    public void clickOnLoginBtn() {
        driver.findElement(By.xpath("//*[@type='submit' and @class='button-1 login-button']")).click();
    }

    public void fillPasswordOnLogin(String Password) {
        WebElement inputPassword = driver.findElement(By
                .xpath("//input[@name='Password']"));
        inputPassword.click();
        inputPassword.clear();
        inputPassword.sendKeys(Password);
    }

    public void fillEmailOnLogin(String Email) {
        WebElement inputEmail = driver.findElement(By
                .xpath("//input[@name='Email']"));
        inputEmail.click();
        inputEmail.clear();
        inputEmail.sendKeys(Email);
    }

    public void login(String email, String password) {

        fillEmailOnLogin(email);
        fillPasswordOnLogin(password);
        clickOnLoginBtn();
    }
}
