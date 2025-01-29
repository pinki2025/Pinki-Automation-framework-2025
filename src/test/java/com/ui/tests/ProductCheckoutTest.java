package com.ui.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static com.constants.Size.*;
import com.ui.pages.SearchResultPage;

public class ProductCheckoutTest extends TestBase {

	private static final String SEARCH_TERM = "printed summer dress";

	private SearchResultPage searchresultPage;

	@BeforeMethod(description = "user logs into the application and searches for the product")
	public void setup() {

		searchresultPage = homePage.goToLoginPage().doLoginwith("vedem30583@fundapk.com", "password")
				.searchForAProduct(SEARCH_TERM);
	}

	@Test(description = "verify if a logged in user is able to buy a dress", groups = { "e2e", "smoke", "sanity" })
	public void checkoutTest() {

	String result =	searchresultPage.clickontheProductAtIndex(1).changeSize(L).AddproductTocart().ProccedToCheckout()
		.goToConfirmAddressPage().goToShipmentPage().gotToPaymentPage().makePaymentByWire();
	
	Assert.assertTrue(result.contains("complete"));

	}
	

}
