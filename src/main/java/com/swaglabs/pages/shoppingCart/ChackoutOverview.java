package com.swaglabs.pages.shoppingCart;

import com.swaglabs.pages.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static com.swaglabs.util.BaseDriver.getDriver;
import static com.swaglabs.util.CustomElement.click;
import static com.swaglabs.util.WaitHelpers.waitForJSToLoad;

public class ChackoutOverview extends BasePage {

    @FindBy(className = "title")
    private WebElement title;
    @FindBy(name = "cancel")
    private WebElement cancelBtn;
    @FindBy(id = "finish")
    private WebElement finishBtn;


    public ChackoutOverview(WebDriver driver) {
        super();
        PageFactory.initElements(driver, this);
        load();
    }

    public void cancelBtn(){
        click(cancelBtn);
    }

    public CheckoutComplete finishBtn(){
        click(finishBtn);
        return new CheckoutComplete();
    }

    @Override
    public  void load() {
        getDriver().get("https://www.saucedemo.com/checkout-step-two.html");
    }

    @Override
    protected void isLoaded() throws Error {
        waitForJSToLoad();
    }


}
