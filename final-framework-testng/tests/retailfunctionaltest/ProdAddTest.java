package retailfunctionaltest;

import org.testng.annotations.Test;
import com.training.pom.CatalogPOM;
import com.training.pom.ProductsPOM;
import com.training.pom.ProductAddPOM;
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
* Author : Shilpa morgaonkar
* Test Case ID : RTTC_042
* Test Case Description : To Verify whether application allows admin to add product by 
* entering valid credentials in mandatory fields only
* Precondition : 
* 1. user should launch the application by entering valid URL
* 2. Login as admin

*/

public class ProdAddTest {
	private WebDriver driver;
	private String baseUrl;
	private retailLoginpage retailLoginpage;
	private CatalogPOM catalogpom;
	private ProductsPOM produtspom;
	private ProductAddPOM productaddpom;
	private static Properties properties;
	
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
	public void loginadmin() 		 								//login to application
	{
		retailLoginpage.sendUserName("admin");
		retailLoginpage.sendPassword("admin@123");
		retailLoginpage.clickLoginBtn(); 
		
	}
	@Test(priority =2)
	public void catalog() 									//move to catalog-product-  click add option
	{
		catalogpom.movecatalog();
		catalogpom.clickproducts();
		produtspom.addnewprod();
	}
	
	@Test(priority =3)
	public void addGeneral() 								//add information in general tab, data tab, links tab and save
	{
		productaddpom.sendprodname("Shilpa Test Prod1");
		productaddpom.sendprodTitle("Shilpa Test Prod1");
		productaddpom.selectdataoption();
		productaddpom.sendprodmodel("SKU-002");
		productaddpom.sendprodprice("500");
		productaddpom.sendprodquantity("50");
		productaddpom.selectlinksoption();
		productaddpom.selecetcategory();
		productaddpom.savedetails();
		
	}
	@Test(priority =4)                                                //assertion to check return message
	public void getmsg() 
	{
		String actualmsg= produtspom.returnaddproductmessage();
		String Expectedmsg = "Success: You have modified products!";	
		boolean st = actualmsg.contains(Expectedmsg);
        assertTrue(st);
        
	}
	}
	

