package pageobject;//Настрои импорты
import org.junit.Assert;
import org.openqa.selenium.*;

import java.text.SimpleDateFormat;
import java.util.Date;


public class OrderPage {
  private WebDriver driver;

    public OrderPage(WebDriver driver) {
       this.driver = driver;
    }


    // локатор для кнопки куки
    private By cookieButtonMain = By.id("rcc-confirm-button");
    //локатор кнопки "заказать", верхняя.
    private By orderFirstButton = By.cssSelector(".Header_Nav__AGCXC > button:nth-child(1)");
    //локатор кнопки "заказать", нижняя.
    private  By orderSecondButton = By.cssSelector(".Button_Middle__1CSJM");
    //локатор поля "Имя".
    private By nameField = By.xpath(".//div[@class='Input_InputContainer__3NykH']/input[@placeholder='* Имя']");
    //локатор поля "Фамилия".
    private By surnameField = By.xpath(".//div[@class='Input_InputContainer__3NykH']/input[@placeholder='* Фамилия']");
    //локатор поля "Адрес".
    private By adressField = By.xpath(".//div[@class='Input_InputContainer__3NykH']/input[@placeholder='* Адрес: куда привезти заказ']");
    //локатор списка метро.
    private By undegroundList = By.className("select-search__input");
    //локатор поля "Телефон".
    private By phoneNumberField =  By.xpath(".//div[@class='Input_InputContainer__3NykH']/input[@placeholder='* Телефон: на него позвонит курьер']");
    //локатор кнопки "Далее".
    private By nextButton = By.cssSelector(".Button_Middle__1CSJM");
    //локатор поля "Когда привезти".
    private By orderDate = By.xpath(".//div[@class='react-datepicker__input-container']/input[@placeholder='* Когда привезти самокат']");
    //локатор поля "Срока аренды".
    private By rentalPeriod = By.className("Dropdown-placeholder");
    //локатор поля "Цвет самоката".
    private By scooterColour = By.className("Order_Checkboxes__3lWSI");
    //локатор поля "Комментарии".
    private By commentField = By.cssSelector("div.Input_InputContainer__3NykH:nth-child(4) > input:nth-child(1)");
    //локатор кнопки "заказ", форма заказа.
    private By orderFormButton = By.xpath(".//div[@class='Order_Buttons__1xGrp']/button[text() = 'Заказать']");
    //локатор кнопки "Да".
    private By yesButton = By.xpath(".//button[@class='Button_Button__ra12g Button_Middle__1CSJM' and (text() = 'Да')]");
    //Информация окна заказа
    private By orderInfo = By.className("Order_ModalHeader__3FDaJ");
    //локатор кнопки подтверждения.
    private By confirmationButton = By.cssSelector(".Order_Text__2broi");


    // метод для закрытия кнопки куки
   public void clickCookie() {
  driver.findElement(cookieButtonMain).click();
    }

    //Выбор кнопки заказа
    public void clickOderButton(boolean upButton) {
        if(upButton)
            clickOrderUpButton();
        else clickOrderDownButton();
    }
    //нажатие кнопки "заказать", верхняя.
    public void clickOrderUpButton() {
        driver.findElement(orderFirstButton).click();
        }

    //нажатие кнопки "заказать", нижняя.
    public void clickOrderDownButton() {
        WebElement button = driver.findElement(orderSecondButton);
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();", button);
        driver.findElement(orderSecondButton).click();
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
    public void clickUndegroundList(String metro) {
        driver.findElement(undegroundList).click();
        driver.findElement(By.xpath(".//button[@value='" + metro + "']")).click();
    }
        //заполняет телефон
    public void setPhoneNumberField(String number) {
        driver.findElement(phoneNumberField).sendKeys(number);
    }

    //заполнение полей первой формы заказа
    public void login (String name, String surname, String adress, String numer) {
        setNameField(name);
        setSurnameField(surname);
        setAdressField(adress);
        setPhoneNumberField(numer);
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
        public void setRentalPeriod(int rentTime) {
        driver.findElement(rentalPeriod).click();
        driver.findElement(rentalPeriod).findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/div[2]/div[2]/div[2]/div["+rentTime+"]")).click();
    }

    //выбирает цвет самоката
        public void setScooterColour(String colour) {
            driver.findElement(scooterColour);
            driver.findElement(By.xpath("//*[@id=\""+colour+"\"]")).click();
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
          driver.findElement(confirmationButton).getText();
       }
    //вывод содержимого сообщения
    public String getConfirmationButton() {
       return driver.findElement(By.className("Order_Text__2broi")).getText();
    }

    //проверка окна информации
    public void getConfirmationInfo() {
        String text = driver.findElement(orderInfo).getText();
        String textPart = "Заказ оформлен";
        Assert.assertTrue(text.contains(textPart));
    }

}



/* С неймингом перестарался - в итоге сам запутался. Теперь распутался, спасибо!)  */



