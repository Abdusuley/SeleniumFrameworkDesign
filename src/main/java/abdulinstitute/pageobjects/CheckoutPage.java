package abdulinstitute.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import abdulinstitute.AbstractComponents.AbstractComponent;

public class CheckoutPage extends AbstractComponent {

    private WebDriver driver;

    @FindBy(css = ".action__submit")
    private WebElement submit;

    @FindBy(css = "[placeholder='Select Country']")
    private WebElement countryInput;

    public CheckoutPage() {
        super();
    }

    public void selectCountry(String countryName) {
        Actions actions = new Actions(driver);
        actions.sendKeys(countryInput, countryName).build().perform();
        waitForElementToAppear(By.cssSelector(".ta-results"));
        driver.findElement(By.xpath("//button[text()='" + countryName + "']")).click();
    }

    public ConfirmationPage submitOrder() {
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", submit);
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", submit);
        return new ConfirmationPage();
    }
}
