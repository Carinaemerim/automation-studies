package studies.example.elements;

import org.openqa.selenium.By;

public class ConsumerPortalElements {

    //public final static String baseURL = "https://my.uat.trustly.one/login";
    public final static String baseURL = "http://localhost:16000/login";
    public final static By passKeyButton = By.xpath("//*[@id=\"root\"]/div/div/button[1]");
    public final static By lightboxIframe = By.id("paywithmybank-iframe");
    public final static By lightboxSearch = By.id("lbx-listBank-inputSearch");
    public final static By demoBankRadio = By.xpath("//*[@id=\"lbx-listBank-select200005501\"]/div/div/label/div[2]/div/span[2]");
    public final static By usernameField = By.id("lbx-formAuthenticate-authFields-inputusername");
    public final static By authenticationIframe = By.id("lbx-iframeAuthenticate");
    public final static By passwordField = By.id("lbx-formAuthenticate-authFields-inputpassword");
    public final static By widgetSearch = By.id("widgetSearchField");
    public final static By widgetIframe = By.id("paywithmybank-iframe-widgetFrame");
    public final static By demoBankRadioWidget = By.xpath("//*[@id=\"fic-200005501\"]");
    public final static By submitFormButton = By.id("lbx-formLogin-submit");
    public final static By ConsumerPortalHomeWelcome = By.xpath("//*[@id=\"root\"]/div/div[3]/div/h1");

}
