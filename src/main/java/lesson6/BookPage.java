package lesson6;

import io.qameta.allure.Step;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class BookPage extends BaseCharacteristics {

    public BookPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//button[@class='art-button art-buttons__basket']")
    private WebElement addToCartButton;

    @FindBy(xpath = "//button[@class='art-button art-buttons__basket art-buttons__basket_active']")
    private WebElement activeCartButton;

    @FindBy(xpath = "//div[@class='promo-books-popup__head']")
    private WebElement promoPopup;
    @FindBy(xpath = "//div[@class='promo-books-popup']/a[@class='close']")
    private WebElement popupCloseButton;

    @Step("Добавить книги в корзину")
    public BookPage addToCart() {
        webDriverWait.until(ExpectedConditions.visibilityOf(addToCartButton));
        addToCartButton.click();
        webDriverWait.until(ExpectedConditions.visibilityOf(promoPopup));
        popupCloseButton.click();
        activeCartButton.click();
        return new BookPage(driver);


    }


}
