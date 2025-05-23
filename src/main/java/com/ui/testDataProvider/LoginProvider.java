package com.ui.testDataProvider;

import java.util.HashMap;
import java.util.Map;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.ui.utils.ExcelUtil;

public class LoginProvider {
	
 /*
		
		@Test(dataProvider="getData")
		public void getTestData (HashMap<String, String> hmap) {
			
			System.out.println("username :" + hmap.get("username") + "password"+ hmap.get("password") 
			+ "accountName"+ hmap.get("accountName"));
		}
*/	 
	
	@DataProvider
	public Object[][] getData(){
		
		ExcelUtil ex = new ExcelUtil("./src/test/resources/testData/data.xlsx","TestData");
		int rows= ex.getRowCount();
		System.out.println("Rows: " + rows);
		int cols = ex.getCellCount();
		System.out.println("cells: " + cols);
		 Object[][] data = new Object[rows][1];
		 Map<String, String> hmap = null;
	
		 
		 for( int i=1; i<=rows; i++) {
			 
			 hmap= new HashMap<>();
			 
			 for( int j=0; j<cols; j++) {
				 
				String key =ex.readData(0, j);
				String value= ex.readData(i, j);
				hmap.put(key,  value);
			 }
			 
			 data[i-1][0] = hmap;
		 }
		 return data;
		 
	}
	
	

}
