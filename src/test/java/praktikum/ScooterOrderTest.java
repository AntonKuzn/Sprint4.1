package praktikum;
//Настрои импорты
import PageObject.OrderPage;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

import java.util.concurrent.TimeUnit;

public class ScooterOrderTest {
    private WebDriver driver;
    OrderPage Order;

    @Before
    public void setUp() {
        // драйвер для браузера Chrome
       /* ChromeOptions options = new ChromeOptions();
        options.addArguments("--no-sandbox", "--headless", "--disable-dev-shm-usage");
        driver = new ChromeDriver(options);*/
        /* драйвер для браузера Firefox*/
        FirefoxOptions options = new FirefoxOptions();
       driver = new FirefoxDriver(options);
         WebDriver driver = new FirefoxDriver();

        //переход страницу тестового приложения
        driver.get("https://qa-scooter.praktikum-services.ru/");
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        Order = new OrderPage(driver);
        Order.closeCookie();
    }

    @Test
    public void checkOrderScooter() {
        Order.clickOrderDownButton();
        Order.login("Антон", "Кузнецов", "Двинская, 14", "+79044373822");
        Order.clickUndegroundList();
        Order.clickNextButton();
        Order.setOrderDate();
        Order.setRentalPeriodToFiveDays();
        Order.setScooterColourBlack();
        Order.setCommentField("Как можно скорее!");
        Order.clickOrderFormButton();
        Order.clickYesButton();
        Order.setConfirmationButton();
    }
    @Test
    public void checkOrderScooter1() {
        Order.clickOrderUpButton();
        Order.login("Василий", "Васильев", "Васильева, 124", "+79090001122");
        Order.clickUndegroundList1();
        Order.clickNextButton();
        Order.setOrderDate();
        Order.setRentalPeriodOneDays();
        Order.setScooterColourGray();
        Order.setCommentField("Я уже жду!");
        Order.clickOrderFormButton();
        Order.clickYesButton();
        Order.setConfirmationButton();
    }
    @After
    public void tearDown() {
        driver.quit();
    }
}