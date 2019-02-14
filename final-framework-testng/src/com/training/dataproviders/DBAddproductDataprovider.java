package com.training.dataproviders;

import java.util.List;

import org.testng.annotations.DataProvider;

import com.training.bean.DBAddproductBean;
import com.training.dao.DBAddproductDAO;
import com.training.readexcel.ApachePOIExcelRead;
import com.training.readexcel.ReadExcel;

public class DBAddproductDataprovider {
	@DataProvider(name = "db-inputs")
	public Object [][] getDBData() {

		List<DBAddproductBean> list = new DBAddproductDAO().getLogins(); 
		
		Object[][] result = new Object[list.size()][]; 
		int count = 0; 
		for(DBAddproductBean temp : list){
			Object[]  obj = new Object[6]; 
			obj[0] = temp.getProdname(); 
			obj[1] = temp.getProdtitle(); 
			obj[2] = temp.getProdmodel(); 
			obj[3] = temp.getProdprice(); 
			obj[4] = temp.getProdquan(); 
			obj[5] = temp.getProdcategory();
			
			result[count ++] = obj; 
		}
		
		
		return result;
	}
	
	@DataProvider(name = "excel-inputs")
	public Object[][] getExcelData(){
		String fileName ="C:/Users/Naveen/Desktop/Testing.xlsx"; 
		return new ApachePOIExcelRead().getExcelContent(fileName); 
	}
	
	@DataProvider(name = "xls-inputs")
	public Object[][] getXLSData(){
		// ensure you will have the title as first line in the file 
		return new ReadExcel().getExcelData("C:/Users/Naveen/Desktop/Testing.xls", "Sheet1"); 
	}

}
