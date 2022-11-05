package com.swaglabs.util;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class BaseDriver {
    private static WebDriver driver = null;

    private static ChromeOptions options;





    public static void setDriver(WebDriver driver){
        BaseDriver.driver = driver;
    }

    public static WebDriver getDriver(){
        if (driver == null) {
            driver = new ChromeDriver(setOptions());

        }
        return driver;
    }

    private static ChromeOptions setOptions(){

        options = new ChromeOptions();
        options.addArguments("start-maximized");

        return options;
    }

}
