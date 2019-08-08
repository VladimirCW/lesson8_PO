package test.java.Test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import test.java.PO.ContactPage;
import test.java.PO.HomePage;
import test.java.Utils.RetryAnalizer;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.testng.Assert.assertTrue;
import static org.testng.FileAssert.fail;

public class MaintTest extends TestBaseSetup{
    HomePage homePage;
    ContactPage contactPage;

    @BeforeMethod
    public void init2() {
        homePage = new HomePage(driver);
        contactPage = new ContactPage(driver);
    }

    @Test
    public void testMessage() {
        homePage.isShown()
                .openContactPage();
        fail();
    }
    @Test
    public void testMessage2() {
        homePage.isShown()
                .openContactPage();
        //fail();
    }
}
