package test.java.Test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import test.java.PO.ContactPage;
import test.java.PO.HomePage;

public class MaintTest {
    HomePage homePage;
    ContactPage contactPage;
    WebDriver driver;

    @BeforeMethod
    public void init() {
        System.setProperty("webdriver.chrome.driver"
                , "C:\\Users\\Volodymyr_Dmytriukhi\\WebDriver\\chromedriver_win32v75\\chromedriver.exe");
        driver = new ChromeDriver();
        homePage = new HomePage(driver);
        contactPage = new ContactPage(driver);
    }

    @Test
    public void testMessage() {
        homePage.isShown()
                .openContactPage();
        contactPage.isShown()
                .selectCityDnipro()
                .clickContactCard();
    }

    @AfterMethod
    public void finilize() {
        driver.quit();
    }
}
