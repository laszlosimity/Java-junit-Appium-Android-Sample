package com.yourcompany.Tests;

import com.yourcompany.Pages.ShoppingListPage;
import org.junit.Test;
import org.openqa.selenium.InvalidElementStateException;

import java.util.UUID;

import static org.hamcrest.CoreMatchers.containsString;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertThat;

public class AddItemTest extends TestBase {

    public AddItemTest (String os, String version, String browser, String deviceName, String deviceOrientation) {
        super(os, version, browser, deviceName, deviceOrientation);

    }

    /**
     * Runs a simple test verifying if the comment input is functional.
     * @throws InvalidElementStateException
     */
    @Test
    public void addItemRemoveItemTest() throws InvalidElementStateException {
        ShoppingListPage page = new ShoppingListPage(driver);

        String commentInputText = UUID.randomUUID().toString();

        page.addItem(commentInputText);

        String theResult = page.getAddedItemText();

        page.removeItem();

        assertThat(theResult, containsString(commentInputText));

       // assertFalse(page.isOnPage());
    }

    /**
     * Runs a simple test verifying link can be followed.
     * @throws InvalidElementStateException
     */
   /*@Test
    public void removeItemTest() throws InvalidElementStateException {
        //ShoppingListPage page = new ShoppingListPage(driver);

        page.removeItem();

        assertFalse(page.isOnPage());
    }*/
}