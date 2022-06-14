package lesson3;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;


public class LitresTest {

    public static void main(String[] args) throws InterruptedException {

        WebDriverManager.chromedriver().setup();


        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
        WebDriver webDriver = new ChromeDriver();

        //Сценарий проверки входа в личный кабинет
        webDriver.get("https://www.litres.ru/");

        WebElement loginModule = webDriver.findElement(By.xpath("//a[@class='Login-module__loginLink']"));
        loginModule.click();

        WebElement emailButton = webDriver.findElement(By.xpath("//div[@class='AuthorizationPopup-module__step__block']/button/div[text()='Электронная почта']"));
        emailButton.click();

        //Для проверки использовала одноразовую почту
        WebElement username = webDriver.findElement(By.xpath("//div[@class='AuthorizationPopup-module__step__block']/input[@name='email']"));
        username.sendKeys("vho45164@jiooq.com");

        WebElement submitButton = webDriver.findElement(By.xpath("//div[@class='AuthorizationPopup-module__step__block']/button[@type='submit']"));
        submitButton.click();

        Thread.sleep(2000);

        WebElement password = webDriver.findElement(By.xpath("//div[@class='AuthorizationPopup-module__step__block AuthorizationPopup-module__input-block']/input[@type='password']"));
        password.sendKeys("338/994");

        WebElement enterButton = webDriver.findElement(By.xpath("//div[@class='AuthorizationPopup-module__step__block']/button[@type='submit']"));
        enterButton.click();

        Thread.sleep(2000);
        webDriver.quit();

        //Сценарий из тест-кейса к прошлому уроку на добавление книги в корзину

        WebDriverManager.chromedriver().setup();


        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
        WebDriver webDriver1 = new ChromeDriver();

        webDriver1.get("https://www.litres.ru/");

        WebElement searchField = webDriver1.findElement(By.xpath("//div[@class='Search-module__wrapper']/input[@class='Search-module__input']"));
        searchField.sendKeys("Американские боги");

        WebElement searchButton = webDriver1.findElement(By.xpath("//div[@class='Search-module__wrapper']/button[@type='submit']"));
        searchButton.click();

        Thread.sleep(2000);

        WebElement searchResult = webDriver1.findElement(By.xpath("//div[@class='art-item__name']/a[@title='Американские боги']"));
        searchResult.click();

        WebElement addToCartButton = webDriver1.findElement(By.xpath("//button[@class='art-button art-buttons__basket']"));
        addToCartButton.click();

        Thread.sleep(2000);
        webDriver1.quit();

    }
}
