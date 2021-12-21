package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

import static org.openqa.selenium.Keys.ENTER;

public class PaymentPage extends BasePage {

    @FindBy(xpath = "//span[contains(text(), 'Add a credit or debit card')]")
    private WebElement addCreditCartButton;

    @FindBy(xpath = "//span[contains(text(), 'Enter a gift card')]")
    private WebElement enterAGiftCardButton;


    @FindBy(xpath = "//h1[contains(@class, 'a-spacing')] ")
    private WebElement information;

    @FindBy(xpath = "//a[contains(@class, 'a-link-normal pmts-add-amazon-store-card-learn-more-link')] ")
    private WebElement learnMoreButton;

    public PaymentPage(WebDriver driver) {
        super(driver);
    }

  public boolean isAddCreditCartButtonVisible(){
        return addCreditCartButton.isDisplayed();
  }

  public boolean isEnterAGiftCardButtonVisible(){
       return enterAGiftCardButton.isDisplayed();
  }


  public String getAlertHeadingText(){
        return information.getText();
  }

  public boolean isLearnMoreButtonVisible(){
        return learnMoreButton.isDisplayed();
  }

}
