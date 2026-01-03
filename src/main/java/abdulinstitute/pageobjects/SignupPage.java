package abdulinstitute.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class SignupPage {

    private WebDriver driver;
    private WebDriverWait wait;

    private By nameField = By.xpath("//input[@data-qa='signup-name']");
    private By emailField = By.xpath("//input[@data-qa='signup-email']");
    private By signupButton = By.xpath("//button[@data-qa='signup-button']");
    private By accountInfoHeader = By.xpath("//b[contains(text(), 'Enter Account Information')]");

    public SignupPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public void enterSignupDetails(String name, String email) {
        driver.findElement(nameField).sendKeys(name);
        driver.findElement(emailField).sendKeys(email);
    }

    public void clickSignup() {
        driver.findElement(signupButton).click();
    }

    public boolean isRegistrationPageDisplayed() {
        try {
            return wait.until(ExpectedConditions.visibilityOfElementLocated(accountInfoHeader)).isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }
}
