package cucumber;

import cucumber.utils.Hooks;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import studies.example.elements.demoqa.ElementsDemoQATextBox;
import studies.example.elements.demoqa.ElementsDemoQAcheckBox;

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

    @And("the name {string} was typed on the Full name field")
    public void theNameFullNameWasTypedOnTheFullNameField(String name) {
        Hooks.getWaitWebDriver().until(ExpectedConditions.visibilityOfElementLocated(ElementsDemoQATextBox.fullName));
        Hooks.getWebDriver().findElement(ElementsDemoQATextBox.fullName).sendKeys(name);
    }

    @And("the email {string} was typed on the Email field")
    public void theEmailEmailWasTypedOnTheEmailField(String email) {
        Hooks.getWebDriver().findElement(ElementsDemoQATextBox.userEmail).sendKeys(email);
    }

    @And("the address {string} was typed on the Current Address field")
    public void theAddressCurrentAddressWasTypedOnTheCurrentAddressField(String currentAddress) {
        Hooks.getWebDriver().findElement(ElementsDemoQATextBox.currentAddress).sendKeys( currentAddress);
    }

    @And("the address {string} was typed on the Permanent Address field")
    public void theAddressPermanentAddressWasTypedOnThePermanentAddressField(String permanentAddress) {
        Hooks.getWebDriver().findElement(ElementsDemoQATextBox.permanentAddress).sendKeys( permanentAddress);

    }

    @When("Submit button is clicked")
    public void submitButtonIsClicked() {

        WebElement submitButtonForm = Hooks.getWebDriver().findElement(ElementsDemoQATextBox.submitButtonForm);

        Hooks.getWaitWebDriver().until(ExpectedConditions.elementToBeClickable(submitButtonForm));
        Hooks.getJavascriptExecutor().executeScript("arguments[0].scrollIntoView();", submitButtonForm);
        submitButtonForm.click();
    }

    @Then("all information added should be displayed at the bottom fo the form")
    public void allInformationAddedShouldBeDisplayedAtTheBottomFoTheForm() {
        WebElement nameConfirmation = Hooks.getWebDriver().findElement(ElementsDemoQATextBox.nameConfirmation);

        Hooks.getWaitWebDriver().until(ExpectedConditions.visibilityOf(nameConfirmation));
        Assert.assertTrue(nameConfirmation.getText().contains("Joana Guimarães"));
        Assert.assertTrue(Hooks.getWebDriver().findElement(ElementsDemoQATextBox.emailConfirmation).getText().contains("joanaguimaraes@example.com"));
    }
    @And("the Check Box item was clicked")
    public void theCheckBoxItemWasClicked() {
        Hooks.getWaitWebDriver().until(ExpectedConditions.visibilityOfElementLocated(ElementsDemoQAcheckBox.checkboxItem));
        Hooks.getWebDriver().findElement(ElementsDemoQAcheckBox.checkboxItem).click();
    }

    @And("the Home arrow was clicked")
    public void theHomeArrowWasClicked() {
        Hooks.getWaitWebDriver().until(ExpectedConditions.visibilityOfElementLocated(ElementsDemoQAcheckBox.checkboxHome));
        Hooks.getWebDriver().findElement(ElementsDemoQAcheckBox.checkboxHomeArrow).click();
    }

    @And("the Desktop arrow was clicked")
    public void theDesktopArrowWasClicked() {
        Hooks.getWaitWebDriver().until(ExpectedConditions.visibilityOfElementLocated(ElementsDemoQAcheckBox.checkboxDesktopArrow));
        Hooks.getWebDriver().findElement(ElementsDemoQAcheckBox.checkboxDesktopArrow).click();
    }

    @When("the Check Box Notes item is checked")
    public void theCheckBoxNotesItemIsChecked() {
        Hooks.getWaitWebDriver().until(ExpectedConditions.visibilityOfElementLocated(ElementsDemoQAcheckBox.checkboxNotes));
        Hooks.getWebDriver().findElement(ElementsDemoQAcheckBox.checkboxNotes).click();

    }

    @And("a confirmation message is displayed")
    public void aConfirmationMessageIsDisplayed() {
        WebElement notesConfirmationMessage = Hooks.getWebDriver().findElement(ElementsDemoQAcheckBox.notesConfirmationMessage);

        Hooks.getWaitWebDriver().until(ExpectedConditions.visibilityOf(notesConfirmationMessage));
        Assert.assertTrue(notesConfirmationMessage.getText().contains("notes"));
    }

    @And("the Check Box item is unchecked")
    public void theCheckBoxItemIsUnchecked() {
        Hooks.getWebDriver().findElement(ElementsDemoQAcheckBox.checkboxNotes).click();
    }

    @Then("the confirmation message should not be displayed anymore")
    public void theConfirmationMessageShouldNotBeDisplayedAnymore() {
        Assert.assertTrue(Hooks.getWebDriver().findElements(ElementsDemoQAcheckBox.notesConfirmationMessage).isEmpty());
    }
}
