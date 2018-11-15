##Homework 1
1. Setup project that has been discussed in the class. Make sure you can run both tests (native and web) successfully.<br />

   See "hw1" package

2. For existing native mobile autotest try to use another locator (xpath, classname, ?). 
   Define these locators using Appium Inspector. Are there any difference with id version?<br />

    ```
    //Find button by id
    String app_package_name = "com.example.android.contactmanager:id/";
    By add_btn = By.id(app_package_name + "addContactButton");

    //Find button by xpath
    By add_btn = By.xpath("//android.widget.Button");

    //Find button by classname
    By add_btn = By.className("android.widget.Button");
    ```
   
3. Modify existing tests to run on a real device. What should be changed?<br /> 

   Capabilities (deviceName) should be changed:
    ```
    capabilities.setCapability("deviceName","a70ae441");
    ```
  
4. Connect a real device to Appium (describe required actions) and run tests.<br /> 
   Are there any difference with run on emulator?<br />
    
   I should enable developer options and USB debugging on mobile device firstly.<br />
   
5. What should be improved/changed in existing test code? Why, for what?<br />
    
    * Hardcoded values should be fixed<br />
    * Thread.sleep isn't allowed in production code. It should be fixed<br />
    * The code structure should be changed to separate web and native app tests to avoid commenting<br />
    * Absolute path isn't allowed<br />
    * There are no tests<br />
    * DriverSetup class is too specific class. The structure should be changed to add more abstraction and to avoid code duplication<br />
    
##Homework 2
1. Rewrite (complete) Driver using “singleton” pattern. Are there any advantages?

   It allows to have one unique object of Driver instead of several instances after inheritance of several classes.
   Otherwise we will not know what driver we work with.

2. Suggest improvements for .properties reading. What are the purposes?
   
   We can put .properties file in the root of project to make the path shorter.
   Also we can use relative path instead of absolute:
   ```
   FileInputStream in = new FileInputStream("nativetest.properties");
   ```
   instead of:
   ```
   FileInputStream in = new FileInputStream(System.getProperty("user.dir") + "/nativetest.properties");
   ```
   It's more readable and easy to change

3. Add checks of other fields and their titles (Contact Name, Contact phone) in “native” test
   
   See SimpleNativeTests.java
   * Check that fields (Contact Name, Contact Phone) are appeared
   * Check that fields titles are right 

4. Add keyboard presence check  in “native” test.

   See SimpleNativeTests.java

5. Which checks would you place in the “web” test?
 
   * Check that current url is right
   * Check that http status code is 200

6. Implement checks for “web” test in code and try to use. 
    
   See SimpleWebTests.java