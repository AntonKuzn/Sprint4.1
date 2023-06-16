package pageObject;//Настрои импорты
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


import java.time.Duration;


public class MainPage {

    private WebDriver driver;

    public MainPage(WebDriver driver) {
        this.driver = driver;
    }

    // локатор выпадающего списка
    private By dropDownMenu = By.className("accordion");
    // локатор для кнопки куки
    private By cookieButton = By.id("rcc-confirm-button");



    //закрывает куки
    public void clickCookie() {
        driver.findElement(cookieButton).click();
    }

    //скролл до "Вопросы о важном"
    public void scrollToDropDown() {
        WebElement element = driver.findElement(dropDownMenu);
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();", element);
    }

    //нажатие на выпадающий список
    public void clickdropDownMenu(int index) {
        driver.findElement(By.id("accordion__heading-"+index)).click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
    }


    // возвращает ответ на вопрос
    public String getAnswer(int index) {
        return driver.findElement(By.id("accordion__panel-"+index)).getText();
    }


}