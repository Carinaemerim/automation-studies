package studies.example.elements;

import org.openqa.selenium.By;

public class TestingBotApplicationElements{

    //Get element using a method
    public static String getBaseURL() {
        return "https://testingbot.com";
    }

    //Get element using an attribute
    public final static By pageHeader = By.xpath("/html/body/div[1]/nav/div/div[3]/a[1]");
    //public final static By pageHeaderTitle = By.xpath("/html/body/div[2]/div[1]/div/div/h1");
    public final static String trialButtonText = "Start a free trial";
    public final static By companyNameInputField = By.id("user_company");
    public final static By trialPageForm = By.xpath("/html/body/div[1]/nav/div/div[3]/a[1]");

}
