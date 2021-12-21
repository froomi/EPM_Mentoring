package manager;

import org.openqa.selenium.WebDriver;
import pages.*;

public class PageFactoryManager {

    WebDriver driver;

    public PageFactoryManager(WebDriver driver) {
        this.driver = driver;
    }

    public HomePage getHomePage() {
        return new HomePage();
    }

    public SettingsPage getSettingsPage(){return  new SettingsPage(); }

    public SearchResultsPage getSearchResultsPage() {
        return new SearchResultsPage();
    }

    public ProductPage getProductPage() {
        return new ProductPage(driver);
    }

    public BrowsingHistoryPage getBrowsingHistoryPage() { return new BrowsingHistoryPage(driver); }

    public PaymentPage getPaymentPage(){ return new PaymentPage(driver); }

    public ProfilePage getProfilePage(){return new ProfilePage(); }

    public CustomerServicePage getCustomerServicePage() {return new CustomerServicePage();}

}
