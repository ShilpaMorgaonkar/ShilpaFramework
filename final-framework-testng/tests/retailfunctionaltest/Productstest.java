package retailfunctionaltest;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.AfterClass;
import com.training.pom.ProductsPOM;
import com.training.pom.retailLoginpage;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;
import static org.testng.Assert.assertTrue;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import org.openqa.selenium.WebDriver;
import com.training.pom.CatalogPOM;


public class Productstest {
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
		baseUrl = properties.getProperty("baseURL");      // open the browser 
		driver.get(baseUrl);
	}

	@BeforeClass

	public static void setUpBeforeClass() throws IOException {
		properties = new Properties();
		FileInputStream inStream = new FileInputStream("./resources/others.properties");
		properties.load(inStream);
	}


	@AfterClass
	
	public void tearDown() throws Exception
	{
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
	public void catalog() throws InterruptedException 				//move to calatog and click on product 
	{
		catalogpom.movecatalog();
		Thread.sleep(3000);
		catalogpom.clickproducts();
		Thread.sleep(3000);
	}
	
	@Test(priority =3)
	public void selectProduct() throws InterruptedException 		//select product
	{
		produtspom = new ProductsPOM(driver);
		Thread.sleep(3000);
		produtspom.selectprodchkbox();
	}
	
	@Test(priority =4)
	public void deleteproduct() throws InterruptedException			//Delete product
	{
		Thread.sleep(3000);
		String actual = produtspom.deleteselectproduct();
		String expected = "Success: You have modified products!";
		Thread.sleep(3000);
		boolean st = actual.contains(expected);
		assertTrue(st);
	}
}
