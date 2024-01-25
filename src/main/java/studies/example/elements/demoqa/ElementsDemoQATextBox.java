package studies.example.elements.demoqa;

import org.openqa.selenium.By;

public class ElementsDemoQATextBox {
    public final static String baseURL = "https://demoqa.com/";
    public final static By elementsButton = By.xpath("//*[@id=\"app\"]/div/div/div[2]/div/div[1]/div/div[1]");
    public final static  By textBoxButton = By.xpath("//*[@id=\"item-0\"]");
    public final static By fullName = By.id("userName");
    public final static By userEmail = By.id("userEmail");
    public final static By currentAddress = By.id("currentAddress");
    public final static By permanentAddress = By.id("permanentAddress");
    public final static By submitButtonForm = By.id("submit");
    public final static  By nameConfirmation = By.id("name");
    public final static  By emailConfirmation = By.id("email");
}
