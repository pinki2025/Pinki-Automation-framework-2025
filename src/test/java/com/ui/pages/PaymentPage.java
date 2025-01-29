package com.ui.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.utility.BrowserUtility;

public class PaymentPage extends BrowserUtility {

	private static final By PAYMENT_BYWIRE_BUTTON_LOCATOR = By.xpath("//a[@title='Pay by bank wire']");
	private static final By CONFIRM_PAYMENT_BUTTON_LOCATOR = By.xpath("//button[contains(@class,'button btn btn-default button-medium')]//span[text()='I confirm my order']");
	private static final By ALERT_SUCCESSMSG_TEXT_LOCATOR = By.xpath("//p[contains(@class,'success')]");
	
	
	public PaymentPage(WebDriver driver) {
		super(driver);
		
	}
	
	public String makePaymentByWire() {
		
		clickOn(PAYMENT_BYWIRE_BUTTON_LOCATOR);
		clickOn(CONFIRM_PAYMENT_BUTTON_LOCATOR);
		return getVisibleText(ALERT_SUCCESSMSG_TEXT_LOCATOR);
	}
	


}
