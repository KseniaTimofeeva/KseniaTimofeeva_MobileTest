package pageObjects.webPO;

import io.appium.java_client.AppiumDriver;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClientBuilder;
import org.testng.Assert;

import java.io.IOException;

public class IndexPage {

    //checks
    public void checkCurrentUrlIsRight(AppiumDriver driver, String expUrl) {
        Assert.assertEquals(driver.getCurrentUrl(), expUrl);
    }

    public void checkHttpStatusCode(String url, int expCode) throws IOException {
        HttpClient client = HttpClientBuilder.create().build();
        HttpGet request = new HttpGet(url);
        HttpResponse response = client.execute(request);
        Assert.assertEquals(response.getStatusLine().getStatusCode(), expCode);
    }
}
