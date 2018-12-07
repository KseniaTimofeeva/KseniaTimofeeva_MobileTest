package scenarios;

import enums.PropertyFile;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import setup.Driver;

import java.io.IOException;

@Test(groups = {"web", "native"})
public class Hooks extends Driver {
    private static final Logger LOG = LogManager.getLogger(Hooks.class);

    protected Hooks() throws IOException {
        super();
        LOG.debug("Hooks init");
    }

    @Parameters("usePropFile")
    @BeforeSuite(description = "Prepare driver to run test(s)")
    public void setUp(String usePropFile) throws Exception {
        setPropertyFile(PropertyFile.getPropertyFile(usePropFile));
        prepareDriver();
        LOG.debug("Driver prepared");
    }

    @AfterSuite(description = "Close driver on all tests completion")
    public void tearDown() throws Exception {
        driver().quit();
        LOG.debug("Driver closed");
    }
}
