package retailfunctionaltest;

import org.testng.annotations.Test;
import com.training.pom.CheckoutPOM;
import com.training.pom.OrderHistoryPOM;
import com.training.pom.OrderInformationPOM;
import com.training.pom.OrderPOM;
import com.training.pom.ProductReturnPOM;
import com.training.pom.RetailhomeUserPOM;
import com.training.pom.UserloginretailPOM;
import com.training.pom.UsermenuPOM;
import com.training.pom.ViewOrderPOM;
import com.training.pom.retailLoginpage;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;
import com.training.pom.retailLoginpage;

import org.testng.annotations.BeforeClass;

import static org.testng.Assert.assertTrue;

import java.awt.AWTException;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;

/*
* Author : Shilpa Morgaonkar
* Test Case ID : RTTC_074
* Test Case Description : To verify whether application allows user to place an order as 
* guest user & admin to change order order status as complete.
* Precondition : 1. user should launch the application by entering valid URL

* 
*/ 

public class OrderStatusChangeNewTest {
	private WebDriver driver;
	private String baseUrl1;
	private UserloginretailPOM userloginretailpom;
	private OrderHistoryPOM oderhistorypom;
	private OrderInformationPOM orderinformationpom;
	private ProductReturnPOM orderreturnpom;
	private UsermenuPOM usermenupom;
	private CheckoutPOM checkoutpom;
	private RetailhomeUserPOM retailhomeuserpom;
	private retailLoginpage retailLoginpage;
	private static Properties properties;
	String actual =null;
	private int ordernbradmin=0;
	private int userordernbr=0;
	private String exporderstatus="Complete";
	private OrderPOM orderpom;
	private ViewOrderPOM vieworderpom;
	
  
	@Test(priority =0)                          //Initialize objects for POM file driver
	  public void setUp() throws Exception {
		  driver = DriverFactory.getDriver(DriverNames.CHROME);
			
		    usermenupom = new UsermenuPOM(driver);
		    retailhomeuserpom = new RetailhomeUserPOM(driver);
			userloginretailpom = new UserloginretailPOM(driver);
			oderhistorypom = new OrderHistoryPOM(driver);
			orderinformationpom = new OrderInformationPOM(driver);
			orderreturnpom = new ProductReturnPOM(driver);
			checkoutpom = new CheckoutPOM(driver);
			retailLoginpage = new retailLoginpage(driver); 
			orderpom = new OrderPOM(driver);
			vieworderpom = new ViewOrderPOM(driver);
			baseUrl1 = properties.getProperty("baseURL1");        // open the browser 
			driver.get(baseUrl1);
	  }
  
  
  @BeforeClass                                                  //Refer to the path for URl and xls as given in resources folder 
  
  public static void setUpBeforeClass() throws IOException {  
		properties = new Properties();
		FileInputStream inStream = new FileInputStream("./resources/others.properties");
		properties.load(inStream);
	}

  @AfterClass                                 // This is to close the object
  
  public void tearDown() throws Exception
  {
  Thread.sleep(1000);
  driver.quit();
  }
  
  @Test(priority =1) 
  
  public void shopnow()                     //This is to go to shopnow and select Ethinc option and add product to cart
  {
	  retailhomeuserpom.moveshopnowicon();  // Move to shop now icon
	  retailhomeuserpom.movetoquickmove();  // Move to quickview and click
	  retailhomeuserpom.addtocard();        // Go to add to cart and click 
	  retailhomeuserpom.shoppingcart();     // Move and click shopping cart click on checkout button
	   
	  
 }
  
  @Test(priority =2) 
  public void login()                       //login to application passing id and password
  {
	  checkoutpom.sendemail("shilpa.morgaonkar@in.ibm.com");   
	  checkoutpom.sendpassword("Janu2019");
	  checkoutpom.clicklogin();
	  
  }
  
