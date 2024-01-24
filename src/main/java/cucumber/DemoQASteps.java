package cucumber;

import cucumber.utils.Hooks;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import studies.example.elements.demoqa.ElementsDemoQATextBox;

public class DemoQASteps {

    @Given("DemoQA application was accessed")
    public void demoqaApplicationWasAccessed() {
        Hooks.getWebDriver().get(ElementsDemoQATextBox.baseURL);
    }

    @And("Elements menu was clicked")
    public void elementsMenuWasClicked() {
        Hooks.getWaitWebDriver().until(ExpectedConditions.elementToBeClickable(ElementsDemoQATextBox.elementsButton));
        Hooks.getWebDriver().findElement(ElementsDemoQATextBox.elementsButton).click();
    }

    @And("Text Box item was clicked")
    public void textBoxItemWasClicked() {
        Hooks.getWaitWebDriver().until(ExpectedConditions.elementToBeClickable(ElementsDemoQATextBox.textBoxButton));
        Hooks.getWebDriver().findElement(ElementsDemoQATextBox.textBoxButton).click();
    }

    @And("the name <fullName> was typped on the Full name field")
    public void theNameFullNameWasTyppedOnTheFullNameField() {
        Hooks.getWaitWebDriver().until(ExpectedConditions.visibilityOfElementLocated(ElementsDemoQATextBox.fullName));
        Hooks.getWebDriver().findElement(ElementsDemoQATextBox.fullName).sendKeys("Joana Guimarães");
    }

    @And("the email <email> was typped on the Email field")
    public void theEmailEmailWasTyppedOnTheEmailField() {
        Hooks.getWebDriver().findElement(ElementsDemoQATextBox.userEmail).sendKeys("joanaguimaraes@example.com");
    }

    @And("the address <currentAddress> was typped on the Current Address field")
    public void theAddressCurrentAddressWasTyppedOnTheCurrentAddressField() {
        Hooks.getWebDriver().findElement(ElementsDemoQATextBox.currentAddress).sendKeys("Rua Porto Alegre, 300, Araranguá SC");
    }

    @And("the address <permanentAddress> was typped on the Permanent Address field")
    public void theAddressPermanentAddressWasTyppedOnThePermanentAddressField() {
        Hooks.getWebDriver().findElement(ElementsDemoQATextBox.permanentAddress).sendKeys("Rua Porto Alegre, 300, Araranguá SC");

    }

    @When("Submit button is clicked")
    public void submitButtonIsClicked() {
        JavascriptExecutor js = (JavascriptExecutor) Hooks.getWebDriver();
        WebElement submitButtonForm = Hooks.getWebDriver().findElement(ElementsDemoQATextBox.submitButtonForm);

        Hooks.getWaitWebDriver().until(ExpectedConditions.elementToBeClickable(submitButtonForm));
        Assert.assertTrue(submitButtonForm.isDisplayed());
        js.executeScript("arguments[0].scrollIntoView();", submitButtonForm);
        submitButtonForm.click();
    }

    @Then("all informations added should be displayed at the bottom fo the form")
    public void allInformationsAddedShouldBeDisplayedAtTheBottomFoTheForm() {
    }
}
