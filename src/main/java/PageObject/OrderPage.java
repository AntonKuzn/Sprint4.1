package PageObject;
//Настрои импорты
import org.openqa.selenium.*;

import java.text.SimpleDateFormat;
import java.util.Date;

public class OrderPage {

    private WebDriver driver;

    // локатор для кнопки куки
    private By cookieButton = By.id("rcc-confirm-button");
    //локатор кнопки "заказать", верхняя.
    private By orderUpButton = By.xpath("/html/body/div/div/div/div[1]/div[2]/button[1]");
    //локатор кнопки "заказать", нижняя.
    private  By orderDownButton = By.xpath("//*[@id=\"root\"]/div/div/div[4]/div[2]/div[5]/button");
    //локатор поля "Имя".
    private By nameField = By.xpath("/html/body/div/div/div[2]/div[2]/div[1]/input");
    //локатор поля "Фамилия".
    private By surnameField = By.xpath("/html/body/div/div/div[2]/div[2]/div[2]/input");
    //локатор поля "Адрес".
    private By adressField = By.xpath("/html/body/div/div/div[2]/div[2]/div[3]/input");
    //локатор списка метро.
    private By undegroundList = By.className("select-search__input");
    //локатор поля "Телефон".
    private By phoneNumberField =  By.xpath("/html/body/div/div/div[2]/div[2]/div[5]/input");
    //локатор кнопки "Далее".
    private By nextButton = By.xpath("/html/body/div/div/div[2]/div[3]/button");
    //локатор поля "Когда привезти".
    private By orderDate = By.xpath("/html/body/div/div/div[2]/div[2]/div[1]/div/div/input");
    //локатор поля "Срока аренды".
    private By rentalPeriod = By.className("Dropdown-placeholder");
    //локатор поля "Цвет самоката".
    private By scooterColour = By.xpath("/html/body/div/div/div[2]/div[2]/div[3]");
    //локатор поля "Комментарии".
    private By commentField = By.xpath("/html/body/div/div/div[2]/div[2]/div[4]/input");
    //локатор кнопки "заказ", форма заказа.
    private By orderFormButton = By.xpath("/html/body/div/div/div[2]/div[3]/button[2]");
    //локатор кнопки "Да".
    private By yesButton = By.xpath("/html/body/div/div/div[2]/div[5]/div[2]/button[2]");
    //локатор кнопки подтверждения.
    private By confirmationButton = By.xpath("/html/body/div/div/div[2]/div[5]/div[1]");

    public OrderPage(WebDriver driver) {
        this.driver = driver;
    }
    // метод для закрытия кнопки куки
    public void closeCookie() {
        driver.findElement(cookieButton).click();
    }
        //нажатие кнопки "заказать", верхняя.
    public void clickOrderUpButton() {
        driver.findElement(orderUpButton).click();
        }
    //нажатие кнопки "заказать", нижняя.
    public void clickOrderDownButton() {
        WebElement buton = driver.findElement(orderDownButton);
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();", buton);
        driver.findElement(orderDownButton).click();
    }
    //заполняет поле "Имя"
        public void setNameField(String name) {
            driver.findElement(nameField).sendKeys(name);
        }
    //заполняет поле "Фамилия"
        public void setSurnameField(String surname){
                driver.findElement(surnameField).sendKeys(surname);
        }
    //заполняет Адрес
        public void setAdressField(String adress){
                    driver.findElement(adressField).sendKeys(adress);
        }
    //выбирает станцию метро
        public void clickUndegroundList() {
            driver.findElement(undegroundList).click();
            driver.findElement(By.xpath(".//button[@value='34']")).click();
         }
        public void clickUndegroundList1() {
            driver.findElement(undegroundList).click();
            driver.findElement(By.xpath(".//button[@value='18']")).click();
        }
    //заполняет телефон
        public void setPhoneNumberField(String number) {
            driver.findElement(phoneNumberField).sendKeys(number);
        }
    //нажимает кнопку "Далее"
        public void clickNextButton() {
            driver.findElement(nextButton).click();
        }
    //заполняет дату доставки самоката
        public void setOrderDate() {
            SimpleDateFormat formatter = new SimpleDateFormat("dd.MM.yy");
            Date date = new Date();
            driver.findElement(orderDate).click();
            driver.findElement(orderDate).sendKeys(formatter.format(date));
            driver.findElement(orderDate).sendKeys(Keys.ENTER);
        }
    //заполняет срок аренды
        public void setRentalPeriodToFiveDays() {
        driver.findElement(rentalPeriod).click();
        driver.findElement(rentalPeriod).findElement(By.xpath("/html/body/div/div/div[2]/div[2]/div[2]/div[2]/div[5]")).click();
    }
        public void setRentalPeriodOneDays() {
        driver.findElement(rentalPeriod).click();
        driver.findElement(rentalPeriod).findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/div[2]/div[2]/div[2]/div[1]")).click();
    }
    //выбирает цвет самоката
        public void setScooterColourBlack() {
            driver.findElement(scooterColour);
            driver.findElement(By.xpath("//*[@id=\"black\"]")).click();
    }
        public void setScooterColourGray() {
            driver.findElement(scooterColour);
            driver.findElement(By.xpath("//*[@id=\"grey\"]")).click();
    }
    //заполняет поле "Комментарий"
        public void setCommentField(String comment) {
            driver.findElement(commentField).sendKeys(comment);
    }
    //нажимает кнопку "заказать" в форме
        public void clickOrderFormButton() {
            driver.findElement(orderFormButton).click();
    }
    //нажимает кнопку "Да"
        public void clickYesButton() {
            driver.findElement(yesButton).click();
    }
    //проверка всплывающего уведомления о создании заказа
       public void setConfirmationButton () {
           String text = driver.findElement(confirmationButton).getText();
           System.out.println("Текст сообщения" + " " + text);
    }
    //заполнение полей первой формы заказа
       public void login (String name, String surname, String adress, String numer) {
           setNameField(name);
           setSurnameField(surname);
           setAdressField(adress);
           setPhoneNumberField(numer);
           }

}




