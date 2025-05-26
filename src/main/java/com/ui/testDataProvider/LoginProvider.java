package com.ui.testDataProvider;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.function.Predicate;

import org.testng.annotations.DataProvider;

import com.ui.pojos.UserCredentials;
import com.ui.utils.CsvUtil;
import com.ui.utils.ExcelDataUtils;
import com.ui.utils.JsonUtils;

public class LoginProvider {

	private static List<Map<String, String>> list =	new ArrayList<>();
	
	@DataProvider(parallel = true)
	public Object[] getData(Method m) {
      
		 String testName = m.getName();
		 if(list.isEmpty()) {
			 
			 list =ExcelDataUtils.getTestDetails("DATA");
		 }
		 List<Map<String, String>> smalllist = new ArrayList<>(list);
		 
		 Predicate<Map<String,String>> isTestNameNotMatching = map->!map.get("testName").equalsIgnoreCase(testName);
		 Predicate<Map<String,String>> isExecuteColumnNo = map -> map.get("execute").equalsIgnoreCase("no");
		 smalllist.removeIf(isTestNameNotMatching.or(isExecuteColumnNo));
		 return smalllist.toArray();
	}
	
	
	
	
	
	
	@DataProvider(parallel = true)
	public Iterator<Object[]> getJsonData() {

		List<Object[]> data = new ArrayList<>();

		List<UserCredentials> userCred = JsonUtils.getLoginData();
		System.out.println(userCred);

		for (UserCredentials user : userCred) {

			data.add(new Object[] { user });
		}

		return data.iterator();

	}

	@DataProvider(parallel = true)
	public Iterator<UserCredentials> getCSVData() {

		return CsvUtil.csvReadUtil("login.csv");

	}



}
