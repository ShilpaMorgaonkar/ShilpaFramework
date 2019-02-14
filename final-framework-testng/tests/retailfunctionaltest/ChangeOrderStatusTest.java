package retailfunctionaltest;

import org.testng.annotations.Test;

import com.training.pom.OrderPOM;
import com.training.pom.ViewOrderPOM;
import com.training.pom.retailLoginpage;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

import org.testng.annotations.BeforeClass;

import static org.testng.Assert.assertTrue;

import java.awt.AWTException;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;

public class ChangeOrderStatusTest {
	private WebDriver driver;
	private String baseUrl;
	private retailLoginpage retailLoginpage;
	private OrderPOM orderpom;
	private ViewOrderPOM vieworderpom;
	private static Properties properties;
	String actual =null;
	private int ordernbradmin=0;
	
	@Test(priority =0)
	  public void setUp() throws Exception {
		  driver = DriverFactory.getDriver(DriverNames.CHROME);
			retailLoginpage = new retailLoginpage(driver); 
			orderpom = new OrderPOM(driver);
			vieworderpom = new ViewOrderPOM(driver);
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
  
   /* public void tearDown() throws Exception{
	  Thread.sleep(1000);
	  driver.quit();
		}*/
  
  @Test(priority =1) 
  
  public void loginuser() throws InterruptedException    //login to application
    {
  			retailLoginpage.sendUserName("admin");
  			retailLoginpage.sendPassword("admin@123");
  			retailLoginpage.clickLoginBtn(); 
  			Thread.sleep(3000);
     }
    
    @Test(priority =2) 			
     public void selectesales() throws InterruptedException    
     {
 
    	orderpom.movesales();                                //move to sales
     }	
    
    @Test(priority =3) 		
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
    @Test(priority =4) 		
    public void selectorderststus() throws InterruptedException 
    {
    	System.out.println("within selectorderststus");
    	vieworderpom.selectstatus();
    	Thread.sleep(1000);
     	vieworderpom.clickaddhistorybtn();
     	Thread.sleep(1000);
     	String actualmsg2=vieworderpom.chksuccessmsg();
     	String expemsg2= "Success: You have modified orders!";
     	boolean st2 = actualmsg2.contains(expemsg2);
        assertTrue(st2);
    }

}
