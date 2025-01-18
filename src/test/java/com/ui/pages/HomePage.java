package com.ui.pages;

import java.util.Properties;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static com.constants.Env.*;
import com.constants.Browser;
import com.utility.BrowserUtility;
import com.utility.JSONUtility;
import com.utility.LoggerUtility;

import static com.utility.PropertiesUtil.*;

public final class HomePage extends BrowserUtility {
	
	Logger logger =	LoggerUtility.getLogger(this.getClass());
	
	private static final By Sign_In_Link_Locator = By.xpath("//a[@class='login']");

	public HomePage(Browser browserName,boolean isheadless) {
		super(browserName,isheadless);// to call parent class constructor from the child class constructor
		
		//goToWebsite(readProperty(QA,"URL"));
		//goToWebsite(JSONUtility.readJson(QA));
		
		goToWebsite((JSONUtility.readJson(QA).getUrl()));
	}
	
	public HomePage(WebDriver driver) {
		super(driver);
		goToWebsite(JSONUtility.readJson(QA).getUrl());
	}

	public LoginPage goToLoginPage() {
		
		logger.info("Trying to perform click to go to sign page");
		clickOn(Sign_In_Link_Locator);
		LoginPage loginpage = new LoginPage(getDriver());
		return loginpage;

	}
	public void quit() {
		getDriver().quit();
	}
	

	

}
