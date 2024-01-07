package cucumber;

import cucumber.utils.Hooks;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import studies.example.elements.CheckoutElements;

import java.time.Duration;
import java.util.List;

public class CheckoutSteps {
    @Given("a payment link was generated")
    public void aPaymentLinkWasGenerated() {
        Hooks.getWebDriver().get(CheckoutElements.paymentLink);
        //TODO Generate a dynamic link using API
    }

    @And("the payment link was accessed")
    @When("the payment link is accessed")
    public void theConsumerAccessesThePaymentLink() {
        WebDriverWait wait = new WebDriverWait(Hooks.getWebDriver(), Duration.ofSeconds(15));
        wait.until(ExpectedConditions.visibilityOfElementLocated(CheckoutElements.paymentTitle));
    }

    @Then("it should open the payment information")
    public void itShouldOpenThePaymentInformation() {
        WebElement pageLogo = Hooks.getWebDriver().findElement(CheckoutElements.pageLogo);
        WebElement paymentTitle = Hooks.getWebDriver().findElement(CheckoutElements.paymentTitle);
        WebElement paymentAmount = Hooks.getWebDriver().findElement(CheckoutElements.paymentAmount);
        WebElement createdLinkDate = Hooks.getWebDriver().findElement(CheckoutElements.createdLinkDate);

        Assert.assertTrue(pageLogo.isDisplayed());
        Assert.assertTrue(paymentTitle.isDisplayed()); //TODO get paymentTitle dynamically from API parameters
        Assert.assertTrue(paymentAmount.isDisplayed()); //TODO get paymentAmount dynamically from API parameters
        Assert.assertTrue(createdLinkDate.isDisplayed());

        Assert.assertTrue(paymentTitle.getText().contains("demo-2023-12-30-02-52"));
        Assert.assertTrue(paymentAmount.getText().contains("200,00"));
        Assert.assertTrue(createdLinkDate.getText().contains("02:53 - 30/12/2023"));
    }

    @And("the credit card option was selected")
    public void theCreditCardOptionWasSelected() {
        WebElement creditCardOption = Hooks.getWebDriver().findElement(CheckoutElements.paymentTypeCredit);
        creditCardOption.click();
        Hooks.getWaitWebDriver().until(ExpectedConditions.visibilityOfElementLocated(CheckoutElements.creditCardNumberForm));
    }

    @And("CVV card is displayed")
    public void cvvCardIsDisplayed() {
        WebElement cardCvv = Hooks.getWebDriver().findElement(CheckoutElements.cardCvv);

        cardCvv.click();
        cardCvv.sendKeys("120");
    }

    @And("{string} installments were selected")
    public void installmentsWereSelected(String installmentsQuantity) {
        WebElement installmentQuantity = Hooks.getWebDriver().findElement(CheckoutElements.installmentsQuantity);

        installmentQuantity.click();
        WebElement installmentsMenu = Hooks.getWebDriver().findElement(CheckoutElements.installmentsMenu);
        Hooks.getWaitWebDriver().until(ExpectedConditions.visibilityOf(installmentsMenu));
        List<WebElement> installmentsOption = Hooks.getWebDriver().findElements(CheckoutElements.installmentsOption);

        for (int i = 0; i<installmentsOption.size(); i++) {
            WebElement option = installmentsOption.get(i);
            String value = option.getAttribute("data-value");

            if (value.equals(installmentsQuantity)) {
                option.click();
                break;
            }
        }
    }

    @And("terms Of Use was checked")
    public void termsofuseWasChecked() {
        WebElement checkboxTou = Hooks.getWebDriver().findElement(CheckoutElements.touCheckBox);

        Hooks.getWaitWebDriver().until(ExpectedConditions.visibilityOfElementLocated(CheckoutElements.touCheckBox));
        checkboxTou.click();
    }

    @When("the transaction amount is displayed")
    public void theTransactionAmountIsDisplayed() {
        WebElement paymentAmount = Hooks.getWebDriver().findElement(CheckoutElements.paymentAmount);
        Assert.assertTrue(paymentAmount.getText().contains("200,00"));
    }

    @And("the card number {string} is filled")
    public void theCardNumberIsFilled(String cardNumber) {
        WebElement creditCardForm = Hooks.getWebDriver().findElement(CheckoutElements.creditCardNumberForm);

        creditCardForm.click();
        creditCardForm.sendKeys(cardNumber);
    }

    @And("the card name {string} is filled")
    public void theCardNameIsFilled(String cardName) {
        WebElement creditCardName = Hooks.getWebDriver().findElement(CheckoutElements.cardName);

        creditCardName.click();
        creditCardName.sendKeys(cardName);
    }

    @And("the Due date is filled")
    public void theDueDateIsFilled() {
        WebElement dueDate = Hooks.getWebDriver().findElement(CheckoutElements.dueCardDate);

        dueDate.click();
        dueDate.sendKeys("01/26");
    }

    @And("the button to conclude payment was clicked")
    public void theButtonToConcludePaymentWasClicked() {
        WebElement finishTransactionButton = Hooks.getWebDriver().findElement(CheckoutElements.finishPaymentButton);

        finishTransactionButton.click();
    }

    @Then("the system should return {string}")
    public void theSystemShouldReturnMessage(String returnMessage) throws InterruptedException {
        WebElement paymentFinalStatus = Hooks.getWebDriver().findElement(CheckoutElements.paymentFinalStatus);

        Hooks.getWaitWebDriver().until(ExpectedConditions.visibilityOfElementLocated(CheckoutElements.paymentFinalStatus));
        WebElement pageLoading = Hooks.getWebDriver().findElement(CheckoutElements.pageLoading);

        Hooks.getWaitWebDriver().until( ExpectedConditions.invisibilityOf(pageLoading));
        WebElement paymentConsumerMessage = Hooks.getWebDriver().findElement(CheckoutElements.paymentConsumerMessage);

        Hooks.getWaitWebDriver().until(ExpectedConditions.visibilityOf(paymentFinalStatus));

        Assert.assertTrue(paymentFinalStatus.getText().contains("recusado"));
        Assert.assertEquals(paymentConsumerMessage.getText(), returnMessage);
    }
}
