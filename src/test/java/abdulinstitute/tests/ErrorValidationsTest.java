package abdulinstitute.tests;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import abdulinstitute.TestComponents.BaseTest;
import abdulinstitute.TestComponents.Retry;
import abdulinstitute.pageobjects.CartPage;
import abdulinstitute.pageobjects.LoginPage;
import abdulinstitute.pageobjects.ProductCatalogue;

public class ErrorValidationsTest extends BaseTest {

    @Test(groups = {"ErrorHandling"}, retryAnalyzer = Retry.class)
    public void LoginErrorValidation() throws IOException {

        landingPage.loginApplication("automate@gmail.com", "Iamki000");

        Assert.assertEquals(
                landingPage.getErrorMessage(),
                "Incorrect email or password."
        );
    }

    @Test(groups = {"ErrorHandling"}, retryAnalyzer = Retry.class)
    public void loginErrorValidation() {

        // Navigate to login page
        landingPage.clickSignupLogin();

        // ✅ Use thread-local driver
        LoginPage loginPage = new LoginPage();

        // Trigger error
        loginPage.login("invalid_user@gmail.com", "wrong_password");

        // Validate error message
        String actualMessage = loginPage.getErrorMessage();
        Assert.assertEquals(
                actualMessage,
                "Your email or password is incorrect!"
        );
    }

    @Test(groups = {"ErrorHandling"}, retryAnalyzer = Retry.class)
    public void ProductErrorValidation() throws IOException {

        String productName = "ZARA COAT 3";

        ProductCatalogue productCatalogue =
                landingPage.loginApplication("abdul.salih@outlook.com", "Deen2024");

        List<WebElement> products = productCatalogue.getProductList();

        productCatalogue.addProductToCart(productName);

        CartPage cartPage = productCatalogue.goToCartPage();

        Boolean match = cartPage.verifyProductDisplay("ZARA COAT 33");
        Assert.assertFalse(match);
    }
}
