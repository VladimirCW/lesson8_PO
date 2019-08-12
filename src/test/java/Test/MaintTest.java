package test.java.Test;

import io.qameta.allure.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import test.java.PO.ContactPage;
import test.java.PO.HomePage;
import test.java.Utils.RetryAnalizer;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;
import static org.testng.FileAssert.fail;

@Epic("Allure examples")
@Feature("Junit 4 support")
public class MaintTest extends TestBaseSetup{
    HomePage homePage;
    ContactPage contactPage;

    @BeforeMethod(description = "Page factory")
    public void init2() {
        homePage = new HomePage(driver);
        contactPage = new ContactPage(driver);
    }

    @Issues({
            @Issue("AAA-1"),
            @Issue("AAA-2")
    })
    @Story("Base support for bdd annotations")
    @Link("https://example.org")
    @Test(description = "Check courses price", dataProvider = "coursesProvider")
    public void checkCoursesPrice(String courseName, int expectedPrice) {
        homePage.isShown()
                .openNigthCourses()
                .openCourse(courseName);
        int actualPrice = homePage.getCoursePrice();
        assertEquals(actualPrice, expectedPrice, String.format("Expected price to be equals '%d' for '%s'", expectedPrice, courseName));
    }

    @DataProvider(name = "coursesProvider")
    public Object[][] coursesProvider() {
        return new Object[][] {
                {"Тестування", 17300},
                {"Frontend development", 18100}
        };
    }
}
