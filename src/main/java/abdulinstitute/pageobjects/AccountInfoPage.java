package abdulinstitute.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class AccountInfoPage {

    private WebDriver driver;

    @FindBy(id = "id_gender1")
    private WebElement mrRadio;

    @FindBy(id = "id_gender2")
    private WebElement mrsRadio;

    @FindBy(id = "password")
    private WebElement passwordInput;

    @FindBy(id = "days")
    private WebElement daysDropdown;

    @FindBy(id = "months")
    private WebElement monthsDropdown;

    @FindBy(id = "years")
    private WebElement yearsDropdown;

    @FindBy(id = "newsletter")
    private WebElement newsletterCheckbox;

    @FindBy(id = "optin")
    private WebElement partnersCheckbox;

    @FindBy(id = "first_name")
    private WebElement firstNameInput;

    @FindBy(id = "last_name")
    private WebElement lastNameInput;

    @FindBy(id = "company")
    private WebElement companyInput;

    @FindBy(id = "address1")
    private WebElement address1Input;

    @FindBy(id = "address2")
    private WebElement address2Input;

    @FindBy(id = "country")
    private WebElement countryDropdown;

    @FindBy(id = "state")
    private WebElement stateInput;

    @FindBy(id = "city")
    private WebElement cityInput;

    @FindBy(id = "zipcode")
    private WebElement zipcodeInput;

    @FindBy(id = "mobile_number")
    private WebElement mobileNumberInput;

    @FindBy(xpath = "//button[@data-qa='create-account']")
    private WebElement createAccountButton;

    public AccountInfoPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void fillAccountDetails(String title, String password, String day, String month, String year) {
        if (title.equalsIgnoreCase("Mr")) mrRadio.click();
        else mrsRadio.click();

        passwordInput.sendKeys(password);
        new Select(daysDropdown).selectByVisibleText(day);
        new Select(monthsDropdown).selectByVisibleText(month);
        new Select(yearsDropdown).selectByVisibleText(year);
    }

    public void selectNewsletters() {
        if (!newsletterCheckbox.isSelected()) newsletterCheckbox.click();
        if (!partnersCheckbox.isSelected()) partnersCheckbox.click();
    }

    public void fillAddressDetails(String fname, String lname, String company, String addr1, String addr2,
                                   String country, String state, String city, String zip, String mobile) {
        firstNameInput.sendKeys(fname);
        lastNameInput.sendKeys(lname);
        companyInput.sendKeys(company);
        address1Input.sendKeys(addr1);
        address2Input.sendKeys(addr2);
        new Select(countryDropdown).selectByVisibleText(country);
        stateInput.sendKeys(state);
        cityInput.sendKeys(city);
        zipcodeInput.sendKeys(zip);
        mobileNumberInput.sendKeys(mobile);
    }

    public void clickCreateAccount() {
        createAccountButton.click();
    }
}
