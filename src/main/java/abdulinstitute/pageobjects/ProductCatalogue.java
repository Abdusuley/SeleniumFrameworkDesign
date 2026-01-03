package abdulinstitute.pageobjects;

import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import abdulinstitute.AbstractComponents.AbstractComponent;

public class ProductCatalogue extends AbstractComponent {

    private WebDriver driver;

    @FindBy(css = ".features_items .col-sm-4")
    private List<WebElement> products;

    private By productsBy = By.cssSelector(".features_items .col-sm-4");

    public ProductCatalogue() {
        super();
    }

    public List<WebElement> getProductList() {
        waitForElementToAppear(productsBy);
        return products;
    }

    public WebElement getProductByName(String productName) {
        return getProductList().stream()
                .filter(product ->
                        product.findElement(By.cssSelector(".productinfo p"))
                               .getText()
                               .equalsIgnoreCase(productName))
                .findFirst()
                .orElse(null);
    }

    public void addProductToCart(String productName) {
        WebElement prod = getProductByName(productName);
        if (prod == null) throw new RuntimeException("Product not found: " + productName);

        WebElement addToCartBtn = prod.findElement(By.cssSelector(".productinfo a.add-to-cart"));

        ((JavascriptExecutor) driver)
                .executeScript("arguments[0].scrollIntoView({block:'center'});", addToCartBtn);

        Actions actions = new Actions(driver);
        actions.moveToElement(prod).perform();

        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", addToCartBtn);

        By continueShoppingBtn = By.cssSelector("button.close-modal");
        waitForElementToAppear(continueShoppingBtn);
        driver.findElement(continueShoppingBtn).click();
    }
}
