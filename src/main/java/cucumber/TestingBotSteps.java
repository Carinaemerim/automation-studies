package cucumber;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import studies.example.elements.TestingBotApplicationElements;
import cucumber.utils.Hooks;

import java.time.Duration;

public class TestingBotSteps {

    @Given("the 'Testing Bot' application was accessed")
        public void applicationWasAccessed() {
        Hooks.getWebdriver().get(TestingBotApplicationElements.getBaseURL());
    }

    @When("the page loads")
    public void thePageLoads() {
        WebDriverWait wait = new WebDriverWait(Hooks.getWebdriver(), Duration.ofSeconds(15));
        wait.until(ExpectedConditions.visibilityOfElementLocated(TestingBotApplicationElements.pageHeader));
    }

    @Then("the homepage should be displayed")
    public void theHomepageShouldBeDisplayed() {
        WebElement header = Hooks.getWebdriver().findElement(TestingBotApplicationElements.pageHeader);

        Assert.assertTrue(header.isDisplayed());
    }

    @And("the Trial button is displayed")
    public void theTrialButtonIsDisplayed() {
        WebElement button = Hooks.getWebdriver().findElement(TestingBotApplicationElements.pageHeader);
        Assert.assertTrue(button.getText().contains(TestingBotApplicationElements.trialButtonText));

    }

    @When("the consumer clicks on it")
    public void theConsumerClicksOnIt() {
        WebElement button = Hooks.getWebdriver().findElement(TestingBotApplicationElements.pageHeader);
        button.click();
        WebDriverWait wait = new WebDriverWait(Hooks.getWebdriver(), Duration.ofSeconds(5));
        wait.until(ExpectedConditions.visibilityOfElementLocated(TestingBotApplicationElements.companyNameInputField));
    }

    @Then("the Trial form page should be displayed")
    public void theTrialFormPageShouldBeDisplayed() {
        WebElement form = Hooks.getWebdriver().findElement(TestingBotApplicationElements.trialPageForm);
        Assert.assertTrue(form.isDisplayed());
    }
}
