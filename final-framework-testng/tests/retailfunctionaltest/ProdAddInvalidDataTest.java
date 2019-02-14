package retailfunctionaltest;

import org.testng.annotations.Test;
import com.training.dataproviders.InvalidAddproductDataprovider;
import com.training.pom.CatalogPOM;
import com.training.pom.ProductAddPOM;
import com.training.pom.ProductsPOM;
import com.training.pom.retailLoginpage;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;
import org.testng.annotations.BeforeClass;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;

/*
* Author : Shilpa Morgaonkar
* Test Case ID : RTTC_072
* Test Case Description : To verify whether application displays 
* error message upon entering invalid details while adding product with reward points
* Precondition : 
* 1. user should launch the application by entering valid URL
*
* 2. Login as admin
* 
*/

public class ProdAddInvalidDataTest {
	private WebDriver driver;
	private String baseUrl;
	private retailLoginpage retailLoginpage;
	private static Properties properties;
	private String actual=null;
	private String expected=null;
	private CatalogPOM catalogpom;
	private ProductsPOM produtspom;
	private ProductAddPOM productaddpom;
  
  @BeforeClass                                                       //Refer to the path for URl and xls as given in resources folder 
 
  public static void setUpBeforeClass() throws IOException {
		properties = new Properties();
		FileInputStream inStream = new FileInputStream("./resources/others.properties");
		properties.load(inStream);
	}

  
@Test(priority =0)                                                   // Initialize objects for POM file driver
  
  public void setUp() throws Exception {
		driver = DriverFactory.getDriver(DriverNames.CHROME);
		retailLoginpage = new retailLoginpage(driver); 
		catalogpom = new CatalogPOM(driver);
		produtspom = new ProductsPOM(driver);
		productaddpom = new ProductAddPOM(driver);
		baseUrl = properties.getProperty("baseURL");
		// open the browser 
		driver.get(baseUrl);
	}

  @AfterClass                                                       //Close objects
  
  public void teardown() throws Exception{
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
	public void catalog() 											//Move to catalog-product-  click add option
	{
		
		catalogpom.movecatalog();
		catalogpom.clickproducts();
		
	}
  
//This test is to retrieve values from xls sheet "Test-data1" and get error message as those values are invalid
  
  @Test(priority =3 , dataProvider = "Test-Data1", dataProviderClass = InvalidAddproductDataprovider.class)
	public void addGeneral(String prodname, String prodtitle, String prodmodel, String prodprice,String prodquan, String discquan,String discprice,String points) throws InterruptedException	//add information in general tab, data tab, links tab and save
	{   
	    produtspom.addnewprod();
		productaddpom.sendprodname(prodname);
		productaddpom.sendprodTitle(prodtitle);
		productaddpom.selectdataoption();
		productaddpom.sendprodmodel(prodmodel);
		productaddpom.sendprodprice(prodprice);
		productaddpom.sendprodquantity(prodquan);
		productaddpom.selectlinksoption();
		productaddpom.selecetcategory(); 
	    productaddpom.selectdiscountoption();
	    productaddpom.senddiscquantity(discquan);
	    productaddpom.senddiscprise(discprice);
	    productaddpom.selectstartdate();
	    productaddpom.selectenddate();
	    productaddpom.selectrewardpointtab();
	    productaddpom.sendrewardPoints(points);
		productaddpom.savedetails();
		String actualmsg= productaddpom.chkerrmsg();
		String Expectedmsg = "Warning: Please check the form carefully for errors!";	
		boolean st = actualmsg.contains(Expectedmsg);
        if (st= true) {
        	productaddpom.canclebtnclick();}
              
	}
  
}
