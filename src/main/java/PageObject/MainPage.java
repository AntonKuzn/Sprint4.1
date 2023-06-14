package PageObject;

//Настрои импорты
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
    // локатор для кнопки куки
    private By cookieButton = By.id("rcc-confirm-button");

    // локатор выпадающего списка
    private By dropDowmMenu = By.xpath("/html/body/div/div/div/div[5]");

    //скролл до "Вопросы о важном"
    public void scrollToImportantQuestion() {
        WebElement element = driver.findElement(dropDowmMenu);
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();", element);
    }

    //закрывает куки
    public void closeCookie() {
        driver.findElement(cookieButton).click();
    }
    //нажатие на выпадающий список
    public void clickFirstQuestions() {
        driver.findElement(By.cssSelector("#accordion__heading-0")).click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
    }

    public void clickSecondQuestions() {
            driver.findElement(By.cssSelector("#accordion__heading-1")).click();
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        }

    public void clickThirdQuestions() {
        driver.findElement(By.cssSelector("#accordion__heading-2")).click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
    }

    public void clickFourthQuestion() {
        driver.findElement(By.cssSelector("#accordion__heading-3")).click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
    }
    public void clickFifthQuestion() {
        driver.findElement(By.cssSelector("#accordion__heading-4")).click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
    }
    public void clickSixthQuestion() {
        driver.findElement(By.cssSelector("#accordion__heading-5")).click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
    }
    public void clickSeventhQuestion() {
        driver.findElement(By.cssSelector("#accordion__heading-6")).click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
    }
    public void clickEighthQuestion() {
        driver.findElement(By.cssSelector("#accordion__heading-7")).click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
    }

    //
    public String getFirstAnswer() {
        return driver.findElement(By.cssSelector("#accordion__panel-0")).getText();
    }
    public String getSecondAnswer() {
        return driver.findElement(By.cssSelector("#accordion__panel-1")).getText();
    }
    public String getThirdAnswer() {
        return driver.findElement(By.cssSelector("#accordion__panel-2")).getText();
    }
    public String getFourthAnswer() {
        return driver.findElement(By.cssSelector("#accordion__panel-3")).getText();
    }
    public String getFifthAnswer() {
        return driver.findElement(By.cssSelector("#accordion__panel-4")).getText();
    }
    public String getSixthAnswer() {
        return driver.findElement(By.cssSelector("#accordion__panel-5")).getText();
    }
    public String getSeventhAnswer() {
        return driver.findElement(By.cssSelector("#accordion__panel-6")).getText();
    }
    public String getEighthAnswer() {
        return driver.findElement(By.cssSelector("#accordion__panel-7")).getText();
    }


}