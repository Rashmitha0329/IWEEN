//package com.iween.testBase;
//
//import java.io.File;
//import java.io.FileReader;
//import java.io.IOException;
//import java.time.Duration;
//import java.util.Properties;
//
//import org.apache.commons.io.FileUtils;
//import org.apache.logging.log4j.LogManager;
//import org.apache.logging.log4j.Logger;
//import org.openqa.selenium.OutputType;
//import org.openqa.selenium.Platform;
//import org.openqa.selenium.TakesScreenshot;
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.chrome.ChromeDriver;
//import org.openqa.selenium.edge.EdgeDriver;
//import org.openqa.selenium.firefox.FirefoxDriver;
//import org.openqa.selenium.remote.Browser;
//import org.openqa.selenium.remote.DesiredCapabilities;
//import org.openqa.selenium.remote.RemoteWebDriver;
//import org.testng.annotations.AfterMethod;
//import org.testng.annotations.BeforeMethod;
//import org.testng.annotations.Parameters;
//
//import com.iween.utilities.ExtentManager;
//import com.iween.utilities.Iween_FutureDates;
//import com.iween.utilities.Log;
//import com.iween.utilities.ScreenshotUtil;
//
//import io.github.bonigarcia.wdm.WebDriverManager;
//
//import com.aventstack.extentreports.ExtentReports;
//import com.aventstack.extentreports.ExtentTest;
//
//import java.lang.reflect.Method;
//import java.net.URL;
//
//public class baseClass {
//
//	 public static WebDriver driver;
//	    public static Logger logger;
//	    public static Properties p;
//	    public static ExtentTest test;
//	    public Log log;
//	    public ScreenshotUtil screenShots;
//	    public ExtentReports extent;
//	    public Iween_FutureDates futureDates;
//
//    @BeforeMethod
//    @Parameters({"os", "browser"})
//    public void setup(String os, String browser,Method method) throws Exception {
//        // Initialize Logger
//        logger = LogManager.getLogger(this.getClass());
//
//        // Load properties
//        p = new Properties();
//        FileReader file = new FileReader("./src/test/resources/config.properties");
//        p.load(file);
//
//        logger.info("Operating System: " + os);
//        logger.info("Browser: " + browser);
//
//        
//        
//        if(p.getProperty("execution_env" ).equals("remote"))
//        {
//        	DesiredCapabilities capabilities =  new DesiredCapabilities();
//        	if(os.equalsIgnoreCase("windows"))
//        	{
//        	capabilities.setPlatform(Platform.WIN11);
//        	}
//        	else if(os.equalsIgnoreCase("windows"))
//        	{
//            	capabilities.setPlatform(Platform.MAC);
//
//        	}
//        	switch(browser.toLowerCase())
//        	{
//        	case "chrome" : capabilities.setBrowserName("chrome");break;
//        	case "edge" : capabilities.setBrowserName("MicrosoftEdge");break;
//        	case "firefox" : capabilities.setBrowserName("firefox");break;
//
//        	default: System.out.println("No matching browser");return;
//
//        	}
//        	driver= new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"),capabilities);
//        	//192.168.83.57
//        }
//            if(p.getProperty("execution_env" ).equals("local"))
//            {
//            	switch (browser.toLowerCase()) {
//                case "chrome":
//                    WebDriverManager.chromedriver().setup();
//                    driver = new ChromeDriver();
//                    break;
//                case "firefox":
//                    WebDriverManager.firefoxdriver().setup();
//                    driver = new FirefoxDriver();
//                    break;
//                case "edge":
//                    WebDriverManager.edgedriver().setup();
//                    driver = new EdgeDriver();
//                    break;
//                default:
//                    throw new IllegalArgumentException("Unsupported browser: " + browser);
//            }
//
//            }
//        
////        // Setup WebDriver
////        switch (browser.toLowerCase()) {
////            case "chrome":
////                WebDriverManager.chromedriver().setup();
////                driver = new ChromeDriver();
////                break;
////            case "firefox":
////                WebDriverManager.firefoxdriver().setup();
////                driver = new FirefoxDriver();
////                break;
////            case "edge":
////                WebDriverManager.edgedriver().setup();
////                driver = new EdgeDriver();
////                break;
////            default:
////                throw new IllegalArgumentException("Unsupported browser: " + browser);
////        }
//
//        driver.manage().deleteAllCookies();
//        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
//        driver.manage().window().maximize();
//        driver.get(p.getProperty("applicationUrl"));
//
//        logger.info("Browser launched and navigated to URL: " + p.getProperty("applicationUrl"));
//
//        // Setup Extent Reporting properly
//        extent = ExtentManager.getExtentReports();
//     //   test = extent.createTest(method.getName());
//        ExtentManager.setTest(test); // ✅ Now test won't be null
//
//        // Setup log and screenshot util
//        log = new Log(); // Uses ExtentManager.getTest()
//        screenShots = new ScreenshotUtil();
//
//      futureDates =new  Iween_FutureDates();
//        
//        
//    }
//    
//   
//
//
//    @AfterMethod
//    public void tearDown() {
//        if (driver != null) {
//            logger.info("Closing browser.");
//            driver.quit();
//        }
//    }
//}
//package com.iween.testBase;
//
//import java.io.FileReader;
//import java.lang.reflect.Method;
//import java.net.URL;
//import java.time.Duration;
//import java.util.Properties;
//
//import org.apache.logging.log4j.LogManager;
//import org.apache.logging.log4j.Logger;
//import org.openqa.selenium.Platform;
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.chrome.ChromeOptions;
//import org.openqa.selenium.edge.EdgeDriver;
//import org.openqa.selenium.firefox.FirefoxDriver;
//import org.openqa.selenium.remote.CapabilityType;
//import org.openqa.selenium.remote.DesiredCapabilities;
//import org.openqa.selenium.remote.RemoteWebDriver;
//import org.testng.annotations.AfterMethod;
//import org.testng.annotations.BeforeMethod;
//import org.testng.annotations.Parameters;
//
//import com.aventstack.extentreports.ExtentReports;
//import com.aventstack.extentreports.ExtentTest;
//import com.iween.utilities.ExtentManager;
//import com.iween.utilities.Iween_FutureDates;
//import com.iween.utilities.Log;
//import com.iween.utilities.ScreenshotUtil;
//
//import io.github.bonigarcia.wdm.WebDriverManager;
//
//public class baseClass {
//
//    public static WebDriver driver;
//    public static Logger logger;
//    public static Properties p;
//    public static ExtentTest test;
//    public Log log;
//    public ScreenshotUtil screenShots;
//    public ExtentReports extent;
//    public Iween_FutureDates futureDates;
//
//    @BeforeMethod
//    @Parameters({"os", "browser"})
//    public void setup(String os, String browser, Method method) throws Exception {
//        logger = LogManager.getLogger(this.getClass());
//
//        // Load properties
//        p = new Properties();
//        FileReader file = new FileReader("./src/test/resources/config.properties");
//        p.load(file);
//
//        logger.info("Operating System: " + os);
//        logger.info("Browser: " + browser);
//
//        String env = p.getProperty("execution_env").toLowerCase();
//
//        if (env.equals("remote")) {
//            DesiredCapabilities capabilities = new DesiredCapabilities();
//
//            // Set platform based on input OS param
//            switch (os.toLowerCase()) {
//                case "windows":
//                    capabilities.setPlatform(Platform.WIN10); // or WIN11 if you want
//                    break;
//                case "mac":
////                case "macos":
//                    capabilities.setPlatform(Platform.MAC);
//                    break;
//                case "linux":
//                    capabilities.setPlatform(Platform.LINUX);
//                    break;
//                default:
//                    throw new IllegalArgumentException("Unsupported OS: " + os);
//            }
//
//            // Set browser capabilities & options
//            switch (browser.toLowerCase()) {
//                case "chrome":
//                    ChromeOptions chromeOptions = new ChromeOptions();
//                    chromeOptions.addArguments("--no-sandbox");
//                    chromeOptions.addArguments("--disable-dev-shm-usage");
//                    chromeOptions.addArguments("--disable-gpu");
//                    chromeOptions.addArguments("--disable-extensions");
//                    chromeOptions.addArguments("--remote-debugging-port=9222");
//                    chromeOptions.addArguments("--headless=new");
//                    chromeOptions.setExperimentalOption("useAutomationExtension", false);
//                    chromeOptions.setExperimentalOption("excludeSwitches", new String[]{"enable-automation"});
//
//                    capabilities.merge(chromeOptions);
//                    capabilities.setBrowserName("chrome");
//                    break;
//
//                case "firefox":
//                    capabilities.setBrowserName("firefox");
//                    // You can add FirefoxOptions here similarly if needed
//                    break;
//
//                case "edge":
//                    capabilities.setBrowserName("MicrosoftEdge");
//                    // Add EdgeOptions if needed
//                    break;
//
//                default:
//                    throw new IllegalArgumentException("Unsupported browser: " + browser);
//            }
//
//            // Connect to Selenium Grid Hub or standalone server
//            driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), capabilities);
//
//        } else if (env.equals("local")) {
//            // Local execution (on current OS)
//            switch (browser.toLowerCase()) {
//                case "chrome":
//                    WebDriverManager.chromedriver().setup();
//                    ChromeOptions options = new ChromeOptions();
//                    options.addArguments("--no-sandbox");
//                    options.addArguments("--disable-dev-shm-usage");
//                    options.addArguments("--disable-gpu");
//                    options.addArguments("--disable-extensions");
//                    options.addArguments("--remote-debugging-port=9222");
//                    options.addArguments("--headless=new");
//                    options.setExperimentalOption("useAutomationExtension", false);
//                    options.setExperimentalOption("excludeSwitches", new String[]{"enable-automation"});
//                    driver = new org.openqa.selenium.chrome.ChromeDriver(options);
//                    break;
//
//                case "firefox":
//                    WebDriverManager.firefoxdriver().setup();
//                    driver = new FirefoxDriver();
//                    break;
//
//                case "edge":
//                    WebDriverManager.edgedriver().setup();
//                    driver = new EdgeDriver();
//                    break;
//
//                default:
//                    throw new IllegalArgumentException("Unsupported browser: " + browser);
//            }
//        } else {
//            throw new IllegalArgumentException("Invalid execution_env value in config.properties");
//        }
//
//        driver.manage().deleteAllCookies();
//        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
//        driver.manage().window().maximize();
//        driver.get(p.getProperty("applicationUrl"));
//
//        logger.info("Browser launched and navigated to URL: " + p.getProperty("applicationUrl"));
//
//        // Setup Extent Reporting
//        extent = ExtentManager.getExtentReports();
//        ExtentManager.setTest(test);
//
//        // Setup logging, screenshots, date utils
//        log = new Log();
//        screenShots = new ScreenshotUtil();
//        futureDates = new Iween_FutureDates();
//    }
//
//    @AfterMethod
//    public void tearDown() {
//        if (driver != null) {
//            logger.info("Closing browser.");
//            driver.quit();
//        }
//    }
//}
//package com.iween.testBase;
//
//import java.io.FileReader;
//import java.lang.reflect.Method;
//import java.net.URL;
//import java.time.Duration;
//import java.util.Properties;
//
//import org.apache.logging.log4j.LogManager;
//import org.apache.logging.log4j.Logger;
//
//import org.openqa.selenium.Platform;
//import org.openqa.selenium.WebDriver;
//
//import org.openqa.selenium.chrome.ChromeDriver;
//import org.openqa.selenium.chrome.ChromeOptions;
//
//import org.openqa.selenium.edge.EdgeDriver;
//import org.openqa.selenium.edge.EdgeOptions;
//
//import org.openqa.selenium.firefox.FirefoxDriver;
//import org.openqa.selenium.firefox.FirefoxOptions;
//
//import org.openqa.selenium.remote.DesiredCapabilities;
//import org.openqa.selenium.remote.RemoteWebDriver;
//
//import org.testng.annotations.AfterMethod;
//import org.testng.annotations.BeforeMethod;
//import org.testng.annotations.Parameters;
//
//import com.aventstack.extentreports.ExtentReports;
//import com.aventstack.extentreports.ExtentTest;
//
//import com.iween.utilities.ExtentManager;
//import com.iween.utilities.Iween_FutureDates;
//import com.iween.utilities.Log;
//import com.iween.utilities.ScreenshotUtil;
//
//import io.github.bonigarcia.wdm.WebDriverManager;
//
//public class baseClass {
//
//    public static WebDriver driver;
//    public static Logger logger;
//    public static Properties p;
//    public static ExtentTest test;
//    public Log log;
//    public ScreenshotUtil screenShots;
//    public ExtentReports extent;
//    public Iween_FutureDates futureDates;
//
//    @BeforeMethod
//    @Parameters({"os", "browser"})
//    public void setup(String os, String browser, Method method) throws Exception {
//        logger = LogManager.getLogger(this.getClass());
//
//        // Load properties
//        p = new Properties();
//        FileReader file = new FileReader("./src/test/resources/config.properties");
//        p.load(file);
//
//        logger.info("Operating System: " + os);
//        logger.info("Browser: " + browser);
//
//        String env = p.getProperty("execution_env").toLowerCase();
//
//        if (env.equals("remote")) {
//            DesiredCapabilities capabilities = new DesiredCapabilities();
//
//            // Set platform based on input OS param
//            switch (os.toLowerCase()) {
//                case "windows":
//                    capabilities.setPlatform(Platform.WIN10); // or WIN11
//                    break;
//                case "mac":
//                    capabilities.setPlatform(Platform.MAC);
//                    break;
//                case "linux":
//                    capabilities.setPlatform(Platform.LINUX);
//                    break;
//                default:
//                    throw new IllegalArgumentException("Unsupported OS: " + os);
//            }
//
//            // Set browser capabilities & options
//            switch (browser.toLowerCase()) {
//                case "chrome":
//                    ChromeOptions chromeOptions = new ChromeOptions();
//                    chromeOptions.addArguments("--no-sandbox");
//                    chromeOptions.addArguments("--disable-dev-shm-usage");
//                    chromeOptions.addArguments("--disable-gpu");
//                    chromeOptions.addArguments("--disable-extensions");
//                    chromeOptions.addArguments("--remote-debugging-port=9222");
//                    chromeOptions.addArguments("--headless=new");
//                    chromeOptions.setExperimentalOption("useAutomationExtension", false);
//                    chromeOptions.setExperimentalOption("excludeSwitches", new String[]{"enable-automation"});
//
//                    capabilities.merge(chromeOptions);
//                    capabilities.setBrowserName("chrome");
//                    break;
//
//                case "firefox":
//                    // For Firefox, you can add FirefoxOptions if needed, but here just set browserName
//                    capabilities.setBrowserName("firefox");
//                    break;
//
//                case "edge":
//                    capabilities.setBrowserName("MicrosoftEdge");
//                    break;
//
//                default:
//                    throw new IllegalArgumentException("Unsupported browser: " + browser);
//            }
//
//            // Connect to Selenium Grid Hub or standalone server
//            driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), capabilities);
//
//        } else if (env.equals("local")) {
//            // Local execution
//            switch (browser.toLowerCase()) {
//                case "chrome":
//                    WebDriverManager.chromedriver().setup();
//                    ChromeOptions chromeOptions = new ChromeOptions();
//                    chromeOptions.addArguments("--no-sandbox");
//                    chromeOptions.addArguments("--disable-dev-shm-usage");
//                    chromeOptions.addArguments("--disable-gpu");
//                    chromeOptions.addArguments("--disable-extensions");
//                    chromeOptions.addArguments("--remote-debugging-port=9222");
//                    chromeOptions.addArguments("--headless=new");  // Headless mode for Chrome
//                    chromeOptions.setExperimentalOption("useAutomationExtension", false);
//                    chromeOptions.setExperimentalOption("excludeSwitches", new String[]{"enable-automation"});
//                    driver = new ChromeDriver(chromeOptions);
//                    break;
//
//                case "firefox":
//                    WebDriverManager.firefoxdriver().setup();
//                    FirefoxOptions firefoxOptions = new FirefoxOptions();
//                    firefoxOptions.addArguments("-headless"); // Headless mode for Firefox
//                    driver = new FirefoxDriver(firefoxOptions);
//                    break;
//
//                case "edge":
//                    WebDriverManager.edgedriver().setup();
//                    EdgeOptions edgeOptions = new EdgeOptions();
//                    edgeOptions.addArguments("headless"); // Headless mode for Edge
//                    edgeOptions.addArguments("disable-gpu");
//                    driver = new EdgeDriver(edgeOptions);
//                    break;
//
//                default:
//                    throw new IllegalArgumentException("Unsupported browser: " + browser);
//            }
//        } else {
//            throw new IllegalArgumentException("Invalid execution_env value in config.properties");
//        }
//
//        driver.manage().deleteAllCookies();
//        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
//        driver.manage().window().maximize();
//        driver.get(p.getProperty("applicationUrl"));
//
//        logger.info("Browser launched and navigated to URL: " + p.getProperty("applicationUrl"));
//
//        // Setup Extent Reporting
//        extent = ExtentManager.getExtentReports();
//        ExtentManager.setTest(test);
//
//        // Setup logging, screenshots, date utils
//        log = new Log();
//        screenShots = new ScreenshotUtil();
//        futureDates = new Iween_FutureDates();
//    }
//
//    @AfterMethod
//    public void tearDown() {
//        if (driver != null) {
//            logger.info("Closing browser.");
//            driver.quit();
//        }
//    }
//}
package com.iween.testBase;

