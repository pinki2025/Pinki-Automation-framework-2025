package com.ui.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.ui.pages.MyAccountPage;

@Listeners(com.ui.listners.TestListeners.class)

public class searchProductTest extends TestBase{
	
	private MyAccountPage accountPage ;
	private static final String SEARCH_TERM = "printed summer dress" ;
	
	
	@BeforeMethod(description ="Valid user login to the application")
	public void setup() {
		accountPage = homePage.goToLoginPage().doLoginwith("vedem30583@fundapk.com", "password");
	}
	
	@Test(description = "Verify if logged in user is able to search a products and correct product search results",groups = {"e2e","sanity","smoke"}
	
			)
	public void verifyProductSearchTest() {
		
		boolean actualResult = accountPage.searchForAProduct(SEARCH_TERM).
				isSearchTermpresentinProductList(SEARCH_TERM);
		
		Assert.assertEquals(actualResult,true);
		
	}
		
		
		
	
	
	

}
