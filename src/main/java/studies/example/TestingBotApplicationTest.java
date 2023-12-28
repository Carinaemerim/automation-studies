package studies.example;

import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import studies.example.elements.TestingBotApplicationElements;

import java.time.Duration;

public class TestingBotApplicationTest extends SetUp{

    @Test
    public void siteHeaderIsOnHomepage() {
        getWebdriver().get(TestingBotApplicationElements.getBaseURL());
        WebElement header = getWebdriver().findElement(TestingBotApplicationElements.pageHeader);
        Assert.assertTrue(header.isDisplayed());
    }

    @Test
    public void validateClickOnStartFreeTrial(){
        getWebdriver().get(TestingBotApplicationElements.getBaseURL());
        WebElement button = getWebdriver().findElement(TestingBotApplicationElements.pageHeader);
        Assert.assertTrue(button.getText().contains(TestingBotApplicationElements.trialButtonText));
        button.click();
        WebDriverWait wait = new WebDriverWait(getWebdriver(), Duration.ofSeconds(5));
        wait.until(ExpectedConditions.visibilityOfElementLocated(TestingBotApplicationElements.companyNameInputField));
        WebElement form = getWebdriver().findElement(TestingBotApplicationElements.trialPageForm);
        Assert.assertTrue(form.isDisplayed());
    }

}
