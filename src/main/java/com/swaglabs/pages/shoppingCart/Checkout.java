package com.swaglabs.pages.shoppingCart;

import com.swaglabs.pages.BasePage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static com.swaglabs.util.BaseDriver.getDriver;
import static com.swaglabs.util.CustomElement.getText;
import static com.swaglabs.util.WaitHelpers.waitForJSToLoad;

public class Checkout extends BasePage {
    @FindBy(className = "title")
    private WebElement title;
    @FindBy(id = "first-name")
    private WebElement firstName;
    @FindBy(id = "last-name")
    private WebElement lastName;
    @FindBy(id = "postal-code")
    private WebElement postalCode;
    @FindBy(name = "cancel")
    private WebElement cancelBtn;
    @FindBy(id = "continue")
    private WebElement continuebtn;

    public Checkout() {
        super();
        PageFactory.initElements(driver, this);
        load();
    }

    public String getTitle() {
        return getText(title);
    }

    public void setFirstName(String name) {
        firstName.sendKeys(name);
    }

    public void setLastName(String name) {
        lastName.sendKeys(name);
    }

    public void setPostalCode(String code) {
        postalCode.sendKeys(code);
    }

    public void sendKeys(String firstName, String lastName, String postalCode){
        setFirstName(firstName);
        setLastName(lastName);
        setPostalCode(postalCode);
    }

    public void cancelBtn() {
        cancelBtn.click();
    }

    public ChackoutOverview continuebtn() {
        return new ChackoutOverview(getDriver());
    }

    @Override
    public  void load() {
        getDriver().get("https://www.saucedemo.com/checkout-step-one.html");
    }

    @Override
    protected void isLoaded() throws Error {
        waitForJSToLoad();
    }
}
