package com.bw.webdriver;

import org.openqa.selenium.chrome.ChromeDriver;

public abstract class DriverManager {
    protected ChromeDriver driver;
    protected abstract void startService();
    protected abstract void createDriver();

    public void quitDriver() {
        if (null != driver) {
            driver.quit();
            driver = null;
        }
    }

    public ChromeDriver getDriver() {
        if (null == driver) {
            startService();
            createDriver();
        }
        return driver;
    }
}
