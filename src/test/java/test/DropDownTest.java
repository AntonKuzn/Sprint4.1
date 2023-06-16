package test;//Настроил импорты

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import pageObject.MainPage;

import java.time.Duration;


@RunWith(Parameterized.class)
public class DropDownTest {
    private WebDriver driver;

    //объявил страницу с методами для теста
    MainPage MainPage;

    //объявили переменные
    private final String text;
    private final int index;
    private final String URL = "https://qa-scooter.praktikum-services.ru/";

    public DropDownTest(String text, int index) {
        this.text = text;
        this.index = index;
    }
    @Parameterized.Parameters
    public static Object[] getText() {
        return new Object[][]{
                {"Сутки — 400 рублей. Оплата курьеру — наличными или картой.", 0},
                {"Пока что у нас так: один заказ — один самокат. Если хотите покататься с друзьями, можете просто сделать несколько заказов — один за другим.", 1},
                {"Допустим, вы оформляете заказ на 8 мая. Мы привозим самокат 8 мая в течение дня. Отсчёт времени аренды начинается с момента, когда вы оплатите заказ курьеру. Если мы привезли самокат 8 мая в 20:30, суточная аренда закончится 9 мая в 20:30.", 2},
                {"Только начиная с завтрашнего дня. Но скоро станем расторопнее.", 3},
                {"Пока что нет! Но если что-то срочное — всегда можно позвонить в поддержку по красивому номеру 1010.", 4},
                {"Самокат приезжает к вам с полной зарядкой. Этого хватает на восемь суток — даже если будете кататься без передышек и во сне. Зарядка не понадобится.", 5},
                {"Да, пока самокат не привезли. Штрафа не будет, объяснительной записки тоже не попросим. Все же свои.", 6},
                {"Да, обязательно. Всем самокатов! И Москве, и Московской области.", 7},
        };
    }

    @Before
    public void setUp() {
        //ChromeOptions options = new ChromeOptions();
        //options.addArguments("--no-sandbox", "--headless", "--disable-dev-shm-usage");
        //driver = new ChromeDriver(options);
        FirefoxOptions options = new FirefoxOptions();
        driver = new FirefoxDriver(options);
        driver.get(URL);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        MainPage = new MainPage(driver);
        MainPage.clickCookie();
    }

    @Test
    public void checkdropDownMenu() {
        MainPage.scrollToDropDown();
        MainPage.clickdropDownMenu(index);
        Assert.assertEquals("Текст не совпадает", text, MainPage.getAnswer(index));
    }

    @After
    public void tearDown() {
        driver.quit();
    }

    }