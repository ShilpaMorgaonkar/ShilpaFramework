package retailfunctionaltest;

import org.testng.annotations.Test;

import com.training.dataproviders.DBAddproductDataprovider;
import com.training.dataproviders.LoginDataProviders;
import com.training.bean.DBAddproductBean;
import com.training.dao.DBAddproductDAO;
import com.training.generics.GenericMethods;
import com.training.generics.ScreenShot;
import com.training.pom.CatalogPOM;
import com.training.pom.LoginPOM;
import com.training.pom.ProductAddPOM;
import com.training.pom.ProductsPOM;
import com.training.pom.retailLoginpage;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

import org.testng.annotations.BeforeClass;

import static org.testng.Assert.assertTrue;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
/*
* Author : Shilpa Morgaonkar
* Test Case ID : RTTC_073
* Test Case Description : To Verify whether added product details get stored in database
* Precondition : 1. user should launch the application by entering valid URL
* 1. user should launch the application by entering valid URL
* 2. Login as admin
*
* 
*/ 
public class DatabaseAddProductTest {
	private WebDriver driver;
	private String baseUrl;
	private static Properties properties;
	private retailLoginpage retailLoginpage;
	private CatalogPOM catalogpom;
	private ProductsPOM produtspom;
	private ProductAddPOM productaddpom;
	private String screenname= null;
	private String screetitle= null;
	private String screenmodel= null;
	private int screenprice= 0;
	private int screenquantity= 0;
	private String screencategory= null;
	
	@Test(priority =0)
	public void setUp() throws Exception {
		driver = DriverFactory.getDriver(DriverNames.CHROME);
		retailLoginpage = new retailLoginpage(driver); 
		catalogpom = new CatalogPOM(driver);
		produtspom = new ProductsPOM(driver);
		productaddpom = new ProductAddPOM(driver);
		baseUrl = properties.getProperty("baseURL");  // open the browser 
		driver.get(baseUrl);
	}
 
  @BeforeClass
  
  public static void setUpBeforeClass() throws IOException {
		properties = new Properties();
		FileInputStream inStream = new FileInputStream("./resources/others.properties");
		properties.load(inStream);
	}

  @AfterClass
  
  public void tearDown() throws Exception{
		Thread.sleep(1000);
		driver.quit();

}
  
  @Test(priority =1)
	public void loginadmin() 										//login to application as admin
	{
		retailLoginpage.sendUserName("admin");
		retailLoginpage.sendPassword("admin@123");
		retailLoginpage.clickLoginBtn(); 
		
	}
	@Test(priority =2)
	public void catalog() 										//move to catalog-product-  click add option
	{
		
		catalogpom.movecatalog();
		catalogpom.clickproducts();
		produtspom.addnewprod();
		
		
	}
	
	@Test(priority =3)
	public void addGeneral() 	//Add information in general tab, data tab, links tab and save (make sure values are same as database)
	{
		productaddpom.sendprodname("testname");
		screenname= productaddpom.getnamevalue();
		productaddpom.sendprodTitle("testtitle");
		screetitle= productaddpom.gettitlevalue();
		productaddpom.selectdataoption();
		productaddpom.sendprodmodel("SKU-003");
		screenmodel= productaddpom.getmodelvalue();
		productaddpom.sendprodprice("500");
		screenprice= productaddpom.getpricevalue();
		productaddpom.sendprodquantity("10");
		screenquantity= productaddpom.getquantityvalue();
		productaddpom.selectlinksoption();
		productaddpom.selecetcategory();
		screencategory= productaddpom.getcategoryvalue();
		productaddpom.savedetails();
		
		
		
	}
	@Test(priority =4)                                                //Assertion to check success message
	public void getmsg() 
	{
		String actualmsg= produtspom.returnaddproductmessage();
		String Expectedmsg = "Success: You have modified products!";	
		boolean st = actualmsg.contains(Expectedmsg);
      assertTrue(st);
      
	}
	
	//This test add retrieve the data from database and compare the retrieved fields with fields
	//which are added in application using addGeneral() method above 
	//below is database query and result for reference:
	/*create database retailproduct;

	use retailproduct;
	create table addproduct
	( productname varchar(50) not null, productmegatitle varchar(50),model varchar(50),price numeric(5),quantity numeric(3), category varchar(50));

	use retailproduct;
	insert into addproduct values ("testname", "testtitle", "SKU-003", 500, 10, "Earrings");

	select * from addproduct;
	testname	testtitle	SKU-003	500	10	Earrings*/
	
	
	@Test(priority =5,dataProvider = "db-inputs", dataProviderClass = DBAddproductDataprovider.class)
	public void loginDBTest(String prodname, String prodtitle, String prodmodel,int prodprice, int prodquan,String prodcategory ) {
					
	    Assert.assertEquals(screenname, prodname);
	    Assert.assertEquals(screetitle, prodtitle);
	    Assert.assertEquals(screenmodel, prodmodel);
	    Assert.assertEquals(screenprice, prodprice);
	    Assert.assertEquals(screenquantity, prodquan);
	    Assert.assertEquals(screencategory, prodcategory);
	   
	}
}
