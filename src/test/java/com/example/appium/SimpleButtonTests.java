package com.example.appium;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.URL;

import static org.junit.Assert.assertEquals;

public class SimpleButtonTests {
    public AppiumDriver<WebElement> driver;

    @Before
    public void setUp() throws Exception {
        //-------------------------------------------------------
        // NOTE: don't define capabilities locally since we want to upload to AWS Device Farm
        //   File classpathRoot = new File(System.getProperty("user.dir"));
        //   File appDir = new File(classpathRoot, "apks");
        //   File appPath = new File(appDir.getCanonicalPath(), "simpleButton-debug.apk");
        //   capabilities.setCapability("platformName", "Android");
        //   capabilities.setCapability("platformVersion", "7.1.1");
        //   capabilities.setCapability("deviceName","appium_test_avd_1");
        //   capabilities.setCapability("app", appPath);
        //-------------------------------------------------------
        // To test locally:
        // 1. Start the server:
        //   appium --pre-launch --platform-name Android --device-name avdName --app apkPath
        // For example,
        //   appium --pre-launch --platform-name Android --device-name appium_test_avd_1 --app ../apks/simpleButton-debug.apk
        // 2. Right click the test file, and "Run"
        //-------------------------------------------------------
        // To package a zip file for AWS device farm:
        // 1. Terminal
        // 2. mvn clean package
        //-------------------------------------------------------

        driver = new AndroidDriver(new URL("http://0.0.0.0:4723/wd/hub"), new DesiredCapabilities());
    }

    @After
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }

    @Test
    public void testButtonClicks() {
        WebElement textView = driver.findElement(By.id("com.example.cs.buttontest:id/textView"));
        assertEquals("Hello World!", textView.getText());

        WebElement button = driver.findElement(By.id("com.example.cs.buttontest:id/button"));
        button.click();
        assertEquals("Button clicked 1 time", textView.getText());

        button.click();
        assertEquals("Button clicked 2 times", textView.getText());
    }
}
