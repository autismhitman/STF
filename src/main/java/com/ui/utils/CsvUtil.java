package com.ui.utils;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;
import com.ui.pojos.UserCredentials;

public class CsvUtil {
	
	
	public static Iterator<UserCredentials> csvReadUtil(String fileName){
		
		FileReader reader = null;
		CSVReader csv;
		String[] line;
		List<UserCredentials> userList=null;
		UserCredentials user;
		try {
			reader = new FileReader(new File("./src/test/resources/testData/"+fileName));
			 csv = new CSVReader(reader);
			 csv.readNext();
			 userList = new ArrayList();
			 while((line=csv.readNext())!=null) {
				 user= new UserCredentials(line[0], line[1], line[2]);
				 userList.add(user);
			 }
			 
		} catch (FileNotFoundException | CsvValidationException e) {
			
			e.printStackTrace();
		} catch (IOException e) {
			 
			e.printStackTrace();
		}
	       
	 
	     return userList.iterator();
		
	}
	
	
	

}
