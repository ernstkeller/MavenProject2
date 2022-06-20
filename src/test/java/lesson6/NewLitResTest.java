package lesson6;

import io.github.bonigarcia.wdm.WebDriverManager;
import io.qameta.allure.Allure;
import io.qameta.allure.Description;
import io.qameta.allure.Story;
import lesson7.AdditionalAllureSteps;
import org.junit.jupiter.api.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.logging.LogEntries;
import org.openqa.selenium.logging.LogEntry;
import org.openqa.selenium.logging.LogType;
import org.openqa.selenium.support.events.EventFiringDecorator;


public class NewLitResTest {

    WebDriver driver;

    @BeforeAll
    static void registerDriver() {
        WebDriverManager.chromedriver().setup();
    }

    @BeforeEach
    void initDriver() {
        driver = new EventFiringDecorator(new AdditionalAllureSteps()).decorate(new ChromeDriver());
        driver.get("https://www.litres.ru/");
    }

    @Story("Вход в учетную запись зарегистрированного пользователя")
    @Description("Проверка входа в учетную запись зарегистрированного пользователя с вводом валидных данных логина и пароля")
    @Test
    void logInTest() {
        new MainPage(driver)
                .login("vho45164@jiooq.com", "338/994");
        new SignedInUserPage(driver)
                .checkSuccessLogIn("vho45164");
    }

    @Story("Покупка книги")
    @Description("Проверка добавления книги в корзину")
    @Test
    void addBookToCart() {
        new MainPage(driver)
                .searchBook("Американские боги");
        new SearchResultPage(driver)
                .chooseSearchResult();
        new BookPage(driver)
                .addToCart();
        new CartPage(driver)
                .checkTitle("Американские боги");
    }

    @AfterEach
    void killDriver() {
        LogEntries logEntries = driver.manage().logs().get(LogType.BROWSER);
        for (LogEntry logEntry: logEntries) {
            Allure.addAttachment("Элемент лога браузера", logEntry.getMessage());
        }
        driver.quit();
    }

}
