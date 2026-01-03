package abdulinstitute.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import abdulinstitute.AbstractComponents.AbstractComponent;

public class LandingPage extends AbstractComponent {

    private WebDriver driver;

    public LandingPage() {
        super();
  
    }

    @FindBy(xpath = "//a[contains(text(), 'Signup / Login')]")
    private WebElement signupLoginButton;

    @FindBy(id = "userEmail")
    private WebElement userEmail;

    @FindBy(id = "userPassword")
    private WebElement passwordEle;

    @FindBy(id = "login")
    private WebElement submit;

    @FindBy(css = "[class*='flyInOut']")
    private WebElement errorMessage;

    // Click "Signup / Login" button
    public void clickSignupLogin() {
        waitForWebElementToAppear(signupLoginButton);
        signupLoginButton.click();
    }

    // Login method, returns ProductCatalogue
    public ProductCatalogue loginApplication(String email, String password) {
        waitForWebElementToAppear(userEmail);
        userEmail.clear();
        userEmail.sendKeys(email);

        passwordEle.clear();
        passwordEle.sendKeys(password);

        submit.click();

        // Return ProductCatalogue page object with the same driver
        return new ProductCatalogue();
    }

    // Get error message from failed login
    public String getErrorMessage() {
        waitForWebElementToAppear(errorMessage);
        return errorMessage.getText();
    }

    // Navigate to base URL
    public void goTo() {
        driver.get("http://automationexercise.com");
    }
}
