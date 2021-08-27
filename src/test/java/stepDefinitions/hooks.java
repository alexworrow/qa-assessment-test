package stepDefinitions;

import common.basePage;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

/**
 * Contains the hooks @before and @after which run before and after each scenario to initialise and close the browser.
 * This allows each test to be run independently and without impacting each other.
 */

public class hooks extends basePage {

    /**
     * As part of using Cucumber @before is always run before the execution of each test.
     * In this instance it is used to initialise the browser, and also maximise it to the screen as well as remove the automation indicator which Chrome automatically applies.
     */
    @Before
    public void setUp(){
        System.setProperty("webdriver.chrome.driver","src\\test\\resources\\seleniumDrivers\\chromedriver.exe");
//Directs to the driver so that the Chrome browser can be used in the tests.

        ChromeOptions options = new ChromeOptions();
        options.addArguments("disable-infobars");
        options.addArguments("--start-maximized");
//Disables the info bars and maximises the browser on launch.

        driver = new ChromeDriver(options);
    }

    /**
     * As part of using Cucumber @after is always run after the execution of the tests.
     * In this case it is used to close the browser tab that was used to run the test.
     */
    @After
    public void tearDown(){
        driver.close();
    }
}