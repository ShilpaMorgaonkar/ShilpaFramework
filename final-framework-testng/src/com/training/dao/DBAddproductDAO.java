package com.training.dao;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import com.training.bean.DBAddproductBean;
import com.training.connection.GetConnection;
import com.training.utility.LoadDBDetails;

public class DBAddproductDAO {
Properties properties; 
	
	public DBAddproductDAO() {
		 try {
			properties = new Properties();
			FileInputStream inStream = new FileInputStream("./resources/sql.properties");
			properties.load(inStream);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public List<DBAddproductBean> getLogins(){
		String sql = properties.getProperty("get.logins"); 
		
		GetConnection gc  = new GetConnection(); 
		List<DBAddproductBean> list = null;
		try {
			gc.ps1 = GetConnection.getMySqlConnection(LoadDBDetails.getDBDetails()).prepareStatement(sql); 
			list = new ArrayList<DBAddproductBean>(); 
			
			gc.rs1 = gc.ps1.executeQuery(); 
			
			while(gc.rs1.next()) {
			
				DBAddproductBean temp = new DBAddproductBean(); 
				temp.setProdname(gc.rs1.getString(1));
				temp.setProdtitle(gc.rs1.getString(2));
				temp.setProdmodel(gc.rs1.getString(3));
				temp.setProdprice(gc.rs1.getInt(4));
				temp.setProdquan(gc.rs1.getInt(5));
				temp.setProdcategory(gc.rs1.getString(6));				
				list.add(temp); 
				
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return list; 
	}
	
	public static void main(String[] args) {
		new DBAddproductDAO().getLogins().forEach(System.out :: println);
	}
	
	

}
