package abdulinstitute.pageobjects;

import java.util.List;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import abdulinstitute.AbstractComponents.AbstractComponent;

public class CartPage extends AbstractComponent {

    private WebDriver driver;

    @FindBy(css = ".totalRow button")
    private WebElement checkoutEle;

    @FindBy(css = ".cartSection h3")
    private List<WebElement> cartProducts;

    public CartPage() {
        super();
    }

    public boolean verifyProductDisplay(String productName) {
        return cartProducts.stream()
                .anyMatch(product -> product.getText().equalsIgnoreCase(productName));
    }

    public CheckoutPage goToCheckout() {
        checkoutEle.click();
        return new CheckoutPage();
    }
}
