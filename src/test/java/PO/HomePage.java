package test.java.PO;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.Arrays;
import java.util.List;

import static org.testng.Assert.assertTrue;
import static org.testng.Assert.fail;

public class HomePage extends BasePage{

    public HomePage(WebDriver driver) {
        super(driver);
    }

    By contactsBtn = By.xpath("//a[contains(@href, 'our-contacts')]");

    public HomePage isShown() {
        logger.trace("Trace log");
        logger.info("Open home page");
        logger.debug("Debug loger");
        logger.warn("WARN logger");
        logger.error("ERROR logger");
        logger.fatal("FATAL logger");

        driver.manage().window().maximize();
        driver.get("http://iteaua-develop.demo.gns-it.com/uk/about_itea/");
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(contactsBtn));
        return this;
    }

    public HomePage openContactPage() {
        logger.info("Open Contact page with paramenter");
        wait.until(ExpectedConditions.elementToBeClickable(contactsBtn));
        driver.findElement(contactsBtn).click();
        return this;
    }

    public HomePage openNigthCourses() {
        logger.info("open night courses");
        driver.get("http://iteaua-develop.demo.gns-it.com/courses_itea/");
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("(//h2)[23]")));
        return this;
    }

    public boolean checkDayCoursesArePresent() {
        logger.info("Check day courses are present");
        String arr[] = {"Тестування", "Frontend development"};
        List<String> courses = Arrays.asList(arr);
        List<WebElement> list = driver.findElements(By.xpath("//h2"));
        for(WebElement el: list) {
            if(!courses.contains(el.getText())){
                System.out.println(String.format("Expected courses to contain '%s'.", el.getText()));
                return false;
            }
        }
        return true;
    }
}
