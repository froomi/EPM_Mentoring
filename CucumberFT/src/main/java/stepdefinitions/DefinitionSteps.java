package stepdefinitions;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.WebDriverRunner;
import com.codeborne.selenide.junit5.ScreenShooterExtension;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import manager.PageFactoryManager;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.extension.RegisterExtension;
import org.openqa.selenium.MutableCapabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import pages.*;

import java.net.URL;

public class DefinitionSteps {

    @RegisterExtension
    static ScreenShooterExtension screenshotEmAll = new ScreenShooterExtension(true).to("target/screenshots");

    WebDriver driver;
    HomePage homePage;
    SettingsPage settingsPage;
    SearchResultsPage searchResultsPage;
    ProductPage productPage;
    PageFactoryManager pageFactoryManager;
    BrowsingHistoryPage browsingHistoryPage;
    PaymentPage paymentPage;
    ProfilePage profilePage;
    CustomerServicePage customerServicePage;

    @Before
    public void testsSetUp() {

//        MutableCapabilities sauceOpts = new MutableCapabilities();
//        sauceOpts.setCapability("name", "amazon");
//        sauceOpts.setCapability("build", "Examples");
//        sauceOpts.setCapability("seleniumVersion", "3.141.59");
//        sauceOpts.setCapability("username", "oauth-fasye1632-f94ed");
//        sauceOpts.setCapability("accessKey", "8d7b7b01-7928-4326-a754-9a038f5d2891");
//        sauceOpts.setCapability("tags", "chrome-tests");
//
//        DesiredCapabilities cap = new DesiredCapabilities();
//        cap.setCapability("sauce:options", sauceOpts);
//        cap.setCapability("browserVersion", "latest");
//        cap.setCapability("platformName", "windows 10");
//        cap.setCapability("browserName", "chrome");
//
//        WebDriver driver = new RemoteWebDriver(new URL("https://oauth-fasye1632-f94ed:8d7b7b01-7928-4326-a754-9a038f5d2891@ondemand.eu-central-1.saucelabs.com:443/wd/hub"), cap);
//        WebDriverRunner.setWebDriver(driver);

        pageFactoryManager = new PageFactoryManager(driver);
        homePage = pageFactoryManager.getHomePage();
        productPage = pageFactoryManager.getProductPage();
        profilePage = pageFactoryManager.getProfilePage();
        paymentPage = pageFactoryManager.getPaymentPage();
        searchResultsPage = pageFactoryManager.getSearchResultsPage();
        browsingHistoryPage = pageFactoryManager.getBrowsingHistoryPage();
        settingsPage = pageFactoryManager.getSettingsPage();
        customerServicePage = pageFactoryManager.getCustomerServicePage();
    }

    @Given("User opens {string} page")
    public void openPage(final String url) {
        homePage.openHomePage(url);
    }

    @And("User checks Sign-in form button visibility")
    public void userChecksSignInFormButtonVisibility() {
        assertTrue(homePage.isSignInFormButtonVisible());
    }

    @When("User clicks Sign-in form button")
    public void userClicksSignInFormButton() {
        homePage.clickSignInFormButton();
    }

    @And("User checks Email field visibility")
    public void userChecksEmailFieldVisibility() {
        assertTrue(homePage.isEmailFieldVisible());
    }

    @And("User checks continue button visibility")
    public void userChecksContinueButtonVisibility() {
        assertTrue(homePage.isContinueButtonVisible());
    }

    @And("User logs in using Email as {string}")
    public void userLogsInUsingEmailAsEMAIL(final String EMAIL) {
        homePage.inputEmail(EMAIL);
    }

    @And("User clicks continue button")
    public void userClicksContinueButton() {
        homePage.clickContinueButton();
    }

    @And("User checks password field visibility")
    public void userChecksPasswordFieldVisibility() {
        assertTrue(homePage.isPasswordFieldVisible());
    }

    @And("User logs in using Password as {string}")
    public void userLogsInUsingPasswordAsPASSWORD(final String PASSWORD) {
        homePage.inputPassword(PASSWORD);
    }

