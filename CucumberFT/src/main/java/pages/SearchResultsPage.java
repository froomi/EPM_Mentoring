package pages;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.*;

import java.util.List;

import static com.codeborne.selenide.Selectors.byXpath;

public class SearchResultsPage {

    @FindBy(xpath = "//li[contains(@id, 'p_n_format_browse-bin')]")
    private List<WebElement>  cardDeliveryTypes;

    @FindBy(xpath = "//span[contains(text(), 'Sort by:')]")
    private WebElement sortByButton;

    @FindBy(xpath = "//a[contains(@id, 's-result-sort-select_2')]")
    private WebElement highToLowSortingType;

    @FindBy(xpath = "//span[contains(@class, 'a-size-base-plus a-color-base a-text-normal')]")
    private List<WebElement> cardsList;

    @FindBy(xpath = "//span[contains(@class, 'a-size-medium a-color-base a-text-normal')]")
    private List<WebElement> productsList;

//    public SearchResultsPage(WebDriver driver) {
//        super(driver);
//    }

    public WebElement getFirstCardDeliveryType(){
        return cardDeliveryTypes.get(0);
    }

    public void clickCardDeliveryListOnFirstType() {
        $$(byXpath("//li[contains(@id, 'p_n_format_browse-bin')]")).get(0).click();
       // cardDeliveryTypes.get(0).click();
    }

    public boolean isSortByButtonVisible(){
        return  $(byXpath("//span[contains(text(), 'Sort by:')]")).isDisplayed();
    }

    public void clickSortByButton(){
        $(byXpath("//span[contains(text(), 'Sort by:')]")).click();
    }

    public void clickHighToLowSortingType(){
        $(byXpath("//a[contains(@id, 's-result-sort-select_2')]")).click();
    }

    public List<SelenideElement> getCardsList(){
        return $$(byXpath("//span[contains(@class, 'a-size-base-plus a-color-base a-text-normal')]"));
    }

    public void clickOnFirstProductFromList(){
        $$(byXpath("//span[contains(@class, 'a-size-medium a-color-base a-text-normal')]")).get(0).click();
    }

}
