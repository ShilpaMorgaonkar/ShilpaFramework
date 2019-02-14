package com.training.dataproviders;

import java.util.List;

import org.testng.annotations.DataProvider;

import com.training.bean.LoginBean;
import com.training.bean.AddproductBean;
import com.training.dao.ELearningDAO;
import com.training.readexcel.ApachePOIExcelRead;
import com.training.readexcel.ReadExcel;
import com.training.readexcel.ApachePOIvaliddataRead;

public class AddproductDataprovider {

	@DataProvider(name = "db-inputs")
	public Object [][] getDBData() {

		List<LoginBean> list = new ELearningDAO().getLogins(); 
		
		Object[][] result = new Object[list.size()][]; 
		int count = 0; 
		for(LoginBean temp : list){
			Object[]  obj = new Object[2]; 
			obj[0] = temp.getUserName(); 
			obj[1] = temp.getPassword(); 
			
			result[count ++] = obj; 
		}
				
		return result;
	}
	
	@DataProvider(name = "Test-Data")
	public Object[][] getExcelData(){
		String fileName ="./resources/Retail_RTTC_071_RTTC_072_RTTC_075.xlsx"; 
		return new ApachePOIvaliddataRead().getExcelContent(fileName); 
	}
	
	@DataProvider(name = "xls-inputs")
	public Object[][] getXLSData(){
		// ensure you will have the title as first line in the file 
		return new ReadExcel().getExcelData("C:/Users/IBM_ADMIN/Desktop/selenium training/Retail_RTTD_009.xlsx", "Sheet1"); 
	}
}
