package test.java.Test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import test.java.PO.ContactPage;
import test.java.PO.HomePage;
import test.java.Utils.Screenshot;

public class TestBaseSetup {
    WebDriver driver;

    @BeforeMethod(description = "Initialize custom driver")
    public void init(ITestContext context) {
        System.setProperty("webdriver.chrome.driver"
                , "C:\\Users\\Volodymyr_Dmytriukhi\\WebDriver\\chromedriver_win32v75\\chromedriver.exe");
        driver = new ChromeDriver();
        context.setAttribute("webDriver", driver);
    }

    @AfterMethod (description = "Finilize custom driver")
    public void finilize(ITestResult result) {
        driver.quit();
    }
}
