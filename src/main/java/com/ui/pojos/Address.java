package com.ui.pojos;

public class Address {
	
	  private String address_line;   
	  private String city ; 
	  private String state ; //dropdown
	  private String zip ;
	  private String phone ;
	  private String mobile ; 
	  private String  alias ;
	  
	  
	  
	public Address(String address_line, String city, String state, String zip, String phone, String mobile,
			String alias) {
		super();
		this.address_line = address_line;
		this.city = city;
		this.state = state;
		this.zip = zip;
		this.phone = phone;
		this.mobile = mobile;
		this.alias = alias;
	}
	public String getAddress_line() {
		return address_line;
	}
	public String getCity() {
		return city;
	}
	public String getState() {
		return state;
	}
	public String getZip() {
		return zip;
	}
	public String getPhone() {
		return phone;
	}
	public String getMobile() {
		return mobile;
	}
	public String getAlias() {
		return alias;
	}
	@Override
	public String toString() {
		return "Address [address_line=" + address_line + ", city=" + city + ", state=" + state + ", zip=" + zip
				+ ", phone=" + phone + ", mobile=" + mobile + ", alias=" + alias + "]";
	}

		 

}
