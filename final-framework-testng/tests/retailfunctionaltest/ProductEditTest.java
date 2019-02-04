package retailfunctionaltest;

import org.testng.annotations.Test;

import com.training.pom.CatalogPOM;
import com.training.pom.ProductEditPOM;
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

public class ProductEditTest {
	private WebDriver driver;
	private String baseUrl;
	private retailLoginpage retailLoginpage;
	private CatalogPOM catalogpom;
	private ProductsPOM produtspom;
	private ProductEditPOM producteditpom;
	private static Properties properties;
 
  @Test(priority =0)
	public void setUp() throws Exception {
		driver = DriverFactory.getDriver(DriverNames.CHROME);
		retailLoginpage = new retailLoginpage(driver); 
		catalogpom = new CatalogPOM(driver);
		produtspom = new ProductsPOM(driver);
		producteditpom = new ProductEditPOM(driver);
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
	public void loginadmin() throws InterruptedException			//login to application
	{
		retailLoginpage.sendUserName("admin");
		retailLoginpage.sendPassword("admin@123");
		retailLoginpage.clickLoginBtn(); 
		Thread.sleep(3000);
	}
	@Test(priority =2)
	public void catalog() throws InterruptedException				//move to catalog  and select product option
	{
		
		catalogpom.movecatalog();
		Thread.sleep(3000);
		catalogpom.clickproducts();
		Thread.sleep(3000);
	}
		
	@Test(priority =3)
	public void editProduct() throws InterruptedException 		//select product and click on edit to go to edit screen
	{
		
		produtspom.editselectedproduct();
		
	}
	
	@Test(priority =4)
	public void editquantity() throws InterruptedException 		 //select data in option menu (edit screen) edit product quantity and save
	{
		producteditpom.selectdataoption();                           //select data in option menu (edit screen)
		producteditpom.editselectdataoption();                       //edit quantity
		producteditpom.saveditedquantity();                          //save quantity
		String actualmsg= produtspom.returneditproductmessage();     //return message
		String expectedmsg= "Success: You have modified products!";  //assertion to check return message
		boolean st = actualmsg.contains(expectedmsg);
        assertTrue(st);
	}
	
}

