package cucumber.utils;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.function.Function;

public class Hooks {
    private static WebDriver driver;
    private static WebDriverWait wait;
    private static JavascriptExecutor javascriptExecutor;

    @Before
    public static void startDriver(){
        ChromeOptions options = new ChromeOptions();
        String ci = System.getenv("CI");

        if (ci != null && ci.equals("true")) {
            options.addArguments("--no-sandbox");
            options.addArguments("--disable-dev-shm-usage");
            options.addArguments("--headless");
            options.addArguments("--window-size=1920,1080");
        }

        driver = new ChromeDriver(options);

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
