package pageObjects.nativePO;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.HasOnScreenKeyboard;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

public class AddContactPage {

    @FindBy(id = app_package_name + "contactNameEditText")
    private WebElement contactNameFiled;

    @FindBy(id = app_package_name + "contactPhoneEditText")
    private WebElement contactPhoneField;

    @FindBy(id = "Contact Name")
    private WebElement contactNameTitle;

    @FindBy(id = "Contact Phone")
    private WebElement contactPhoneTitle;

    private final String app_package_name = "com.example.android.contactmanager:id/";

    //checks
    public void checkContactNameFieldAppeared() {
        Assert.assertTrue(contactNameFiled.isDisplayed());
    }

    public void checkContactPhoneFiledAppeared() {
        Assert.assertTrue(contactPhoneField.isDisplayed());
    }

    public void checkContactNameTitle(String expTitle) {
        Assert.assertEquals(contactNameTitle.getText(), expTitle);
    }

    public void checkContactPhoneTitle(String expTitle) {
        Assert.assertEquals(contactPhoneTitle.getText(), expTitle);
    }

    public void checkKeyboardPresence(AppiumDriver driver) {
        if (driver instanceof HasOnScreenKeyboard) {
            Assert.assertTrue(((HasOnScreenKeyboard) driver).isKeyboardShown());
        } else {
            throw new RuntimeException("Current driver " + driver.getClass().getSimpleName() + " doesn't have a HasOnScreenKeyboard implementation");
        }
    }
}
