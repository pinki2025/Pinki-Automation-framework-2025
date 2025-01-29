package com.ui.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.ui.pages.AddressPage;
import com.ui.pages.MyAccountPage;
import com.ui.pojo.AddressPojo;
import com.utility.FakeAddressUtility;

public class AddNewFirstAddressTest extends TestBase{
	
	private MyAccountPage accountPage ;
	private AddressPage addressPage;
	private AddressPojo address;
	
	@BeforeMethod(description ="Valid first time user logs in to the application")
	public void setup() {
		accountPage = homePage.goToLoginPage().doLoginwith("vedem30583@fundapk.com", "password");
		address = FakeAddressUtility.getFakeAddress();
	}
	
	@Test
	public void addnewaddress() {
		
	String newAddress =	accountPage.goToAddresspage().saveAdress(address);
	Assert.assertEquals(newAddress, address.getAddressAlias().toUpperCase());
	}
	
	
	

}
