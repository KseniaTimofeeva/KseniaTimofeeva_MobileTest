package scenarios.nativeTests;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pageObjects.nativePO.AddContactPage;
import pageObjects.nativePO.ContactPage;
import setup.Driver;

import java.io.IOException;

@Test(groups = "native")
public class SimpleNativeTests extends Driver {
    private static final Logger LOG = LogManager.getLogger(SimpleNativeTests.class);

    private ContactPage contactPage;
    private AddContactPage addContactPage;

    protected SimpleNativeTests() throws IOException {
    }

    @BeforeClass
    public void beforeClass() throws Exception {
        contactPage = PageFactory.initElements(driver(), ContactPage.class);
        addContactPage = PageFactory.initElements(driver(), AddContactPage.class);
    }

    @Test(description = "This simple test just click on button 'Add contact'")
    public void SimplestTest() throws Exception {

        //Click button Add contact
        contactPage.clickAddContactButton(driver());

        //Check that field Contact Name is appeared
        addContactPage.checkContactNameFieldAppeared();

        //Check that field Contact Phone is appeared
        addContactPage.checkContactPhoneFiledAppeared();

        //Check title of Contact Name field is right
        addContactPage.checkContactNameTitle("Contact Name");

        //Check title of Contact Phone field is right
        addContactPage.checkContactPhoneTitle("Contact Phone");

        //Keyboard presence check
        addContactPage.checkKeyboardPresence(driver());

        LOG.info("Simplest Appium test done");
    }


}
