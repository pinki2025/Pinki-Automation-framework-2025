package com.ui.tests;


import static com.constants.Browser.*;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import com.constants.Browser;
import com.ui.pages.HomePage;
import com.utility.BrowserUtility;
import com.utility.LambdaTestUtility;
import com.utility.LoggerUtility;

public class TestBase {
	
	protected HomePage homePage ;
	Logger logger =	LoggerUtility.getLogger(this.getClass());
	private boolean islambdaTest ;
	
	
	@Parameters({"browser", "islambdaTest", "isHeadless"})
	@BeforeMethod(description = "Load the HomePage of the WebSite")
	
	public void setup(
		@Optional("chrome")String browser,
		@Optional("false")boolean islambdaTest,
		@Optional("false") boolean isHeadless,ITestResult result) {
		
		this.islambdaTest = islambdaTest;
		WebDriver lambdaDriver ;
		
		if(islambdaTest) {
			lambdaDriver = LambdaTestUtility.initializeLambdaTestSession(browser,result.getMethod().getMethodName());
			homePage = new HomePage(lambdaDriver);
		}
		else {
		logger.info("Load the homepage of the website");
		homePage = new HomePage(Browser.valueOf(browser.toUpperCase()),isHeadless);
		}
	}
	
	public BrowserUtility getInstance() {
		return homePage;
	}
	
	@AfterMethod(description = "Tear down the browser")
	public void tearDown() {
		
		if(islambdaTest) {
			
			LambdaTestUtility.quitSession();//quit or close the browser session on lambda test
		}
			else {
			homePage.quit();//local
			}
		}
		
	}
	
	
	


