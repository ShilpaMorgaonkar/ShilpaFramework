package retailfunctionaltest;

import org.testng.annotations.Test;
import com.training.pom.retailLoginpage;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import static org.testng.Assert.assertTrue;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import org.openqa.selenium.WebDriver;

public class retaillogintest {
	private WebDriver driver;
	private String baseUrl;
	private retailLoginpage retailLoginpage;
	private static Properties properties;
	private String actual=null;
	private String expected=null;

	@BeforeClass
	public static void setUpBeforeClass() throws IOException {
		properties = new Properties();
		FileInputStream inStream = new FileInputStream("./resources/others.properties");
		properties.load(inStream);
	}
  
  
	@Test(priority =0)
  
	  public void setUp() throws Exception {
			driver = DriverFactory.getDriver(DriverNames.CHROME);
			retailLoginpage = new retailLoginpage(driver); 
			baseUrl = properties.getProperty("baseURL");
			// open the browser 
			driver.get(baseUrl);
		}
  

  @AfterClass
  public void teardown() throws Exception{
	  		Thread.sleep(1000);
			driver.quit();
		}
  
  @Test(priority =1)
  public void validLoginTest()    //login to application
  {
	retailLoginpage.sendUserName("admin");
	retailLoginpage.sendPassword("admin@123");
	actual = retailLoginpage.clickLoginBtn(); 
	expected = "Dashboard";
    boolean st = actual.contains(expected);
    assertTrue(st);
  }

}