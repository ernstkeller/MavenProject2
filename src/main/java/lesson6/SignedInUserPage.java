package lesson6;

import io.qameta.allure.Step;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class SignedInUserPage extends BaseCharacteristics{

    public SignedInUserPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//span/div/div/div/div[@class='Avatar-module__topContent']")
    private WebElement profileLink;

    @Step("Проверить успешный вход в четную запись")
    public void checkSuccessLogIn(String username){
        webDriverWait.until(ExpectedConditions.visibilityOf(profileLink));
        Assertions.assertEquals(username, profileLink.getText());
    }



}
