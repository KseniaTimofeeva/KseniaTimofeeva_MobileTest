package scenarios.nativeTests;

import io.appium.java_client.HasOnScreenKeyboard;
import org.openqa.selenium.By;
import org.testng.Assert;
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


        //checks
        //Check that fields (Contact Name, Contact Phone) are appeared
        By contactNameFiled = By.id(app_package_name + "contactNameEditText");
        By contactPhoneField = By.id(app_package_name + "contactPhoneEditText");
        Assert.assertTrue(driver().findElement(contactNameFiled).isDisplayed());
        Assert.assertTrue(driver().findElement(contactPhoneField).isDisplayed());

        //Check that fields titles are right
        By contactNameTitle = By.id("Contact Name");
        By contactPhoneTitle = By.id("Contact Phone");
        Assert.assertEquals(driver().findElement(contactNameTitle).getText(), "Contact Name");
        Assert.assertEquals(driver().findElement(contactPhoneTitle).getText(), "Contact Phone");

        //Keyboard presence check
        if (driver() instanceof HasOnScreenKeyboard) {
            Assert.assertTrue(((HasOnScreenKeyboard) driver()).isKeyboardShown());
        } else {
            throw new RuntimeException("Current driver " + driver().getClass().getSimpleName() + " doesn't have a HasOnScreenKeyboard implementation");
        }

        System.out.println("Simplest Appium test done");
    }


}
