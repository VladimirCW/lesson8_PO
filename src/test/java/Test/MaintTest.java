package test.java.Test;

import io.qameta.allure.*;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import test.java.PO.ContactPage;
import test.java.PO.HomePage;

import static org.testng.Assert.fail;

@Epic("First epic")
@Feature("Super feature")
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
    @Story("Very first test should be green")
    @Test(description = "Initial test should be passed")
    public void testMessage() {
        homePage.isShown()
                .openContactPage();
        //fail();
    }

    @Story("Second test also should be green")
    @Test
    public void testMessage2() {
        homePage.isShown()
                .openContactPage();
        //fail();
    }
}
