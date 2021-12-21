package pages;

import com.codeborne.selenide.SelenideElement;
import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.*;

import java.util.List;

public class SettingsPage {

    private List<SelenideElement> languagesList =  $$(byXpath("//span[contains(@class, 'a-label a-radio-label')]"));
    private SelenideElement currencySelectingButton = $(byXpath("//span[contains(@class, 'a-button-text a-declarative')]"));;
    private List<SelenideElement> currenciesList = $$(byXpath("//a[contains(@class, 'a-dropdown-link')]"));;
    private SelenideElement saveChangesButton = $(byXpath("//input[contains(@class, 'a-button-input')]"));;

    public void clickOnDEButtonFromList(final String LANGUAGE) {

        for(SelenideElement selenideElement : languagesList){
            if (selenideElement.getText().contains(LANGUAGE)){
                selenideElement.click();
            }
        }
    }

    public boolean isCurrencySelectingButtonVisible(){
        return currencySelectingButton.isDisplayed();
    }

    public void clickOnCurrencySelectingButton(){
        currencySelectingButton.click();
    }

    public void clickOnEURButtonFromCurrenciesList(final String CURRENCY){
        for (SelenideElement selenideElement : currenciesList){
            if(selenideElement.getText().contains(CURRENCY)){
                selenideElement.click();
            }
        }
    }

    public boolean isSaveChangesButtonVisible(){
        return saveChangesButton.isDisplayed();
    }

    public void clickOnSaveChangesButton(){
        saveChangesButton.click();
    }

}
