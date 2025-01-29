package com.ui.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.utility.BrowserUtility;

public class ConfirmAddresspage extends BrowserUtility {
	
	private static final By PROCEED_TO_CHECKOUT_BUTTON_LOCATOR = By.name("processAddress");

	public ConfirmAddresspage(WebDriver driver) {
		super(driver);
		
	}
	
	public ShipmentPage goToShipmentPage() {
		
		clickOn(PROCEED_TO_CHECKOUT_BUTTON_LOCATOR);
		return new ShipmentPage(getDriver());
	}
	

}
