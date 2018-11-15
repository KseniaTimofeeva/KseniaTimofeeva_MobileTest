package scenarios.nativeTests;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import setup.Driver;

import java.io.IOException;

@Test(groups = "native")
public class SimpleNativeTests extends Driver {

    protected SimpleNativeTests() throws IOException {
    }

    @Test(description = "This simple test just click on button 'Add contact'")
    public void SimplestTest() throws Exception {

        //Find button by id
        String app_package_name = "com.example.android.contactmanager:id/";
        By add_btn = By.id(app_package_name + "addContactButton");

        //Find button by xpath
//        By add_btn = By.xpath("//android.widget.Button");

        //Find button by classname
//        By add_btn = By.className("android.widget.Button");

        driver().findElement(add_btn).click();
        System.out.println("Simplest Appium test done");
    }



}
