package abdulinstitute.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import abdulinstitute.AbstractComponents.AbstractComponent;

public class ConfirmationPage extends AbstractComponent {

    private WebDriver driver;

    @FindBy(css = ".hero-primary")
    private WebElement confirmationMessage;

    public ConfirmationPage() {
        super();
    }

    public String getConfirmationMessage() {
        return confirmationMessage.getText();
    }
}
