package lesson6;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class SearchResultPage extends BaseCharacteristics {

    public SearchResultPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//div[@class='art-item__name']/a[@title='Американские боги']")
    private WebElement searchResult;

    public SearchResultPage chooseSearchResult() {
        webDriverWait.until(ExpectedConditions.visibilityOf(searchResult));
        searchResult.click();
        return new SearchResultPage(driver);
    }

}
