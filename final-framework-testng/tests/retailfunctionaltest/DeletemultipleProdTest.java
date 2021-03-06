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
* Test Case ID : RTTC_044
* Test Case Description : To Verify whether application allows the admin to delete multiple product from product list
* Precondition : 1. user should launch the application by entering valid URL
* 2. Login as admin

* 
*/ 
public class DeletemultipleProdTest {
	private WebDriver driver;
	private String baseUrl;
	private retailLoginpage retailLoginpage;
	private CatalogPOM catalogpom;
	private ProductsPOM produtspom;
	private static Properties properties;
 
  @Test(priority =0)
	public void setUp() throws Exception {
		driver = DriverFactory.getDriver(DriverNames.CHROME);
		retailLoginpage = new retailLoginpage(driver); 
		catalogpom = new CatalogPOM(driver);
		produtspom = new ProductsPOM(driver);
		baseUrl = properties.getProperty("baseURL");  // open the browser 
		driver.get(baseUrl);
	}
  @Test
  
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
	public void loginadmin() 									//login to application
	{
		retailLoginpage.sendUserName("admin");
		retailLoginpage.sendPassword("admin@123");
		retailLoginpage.clickLoginBtn(); 
		
	}
	@Test(priority =2)
	public void catalog() 										//move to catalog  and select product option
	{
		
		catalogpom.movecatalog();
		catalogpom.clickproducts();
		
	}
		
	@Test(priority =3)
	public void selectmultiprod() throws InterruptedException 									// select multiple products
	{
		produtspom.sendproductname("Shilpa Test Prod1");
		String selectedproduct= produtspom.clickNameFilterBtn();
		produtspom.selectmultipleprodchkbox();
		Thread.sleep(5000);
		}
	
	@Test(priority =4)                                               //delete selected multiple products 
	public void deleteselectedprod() 
	{
		String actualmessage = produtspom.delectmultipleprodchkbox();
		String expectedmessage = "Success: You have modified products!";
		boolean st = actualmessage.contains(expectedmessage);
        assertTrue(st);
       
	}

}
