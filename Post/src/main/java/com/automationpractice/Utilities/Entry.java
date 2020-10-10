package com.automationpractice.Utilities;

import com.automationpractice.DriverFactory;
import org.openqa.selenium.WebDriver;
import java.io.FileInputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

@SuppressWarnings("unchecked")
public class Entry {

        private WebDriver webDriver;
        private UserAction action;

    public UserAction init() throws Exception {
        String browserName = System.getProperty("browserName");
        if (browserName == null) browserName = "Chrome";

        DriverFactory driverFactory = new DriverFactory();
        webDriver = driverFactory.initBrowser(browserName);
        webDriver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
        webDriver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        webDriver.manage().window().maximize();

        action= new UserAction(webDriver);
        return action;

    }

    public void closeTab() {
        webDriver.quit();
    }

    public HashMap<String,String> readProperty () {
        Properties properties = new Properties();

        try {
            properties.load(new FileInputStream("src/main/resources/websites.properties"));
        } catch (Exception e) {

        }

        return new HashMap<String, String>((Map) properties);

    }

}