    @And("User checks Sign-in button visibility")
    public void userChecksSignInButtonVisibility() {
        assertTrue(homePage.signInButtonVisible());
    }

    @And("User clicks Sign-in button")
    public void userClicksSignInButton() {
        homePage.clickSignInButton();
    }

    @Then("User checks that login is successful by seeing page")
    public void userChecksThatLoginIsSuccessfulBySeeingHomePage() {
        assertTrue(homePage.greetingFieldVisible());
    }

    @And("User checks search field visibility")
    public void userChecksSearchFieldVisibility() {
        assertTrue(homePage.isSearchFieldVisible());
    }

    @When("User search by keyword {string}")
    public void userSearchByKeywordKeyword(final String KEYWORD) {
        homePage.inputKeywordToSearch(KEYWORD);
    }

    @And("User clicks on first Delivery type on list")
    public void userClicksOnFirstDeliveryTypeOnList() {
        searchResultsPage.clickCardDeliveryListOnFirstType();
    }

    @And("User checks Sort by button visibility")
    public void userChecksSortByButtonVisibility() {
        assertTrue(searchResultsPage.isSortByButtonVisible());
    }

    @And("User clicks on Sort by button")
    public void userClicksOnSortByButton() {
        searchResultsPage.clickSortByButton();
    }

    @And("User clicks on Price: High to Low point in list")
    public void userClicksOnPriceHighToLowPointInList() {
        searchResultsPage.clickHighToLowSortingType();
    }

    @Then("User checks that all items have pointed Delivery Type")
    public void userChecksThatAllItemsHavePointedDeliveryType() {
        for(SelenideElement selenideElement : searchResultsPage.getCardsList()){
            assertTrue(selenideElement.getText().contains(searchResultsPage.getFirstCardDeliveryType().getText()));
        }
    }

    @And("User checks that items are sorted in {string} order")
    public void userChecksThatItemsAreSortedInOrderOrder(final String ORDER) {
        assertTrue(WebDriverRunner.getWebDriver().getCurrentUrl().contains(ORDER));
    }


    @When("User clicks on the first item in the list")
    public void userClicksOnTheFirstItemInTheList() {
        homePage.clickOnFirstItemFromRecommendationList();
    }

    @And("User checks settings button visibility")
    public void userChecksSettingsButtonVisibility() {
        assertTrue(homePage.isLanguageSettingsButtonVisible());
    }

    @When("User clicks on settings button")
    public void userClicksOnSettingsButton() {
        homePage.clickOnLanguageSettingsButton();
    }

    @And("User clicks on {string} button from languages list")
    public void userClicksOnDEButton(final String LANGUAGE) {
        settingsPage.clickOnDEButtonFromList(LANGUAGE);
    }

    @And("User checks currency selecting button visibility")
    public void userChecksCurrencySelectingButtonVisibility() {
        assertTrue(settingsPage.isCurrencySelectingButtonVisible());
    }

    @And("User clicks on currency selecting button")
    public void userClicksOnCurrencySelectingButton() {
        settingsPage.clickOnCurrencySelectingButton();
    }

    @And("User clicks on {string} button")
    public void userClicksOnEURButton(final String CURRENCY) {
        settingsPage.clickOnEURButtonFromCurrenciesList(CURRENCY);
    }

    @And("User checks save changes button visibility")
    public void userChecksSaveChangesButtonVisibility() {
        assertTrue(settingsPage.isSaveChangesButtonVisible());
    }

    @And("User clicks on save changes button")
    public void userClicksOnSaveChangesButton() {
        settingsPage.clickOnSaveChangesButton();
    }

    @Then("User checks that current url contains {string}")
    public void userChecksThatCurrentUrlContainsDe(final String LANGUAGE) {
        assertTrue(WebDriverRunner.getWebDriver().getCurrentUrl().contains(LANGUAGE));
    }

