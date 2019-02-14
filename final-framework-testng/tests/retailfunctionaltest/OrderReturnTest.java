package retailfunctionaltest;

import org.testng.annotations.Test;

import com.training.dataproviders.AddproductDataprovider;
import com.training.dataproviders.OrderReturnDataprovider;

import com.training.pom.OrderHistoryPOM;
import com.training.pom.OrderInformationPOM;
import com.training.pom.OrderPOM;
import com.training.pom.ProductReturnPOM;
import com.training.pom.UserloginretailPOM;
import com.training.pom.UsermenuPOM;
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
* Test Case ID : RTTC_075
* Test Case Description : To Verify whether application allows the user to return multiple ordered product
* Precondition : 
* 1. user should launch the application by entering valid URL
* 2. Login into application
* 3. Order a Product
* 
*/ 
public class OrderReturnTest {
	private WebDriver driver;
	private String baseUrl1;
	private UserloginretailPOM userloginretailpom;
	private OrderHistoryPOM oderhistorypom;
	private OrderInformationPOM orderinformationpom;
	private ProductReturnPOM orderreturnpom;
	private UsermenuPOM usermenupom;
	private static Properties properties;
	String actual =null;
  
	@Test(priority =0)                                          // Initialize objects for POM file driver
	  public void setUp() throws Exception {
		  driver = DriverFactory.getDriver(DriverNames.CHROME);
			
		    usermenupom = new UsermenuPOM(driver);
			userloginretailpom = new UserloginretailPOM(driver);
			oderhistorypom = new OrderHistoryPOM(driver);
			orderinformationpom = new OrderInformationPOM(driver);
			orderreturnpom = new ProductReturnPOM(driver);
			baseUrl1 = properties.getProperty("baseURL1");    // open the browser 
			driver.get(baseUrl1);
	  }
  @BeforeClass                                                 //Refer to the path for URl and xls as given in resources folder 
 
  public static void setUpBeforeClass() throws IOException {     
		properties = new Properties();
		FileInputStream inStream = new FileInputStream("./resources/others.properties");
		properties.load(inStream);
	}

  @AfterClass
  
     public void tearDown() throws Exception                   //Close objects
    {
	  Thread.sleep(1000);
	  driver.quit();
	}
    
	  @Test(priority=1) 
	  
	  public void loginuser()                                  //login to application as admin
   {
	  usermenupom.moveusermenu1();
	  userloginretailpom.sendUserName("shilpa.morgaonkar@in.ibm.com");
	  userloginretailpom.sendPassword("Janu2019");
	  userloginretailpom.clickLoginBtn();   
   }
     
 
  // This test id to go to my order select order , view , click return, provide details from xls sheet click submit and check message 
  // Repeat same process for xls rows  (values retrieved from xls are product quantity, reason, selection option, and details)
	  
  @Test(priority =2, dataProvider = "Test-Data2", dataProviderClass = OrderReturnDataprovider.class)
  
  public void myorderselect(String prodquan, String reason,String seloption, String details) throws InterruptedException
  {
	
	usermenupom.selectmyproducts();
  	oderhistorypom.clickvieworderbtn();   
  	orderinformationpom.clickreturnorderbtn();
  	orderreturnpom.sendquantity(prodquan);
  	orderreturnpom.selectreason(reason);
  	orderreturnpom.selectisopen(seloption);
  	orderreturnpom.sendfaultydetails(details);
  	orderreturnpom.clicksubmitbtn();
  	String actual = orderreturnpom.retmsg();
	String expected = "Thank you for submitting your return request. Your request has been sent to the relevant department for processing.";
	boolean st = actual.contains(expected);
	assertTrue(st);
  }
      
}
