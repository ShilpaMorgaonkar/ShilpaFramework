package retailfunctionaltest;

import static org.testng.Assert.assertTrue;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.training.dataproviders.AddproductDataprovider;
import com.training.pom.CatalogPOM;
import com.training.pom.ProductAddPOM;
import com.training.pom.ProductsPOM;
import com.training.pom.retailLoginpage;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

/*
* Author : Shilpa Morgaonkar
* Test Case ID : RTTC_071
* Test Case Description : To verify whether application allows admin to add multiple product with the rewards point
* Precondition : 
* 1. user should launch the application by entering valid URL
*
* 2. Login as admin
* 
*/ 

public class ProdAddValidDataTest {
	private WebDriver driver;
	private String baseUrl;
	private retailLoginpage retailLoginpage;
	private static Properties properties;
	private CatalogPOM catalogpom;
	private ProductsPOM produtspom;
	private ProductAddPOM productaddpom;
  
  @BeforeClass                                              //Refer to the path for URl and xls as given in resources folder 
  
  public static void setUpBeforeClass() throws IOException {
		properties = new Properties();
		FileInputStream inStream = new FileInputStream("./resources/others.properties");
		properties.load(inStream);
	}
  
  @Test(priority =0)                                         // Initialize objects for POM file driver
  
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

  @AfterClass                                                      //Close objects
  
  public void teardown() throws Exception{
		Thread.sleep(1000);
		driver.quit();
	}
  
  
  @Test(priority =1)
	public void productselect()    								//login to application as admin
	{
		retailLoginpage.sendUserName("admin");
		retailLoginpage.sendPassword("admin@123");
		retailLoginpage.clickLoginBtn(); 
		
	}
  
  @Test(priority =2)
	public void catalog()                         				//move to catalog-product
	{
		catalogpom.movecatalog();
		catalogpom.clickproducts();		
	}
  
  //This test is to retrieve values from xls sheet "Test-data" and add product in application using those values
  
  @Test(priority =3 , dataProvider = "Test-Data", dataProviderClass = AddproductDataprovider.class)
	public void addGeneral(String prodname, String prodtitle, String prodmodel, String prodprice,String prodquan, String discquan,String discprice,String points) throws InterruptedException	//add information in general tab, data tab, links tab and save
	{   
	    produtspom.addnewprod();                             //click on add
		productaddpom.sendprodname(prodname);                //send name from xls
		productaddpom.sendprodTitle(prodtitle);              //send title from xls
		productaddpom.selectdataoption();                    //select data tab
		productaddpom.sendprodmodel(prodmodel);              //send model from xls
		productaddpom.sendprodprice(prodprice);              //send price from xls
		productaddpom.sendprodquantity(prodquan);            //send quantity from xls
		productaddpom.selectlinksoption();                   //select link tab
		productaddpom.selecetcategory();                     //select category
	    productaddpom.selectdiscountoption();                //select discount tab
	    productaddpom.senddiscquantity(discquan);            //send discount quantity from xls
	    productaddpom.senddiscprise(discprice);              //send discount price from xls
	    productaddpom.selectstartdate();                     //send discount start date
	    productaddpom.selectenddate();                       //send discount end date
	    productaddpom.selectrewardpointtab();                //select reward point tab
	    productaddpom.sendrewardPoints(points);              //send reward points
		productaddpom.savedetails();                         //click on save 
		String actualmsg= produtspom.returnaddproductmessage();              //assertion to check success message
		String Expectedmsg = "Success: You have modified products!";	
		boolean st = actualmsg.contains(Expectedmsg);
        assertTrue(st);
        
	}
  
}
