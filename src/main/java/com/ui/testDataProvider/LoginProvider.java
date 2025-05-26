package com.ui.testDataProvider;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.testng.annotations.DataProvider;

import com.ui.pojos.User;
import com.ui.pojos.UserCredentials;
import com.ui.utils.CsvUtil;
import com.ui.utils.ExcelUtil;
import com.ui.utils.JsonUtils;

public class LoginProvider {

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

	@DataProvider(parallel = true)
	public Object[][] getData() {

		ExcelUtil ex = new ExcelUtil("./src/test/resources/testData/data.xlsx", "DATA");
		int rows = ex.getRowCount();
		System.out.println("Rows: " + rows);
		int cols = ex.getCellCount();
		System.out.println("cells: " + cols);
		Object[][] data = new Object[rows][1];
		Map<String, String> hmap = null;

		for (int i = 1; i <= rows; i++) {

			hmap = new HashMap<>();

			for (int j = 0; j < cols; j++) {

				String key = ex.readData(0, j);
				String value = ex.readData(i, j);
				hmap.put(key, value);
			}

			data[i - 1][0] = hmap;
		}
		return data;

	}

}
