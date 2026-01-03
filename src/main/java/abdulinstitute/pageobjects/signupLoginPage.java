package abdulinstitute.pageobjects;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import abdulinstitute.AbstractComponents.AbstractComponent;


public class signupLoginPage extends AbstractComponent {
	WebDriver driver;

	@FindBy(linkText = "link")
	WebElement clickLogin;

	@FindBy(css = ".cartSection h3")
	private List<WebElement> cartProducts;

    public signupLoginPage() {
        super();
    }

	public Boolean VerifyProductDisplay(String productName) {
		Boolean match = cartProducts.stream().anyMatch(product -> product.getText().equalsIgnoreCase(productName));
		return match;

	}
	
	public void goTo()
	{
		driver.get("http://automationexercise.com");
	}

	public CheckoutPage goToCheckout() {
		clickLogin.click();
		return new CheckoutPage();
		

	}

}
