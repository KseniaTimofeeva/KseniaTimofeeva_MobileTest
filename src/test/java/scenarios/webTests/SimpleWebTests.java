package scenarios.webTests;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pageObjects.webPO.IndexPage;
import scenarios.Hooks;
import setup.Driver;

import java.io.IOException;

@Test(groups = "web")
public class SimpleWebTests extends Hooks {
    private static final Logger LOG = LogManager.getLogger(SimpleWebTests.class);

    private IndexPage indexPage;

    private SimpleWebTests() throws IOException {
        super();
    }

    @BeforeClass
    public void beforeClass() throws Exception {
        indexPage = PageFactory.initElements(driver(), IndexPage.class);
    }

    @Test(description = "Open website")
    public void webTest() throws Exception {
        driver().get(SUT);
        driverWait().until(ExpectedConditions.urlToBe(SUT + "/"));

        //Check that current url is right
        indexPage.checkCurrentUrlIsRight(driver(), SUT + "/");

        //Check that http status code is 200
        indexPage.checkHttpStatusCode(SUT, 200);

        LOG.info("Site opening done");
    }


}
