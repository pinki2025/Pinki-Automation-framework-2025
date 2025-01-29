package com.ui.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.utility.BrowserUtility;

public class ShoppingCartPage extends BrowserUtility {

	private static final By PROCEED_CHECKOUT_BUTTON_LOCATOR = By.xpath("//p[contains(@class,'cart_navigation clearfix')]//a[@title='Proceed to checkout']");
	
	
	
	public ShoppingCartPage(WebDriver driver) {
		super(driver);
	
	}
	
	public ConfirmAddresspage goToConfirmAddressPage() {
		clickOn(PROCEED_CHECKOUT_BUTTON_LOCATOR);
		return new ConfirmAddresspage(getDriver());
	}
	

}
