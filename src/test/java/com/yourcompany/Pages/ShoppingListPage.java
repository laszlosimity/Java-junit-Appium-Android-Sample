package com.yourcompany.Pages;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ShoppingListPage {

    @FindBy(id = "autocomplete_add_item")
    private WebElement theAddItemBox;

    @FindBy(id = "button_add_item")
    private WebElement theAddButton;

    @FindBy(id = "name")
    private WebElement theAddedItem;

    @FindBy(id = "check")
    private WebElement theCheckBox;

    @FindBy(xpath = "//android.widget.TextView[@content-desc=\"Clean up list\"]")
    private WebElement theDeleteButton;


    public AppiumDriver driver;

    public ShoppingListPage(AppiumDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void addItem(String text) {
        this.theAddItemBox.sendKeys(text);
        //driver.hideKeyboard();
        this.theAddButton.click();
    }

    public String getAddedItemText() {
        return this.theAddedItem.getText();
    }

    public void removeItem() {
        this.theCheckBox.click();
        this.theDeleteButton.click();
    }

    public boolean isOnPage() {
        try {
            getAddedItemText();
            return true;
        } catch (NoSuchElementException ex) {
            return false;
        }
    }


}
