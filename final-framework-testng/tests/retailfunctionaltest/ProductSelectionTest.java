package retailfunctionaltest;

import org.testng.annotations.Test;

import com.training.pom.CatalogPOM;
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
import org.testng.annotations.AfterClass;

/*
* Author : Shilpa Morgaonkar
* Test Case ID : RTTC_041
* Test Case Description : To Verify whether application allows the admin to filter the product 
* details with all textbox
* Precondition : 
* 1. user should launch the application by entering valid URL
* 2. Login as admin
* 
*/ 

public class ProductSelectionTest {
	private WebDriver driver;
	private String baseUrl;
	private retailLoginpage retailLoginpage;
	private CatalogPOM catalogpom;
	private ProductsPOM produtspom;
	private static Properties properties;
	private String actualPrice=null;
	private String actualName=null;
	private String expectedPrice=null;
	private String expectedName=null;
	
	@Test(priority =0)
	public void setUp() throws Exception {
		driver = DriverFactory.getDriver(DriverNames.CHROME);
		retailLoginpage = new retailLoginpage(driver); 
		catalogpom = new CatalogPOM(driver);
		produtspom = new ProductsPOM(driver);
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
	public void productselect() 									//login to application
	{
		retailLoginpage.sendUserName("admin");
		retailLoginpage.sendPassword("admin@123");
		retailLoginpage.clickLoginBtn(); 
		
	}
	@Test(priority =2)
	public void catalog() 											//move to catalog  and select product option
	{
		
		catalogpom.movecatalog();
		catalogpom.clickproducts();
	}
	
	@Test (priority =3)
	public void filterProductName()									// filter product as per name of product
	{
		produtspom.sendproductname("Integer vitae iaculis massa");
		actualName =produtspom.clickNameFilterBtn(); 
		expectedName = "Integer vitae iaculis massa";
		boolean st1 = actualName.contains(expectedName);
		assertTrue(st1);
	}
		
	@Test (priority =4)
	public void filterProductPrice() 								// filter product as per price of product
	{
		produtspom.sendproductprise("805.0000");		
		actualPrice = produtspom.clickPriceFilterBtn(); 
		expectedPrice = "805.0000";
		boolean st2 = actualPrice.contains(expectedPrice);
		assertTrue(st2);
	}
	
	@Test (priority =5)
	public void filterProductstatusFilterBtn() 					 	// filter product as per status of product
	{
		produtspom.selectstatus();
		String actualStatus = produtspom.clickstatusFilterBtn(); 
		String expectedStatus = "Enabled";
		boolean st4 = actualStatus.contains(expectedStatus);
		assertTrue(st4);
	}
	
	@Test (priority =6)
	public void filterProductModel() 							 	// filter product as per Model of product
	{
		produtspom.sendproductmodel("SKU-003");		
		String actualModel = produtspom.clickModelFilterBtn(); 
		String expectedModel = "SKU-003";
		boolean st3 = actualModel.contains(expectedModel);
		assertTrue(st3);
	}
		
	@Test (priority =7)
	public void filterProductquantity() 						     	// filter product as per quantity of product
	{
		produtspom.sendproductquantity("45");		
		String actualquantity = produtspom.clickquantityFilterBtn(); 
		String expectedquantity = "45";
		boolean st5 = actualquantity.contains(expectedquantity);
		assertTrue(st5);
	}
	
	@Test (priority =8)
	public void filterProductimage() 									// filter product as per image of product
	{
		produtspom.selectimage();		
		produtspom.clickimageFilterBtn(); 
		
	}
	
}
