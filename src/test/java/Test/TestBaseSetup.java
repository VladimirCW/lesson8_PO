package test.java.Test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import test.java.PO.ContactPage;
import test.java.PO.HomePage;

public class TestBaseSetup {
    WebDriver driver;

    @BeforeMethod
    public void init() {
        System.setProperty("webdriver.chrome.driver"
                , "C:\\Users\\Volodymyr_Dmytriukhi\\WebDriver\\chromedriver_win32v75\\chromedriver.exe");
        driver = new ChromeDriver();
    }

    @AfterMethod
    public void finilize() {
        driver.quit();
    }
}
