package com.automationpractice;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;

public class DriverFactory {

    public WebDriver initBrowser (String browserType) throws Exception {

        switch (browserType.toLowerCase()) {

            case "firefox":
                return openFirefoxInstance();

            case "chrome":
                return openChromeInstance();

            default:
                throw new Exception("Browser Type "+ browserType+" doesn't exist");
        }


    }

    private WebDriver openFirefoxInstance() {
        System.setProperty("webdriver.gecko.driver","src/main/resources/FirefoxDriver/v0.24/geckodriver.exe");
        return new FirefoxDriver();

    }
    private WebDriver openChromeInstance() {
        System.setProperty("webdriver.chrome.driver","src/main/resources/ChromeDriver/v72/chromedriver.exe");
        ChromeOptions chromeOptions = new ChromeOptions();
        return new ChromeDriver(chromeOptions);

    }

}
