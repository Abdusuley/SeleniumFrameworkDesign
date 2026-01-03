package abdulinstitute.stepDefinitions;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.testng.Assert;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import abdulinstitute.TestComponents.BaseTest;
import abdulinstitute.pageobjects.CartPage;
import abdulinstitute.pageobjects.CheckoutPage;
import abdulinstitute.pageobjects.ConfirmationPage;
import abdulinstitute.pageobjects.LandingPage;
import abdulinstitute.pageobjects.ProductCatalogue;

public class StepDefinitionImpl extends BaseTest {

    private LandingPage landingPage;
    private ProductCatalogue productCatalogue;
    private ConfirmationPage confirmationPage;

    @Given("I landed on Ecommerce Page")
    public void i_landed_on_ecommerce_page() throws IOException {

        // ✅ Use BaseTest setup (thread-safe)
        initializeDriver();
        landingPage = new LandingPage();
        landingPage.goTo();
    }

    @Given("^Logged in with username (.+) and password (.+)$")
    public void logged_in_username_and_password(String username, String password) {

        productCatalogue =
                landingPage.loginApplication(username, password);
    }

    @When("^I add product (.+) to Cart$")
    public void i_add_product_to_cart(String productName) {

        List<WebElement> products =
                productCatalogue.getProductList();

        productCatalogue.addProductToCart(productName);
    }

    @When("^Checkout (.+) and submit the order$")
    public void checkout_submit_order(String productName) {

        CartPage cartPage = productCatalogue.goToCartPage();

        Boolean match =
                cartPage.verifyProductDisplay(productName);

        Assert.assertTrue(match);

        CheckoutPage checkoutPage =
                cartPage.goToCheckout();

        checkoutPage.selectCountry("india");

        confirmationPage =
                checkoutPage.submitOrder();
    }

    @Then("{string} message is displayed on ConfirmationPage")
    public void message_displayed_confirmationPage(String expectedMessage) {

        String confirmMessage =
                confirmationPage.getConfirmationMessage();

        Assert.assertTrue(
                confirmMessage.equalsIgnoreCase(expectedMessage)
        );
    }

    @Then("^\"([^\"]*)\" message is displayed$")
    public void error_message_is_displayed(String expectedMessage) {

        Assert.assertEquals(
                expectedMessage,
                landingPage.getErrorMessage()
        );
    }
}
