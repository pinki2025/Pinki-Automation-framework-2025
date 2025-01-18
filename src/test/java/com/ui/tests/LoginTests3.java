package com.ui.tests;
import static com.constants.Browser.*;

import static org.testng.Assert.*;

import org.apache.logging.log4j.Logger;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.ui.pojo.User;
import com.utility.LoggerUtility;


@Listeners(com.ui.listners.TestListeners.class)
public class LoginTests3 extends TestBase {
	
	Logger logger =	LoggerUtility.getLogger(this.getClass());
	

	@Test(description = "Verifies with the valid user credential user able to login to the application",groups = {"e2e","sanity"},
		dataProviderClass = com.ui.dataproviders.LoginDataProvider.class,dataProvider = "LoginTestDataProvider")
	public void loginTest(User user){
		
		assertEquals(homePage.goToLoginPage().doLoginwith(user.getEmailAddress(),user.getPassword()).getUserName(),"Pinki Talukdar");
	}
	
/*	@Test(description = "Verifies with the valid user credential user able to login to the application",groups = {"e2e","sanity"},

			dataProviderClass = com.ui.dataproviders.LoginDataProvider.class,dataProvider = "LoginTestinCSVDataProvider")
		public void loginCSVTest(User user){
			
			assertEquals(homePage.goToLoginPage().doLoginwith(user.getEmailAddress(),user.getPassword()).getUserName(),"Pinki Talukdar");
		}
	

	@Test(description = "Verifies with the valid user credential user able to login to the application",groups = {"e2e","sanity"},
			dataProviderClass = com.ui.dataproviders.LoginDataProvider.class,dataProvider = "LoginTestExcelDataProvider",
	      retryAnalyzer = com.ui.listners.MyRetryAnalyzer.class)
		public void loginExcelTest(User user){
		
		
		assertEquals(homePage.goToLoginPage().doLoginwith(user.getEmailAddress(),user.getPassword()).getUserName(),"Pinki Talukdar1");
		
		
		}*/

}
