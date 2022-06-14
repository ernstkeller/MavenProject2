package lesson5;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;


public class LitResTest {

    WebDriver driver;
    WebDriverWait webDriverWait;

    @BeforeAll
    static void registerDriver() {
        WebDriverManager.chromedriver().setup();
    }

    @BeforeEach
    void initDriver() {
        driver = new ChromeDriver();
        webDriverWait = new WebDriverWait(driver, Duration.ofSeconds(5));
        driver.get("https://www.litres.ru/");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));

        }

     @Test
     void logInTest() throws InterruptedException {
         WebElement loginModule = driver.findElement(By.xpath("//a[@class='Login-module__loginLink']"));
         loginModule.click();

         WebElement emailButton = driver.findElement(By.xpath("//div[@class='AuthorizationPopup-module__step__block']/button/div[text()='Электронная почта']"));
         emailButton.click();

         WebElement username = driver.findElement(By.xpath("//div[@class='AuthorizationPopup-module__step__block']/input[@name='email']"));
         username.sendKeys("vho45164@jiooq.com");

         WebElement submitButton = driver.findElement(By.xpath("//div[@class='AuthorizationPopup-module__step__block']/button[@type='submit']"));
         submitButton.click();

         Thread.sleep(2000);

         WebElement password = driver.findElement(By.xpath("//div[@class='AuthorizationPopup-module__step__block AuthorizationPopup-module__input-block']/input[@type='password']"));
         password.sendKeys("338/994");

         WebElement enterButton = driver.findElement(By.xpath("//div[@class='AuthorizationPopup-module__step__block']/button[@type='submit']"));
         enterButton.click();

         Thread.sleep(2000);

         Assertions.assertTrue(driver.findElement(By.xpath("//div/a[@class='Profile-module__profileLink']")).isDisplayed());

     }

     @Test
     void addBookToCart() throws InterruptedException {
         WebElement searchField = driver.findElement(By.xpath("//div[@class='Search-module__wrapper']/input[@class='Search-module__input']"));
         searchField.sendKeys("Американские боги");

         WebElement searchButton = driver.findElement(By.xpath("//div[@class='Search-module__wrapper']/button[@type='submit']"));
         searchButton.click();

         Thread.sleep(2000);

         WebElement searchResult = driver.findElement(By.xpath("//div[@class='art-item__name']/a[@title='Американские боги']"));
         searchResult.click();

         WebElement addToCartButton = driver.findElement(By.xpath("//button[@class='art-button art-buttons__basket']"));
         addToCartButton.click();

         Thread.sleep(2000);

         Assertions.assertTrue(driver.findElement(By.xpath("//div[@class='promo-books-popup__head']")).isDisplayed());
     }

    @AfterEach
    void tearDown() {
        driver.manage().deleteAllCookies();
        driver.quit();
    }


}
