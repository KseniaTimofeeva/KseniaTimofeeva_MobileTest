2.	For existing native mobile autotest try to use another locator (xpath, classname, ?). 
    Define these locators using Appium Inspector. Are there any difference with id version?

    //Find button by id
 
    String app_package_name = "com.example.android.contactmanager:id/";
    By add_btn = By.id(app_package_name + "addContactButton");

    //Find button by xpath
    By add_btn = By.xpath("//android.widget.Button");

    //Find button by classname
    By add_btn = By.className("android.widget.Button");
   
3.	Modify existing tests to run on a real device. What should be changed? 

    Capabilities (deviceName) should be changed:
    capabilities.setCapability("deviceName","a70ae441");
  
4.	Connect a real device to Appium (describe required actions) and run tests. 
    Are there any difference with run on emulator?
    
    I should enable developer options and USB debugging on mobile device firstly.
   
5.	What should be improved/changed in existing test code? Why, for what?
    
    Hardcoded values should be fixed
    Thread.sleep isn't allowed in production code. It should be fixed
    The code structure should be changed to separate web and native app tests to avoid commenting
    Absolute path isn't allowed
    There are no tests
    DriverSetup class is too specific class. The structure should be changed to add more abstraction and to avoid code duplication
    
    
    
    