package com.ui.listeners;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.testng.IMethodInstance;
import org.testng.IMethodInterceptor;
import org.testng.ITestContext;

import com.ui.utils.ExcelDataUtils;

public class MyMethodInterceptor implements IMethodInterceptor {

	@Override
	public List<IMethodInstance> intercept(List<IMethodInstance> methods,ITestContext context) {
		
		  List<IMethodInstance> result = new ArrayList<>();
		  
		  List<Map<String, String>> list = ExcelDataUtils.getTestDetails("RUMMANAGER");
		  
		  for(int i= 0; i<methods.size(); i++) {
			  
			  for(int j= 0; j<list.size(); j++) {
				  
				  
				 if(methods.get(i).getMethod().getMethodName().equalsIgnoreCase(list.get(j).get("testcasename"))&&
						 list.get(j).get("execute").equalsIgnoreCase("yes")) {
					 
					 methods.get(i).getMethod().setDescription(list.get(j).get("testdescription"));
					 methods.get(i).getMethod().setPriority(Integer.parseInt(list.get(j).get("priority")));
					 result.add(methods.get(i));
				 }
				  
				  
			  }
			  
			  
			  
		  }
	
		  return result;
		}

	 
	
}
