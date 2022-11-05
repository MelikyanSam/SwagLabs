package com.swaglabs.pages.shoppingCart;

import com.swaglabs.pages.BasePage;
import com.swaglabs.pages.Home;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static com.swaglabs.util.CustomElement.click;
import static com.swaglabs.util.CustomElement.getText;
import static com.swaglabs.util.WaitHelpers.waitForJSToLoad;

public class CheckoutComplete extends BasePage {

    @FindBy(className = "title")
    private WebElement title;

    @FindBy(id = "back-to-products")
    WebElement backToproducts;

    CheckoutComplete(){
        super();
        PageFactory.initElements(driver, this);
    }

    public Home backToProductsBtn(){
        click(backToproducts);
        return new Home();
    }

    public String getTitle() {
        return getText(title);
    }

    @Override
    public  void load() {
        driver.get("https://www.saucedemo.com/checkout-complete.html");
    }

    @Override
    protected void isLoaded() throws Error {
        waitForJSToLoad();
    }


}
