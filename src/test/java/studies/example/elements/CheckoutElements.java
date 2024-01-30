package studies.example.elements;

import org.openqa.selenium.By;

public class CheckoutElements {
    public final static String paymentLink = "https://pay.stg.bavabank.com/2b280833-4300-4c06-85a2-34a34bc87b2b";
    public final static By pageLogo = By.xpath("//*[@id=\"root\"]/div/header/div/div/div/div/div/img");
    public final static By paymentTitle = By.xpath("//*[@id=\"root\"]/div/div/div/div/div/div[1]/div/h2/span[2]");
    public final static By paymentAmount = By.xpath("//*[@id=\"root\"]/div/div/div/div/div/div[2]/div/h5/p[2]");
    public final static By createdLinkDate = By.xpath("//*[@id=\"root\"]/div/div/div/div/div/div[1]/div/p");
    public final static By paymentTypeCredit = By.xpath("//*[@id=\"root\"]/div/div/div/div/div/div[3]/div[1]/div/div/div/div/ul[2]/li");
    public final static By creditCardNumberForm = By.xpath("//*[@id=\":r3:\"]");
    public final static By cardName = By.name("cardholder_name");
    public final static By dueCardDate = By.xpath("//*[@id=\":r5:\"]");
    public final static By cardCvv = By.name("card_code");
    public final static By installmentsQuantity = By.id("inp-card-installments");
    public final static By installmentsOption = By.cssSelector("#menu-installments li");
    public final static By installmentsMenu = By.id("menu-installments");
    public final static By touCheckBox = By.cssSelector("input[data-testid=checkbox-terms]");
    public final static By finishPaymentButton = By.xpath("//*[@id=\"root\"]/div/div/div/div/div/div[3]/div[2]/div[2]/button");
    // Finishing a transaction elements
    public final static By paymentFinalStatus = By.xpath("//*[@id=\"root\"]/div/div/div/div/div/div[3]/div[1]/div/div/h2/div[1]/div[1]");
    public final static By paymentConsumerMessage = By.xpath("//*[@id=\"root\"]/div/div/div/div/div/div[3]/div[1]/div/div/h2/div[2]");
    public final static  By pageLoading = By.xpath("//*[@id=\"root\"]/div/div[2]");
}
