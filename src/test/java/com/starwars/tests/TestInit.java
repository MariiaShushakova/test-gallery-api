package com.starwars.tests;

import com.epam.jdi.uitests.core.logger.JDILogger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxBinary;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Method;
import java.util.concurrent.TimeUnit;

public class TestInit{
    public static WebDriver driver;
    public static final String HOST = "https://starwarsarts.com"; //can be local http://127.0.0.1:8000

    public void driverInit() throws IOException {
        System.setProperty("webdriver.gecko.driver", "src/test/resources/geckodriver.exe");
        File pathToBinary = new File("C:\\Users\\mariia.shushakova\\AppData\\Local\\Mozilla Firefox\\firefox.exe");
        FirefoxBinary firefoxBinary = new FirefoxBinary(pathToBinary);
        DesiredCapabilities desired = DesiredCapabilities.firefox();
        FirefoxOptions options = new FirefoxOptions();
        desired.setCapability(FirefoxOptions.FIREFOX_OPTIONS, options.setBinary(firefoxBinary));

        driver = new FirefoxDriver(options);

        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.get(HOST);
    }

    @BeforeMethod(alwaysRun = true)
    public void setUp(Method method) throws IOException {
        driverInit();
    }

    @AfterMethod(alwaysRun = true)
    public void tearDownSuite() {
        driver.close();
    }
}
