package abdulinstitute.tests;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import abdulinstitute.TestComponents.BaseTest;
import abdulinstitute.pageobjects.LoginPage;

public class LoginPageTest extends BaseTest {

    @Test(dataProvider = "getData", groups = {"Purchase"})
    public void loginTest(HashMap<String, String> input)
            throws IOException, InterruptedException {

        // Navigate to login page
        landingPage.clickSignupLogin();

        // ✅ Thread-safe driver usage
        LoginPage loginPage = new LoginPage();

        // Perform login
        loginPage.login(
                input.get("email"),
                input.get("password")
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
