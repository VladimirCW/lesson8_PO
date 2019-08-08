package test.java.Test;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import test.java.PO.ContactPage;
import test.java.PO.HomePage;

public class MaintTest2 extends TestBaseSetup{
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
        //fail();
    }
    @Test
    public void testMessage2() {
        homePage.isShown()
                .openContactPage();
        //fail();
    }
}
