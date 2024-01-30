package cucumber.utils;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.function.Function;

public class Hooks {
    private static WebDriver driver;
    private static WebDriverWait wait;
    private static JavascriptExecutor javascriptExecutor;

    @Before
    public static void startDriver(){
        String chromedriver = System.getenv("CHROMEDRIVER");

        if (chromedriver == null || chromedriver.isEmpty()) {
            chromedriver = "c:/Users/carinaleal/WebDrivers/chromedriver";
        }

        System.setProperty("webdriver.chromedriver", chromedriver);
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        javascriptExecutor = (JavascriptExecutor) driver;
    }

    @After
    public static void closeDriver(){
        driver.close();
    }

    public static WebDriver getWebDriver(){
        return driver;
    }
    public static WebDriverWait getWaitWebDriver() {return wait;}
    public static JavascriptExecutor getJavascriptExecutor() {return javascriptExecutor;}


}
