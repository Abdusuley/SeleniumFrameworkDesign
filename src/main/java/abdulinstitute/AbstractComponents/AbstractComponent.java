package abdulinstitute.AbstractComponents;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import abdulinstitute.pageobjects.CartPage;
import abdulinstitute.pageobjects.OrderPage;
import abdulinstitute.utils.DriverManager;

public abstract class AbstractComponent {

    protected WebDriver getDriver() {
        return DriverManager.getDriver();
    }

    protected AbstractComponent() {
        PageFactory.initElements(getDriver(), this);
    }

    @FindBy(css = "[routerlink*='cart']")
    private WebElement cartHeader;

    @FindBy(css = "[routerlink*='myorders']")
    private WebElement orderHeader;

    // Wait until a WebElement is visible
    public void waitForWebElementToAppear(WebElement element) {
        new WebDriverWait(getDriver(), Duration.ofSeconds(5))
                .until(ExpectedConditions.visibilityOf(element));
    }

    // Wait until element located by By is visible
    public void waitForElementToAppear(By locator) {
        new WebDriverWait(getDriver(), Duration.ofSeconds(10))
                .until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    // Wait until element disappears
    public void waitForElementToDisappear(WebElement element) {
        new WebDriverWait(getDriver(), Duration.ofSeconds(5))
                .until(ExpectedConditions.invisibilityOf(element));
    }

    public CartPage goToCartPage() {
        cartHeader.click();
        return new CartPage();   // ✅ NO driver passed
    }

    public OrderPage goToOrdersPage() {
        orderHeader.click();
        return new OrderPage();  // ✅ NO driver passed
    }
}
