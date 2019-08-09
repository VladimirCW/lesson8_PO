package test.java.PO;

import io.qameta.allure.Step;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;

import javax.swing.*;
import java.util.Arrays;
import java.util.List;

import static org.testng.Assert.assertTrue;
import static org.testng.Assert.fail;

public class HomePage extends BasePage {
    String name = "Vasya";
    String password = "123";

    public HomePage(WebDriver driver) {
        super(driver);
    }

    By contactsBtn = By.xpath("//a[contains(@href, 'our-contacts')]");
    By eveningCourses = By.xpath("//li[@id='menu-item-7956']");
    By coursesBtn = By.xpath("//li[@id='menu-item-7885']");

    @Step("Home page is shown")
    public HomePage isShown() {
        logger.info("Home page is shown");
        driver.manage().window().maximize();
        driver.get("http://iteaua-develop.demo.gns-it.com/uk/about_itea/");
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(contactsBtn));
        this.countToThree(777);
        //driver.findElement(By.xpath("//a[@id='11111111111111']")).click();
        return this;
    }

    @Step("Count to Three {i}")
    private void countToThree(int i) {
        int j = i;
    }

    @Step("Open contact page")
    public HomePage openContactPage() {
        logger.info("Open Contact page with paramenter");
        wait.until(ExpectedConditions.elementToBeClickable(contactsBtn));
        driver.findElement(contactsBtn).click();
        return this;
    }

    public HomePage openNigthCourses() {
        logger.info("open night courses");
        driver.get("http://iteaua-develop.demo.gns-it.com/");
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("(//h2)[23]")));
        return this;
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

    public HomePage openEveningCourses() {
        Actions action = new Actions(driver);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//li[@id='menu-item-7956']")));
        action.moveToElement(driver.findElement(By.xpath("//li[@id='menu-item-7956']"))).perform();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//li[@id='menu-item-7885']")));
        driver.findElement(By.xpath("//li[@id='menu-item-7885']")).click();
        return this;
    }
}
