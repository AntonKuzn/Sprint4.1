package praktikum;
//Настрои импорты
import PageObject.MainPage;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;


import java.time.Duration;

import static org.junit.Assert.assertEquals;


public class DropDownTest {

    private WebDriver driver;
    MainPage MainPage;

    @Before
    public void setUp() {
        //драйвер для Chrome
       /* ChromeOptions options = new ChromeOptions();
        options.addArguments("--no-sandbox", "--headless", "--disable-dev-shm-usage");

         driver = new ChromeDriver(options);*/

        //создали драйвер для браузера Firefox
        FirefoxOptions options = new FirefoxOptions();
        driver = new FirefoxDriver(options);

        driver.get("https://qa-scooter.praktikum-services.ru/");
        WebDriver.Timeouts timeouts = driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        MainPage = new MainPage(driver);
        MainPage.closeCookie();
        }

    @Test
    public void checkFirstQuestion() {
        MainPage.scrollToImportantQuestion();
        MainPage.clickFirstQuestions();
            String text = "Сутки — 400 рублей. Оплата курьеру — наличными или картой.";
            assertEquals("Текст не совпадает", text, MainPage.getFirstAnswer());
        }
    @Test
    public void checkSecondQuestions() {
        MainPage.scrollToImportantQuestion();
        MainPage.clickSecondQuestions();
        String text = "Пока что у нас так: один заказ — один самокат. Если хотите покататься с друзьями, можете просто сделать несколько заказов — один за другим.";
        assertEquals("Текст не совпадает", text, MainPage.getSecondAnswer());
    }

    @Test
    public void checkThirdQuestion() {
        MainPage.scrollToImportantQuestion();
        MainPage.clickThirdQuestions();
        String text = "Допустим, вы оформляете заказ на 8 мая. Мы привозим самокат 8 мая в течение дня. Отсчёт времени аренды начинается с момента, когда вы оплатите заказ курьеру. Если мы привезли самокат 8 мая в 20:30, суточная аренда закончится 9 мая в 20:30.";
        assertEquals("Текст не совпадает", text, MainPage.getThirdAnswer());
    }

    @Test
    public void checkFourthQuestion() {
        MainPage.scrollToImportantQuestion();
        MainPage.clickFourthQuestion();
        String text = "Только начиная с завтрашнего дня. Но скоро станем расторопнее.";
        assertEquals("Текст не совпадает", text, MainPage.getFourthAnswer());
    }

    @Test
    public void checkFifthQuestion() {
        MainPage.scrollToImportantQuestion();
        MainPage.clickFifthQuestion();
        String text = "Пока что нет! Но если что-то срочное — всегда можно позвонить в поддержку по красивому номеру 1010.";
        assertEquals("Текст не совпадает", text, MainPage.getFifthAnswer());
    }

    @Test
    public void checkSixthQuestion() {
        MainPage.scrollToImportantQuestion();
        MainPage.clickSixthQuestion();
        String text = "Самокат приезжает к вам с полной зарядкой. Этого хватает на восемь суток — даже если будете кататься без передышек и во сне. Зарядка не понадобится.";
        assertEquals("Текст не совпадает", text, MainPage.getSixthAnswer());
    }

    @Test
    public void checkSeventhQuestion() {
        MainPage.scrollToImportantQuestion();
        MainPage.clickSeventhQuestion();
        String text = "Да, пока самокат не привезли. Штрафа не будет, объяснительной записки тоже не попросим. Все же свои.";
        assertEquals("Текст не совпадает", text, MainPage.getSeventhAnswer());
    }

    @Test
    public void checkEighthQuestion() {
        MainPage.scrollToImportantQuestion();
        MainPage.clickEighthQuestion();
        String text = "Да, обязательно. Всем самокатов! И Москве, и Московской области.";
        assertEquals("Текст не совпадает", text, MainPage.getEighthAnswer());
    }

    @After
    public void tearDown() {
        driver.quit();
    }

    }
