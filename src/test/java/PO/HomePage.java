package test.java.PO;

import io.qameta.allure.Step;
import io.qameta.allure.Story;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import test.java.Utils.PropertyLoader;

import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static org.testng.Assert.assertTrue;
import static org.testng.Assert.fail;

public class HomePage extends BasePage {

    public HomePage(WebDriver driver) {
        super(driver);
    }

    By contactsBtn = By.xpath("//a[contains(@href, 'our-contacts')]");
    By nightCoursesBtn = By.xpath("(//a[contains(text(), 'Вечірні курси')])[1]");
    By coursesBtn = By.xpath("(//a[contains(text(), 'Курси')])[1]");
    By priceHolder = By.xpath("//li[@class='r-total-price-wrapper']//span");

    @Step("Home page is shown ")
    public HomePage isShown() {
        logger.info("Home page is shown");
        driver.manage().window().maximize();
        driver.get(PropertyLoader.getProperty("url"));
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(contactsBtn));
        return this;
    }

    @Step("Open contact page")
    public HomePage openContactPage() {
        logger.info("Open Contact page with paramenter");
        wait.until(ExpectedConditions.elementToBeClickable(contactsBtn));
        driver.findElement(contactsBtn).click();
        return this;
    }

    @Step("Open night courses")
    public HomePage openNigthCourses() {
        logger.info("open night courses");
        Actions action = new Actions(driver);
        wait.until(ExpectedConditions.elementToBeClickable(nightCoursesBtn));
        action.moveToElement(driver.findElement(nightCoursesBtn)).perform();
        wait.until(ExpectedConditions.elementToBeClickable(coursesBtn));
        driver.findElement(coursesBtn).click();
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id='footer']")));
        return this;
    }

    @Step("Open course {name}")
    public HomePage openCourse(String name) {
        logger.info(String.format("Open course '%s'", name));
        By course = By.xpath(String.format("//h2[text()='%s']/..//a[text()='Переглянути']", name));
        wait.until(ExpectedConditions.elementToBeClickable(course));
        driver.findElement(course).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@data-filter='.course-list']")));
        return this;
    }

    @Step("Get course prise")
    public int getCoursePrice() {
        wait.until(ExpectedConditions.presenceOfElementLocated(priceHolder));
        String rawPrice = driver.findElement(priceHolder).getText();
        int price = Integer.parseInt(rawPrice.substring(0, rawPrice.indexOf(" ")));
        return price;
    }

    public boolean checkDayCoursesArePresent() {
        logger.info("Check day courses are present");
        String arr[] = {"Тестування", "Frontend development"};
        List<String> courses = Arrays.asList(arr);
        List<WebElement> list = driver.findElements(By.xpath("//h2"));
        for (WebElement el : list) {
            if (!courses.contains(el.getText())) {
                System.out.println(String.format("Expected courses to contain '%s'.", el.getText()));
                return false;
            }
        }
        return true;
    }
}
