package test;//Настрои импорты
import pageObject.OrderPage;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.assertEquals;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

import java.util.concurrent.TimeUnit;

@RunWith(Parameterized.class)
public class ScooterOrderTest {
    private WebDriver driver;
    OrderPage Order;

    boolean upButton;
    String name;
    String surname;
    String adress;
    String undeground;
    String numer;
    int rentTime;
    String comment;
    String colour;
    private final String URL = "https://qa-scooter.praktikum-services.ru/";


    public ScooterOrderTest (boolean upButton, String name, String surname, String adress, String undeground, String numer, int rentTime, String comment, String colour) {
        this.upButton = upButton;
        this.name = name;
        this.surname = surname;
        this.adress = adress;
        this.undeground = undeground;
        this.numer = numer;
        this.rentTime = rentTime;
        this.comment = comment;
        this.colour = colour;
    }



    @Parameterized.Parameters
    public static Object[] getInfo() {
        return new Object[][]{
                {true, "Антон", "Кузнецов", "Морская 12", "3", "89000000000", 1, "Тестовый Тест", "black" },
        };
    }

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
        driver.get(URL);
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        Order = new OrderPage(driver);
        Order.closeCookie();
    }

    @Test
    public void checkOrderScooter() {
        Order.clickOderButton(upButton);
        Order.login(name, surname, adress, numer);
        Order.clickUndegroundList(undeground);
        Order.clickNextButton();
        Order.setOrderDate();
        Order.setRentalPeriod(rentTime);
        Order.setScooterColour(colour);
        Order.setCommentField(comment);
        Order.clickOrderFormButton();
        Order.clickYesButton();
        Order.setConfirmationButton();
    }


    @After
    public void tearDown() {
        driver.quit();
    }
    }