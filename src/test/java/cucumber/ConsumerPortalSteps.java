package cucumber;

import cucumber.utils.Hooks;
import cucumber.utils.Retry;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import studies.example.elements.ConsumerPortalElements;

public class ConsumerPortalSteps {
    @Given("Consumer Portal with passkey enabled was accessed")
    public void consumerPortalWithPasskeyWasAccessed(){
        Hooks.getWebDriver().get(ConsumerPortalElements.baseURL);
        Hooks.getWaitWebDriver().until(ExpectedConditions.visibilityOfElementLocated(ConsumerPortalElements.passKeyButton));
    }

    @Given("Consumer Portal was accessed")
    public void consumerPortalWasAccessed(){
        Hooks.getWebDriver().get(ConsumerPortalElements.baseURL);
        Hooks.getWaitWebDriver().until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(ConsumerPortalElements.widgetIframe));
    }

    @And("the button Sign with your bank was clicked")
    public void theButtonSignWithYourBankWasClicked() {
        Hooks.getWebDriver().findElement(ConsumerPortalElements.passKeyButton).click();
        Hooks.getWaitWebDriver().until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(ConsumerPortalElements.lightboxIframe));
    }

    @And("the {string} was selected via widget search")
    public void theDemoBankWasSelectedViaWidgetSearch(String bankName) throws InterruptedException {
        Hooks.getWaitWebDriver().until(ExpectedConditions.elementToBeClickable(ConsumerPortalElements.widgetSearch));
        WebElement widgetSearch = Hooks.getWebDriver().findElement(ConsumerPortalElements.widgetSearch);

        widgetSearch.sendKeys(bankName);

        Hooks.getWaitWebDriver().until(ExpectedConditions.elementToBeClickable(ConsumerPortalElements.demoBankRadioWidget));

        Retry.run(() -> {
            WebElement demoBankRadioWidget = Hooks.getWebDriver().findElement(ConsumerPortalElements.demoBankRadioWidget);
            demoBankRadioWidget.click();
        });
        Hooks.getWebDriver().switchTo().defaultContent();
        // Waiting for the iframe to be rebuilt
        Thread.sleep(2000);
        Hooks.getWaitWebDriver().until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(ConsumerPortalElements.lightboxIframe));
    }

    @And("the Demo Bank was selected via lightbox search")
    public void theDemoBankWasSelectedViaLightboxSearch() throws InterruptedException{
        Hooks.getWaitWebDriver().until(ExpectedConditions.visibilityOfElementLocated(ConsumerPortalElements.lightboxSearch));
        WebElement lightboxSearch = Hooks.getWebDriver().findElement(ConsumerPortalElements.lightboxSearch);
        lightboxSearch.sendKeys("Demo Bank");

        Hooks.getWaitWebDriver().until(ExpectedConditions.elementToBeClickable(ConsumerPortalElements.demoBankRadio));

        // This block has an arrow function that is executing a code block inside {} using the Runnable argument
        // passed on Hook - retry
        Retry.run(() -> {
            WebElement demoBankRadio = Hooks.getWebDriver().findElement(ConsumerPortalElements.demoBankRadio);
            demoBankRadio.click();
        });
    }

    @And("the username {string} was typed")
    public void theUsernameWasTyped(String username) throws InterruptedException {
        Hooks.getWaitWebDriver().until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(ConsumerPortalElements.authenticationIframe));
        Hooks.getWaitWebDriver().until(ExpectedConditions.visibilityOfElementLocated(ConsumerPortalElements.usernameField));
        WebElement usernameField = Hooks.getWebDriver().findElement(ConsumerPortalElements.usernameField);

        usernameField.click();
        usernameField.sendKeys(username);
    }

    @And("the password {string} was typed")
    public void thePasswordWasTyped(String password) throws InterruptedException {
        WebElement passwordField = Hooks.getWebDriver().findElement(ConsumerPortalElements.passwordField);

        passwordField.click();
        passwordField.sendKeys(password);
    }

    @When("the button Agree and Sign In is clicked")
    public void theButtonAgreeAndSignInIsClicked() throws InterruptedException {
        Hooks.getWebDriver().findElement(ConsumerPortalElements.submitFormButton).click();
        Thread.sleep(4000);
    }

    @Then("the CP HomePage should be displayed")
    public void theCPHomePageShouldBeDisplayed() {
        Hooks.getWebDriver().switchTo().defaultContent();
        Hooks.getWaitWebDriver().until(ExpectedConditions.visibilityOfElementLocated(ConsumerPortalElements.ConsumerPortalHomeWelcome));
        WebElement ConsumerPortalWelcome = Hooks.getWebDriver().findElement(ConsumerPortalElements.ConsumerPortalHomeWelcome);

        Assert.assertEquals(ConsumerPortalWelcome.getText(), "Welcome!");
    }
}
