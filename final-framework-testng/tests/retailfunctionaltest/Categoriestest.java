package retailfunctionaltest;

import org.testng.annotations.Test;


import com.training.pom.CatalogPOM;
import com.training.pom.CategoriesPOM;
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

public class Categoriestest {
	private WebDriver driver;
	private String baseUrl;
	private retailLoginpage retailLoginpage;
	private CatalogPOM catalogpom;
	private CategoriesPOM categoriespom;
	private static Properties properties;
 
  @Test(priority =0)
  public void setUp() throws Exception {
		  driver = DriverFactory.getDriver(DriverNames.CHROME);
			retailLoginpage = new retailLoginpage(driver); 
			catalogpom = new CatalogPOM(driver);
			categoriespom = new CategoriesPOM(driver);
			baseUrl = properties.getProperty("baseURL");
			// open the browser 
			driver.get(baseUrl);
  }

    @BeforeClass
 
	  public static void setUpBeforeClass() throws IOException {
			properties = new Properties();
			FileInputStream inStream = new FileInputStream("./resources/others.properties");
			properties.load(inStream);
  }
  @Test(priority =1)
  
  public void userlogintest() throws InterruptedException 		// login to application
  {
		retailLoginpage.sendUserName("admin");
		retailLoginpage.sendPassword("admin@123");
		retailLoginpage.clickLoginBtn(); 
		Thread.sleep(3000);
  }
  
  @Test(priority =2)
  public void selectcatalogtest() throws InterruptedException   //move to catalog and select categories
  {		
		catalogpom.movecatalog();
		catalogpom.clickcatagories();
		Thread.sleep(3000);
  }
  
  @Test(priority =3)
  public void deletecategories() throws InterruptedException    //Delete category
  {				
		categoriespom.selectchkbox();
		Thread.sleep(3000);
		String actual = categoriespom.deleteselectchkbox();
		String expected = "Success: You have modified categories!";
		Thread.sleep(3000);
		boolean st = actual.contains(expected);
		assertTrue(st);
  }

  @AfterClass
    
	 public void tearDown() throws Exception{
			 Thread.sleep(1000);
			driver.quit();
  }

}
