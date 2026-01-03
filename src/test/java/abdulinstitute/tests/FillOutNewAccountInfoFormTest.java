package abdulinstitute.tests;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import abdulinstitute.TestComponents.BaseTest;
import abdulinstitute.pageobjects.AccountInfoPage;
import abdulinstitute.pageobjects.LoginPage;
import abdulinstitute.pageobjects.SignupPage;

public class FillOutNewAccountInfoFormTest extends BaseTest {

    @Test(dataProvider = "getData", groups = {"Purchase"})
    public void submitOrder(HashMap<String, String> input)
            throws IOException, InterruptedException {

        // Navigate to signup/login
        landingPage.clickSignupLogin();

        // ✅ Thread-safe driver usage
        LoginPage loginPage = new LoginPage();
        SignupPage signupPage = new SignupPage(getDriver());

        // Signup flow
        signupPage.enterSignupDetails(
                input.get("name"),
                input.get("email")
        );

        AccountInfoPage accountInfoPage =
                new AccountInfoPage(getDriver());

        accountInfoPage.fillAccountDetails(
                "title",
                "password",
                "day",
                "month",
                "year"
        );

        accountInfoPage.selectNewsletters();
    }

    private WebDriver getDriver() {
		// TODO Auto-generated method stub
		return null;
	}

	@DataProvider
    public Object[][] getData() throws IOException {

        List<HashMap<String, String>> data =
                getJsonDataToMap(
                        System.getProperty("user.dir")
                                + "//src//test//java//abdulinstitute//data//PurchaseOrder2.json"
                );

        Object[][] dataArray = new Object[data.size()][1];
        for (int i = 0; i < data.size(); i++) {
            dataArray[i][0] = data.get(i);
        }

        return dataArray;
    }
}
