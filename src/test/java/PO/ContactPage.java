package test.java.PO;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class ContactPage extends BasePage{
    public ContactPage(WebDriver driver) {
        super(driver);
    }

    By contactsCard = By.xpath("//div[@class='q-contacts-cart']");
    By dniproCity = By.xpath("(//a[@aria-controls='dnipro'])[1]");
    By contactHeader = By.xpath("//h1");

    public ContactPage isShown() {
        logger.info("Open Contact page");
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(contactHeader));
        return this;
    }

    public ContactPage selectCityDnipro() {
        logger.info("Select city Dnipro");
        wait.until(ExpectedConditions.elementToBeClickable(dniproCity));
        driver.findElement(dniproCity).click();
        return this;
    }

    public ContactPage clickContactCard() {
        logger.info("Click contact card");
        wait.until(ExpectedConditions.elementToBeClickable(contactsCard));
        driver.findElement(contactsCard).click();
        return this;
    }
}
