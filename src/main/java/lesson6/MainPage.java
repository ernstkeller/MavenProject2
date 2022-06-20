package lesson6;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class MainPage extends BaseCharacteristics {

    public MainPage(WebDriver driver) {
        super(driver);
    }

    //logInTest
    @FindBy(xpath = "//a[@class='Login-module__loginLink']")
    private WebElement logInButton;

    @FindBy(xpath = "//div[@class='AuthorizationPopup-module__step__block']/button/div[text()='Электронная почта']")
    private WebElement emailButton;

    @FindBy(xpath = "//div[@class='AuthorizationPopup-module__step__block']/input[@name='email']")
    private WebElement userNameField;

    @FindBy(xpath = "//div[@class='AuthorizationPopup-module__step__block']/button[@type='submit']")
    private WebElement submitButton;

    @FindBy(xpath = "//div[@class='AuthorizationPopup-module__step__block AuthorizationPopup-module__input-block']/input[@type='password']")
    private WebElement passwordField;

    @FindBy(xpath = "//div[@class='AuthorizationPopup-module__step__block']/button[@type='submit']")
    private WebElement enterButton;

    //searchBookTest
    @FindBy(xpath = "//div[@class='Search-module__wrapper']/input[@class='Search-module__input']")
    private WebElement searchField;

    @FindBy(xpath = "//div[@class='Search-module__wrapper']/button[@type='submit']")
    private WebElement searchButton;

    @Step ("Ввести логин и пароль зарегистрированного пользователя")
    public MainPage login(String email, String password) {
        logInButton.click();
        emailButton.click();
        userNameField.sendKeys(email);
        submitButton.click();
        webDriverWait.until(ExpectedConditions.visibilityOf(passwordField));
        passwordField.sendKeys(password);
        enterButton.click();
        return new MainPage(driver);
    }

    @Step ("Ввести поисковой запрос в строку поиска")
    public MainPage searchBook(String searchRequest) {
        searchField.sendKeys(searchRequest);
        searchButton.click();
        return new MainPage(driver);
    }


}
