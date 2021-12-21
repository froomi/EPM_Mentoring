package pages;


import com.codeborne.selenide.Selenide;

import static com.codeborne.selenide.Condition.appear;
import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.*;

public class HomePage {

    public void openHomePage(String url) {
        open(url);
    }

    public boolean isSignInFormButtonVisible() {
        return $(byXpath("//a[contains(@id, 'nav-link-accountList')]")).isDisplayed();
    }

    public void clickSignInFormButton() {
        $(byXpath("//a[contains(@id, 'nav-link-accountList')]")).click();
    }

    public boolean isEmailFieldVisible() {
        return $(byXpath("//input[contains(@id, 'ap_email')]")).isDisplayed();
    }

    public void inputEmail(final String EMAIL){
        $(byXpath("//input[contains(@id, 'ap_email')]")).should(appear).setValue(EMAIL);
    }

    public boolean isContinueButtonVisible() {
        return $(byXpath("//span[contains(@id, 'continue')]")).isDisplayed();
    }

    public void clickContinueButton(){
        $(byXpath("//span[contains(@id, 'continue')]")).click();
    }

    public boolean isPasswordFieldVisible() {
        return  $(byXpath("//input[contains(@id, 'ap_password')]")).isDisplayed();
    }

    public void inputPassword(final String PASSWORD){
        $(byXpath("//input[contains(@id, 'ap_password')]")).setValue(PASSWORD);
    }

    public boolean signInButtonVisible(){
        return $(byXpath("//input[contains(@id, 'signInSubmit')]")).isDisplayed();
    }

    public void clickSignInButton(){
        $(byXpath("//input[contains(@id, 'signInSubmit')]")).click();
    }

    public boolean isSearchFieldVisible(){
        return $(byXpath("//input[contains(@id, 'twotabsearchtextbox')]")).isDisplayed();
    }

    public void inputKeywordToSearch(final String KEYWORD){
        $(byXpath("//input[contains(@id, 'twotabsearchtextbox')]")).setValue(KEYWORD).pressEnter();
    }

    public boolean greetingFieldVisible(){
        return $(byXpath("//span[contains(text(), 'Hello')]")).isDisplayed();
    }

    public void clickOnFirstItemFromRecommendationList(){
        $$(byXpath("//li[contains(@data-sgproduct, 'asin')]")).get(0).should(appear).click();
    }

    public boolean isLanguageSettingsButtonVisible(){
        return $(byXpath("//a[contains(@href, 'select-currency') and contains(@class, 'icp-button')]")).isDisplayed();
    }

    public void clickOnLanguageSettingsButton(){
        $(byXpath("//a[contains(@href, 'select-currency') and contains(@class, 'icp-button')]")).click();
    }

    public boolean isCustomerServiceButtonVisible(){
        return $(byXpath("//a[contains(@class, 'nav-a') and contains(text(), 'Customer Service')]")).should(appear).isDisplayed();
    }

    public void clickOnCustomerServiceButton(){
        executeJavaScript("arguments[0].click();",
                $(byXpath("//a[contains(@class, 'nav-a') and contains(text(), 'Customer Service')]")));
    }

    public boolean isDeliverToButtonVisible(){
        return $(byXpath("//a[contains(@id, 'nav-global-location')]")).should(appear).isDisplayed();
    }

    public void clickOnDeliverToButton(){
        $(byXpath("//a[contains(@id, 'nav-global-location')]")).click();
    }

    public boolean isZipCodeInputFieldVisible(){
        return $(byXpath("//input[contains(@id, 'ZipUpdateInput')]")).should(appear).isDisplayed();
    }

    public void inputZipInField(final String ZIP){
        $(byXpath("//input[contains(@id, 'ZipUpdateInput')]")).setValue(ZIP);
    }

    public void clickOnApplyButton(){
        executeJavaScript("arguments[0].click();",
                $(byXpath("//input[contains(@class, 'a-button-input') and contains(@aria-labelledby, 'ZipUpdate')]")));
    }

    public void clickOnDeliverToContinueButton(){
        executeJavaScript("arguments[0].click();",
                $(byXpath("//div[contains(@class, 'a-popover-footer')]")));
        Selenide.refresh();
    }

}
