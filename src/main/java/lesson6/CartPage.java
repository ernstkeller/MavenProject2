package lesson6;

import io.qameta.allure.Step;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class CartPage extends BaseCharacteristics {

    public CartPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//div/a[@class='art__name__href']/span[@class='firstString']")
    private WebElement titleLink;

    @Step("Проверить успешное добавление книги в корзину")
    public void checkTitle(String title) {
        webDriverWait.until(ExpectedConditions.visibilityOf(titleLink));
        Assertions.assertEquals(title, titleLink.getText());


    }


}
