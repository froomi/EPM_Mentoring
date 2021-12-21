package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class BrowsingHistoryPage extends BasePage{

    @FindBy(xpath = "//span[contains(@class, 'a-button a-button-base a-button-small ybh-remove')]")
    private List<WebElement> removeFromViewButtons;

    @FindBy(xpath = "//div[contains(@id, 'no_items_message')]/span")
    private WebElement browsingHistoryMessage;

    public BrowsingHistoryPage(WebDriver driver) {
        super(driver);
    }

    public boolean isRemoveFromViewButtonVisible(){
        return removeFromViewButtons.get(0).isDisplayed();
    }

    public void clickOnRemoveFromViewButton() {
        for (WebElement removeFromViewButton : removeFromViewButtons) removeFromViewButton.click();
    }

    public String getBrowsingHistoryMessage(){
        return browsingHistoryMessage.getText();
    }

}
