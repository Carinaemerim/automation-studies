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
import studies.example.elements.demoqa.ElementsDemoQARadioButton;
import studies.example.elements.demoqa.ElementsDemoQATable;
import studies.example.elements.demoqa.ElementsDemoQATextBox;
import studies.example.elements.demoqa.ElementsDemoQAcheckBox;

import java.util.Locale;
import java.util.Objects;

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

    @And("a confirmation message {string} is displayed")
    @Then("a confirmation {string} message should be displayed")
    public void aConfirmationMessageIsDisplayed(String message) {
        WebElement notesConfirmationMessage = Hooks.getWebDriver().findElement(ElementsDemoQAcheckBox.notesConfirmationMessage);

        Hooks.getWaitWebDriver().until(ExpectedConditions.visibilityOf(notesConfirmationMessage));
        Assert.assertTrue(notesConfirmationMessage.getText().contains(message));
    }

    @And("the Check Box item is unchecked")
    public void theCheckBoxItemIsUnchecked() {
        Hooks.getWebDriver().findElement(ElementsDemoQAcheckBox.checkboxNotes).click();
    }

    @Then("the confirmation message should not be displayed anymore")
    public void theConfirmationMessageShouldNotBeDisplayedAnymore() {
        Assert.assertTrue(Hooks.getWebDriver().findElements(ElementsDemoQAcheckBox.notesConfirmationMessage).isEmpty());
    }

    @And("the Check Box Commands is checked")
    public void theCheckBoxCommandsIsChecked() {
        Hooks.getWaitWebDriver().until(ExpectedConditions.visibilityOfElementLocated(ElementsDemoQAcheckBox.checkboxCommands));
        Hooks.getWebDriver().findElement(ElementsDemoQAcheckBox.checkboxCommands).click();
    }

    @And("the Radio Button item was clicked")
    public void theRadioButtonItemWasClicked() {
        Hooks.getWaitWebDriver().until(ExpectedConditions.visibilityOfElementLocated(ElementsDemoQARadioButton.radioButtonItem));
        Hooks.getWebDriver().findElement(ElementsDemoQARadioButton.radioButtonItem).click();
    }

    @When("the {string} option is clicked")
    public void theRadioOptionIsClicked(String radio) throws InterruptedException {
        Hooks.getWaitWebDriver().until(ExpectedConditions.visibilityOfElementLocated(ElementsDemoQARadioButton.radioButtonYes));
        //Hooks.getWebDriver().findElement(ElementsDemoQARadioButton.radioButtonYes).click();

        WebElement radioText = null;

        if (Objects.equals(radio, "Yes")){
           radioText = Hooks.getWebDriver().findElement(ElementsDemoQARadioButton.radioButtonYes);
        } else {
            radioText = Hooks.getWebDriver().findElement(ElementsDemoQARadioButton.radioButtonImpressive);
        }
        radioText.click();
    }

    @Then("a radio selection confirmation {string} message should be displayed")
    public void aRadioSelectionConfirmationMessageMessageShouldBeDisplayed(String message) {
        WebElement radioButtonConfirmationMessage = Hooks.getWebDriver().findElement(ElementsDemoQARadioButton.radioButtonConfirmationMessage);

        Hooks.getWaitWebDriver().until(ExpectedConditions.visibilityOf(radioButtonConfirmationMessage));
        Assert.assertTrue(radioButtonConfirmationMessage.getText().contains(message));
    }

    @Then("the radio button should not be clickable")
    public void theRadioButtonShouldNotBeClickable() {
        WebElement radioButtonDisabled = Hooks.getWebDriver().findElement(ElementsDemoQARadioButton.radioButtonNo);

        Assert.assertFalse(radioButtonDisabled.isEnabled());
    }

    @And("the Web Tables item was clicked")
    public void theWebTablesItemWasClicked() {
        Hooks.getWaitWebDriver().until(ExpectedConditions.visibilityOfElementLocated(ElementsDemoQATable.webTableItem));
        Hooks.getWebDriver().findElement(ElementsDemoQATable.webTableItem).click();
    }

    @When("the Add button is clicked")
    public void theAddButtonIsClicked() {
        Hooks.getWaitWebDriver().until(ExpectedConditions.visibilityOfElementLocated(ElementsDemoQATable.addNewTableEntry()));
        Hooks.getWebDriver().findElement(ElementsDemoQATable.addNewTableEntry()).click();
    }

    @And("First Name field is filled with {string}")
    public void firstNameFieldIsFilledWith(String arg0) {
        Hooks.getWaitWebDriver().until(ExpectedConditions.elementToBeClickable(ElementsDemoQATable.firstNameInput));
        WebElement firstNameInput = Hooks.getWebDriver().findElement(ElementsDemoQATable.firstNameInput);

        firstNameInput.sendKeys("Sebastian");
    }

    @And("Last Name field is filled with {string}")
    public void lastNameFieldIsFilledWith(String arg0) {
        WebElement lastNameInput = Hooks.getWebDriver().findElement(ElementsDemoQATable.lastNameInput);

        lastNameInput.sendKeys("Alucard");
    }

    @And("Email field is filled with {string}")
    public void emailFieldIsFilledWith(String arg0) {
        WebElement userEmailInput = Hooks.getWebDriver().findElement(ElementsDemoQATable.userEmailInput);

        userEmailInput.sendKeys("sebastian@examples.com");
    }

    @And("Age field is filled with {string}")
    public void ageFieldIsFilledWith(String arg0) {
        WebElement ageInput = Hooks.getWebDriver().findElement(ElementsDemoQATable.ageInput);

        ageInput.sendKeys("234");
    }

    @And("Salary field is filled with {string}")
    public void salaryFieldIsFilledWith(String arg0) {
        WebElement salaryInput = Hooks.getWebDriver().findElement(ElementsDemoQATable.salaryInput);

        salaryInput.sendKeys("100000");
    }

    @And("Department field is filled with {string}")
    public void departmentFieldIsFilledWith(String arg0) {
        WebElement departmentInput = Hooks.getWebDriver().findElement(ElementsDemoQATable.departmentInput);

        departmentInput.sendKeys("Legal");
    }

    @And("Registration Submit button is clicked")
    public void registrationSubmitButtonIsClicked() {
        Hooks.getWebDriver().findElement(ElementsDemoQATable.submitButtonTable).click();
    }

    @Then("a new row with the added info should be created on the table")
    public void aNewRowWithTheAddedInfoShouldBeCreatedOnTheTable() {
        Assert.assertTrue(Hooks.getWebDriver().findElement(ElementsDemoQATable.table).getText().contains("Sebastian"));
        Assert.assertTrue(Hooks.getWebDriver().findElement(ElementsDemoQATable.table).getText().contains("Alucard"));

    }

    @Then("empty fields should display an error mark")
    public void emptyFieldsShouldDisplayAnErrorMark() {
        WebElement inputInvalidAttribute = Hooks.getWebDriver().findElement(ElementsDemoQATable.firstNameInput);
        Assert.assertNotEquals(inputInvalidAttribute.getAttribute("validationMessage"), "");
    }
}
