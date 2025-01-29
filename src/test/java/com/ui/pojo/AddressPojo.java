package com.ui.pojo;

public class AddressPojo {
	
	private String Company;
	private String addressline1;
	private String addressline2;
	private String city;
	private String postCode;
	private String homePhoneNumber;
	private String mobileNumber;
	private String otherInformation;
	private String addressAlias;
	private String state;
	
	
	@Override
	public String toString() {
		return "AddressPojo [Company=" + Company + ", addressline1=" + addressline1 + ", addressline2=" + addressline2
				+ ", city=" + city + ", postCode=" + postCode + ", homePhoneNumber=" + homePhoneNumber
				+ ", mobileNumber=" + mobileNumber + ", otherInformation=" + otherInformation + ", addressAlias="
				+ addressAlias + ", state=" + state + "]";
	}


	public String getCompany() {
		return Company;
	}


	public String getAddressline1() {
		return addressline1;
	}


	public String getAddressline2() {
		return addressline2;
	}


	public String getCity() {
		return city;
	}


	public String getPostCode() {
		return postCode;
	}


	public String getHomePhoneNumber() {
		return homePhoneNumber;
	}


	public String getMobileNumber() {
		return mobileNumber;
	}


	public String getOtherInformation() {
		return otherInformation;
	}


	public String getAddressAlias() {
		return addressAlias;
	}


	public String getState() {
		return state;
	}


	public AddressPojo(String company, String addressline1, String addressline2, String city, String postCode,
			String homePhoneNumber, String mobileNumber, String otherInformation, String addressAlias, String state) {
		super();
		Company = company;
		this.addressline1 = addressline1;
		this.addressline2 = addressline2;
		this.city = city;
		this.postCode = postCode;
		this.homePhoneNumber = homePhoneNumber;
		this.mobileNumber = mobileNumber;
		this.otherInformation = otherInformation;
		this.addressAlias = addressAlias;
		this.state = state;
	}

}
