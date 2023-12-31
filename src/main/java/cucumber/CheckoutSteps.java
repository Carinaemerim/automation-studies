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
import studies.example.elements.TestingBotApplicationElements;

import java.time.Duration;
import java.util.List;

public class CheckoutSteps {
    @Given("the merchant generated a payment link")
    public void theMerchantGeneratedAPaymentLink() {
        String paymentLink = CheckoutElements.paymentLink;
        //TODO Generate a dynamic link using API
    }

    @And("the consumer accessed the payment link")
    @When("the consumer accesses the payment link")
    public void theConsumerAccessesThePaymentLink() {
        Hooks.getWebdriver().get(CheckoutElements.paymentLink);
        WebDriverWait wait = new WebDriverWait(Hooks.getWebdriver(), Duration.ofSeconds(15));
        wait.until(ExpectedConditions.visibilityOfElementLocated(CheckoutElements.paymentTitle));
    }

    @Then("it should open the payment information")
    public void itShouldOpenThePaymentInformation() {
        WebElement pageLogo = Hooks.getWebdriver().findElement(CheckoutElements.pageLogo);
        WebElement paymentTitle = Hooks.getWebdriver().findElement(CheckoutElements.paymentTitle);
        WebElement paymentAmount = Hooks.getWebdriver().findElement(CheckoutElements.paymentAmount);
        WebElement createdLinkDate = Hooks.getWebdriver().findElement(CheckoutElements.createdLinkDate);

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
        WebElement creditCardOption = Hooks.getWebdriver().findElement(CheckoutElements.paymentTypeCredit);
        creditCardOption.click();
        WebDriverWait creditCardform = new WebDriverWait(Hooks.getWebdriver(), Duration.ofSeconds(15));
        creditCardform.until(ExpectedConditions.visibilityOfElementLocated(CheckoutElements.creditCardNumberForm));
    }

    @When("he adds a credit card information")
    public void heAddsACardStatusCreditCardInformation() {
        WebElement creditCardform = Hooks.getWebdriver().findElement(CheckoutElements.creditCardNumberForm);
        WebElement creditCardName = Hooks.getWebdriver().findElement(CheckoutElements.cardName);
        WebElement dueDate = Hooks.getWebdriver().findElement(CheckoutElements.dueCardDate);
        WebElement cardCvv = Hooks.getWebdriver().findElement(CheckoutElements.cardCvv);

        creditCardform.click();
        creditCardform.sendKeys("5155901222270002");
        creditCardName.click();
        creditCardName.sendKeys("John Smith");
        dueDate.click();
        dueDate.sendKeys("01/26");
        cardCvv.click();
        cardCvv.sendKeys("120");

    }

    @Then("the system should return {string}")
    public void theSystemShouldReturnMessage(String returnMessage) {

    }

    @And("{string} installments were selected")
    public void installmentsWereSelected(String installmentsQuantity) {
        WebDriverWait wait = new WebDriverWait(Hooks.getWebdriver(), Duration.ofSeconds(15));
        WebElement installmentQuantity = Hooks.getWebdriver().findElement(CheckoutElements.installmentsQuantity);

        installmentQuantity.click();
        WebElement installmentsMenu = Hooks.getWebdriver().findElement(CheckoutElements.installmentsMenu);
        wait.until(ExpectedConditions.visibilityOf(installmentsMenu));
        List<WebElement> installmentsOption = Hooks.getWebdriver().findElements(CheckoutElements.installmentsOption);

        for (int i = 0; i<installmentsOption.size(); i++) {
            WebElement option = installmentsOption.get(i);
            String value = option.getAttribute("data-value");

            if (value.equals(installmentsQuantity)) {
                option.click();
                break;
            }
        }
    }

    @And("termsOfUse was checked")
    public void termsofuseWasChecked() {
        WebElement checkboxTou = Hooks.getWebdriver().findElement(CheckoutElements.touCheckBox);
        WebElement finishTransactionButton = Hooks.getWebdriver().findElement(CheckoutElements.finishPaymentButton);
        WebDriverWait wait = new WebDriverWait(Hooks.getWebdriver(), Duration.ofSeconds(15));

        wait.until(ExpectedConditions.visibilityOfElementLocated(CheckoutElements.touCheckBox));
        checkboxTou.click();
        finishTransactionButton.click();
    }
}
