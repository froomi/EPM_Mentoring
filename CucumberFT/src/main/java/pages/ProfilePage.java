package pages;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.$;

public class ProfilePage{
    private SelenideElement loginForm = $(byXpath("//h2[contains(text(), 'Login')]"));
    private SelenideElement editNameButton = $(byXpath("//input[contains(@id, 'auth-cnep-edit-name-button')]"));
    private SelenideElement newNameField = $(byXpath("//input[contains(@id, 'customer_name')]"));
    private SelenideElement saveChangesButton = $(byXpath("//input[contains(@id, 'submit_button')]"));
    private SelenideElement message = $(byXpath("//h4[contains(@class, 'alert')]"));


    public boolean isLoginFormVisible(){
        return loginForm.isDisplayed();
    }

    public void clickLoginForm(){
        loginForm.click();
    }

    public boolean isEditNameButtonVisible(){
        return editNameButton.isDisplayed();
    }

    public void clickEditNameButton(){
        editNameButton.click();
    }

    public void inputNewName(final String NAME){
        newNameField.clear();
        newNameField.sendKeys(NAME);
    }

    public void clickOnSaveChangesButton(){
        saveChangesButton.click();
    }

    public String getMessageText(){
        return message.getText();
    }

}
