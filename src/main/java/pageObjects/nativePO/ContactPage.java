package pageObjects.nativePO;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ContactPage {

    @FindBy(id = app_package_name + "addContactButton")
    private WebElement add_btn;

    private final String app_package_name = "com.example.android.contactmanager:id/";

    //methods
    public void clickAddContactButton(AppiumDriver driver) {
        //Find button by xpath
//        By add_btn = By.xpath("//android.widget.Button");

        //Find button by classname
//        By add_btn = By.className("android.widget.Button");

        add_btn.click();
    }


}