    @And("User check that current url contains {string}")
    public void userCheckThatCurrentUrlContainsEUR(final String CURRENCY) {
        assertTrue(WebDriverRunner.getWebDriver().getCurrentUrl().contains(CURRENCY));
    }

    @And("User checks Login and security form visibility")
    public void userChecksLoginAndSecurityFormVisibility() {
        assertTrue(profilePage.isLoginFormVisible());
    }

    @And("User clicks on Login and security form")
    public void userClicksOnLoginAndSecurityForm() {
        profilePage.clickLoginForm();
    }

    @And("User checks that Edit button in Name table is visible")
    public void userChecksThatEditButtonInNameTableIsVisible() {
        assertTrue(profilePage.isEditNameButtonVisible());
    }

    @Then("User clicks on Edit button")
    public void userClicksOnEditButton() {
        profilePage.clickEditNameButton();
    }

    @And("User clears old name and writes new one: {string}")
    public void userClearsOldNameAndWritesNewOneNAME(final String NAME) {
        profilePage.inputNewName(NAME);
    }

    @And("User saves changes")
    public void userSavesChanges() {
        profilePage.clickOnSaveChangesButton();
    }

    @And("User checks that message is {string}")
    public void userChecksThatMessageIsMESSAGE(final String MESSAGE) {
        assertEquals(profilePage.getMessageText(), MESSAGE);

    }

    @And("User checks Costumer Service button visibility")
    public void userChecksCostumerServiceButtonVisibility() {
        assertTrue(homePage.isCustomerServiceButtonVisible());
    }

    @When("User clicks On Costumer Service button")
    public void userClicksOnCostumerServiceButton() {
        homePage.clickOnCustomerServiceButton();
    }

    @And("User checks Help topics navigation field visibility")
    public void userChecksHelpTopicsNavigationFieldVisibility() {
        customerServicePage.isSearchFieldVisible();
    }

    @And("User searches solution inputting {string} in navigation field")
    public void userSearchesSolutionInputtingREQUESTInNavigationField(final String REQUEST) {
        customerServicePage.searchSolution(REQUEST);
    }

    @And("User clicks on first result")
    public void userClicksOnFirstResult() {
        customerServicePage.clickOnFirstResult();
    }

    @Then("User checks that solution responds the {string}")
    public void userChecksThatSolutionRespondsTheREQUEST(final String REQUEST) {
        assertTrue(customerServicePage.getResultHeaderText().contains(REQUEST));
    }

    @And("User marks solution as helpful")
    public void userMarksSolutionAsHelpful() {
        customerServicePage.clickOnYesButtonToMarkResultAsHelpful();
    }

    @And("User checks that message was marked")
    public void userChecksThatMessageWasMarked() {
        assertTrue(customerServicePage.isThankfulMessageVisible());
    }

    @And("User checks change location button visibility")
    public void userChecksChangeLocationButtonVisibility() {
        assertTrue(homePage.isDeliverToButtonVisible());
    }

    @When("User clicks on choose location button")
    public void userClicksOnChooseLocationButton() {
        homePage.clickOnDeliverToButton();
    }

    @And("User checks enter zip code field visibility")
    public void userChecksEnterZipCodeFieldVisibility() {
        assertTrue(homePage.isZipCodeInputFieldVisible());
    }

    @And("User enters {string} in field")
    public void userEntersZIPInField(final String ZIP) {
        homePage.inputZipInField(ZIP);
    }

    @And("User clicks on Apply button")
    public void userClicksOnApplyButton() {
        homePage.clickOnApplyButton();
    }


    @And("User clicks on continue button")
    public void userClicksOnContinueButton() {
        homePage.clickOnDeliverToContinueButton();
    }

    @Then("User checks that delivery location contains {string} code")
    public void userChecksThatDeliveryLocationContainsZIPCode(final String ZIP) {
        assertTrue(productPage.getDeliveryInformationText().contains(ZIP));
    }

    @After
    public void closeUrl(){
        Selenide.closeWindow();
    }

}
