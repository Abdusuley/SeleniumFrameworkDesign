package abdulinstitute.tests;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;

import org.testng.Assert;

import abdulinstitute.TestComponents.BaseTest;
import abdulinstitute.pageobjects.LoginPage;
import abdulinstitute.pageobjects.OrderPage;
import abdulinstitute.pageobjects.ProductCatalogue;

public class SubmitOrderTest extends BaseTest {
    LoginPage loginPage;


    @Test(dataProvider = "getData", groups = {"Purchase"})
    public void submitOrder(HashMap<String, String> input)
            throws IOException, InterruptedException {

        // Navigate to login
        landingPage.clickSignupLogin();

        // ✅ Thread-safe driver
        loginPage = new LoginPage();

        // Login and land on product catalogue
        ProductCatalogue productCatalogue =
                loginPage.login(input.get("email"), input.get("password"));

        productCatalogue.getProductList();

        // Add product from test data
        productCatalogue.addProductToCart(input.get("product"));
    }

//    @Test(dataProvider = "getData", dependsOnMethods = {"submitOrder"}, groups = {"Purchase"})
    public void OrderHistoryTest(HashMap<String, String> input) {
        // Navigate to login page
        landingPage.clickSignupLogin();

        // ✅ Thread-safe driver usage
        LoginPage loginPage = new LoginPage();

        // Perform login
        ProductCatalogue productCatalogue = loginPage.login(
                input.get("email"),
                input.get("password"));

        OrderPage ordersPage = productCatalogue.goToOrdersPage();

        Assert.assertTrue(
                ordersPage.VerifyOrderDisplay("Blue Top")
        );
    }

    @DataProvider
    public Object[][] getData() throws IOException {

        List<HashMap<String, String>> data =
                getJsonDataToMap(
                        System.getProperty("user.dir")
                                + "//src//test//java//abdulinstitute//data//PurchaseOrder.json"
                );

        Object[][] dataArray = new Object[data.size()][1];
        for (int i = 0; i < data.size(); i++) {
            dataArray[i][0] = data.get(i);
        }
        return dataArray;
    }
}
