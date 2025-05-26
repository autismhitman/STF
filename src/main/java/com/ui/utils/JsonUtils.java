package com.ui.utils;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.List;

import com.google.gson.Gson;
import com.ui.pojos.User;
import com.ui.pojos.UserCredentials;

public class JsonUtils {
	
	
	 public static List<UserCredentials> getLoginData() {
		 
		 Gson gson = new Gson();
		 FileReader reader =null;
		 
		 
		 try {
			 reader = new FileReader(new File("./src/test/resources/testData/loginDetails.json"));
		} catch (FileNotFoundException e) {
		 
			e.printStackTrace();
		}
		 
		User user=  gson.fromJson(reader, User.class);
		return user.getData();
		 
	 }

}
