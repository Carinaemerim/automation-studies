package studies.example.elements.demoqa;

import cucumber.utils.Hooks;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class ElementsDemoQAcheckBox {
    public final static By checkboxItem = By.xpath("//*[@id=\"item-1\"]");
    public final static By checkboxHome = By.xpath("//*[@id=\"tree-node\"]/ol/li/span/label");
    public final static By checkboxHomeArrow = By.xpath("//*[@id=\"tree-node\"]/ol/li/span/button");
    public final static By checkboxDesktopArrow = By.xpath("//*[@id=\"tree-node\"]/ol/li/ol/li[1]/span/button");
    public final static By checkboxNotes = By.xpath("//*[@id=\"tree-node\"]/ol/li/ol/li[1]/ol/li[1]/span/label");
    public final static By notesConfirmationMessage = By.xpath("//*[@id=\"result\"]");
    public final static By checkboxCommands = By.xpath("//*[@id=\"tree-node\"]/ol/li/ol/li[1]/ol/li[2]/span/label");
}
