package com.ui.pages;

import org.openqa.selenium.By;

import com.ui.pojos.Address;
import com.ui.utils.BrowserUtility;

public class AddressPage extends BrowserUtility {
	

	private static final By address_line = By.id("address1");
	private static final By city = By.id("city");
	private static final By state = By.id("id_state");
	private static final By zipCode = By.id("postcode");
	private static final By phone = By.id("phone");
	private static final By mobile = By.id("phone_mobile");
	private static final By alias = By.id("alias");
	private static final By saveBtn= By.xpath("//button[@id='submitAddress']");
	
	private static final By MY_ADDRESS_LABEL =By.tagName("h3");
	
	public String enterAndSaveAddressDetails(Address address) {
		
		enterText(address.getAddress_line(),address_line);
		enterText(address.getCity(),city);
		selectDropdown(address.getState(),state);
		enterText(address.getZip(),zipCode);
		enterText(address.getPhone(),phone);
		enterText(address.getMobile(),mobile);
		clearAndEnterText(address.getAlias(), alias);
		click(saveBtn);
		return getText(MY_ADDRESS_LABEL);
		
	}
	
	

}
