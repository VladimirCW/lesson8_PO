package test.java.PO;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class HomePage extends BasePage{
    public HomePage(WebDriver driver) {
        super(driver);
    }

    By contactsBtn = By.xpath("//a[contains(@href, 'our-contacts')]");

    public HomePage isShown() {
        driver.manage().window().maximize();
        driver.get("http://iteaua-develop.demo.gns-it.com/");
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(contactsBtn));
        return this;
    }

    public HomePage openContactPage() {
        wait.until(ExpectedConditions.elementToBeClickable(contactsBtn));
        driver.findElement(contactsBtn).click();
        return this;
    }
}