  @Test(priority =3)                        //provide payment details for necessary fields
  public void checkout()
  {
	  checkoutpom.selectnewaddress();
	  checkoutpom.sendfirstname("shilpa");
	  checkoutpom.sendlastname("morgaonkar");
	  checkoutpom.sendaddone("test address one");
	  checkoutpom.sendacity("Bangalore");
	  checkoutpom.sendpost("560100");
	  checkoutpom.selectcountry("India");
	  checkoutpom.selectstate("Karnataka");
	  checkoutpom.clickcontinuebtn();             //click on continue (payment)
	  checkoutpom.shipclickcontinuebtn();         //click on continue (shipment)
	  checkoutpom.sendinptestarea("test");        //provide text in description
	  checkoutpom.shipmethodclickcontinuebtn();   //click on continue 
	  checkoutpom.termsncond();                   //check the box terms and conditions
	  checkoutpom.continueaftertermsncond();      //click on continue 
	  checkoutpom.confirmorderbtnclick();
	  String retmsg= checkoutpom.confirmordermessage();   //return confirmation message for order 
	  String expconfmsg = "Your order has been successfully processed!";
	  boolean st0 = retmsg.contains(expconfmsg);
	  assertTrue(st0);
	  usermenupom.logoutuser();                       //logout user
	  usermenupom.openadminSiteWindow();              //open admin window
	  
  }
  
  @Test(priority =4) 
  public void adminlogin()                            //login as admin
  {
	    retailLoginpage.sendUserName("admin");
		retailLoginpage.sendPassword("admin@123");
		retailLoginpage.clickLoginBtn(); 
  }
  
  @Test(priority =5) 			
  public void selectesales() throws InterruptedException    
  {
 	orderpom.movesales();                                //move to sales
  }	
 
 @Test(priority =6) 		
 public void selectorder() throws InterruptedException  
 {
 	orderpom.clickorder();                               
 	orderpom.filterorder("shilpa morgaonkar");           //select order by customer name(this case is added to check only desired product)   
 	ordernbradmin=orderpom.getordernbr();
 	orderpom.vieworder();                                //view order
 	String actualmsg1= orderpom.retmsg();                //assertion to check selected order is viewed
 	String expectmsg1= "Orders";                  
 	boolean st1 = actualmsg1.contains(expectmsg1);
     assertTrue(st1); 
  }
 
 @Test(priority =7) 		
 public void changeorderstatus()                           //view change order status to complete
 {
 	vieworderpom.selectstatus();                           //change order status as Complete                                  
 	vieworderpom.clickaddhistorybtn();                     //click on order history button
 	String actualmsg2=vieworderpom.chksuccessmsg();         //assertion for success message
 	String expemsg2= "Success: You have modified orders!";
 	boolean st2 = actualmsg2.contains(expemsg2);
    assertTrue(st2);
 }
 
 @Test(priority =8) 		
 public void openuserlogin()                                //open admin window to check order 
 {
	 retailLoginpage.openuserSiteWindow();                  //open admin window
	 usermenupom.moveusermenu1();                           //move to user icon  and click login
	 userloginretailpom.sendUserName("shilpa.morgaonkar@in.ibm.com");   //provide id
	 userloginretailpom.sendPassword("Janu2019");                       //provide password
	 userloginretailpom.clickLoginBtn();                                //click continue
	 
 }
 
 @Test(priority =9) 		
 public void chkmyorderhistoty()                             // check my order history to verify if correct order status is changed
 {   
	 oderhistorypom.clickorderhistory();                     //click my order history
	 userordernbr= oderhistorypom.retuserordernbr();         //return order number 
	 Assert.assertEquals(ordernbradmin, userordernbr);       //assertion to check if order number is same as admin for which status is changed
	 
 }
 
 @Test(priority =10) 		                                   //verify order status, assertion to check if ststus 'Complete' is reflected in user site as well
 public void verifyorderstatus() 
 {
	 String actualorderstatus= oderhistorypom.retuserorderstatus();
	 Assert.assertEquals(actualorderstatus, exporderstatus);
	 
 }
 

}
 
