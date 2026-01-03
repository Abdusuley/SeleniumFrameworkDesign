package abdulinstitute.pageobjects;

import java.util.List;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import abdulinstitute.AbstractComponents.AbstractComponent;

public class OrderPage extends AbstractComponent {
    // ThreadLocal to ensure thread safety during parallel execution
    private static ThreadLocal<WebDriver> threadDriver = new ThreadLocal<>();

    @FindBy(css = ".totalRow button")
    WebElement checkoutEle;

    @FindBy(css = "tr td:nth-child(3)")
    private List<WebElement> productNames;

    public OrderPage() {
        super();
    }

    /**
     * Verifies if the desired product is displayed in the order list.
     * * @param productName Name of the product to search for
     * @return true if found, false otherwise
     */
    public Boolean VerifyOrderDisplay(String productName) {
        // Use stream to find a match within the list of WebElements
        return productNames.stream()
                .anyMatch(product -> product.getText().trim().equalsIgnoreCase(productName));
    }
}