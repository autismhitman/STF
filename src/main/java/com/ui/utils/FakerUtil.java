package com.ui.utils;

import java.util.Locale;

import com.github.javafaker.Faker;
import com.ui.pojos.Address;

public class FakerUtil {
	
	static Faker faker= new Faker(Locale.US);

	public static Faker getFaker() {
		return faker;
	}
	
	public static Address getAddressData() {
	  
	      return new Address(
	    		   getFaker().address().buildingNumber(),
	    		   getFaker().address().city(),
	    		   getFaker().address().state(),
	    		   getFaker().numerify("#####"),
	    		   getFaker().phoneNumber().cellPhone(),
	    		   getFaker().phoneNumber().cellPhone(),
	               "My Add"
	    		   ); 
		
	   }
}
