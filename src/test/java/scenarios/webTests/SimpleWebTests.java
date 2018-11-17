package scenarios.webTests;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;
import setup.Driver;

import java.io.IOException;

@Test(groups = "web")
public class SimpleWebTests extends Driver {
    private static final Logger LOG = LogManager.getLogger(SimpleWebTests.class);

    private SimpleWebTests() throws IOException {
        super();
    }

    @Test(description = "Open website")
    public void webTest() throws Exception {
        driver().get(SUT);
        driverWait().until(ExpectedConditions.urlToBe(SUT + "/"));

        //checks
        //Check that current url is right
        Assert.assertEquals(driver().getCurrentUrl(), SUT + "/");

        //Check that http status code is 200
        checkHttpStatusCode(200);

        LOG.info("Site opening done");
    }

    private void checkHttpStatusCode(int expCode) throws IOException {
        HttpClient client = HttpClientBuilder.create().build();
        HttpGet request = new HttpGet(SUT);
        HttpResponse response = client.execute(request);
        Assert.assertEquals(response.getStatusLine().getStatusCode(), expCode);
    }
}
