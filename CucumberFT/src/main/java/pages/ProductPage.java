package pages;

import com.codeborne.selenide.Selenide;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import static com.codeborne.selenide.Condition.appear;

import java.util.List;

import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.$;

public class ProductPage extends BasePage {

    @FindBy(xpath = "//div[contains(@id, 'cm-cr-local-reviews-title')]")
    private WebElement reviewColumn;

    @FindBy(xpath = "//input[contains(@value, 'Mark this review as helpful BUTTON')]")
    private List<WebElement>  helpfulButtons;

    @FindBy(xpath = "//span[@class='cr-vote-success cr-vote-component']")
    private WebElement feedbackSuccessfulMessage;

    @FindBy(xpath = "//span[contains(@id, 'recommend')]")
    private WebElement highlyRecommendButton;

    @FindBy(xpath = "//span[contains(@data-hook, 'filtered-customer-reviews-title')]")
    private WebElement reviews;

    @FindBy(xpath = "//input[contains(@id, 'add-to-cart')]")
    private WebElement addToCartButton;

    @FindBy(xpath = "//div[contains(@id, 'AddBaseAlert')]/div/h4")
    private WebElement alertMessage;

    @FindBy(xpath = "//span[contains(@id, 'cart-button')]/span/input")
    private WebElement cartButton;

    @FindBy(xpath = "//input[contains(@data-feature-id, 'heckout-action')]")
    private WebElement checkoutButton;

    @FindBy(xpath = "//input[contains(@id, 'add-to-wishlist-button-submit')]")
    private WebElement addToListButton;

    @FindBy(xpath = "//input[contains(@id, 'list-name')]")
    private WebElement listNameField;

    @FindBy(xpath = "//span[contains(@id, 'wl-redesigned-create-list')]//input")
    private WebElement createListButton;

    @FindBy(xpath = "//a[contains(text(), 'View List')]")
    private WebElement viewListButton;

    @FindBy(xpath = "//a[contains(@id, 'itemEditLabel')]")
    private WebElement addCommentButton;

    @FindBy(xpath = "//input[contains(@id, 'WLNOTES_Requested')]")
    private WebElement quantityOfNeedsField;

    @FindBy(xpath = "//div[contains(text(), 'Deleted')]")
    private WebElement productStateMessageIsDeleted;

    @FindBy(xpath = "//input[contains(@aria-labelledby, 'save-announce')] ")
    private WebElement saveButton;

    @FindBy(xpath = "//div[contains(@id, 'deliveryShortLine')]") // potential error
    private WebElement deliveryInformation;

    public ProductPage(WebDriver driver) {
        super(driver);
    }

    public boolean isReviewColumnVisible(){
        return reviewColumn.isDisplayed();
    }

    public boolean isHelpfulButtonVisible(){
        return helpfulButtons.get(0).isDisplayed();
    }

    public void clickOnFirstHelpfulButton(){
        helpfulButtons.get(0).click();
    }

    public boolean isFeedbackSuccessfulMessageVisible(){
        return feedbackSuccessfulMessage.isDisplayed();
    }

    public boolean isHighlyRecommendButtonVisible(){
        return highlyRecommendButton.isDisplayed();
    }

    public void clickOnHighlyRecommendButton()
    {
        highlyRecommendButton.click();
    }

    public WebElement getReviews(){
        return reviews;
    }

    public boolean isAddToCartVisible(){
        return addToCartButton.isDisplayed();
    }

    public void clickOnAddToCartButton(){
        addToCartButton.click();
    }

    public String getAlertMessageText(){
        return alertMessage.getText();
    }

    public void clickOnCartButton(){
        cartButton.click();
    }

    public void clickOnCheckoutButton(){
        checkoutButton.click();
    }

    public boolean isAddToListButtonVisible(){
        return addToListButton.isDisplayed();
    }

    public void clickOnAddToListButton(){
        addToListButton.click();
    }

    public boolean isViewListButtonVisible(){
        return viewListButton.isDisplayed();
    }

    public void inputNameOfList(final String LISTNAME){
        listNameField.clear();
        listNameField.sendKeys(LISTNAME);
    }

    public void clickOnCreateListButton(){
        createListButton.click();
    }

    public void clickOnViewListButton(){
        viewListButton.click();
    }

    public void clickOnAddCommentButton(){
        addCommentButton.click();
    }

    public void inputQuantityOfNeeds(final String Quantity){
        quantityOfNeedsField.clear();
        quantityOfNeedsField.sendKeys(Quantity);
    }

    public void clickOnSaveButton(){
        saveButton.click();
    }

  public boolean isProductStateMessageIsDeletedVisible(){
        return productStateMessageIsDeleted.isDisplayed();
  }

  public String getDeliveryInformationText(){
        return  $(byXpath("//div[contains(@id, 'deliveryShortLine')]")).should(appear).getText();
  }

}
