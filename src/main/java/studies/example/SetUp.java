package studies.example;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import java.sql.Driver;

public class SetUp {
    private WebDriver driver;

    @BeforeTest
    public void startDriver(){
        System.setProperty("webdriver.chromedriver", "c:/Users/carinaleal/WebDrivers/chromedriver");
        driver = new ChromeDriver();
    }

    @AfterTest
    public void closeDriver(){
        driver.close();
    }

    public WebDriver getWebdriver(){
        return driver;
    }
}
