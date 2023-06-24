package test;//Настрои импорты
import pageobject.OrderPage;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.Test;

import static org.junit.Assert.assertEquals;


@RunWith(Parameterized.class)
public class ScooterOrderTest extends Config {

    //задали переменные для теста
    boolean upButton;
    String name;
    String surname;
    String adress;
    String undeground;
    String numer;
    int rentTime;
    String comment;
    String colour;



    public ScooterOrderTest(boolean upButton, String name, String surname, String adress, String undeground, String numer, int rentTime, String comment, String colour) {
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
                {true, "Антон", "Кузнецов", "Морская 12", "3", "89000000000", 1, "Тестовый Тест", "black"},

                {false, "Тестовый", "Тест", "Тестовая 90", "7", "99999999999", 2, "Тест Тестовый", "grey"},
        };
    }

    //@Before


    @Test
    public void checkOrderScooter() {
        driver.get(Constant.URL);
        OrderPage orderpage = new OrderPage(driver);

        orderpage.clickCookie();
        orderpage.clickOderButton(upButton);
        orderpage.login(name, surname, adress, numer);
        orderpage.clickUndegroundList(undeground);
        orderpage.clickNextButton();
        orderpage.setOrderDate();
        orderpage.setRentalPeriod(rentTime);
        orderpage.setScooterColour(colour);
        orderpage.setCommentField(comment);
        orderpage.clickOrderFormButton();
        orderpage.clickYesButton();
        orderpage.setConfirmationButton();
        orderpage.getConfirmationInfo();
    }

    }