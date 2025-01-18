package com.ui.tests;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import com.utility.BrowserUtility;
public class LoginTests2 {

	public static void main(String[] args) {
		
		WebDriver wd = new ChromeDriver();//Launch browser window or browser session
		
		/*BrowserUtility browserUtility = new BrowserUtility(wd);
		browserUtility.goToWebsite("http://www.automationpractice.pl/");
		
		browserUtility.maximizeBrowserwindow();
		
		By signInlinkLocator = By.xpath("//a[@class='login']");
		browserUtility.clickOn(signInlinkLocator);
		
		By emailTextboxLocator = By.xpath("//input[@id='email']");
		browserUtility.enterText(emailTextboxLocator, "yemiso2158@pokeline.com");
	
		By passwordTextboxLocator = By.xpath("//input[@id='passwd']");
		browserUtility.enterText(passwordTextboxLocator, "password");
		
		By submitLoginLocator = By.xpath("//button[@id='SubmitLogin']");
		browserUtility.clickOn(submitLoginLocator);*/
		
	}

}
