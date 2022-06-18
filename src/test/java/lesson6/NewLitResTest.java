package lesson6;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class NewLitResTest {

    WebDriver driver;

    @BeforeAll
    static void registerDriver() {
        WebDriverManager.chromedriver().setup();
    }

    @BeforeEach
    void initDriver() {
        driver = new ChromeDriver();
        driver.get("https://www.litres.ru/");
    }

    @Test
    void logInTest() {
        new MainPage(driver)
                .login("vho45164@jiooq.com", "338/994");
        new SignedInUserPage(driver)
                .checkSuccessLogIn("vho45164");
    }

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
        driver.quit();
    }

}
