package pages;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.WebDriver;
import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Condition.*;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.$;
import static org.openqa.selenium.Keys.ENTER;

public class CustomerServicePage{
    private SelenideElement searchField = $(byXpath("//input[contains(@type, 'search')]"));
    private List<SelenideElement> resultsList = $$(byXpath("//a[contains(@class, 'a-link-normal')]"));
    private SelenideElement resultHeader = $(byXpath("//div[contains(@class, 'help')]/h1"));
    private SelenideElement markInformationAsHelpful = $(byXpath("//input[contains(@aria-labelledby, 'a-autoid-0-announce')]"));
    private SelenideElement thankfulMessage = $(byXpath("//p[contains(text(), 'Thank you')]"));

    public boolean isSearchFieldVisible(){
        return searchField.isDisplayed();
    }

    public void searchSolution(final String REQUEST){
        searchField.sendKeys(REQUEST, ENTER);
    }

    public void clickOnFirstResult(){
        resultsList.get(0).click();
    }

    public String getResultHeaderText(){
        return resultHeader.getText();
    }

    public void clickOnYesButtonToMarkResultAsHelpful(){
        markInformationAsHelpful.click();
    }

    public boolean isThankfulMessageVisible(){
        return thankfulMessage.isDisplayed();
    }

}