import java.io.FileReader;
import java.lang.reflect.Method;
import java.net.URL;
import java.time.Duration;
import java.util.Properties;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;

import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

import org.openqa.selenium.remote.RemoteWebDriver;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;

import com.iween.utilities.ExtentManager;
import com.iween.utilities.Iween_FutureDates;
import com.iween.utilities.Log;
import com.iween.utilities.ScreenshotUtil;

import io.github.bonigarcia.wdm.WebDriverManager;

public class baseClass {

    public static WebDriver driver;
    public static Logger logger;
    public static Properties p;
    public static ExtentTest test;
    public Log log;
    public ScreenshotUtil screenShots;
    public ExtentReports extent;
    public Iween_FutureDates futureDates;

    @BeforeMethod
    @Parameters({"os", "browser"})
    public void setup(String os, String browser, Method method) throws Exception {
        logger = LogManager.getLogger(this.getClass());

        // Load properties
        p = new Properties();
        FileReader file = new FileReader("./src/test/resources/config.properties");
        p.load(file);

        logger.info("Operating System: " + os);
        logger.info("Browser: " + browser);

        String env = p.getProperty("execution_env").toLowerCase();

        if (env.equals("remote")) {
            // REMOTE execution via Selenium Grid

            switch (browser.toLowerCase()) {
                case "chrome":
                    ChromeOptions chromeOptions = new ChromeOptions();
                    chromeOptions.addArguments("--no-sandbox");
                    chromeOptions.addArguments("--disable-dev-shm-usage");
                    chromeOptions.addArguments("--disable-gpu");
                    chromeOptions.addArguments("--disable-extensions");
                    chromeOptions.addArguments("--remote-debugging-port=9222");
                    chromeOptions.addArguments("--headless");  // Use traditional headless here
                    chromeOptions.setExperimentalOption("useAutomationExtension", false);
                    chromeOptions.setExperimentalOption("excludeSwitches", new String[]{"enable-automation"});

                    // Set platform based on OS param
                    switch (os.toLowerCase()) {
                        case "windows":
                            chromeOptions.setPlatformName("windows");
                            break;
                        case "mac":
                            chromeOptions.setPlatformName("mac");
                            break;
                        case "linux":
                            chromeOptions.setPlatformName("linux");
                            break;
                        default:
                            throw new IllegalArgumentException("Unsupported OS: " + os);
                    }

                    driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), chromeOptions);
                    break;

                case "firefox":
                    FirefoxOptions firefoxOptions = new FirefoxOptions();
                    firefoxOptions.addArguments("-headless");

                    // Set platform
                    switch (os.toLowerCase()) {
                        case "windows":
                            firefoxOptions.setPlatformName("windows");
                            break;
                        case "mac":
                            firefoxOptions.setPlatformName("mac");
                            break;
                        case "linux":
                            firefoxOptions.setPlatformName("linux");
                            break;
                        default:
                            throw new IllegalArgumentException("Unsupported OS: " + os);
                    }

                    driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), firefoxOptions);
                    break;

                case "edge":
                    EdgeOptions edgeOptions = new EdgeOptions();
                    edgeOptions.addArguments("headless");
                    edgeOptions.addArguments("disable-gpu");

                    // Set platform
                    switch (os.toLowerCase()) {
                        case "windows":
                            edgeOptions.setPlatformName("windows");
                            break;
                        case "mac":
                            edgeOptions.setPlatformName("mac");
                            break;
                        case "linux":
                            edgeOptions.setPlatformName("linux");
                            break;
                        default:
                            throw new IllegalArgumentException("Unsupported OS: " + os);
                    }

                    driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), edgeOptions);
                    break;

                default:
                    throw new IllegalArgumentException("Unsupported browser: " + browser);
            }

        } else if (env.equals("local")) {
            // Local execution

            switch (browser.toLowerCase()) {
                case "chrome":
                    WebDriverManager.chromedriver().setup();
                    ChromeOptions chromeOptions = new ChromeOptions();
                    chromeOptions.addArguments("--no-sandbox");
                    chromeOptions.addArguments("--disable-dev-shm-usage");
                    chromeOptions.addArguments("--disable-gpu");
                    chromeOptions.addArguments("--disable-extensions");
                    chromeOptions.addArguments("--remote-debugging-port=9222");
                    chromeOptions.addArguments("--headless");  // Headless mode for Chrome
                    chromeOptions.setExperimentalOption("useAutomationExtension", false);
                    chromeOptions.setExperimentalOption("excludeSwitches", new String[]{"enable-automation"});
                    driver = new ChromeDriver(chromeOptions);
                    break;

                case "firefox":
                    WebDriverManager.firefoxdriver().setup();
                    FirefoxOptions firefoxOptions = new FirefoxOptions();
                    firefoxOptions.addArguments("-headless"); // Headless mode for Firefox
                    driver = new FirefoxDriver(firefoxOptions);
                    break;

                case "edge":
                    WebDriverManager.edgedriver().setup();
                    EdgeOptions edgeOptions = new EdgeOptions();
                    edgeOptions.addArguments("headless"); // Headless mode for Edge
                    edgeOptions.addArguments("disable-gpu");
                    driver = new EdgeDriver(edgeOptions);
                    break;

                default:
                    throw new IllegalArgumentException("Unsupported browser: " + browser);
            }
        } else {
            throw new IllegalArgumentException("Invalid execution_env value in config.properties");
        }

        driver.manage().deleteAllCookies();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        driver.manage().window().maximize();
        driver.get(p.getProperty("applicationUrl"));

        logger.info("Browser launched and navigated to URL: " + p.getProperty("applicationUrl"));

        // Setup Extent Reporting
        extent = ExtentManager.getExtentReports();
        ExtentManager.setTest(test);

        // Setup logging, screenshots, date utils
        log = new Log();
        screenShots = new ScreenshotUtil();
        futureDates = new Iween_FutureDates();
    }

    @AfterMethod
    public void tearDown() {
        if (driver != null) {
            logger.info("Closing browser.");
            driver.quit();
        }
    }
}

