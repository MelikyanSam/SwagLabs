package com.swaglabs.pages;

import com.swaglabs.pages.shoppingCart.ShoppngCart;
import com.swaglabs.util.WaitHelpers;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.LoadableComponent;

import static com.swaglabs.util.BaseDriver.getDriver;
import static com.swaglabs.util.CustomElement.click;

//import static com.swaglabs.util.WaitHelpers.waitForJStoLoad;

public abstract class BasePage  extends LoadableComponent<BasePage> {

    protected WebDriver driver;


    @FindBy(className = "shoping-cart-link")
    private WebElement shopingCartLink;
    @FindBy(partialLinkText = "Twitter")
    private WebElement socialTwitter;
    @FindBy(partialLinkText = "Facebook")
    private WebElement socialFacebook;
    @FindBy(partialLinkText = "linkedin")
    private WebElement socialLinkedin;

    @FindBy(id = "react-burger-menu-btn")
    private WebElement menuBtn;

    @FindBy(id = "inventory_sidebar_link")
    private WebElement allItems_menu;

    @FindBy(id = "about_sidebar_link")
    private WebElement about_menu;

    @FindBy(id = "logout_sidebar_link")
    private WebElement logOut_menu;

    @FindBy(id = "reset_sidebar_link")
    private WebElement resetAppState_menu;

    public BasePage(){
//        WaitHelpers.waitForJSToLoad();
        this.driver = getDriver();
        PageFactory.initElements(driver, this);


    }


    public ShoppngCart clickShoppingCartLink(){
        return new ShoppngCart(getDriver());
    }
    public void clicksocialTwitter(){
        click(socialTwitter);
    }

    public void clickSocialFacebook() {
        click(socialFacebook);
    }

    public void clickSocialLinkedin() {
        click(socialLinkedin);
    }

    // MENU ---------------------------

    public void menuBtn(){
        click(menuBtn);
    }
    public Home allItems_menu(){
        click(allItems_menu);
        return new Home();
    }
    public About about_menu(){
        click(about_menu);
        return new About();
    }
    public LogIn logOut_menu(){
        click(logOut_menu);
        return new LogIn(driver);
    }
    public void resetAppState_menu(){
        click(resetAppState_menu);
    }

    public Boolean isallItemsVisible(){
        if (allItems_menu.isDisplayed())
            return true;
        return false;
    }

    // ------------------------------------

    @Override
    public void load(){
        driver.get("https://www.saucedemo.com/");
    }

    @Override
    protected void isLoaded() throws Error {
//        driver.getCurrentUrl().contains("https://www.saucedemo.com/");
        WaitHelpers.waitForJSToLoad();
    }
}
