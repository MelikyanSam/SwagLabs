package com.swaglabs.util;

import org.openqa.selenium.WebElement;

import static com.swaglabs.util.WaitHelpers.toBeClickable;
import static com.swaglabs.util.WaitHelpers.visibilityOf;

public class CustomElement {


    public static void click(WebElement element){
        toBeClickable( element);
        element.click();
    }
    public static void sendKyes(WebElement element, String key){
//        try{
            visibilityOf( element);
//        }catch(NoSuchElementException e){
//            e.printStackTrace();
//        }
        element.clear();
        element.sendKeys(key);
    }

    public static String getText(WebElement element){
//        try{
            visibilityOf( element);
//        }catch(NoSuchElementException e){
//            e.printStackTrace();
//        }
        return element.getText();
    }

//    public static void select(WebElement element){
//        // until element is selected
//        toBeSelected(driver, element);
//
//    }



}
