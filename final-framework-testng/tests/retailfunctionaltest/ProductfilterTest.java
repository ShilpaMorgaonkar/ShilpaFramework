package retailfunctionaltest;

import static org.testng.Assert.assertTrue;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.training.pom.CatalogPOM;
import com.training.pom.ProductsPOM;
import com.training.pom.retailLoginpage;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

public class ProductfilterTest {
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
	public void productselect() throws InterruptedException			//login to application
	{
		retailLoginpage.sendUserName("admin");
		retailLoginpage.sendPassword("admin@123");
		retailLoginpage.clickLoginBtn(); 
		Thread.sleep(3000);
	}
	@Test(priority =2)
	public void catalog() throws InterruptedException				//move to calalog  and select product option
	{
		
		catalogpom.movecatalog();
		Thread.sleep(3000);
		catalogpom.clickproducts();
		Thread.sleep(3000);
	}
	
	@Test (priority =3)
	public void filterProductName() throws InterruptedException		// filter product as per name 
	{
		produtspom.sendproductname("Diamond ring");
		actualName =produtspom.clickNameFilterBtn(); 
		expectedName = "Diamond ring";
		Thread.sleep(5000);
		boolean st1 = actualName.contains(expectedName);
		assertTrue(st1);
	}
		
	@Test (priority =4)
	public void filterProductPrice() throws InterruptedException 	// filter product as per price of product
	{
		produtspom.sendproductprise("8566.0000");		
		actualPrice = produtspom.clickPriceFilterBtn(); 
		expectedPrice = "8566.0000";
		Thread.sleep(3000);
		boolean st2 = actualPrice.contains(expectedPrice);
		assertTrue(st2);
	}
}
