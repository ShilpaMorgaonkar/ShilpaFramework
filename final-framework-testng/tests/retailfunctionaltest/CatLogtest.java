package retailfunctionaltest;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.AfterClass;
import com.training.pom.CatalogPOM;
import com.training.pom.retailLoginpage;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

import static org.testng.Assert.assertTrue;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import org.openqa.selenium.WebDriver;

public class CatLogtest {
	private WebDriver driver;
	private String baseUrl;
	private retailLoginpage retailLoginpage;
	private CatalogPOM catalogpom;
	private static Properties properties;
	String actual =null;
	
 
	@Test(priority =0)
  public void setUp() throws Exception {
	  driver = DriverFactory.getDriver(DriverNames.CHROME);
		retailLoginpage = new retailLoginpage(driver); 
		catalogpom = new CatalogPOM(driver);
		baseUrl = properties.getProperty("baseURL"); // open the browser 
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
  
public void loginuser() throws InterruptedException    //login to application
  {
			retailLoginpage.sendUserName("admin");
			retailLoginpage.sendPassword("admin@123");
			retailLoginpage.clickLoginBtn(); 
			Thread.sleep(3000);
   }
  
  @Test(priority =2) 			
   public void selectecategories() throws InterruptedException   //move to catalog and select categories
   {
			
			catalogpom.movecatalog();
			String actual = catalogpom.clickcatagories();
			String expected = "Categories";
	        boolean st = actual.contains(expected);
	        assertTrue(st);
   }
  
}
