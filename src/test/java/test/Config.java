package test;

import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

import java.time.Duration;
import java.util.concurrent.TimeUnit;



public class Config {

    public WebDriver driver;

    @Before
    public void setUp() {
            //ChromeOptions options = new ChromeOptions();
        // options.addArguments("--no-sandbox", "--headless", "--disable-dev-shm-usage");
           //driver = new ChromeDriver(options);
           FirefoxOptions options = new FirefoxOptions();
           driver = new FirefoxDriver(options);
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    }

@After
public void tearDown() {
    driver.quit();
}
}



