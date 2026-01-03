package abdulinstitute.tests;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import abdulinstitute.TestComponents.BaseTest;
import abdulinstitute.pageobjects.SignupPage;

public class SignupTest extends BaseTest {

    @Test(groups = {"Signup"})
    public void testSuccessfulSignupRedirection() {

        // Navigate to Signup/Login page
        landingPage.clickSignupLogin();

        // ✅ Use thread-local driver
        SignupPage signupPage = new SignupPage(getDriver());

        // Enter signup details
        signupPage.enterSignupDetails(
                "Abdul Salih",
                "nileintegrity@gmail.com"
        );

        signupPage.clickSignup();

        // Validate redirection
        boolean isSuccess = signupPage.isRegistrationPageDisplayed();
        Assert.assertTrue(
                isSuccess,
                "The page did not redirect to Account Information."
        );
    }

	private WebDriver getDriver() {
		// TODO Auto-generated method stub
		return null;
	}
}
