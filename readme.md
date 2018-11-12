2.	For existing native mobile autotest try to use another locator (xpath, classname, ?). 
    Define these locators using Appium Inspector. Are there any difference with id version?<br />

    //Find button by id<br />
    String app_package_name = "com.example.android.contactmanager:id/";<br />
    By add_btn = By.id(app_package_name + "addContactButton");<br />

    //Find button by xpath<br />
    By add_btn = By.xpath("//android.widget.Button");<br />

    //Find button by classname<br />
    By add_btn = By.className("android.widget.Button");<br />
   
3.	Modify existing tests to run on a real device. What should be changed?<br /> 

    Capabilities (deviceName) should be changed:<br />
    capabilities.setCapability("deviceName","a70ae441");<br />
  
4.	Connect a real device to Appium (describe required actions) and run tests.<br /> 
    Are there any difference with run on emulator?<br />
    
    I should enable developer options and USB debugging on mobile device firstly.<br />
   
5.	What should be improved/changed in existing test code? Why, for what?<br />
    
    Hardcoded values should be fixed<br />
    Thread.sleep isn't allowed in production code. It should be fixed<br />
    The code structure should be changed to separate web and native app tests to avoid commenting<br />
    Absolute path isn't allowed<br />
    There are no tests<br />
    DriverSetup class is too specific class. The structure should be changed to add more abstraction and to avoid code duplication<br />
    
    
    
    