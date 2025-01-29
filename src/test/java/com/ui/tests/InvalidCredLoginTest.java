package com.ui.tests;
import static com.constants.Browser.*;

import static org.testng.Assert.*;

import org.apache.logging.log4j.Logger;
import org.testng.annotations.Listeners;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.ui.pojo.User;
import com.utility.LoggerUtility;


@Listeners(com.ui.listners.TestListeners.class)
public class InvalidCredLoginTest extends TestBase {
	
	Logger logger =	LoggerUtility.getLogger(this.getClass());
	
	private static final String INVALID_EMAIL_ADDRESS = "pinkitalukdar411@gmail.com";
	private static final String INVALID_PASSWORD = "test12345";
	

	
	@Test(description = "Verify if the proper error message shown for the user when they enter invalid credentials",groups = {"e2e","sanity","smoke"})
	
	public void loginTest(){
		assertEquals(homePage.goToLoginPage().doLoginwithInvalidCredentials(INVALID_EMAIL_ADDRESS,INVALID_PASSWORD)
				.getErrorMessage(),"Authentication failed.");
	}
	

}
