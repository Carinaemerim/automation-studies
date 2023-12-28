package cucumber.utils;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Hooks {
    private static WebDriver driver;

    @Before
    public static void startDriver(){
        System.setProperty("webdriver.chromedriver", "c:/Users/carinaleal/WebDrivers/chromedriver");
        driver = new ChromeDriver();
    }

    @After
    public static void closeDriver(){
        driver.close();
    }

    public static WebDriver getWebdriver(){
        return driver;
    }
}
