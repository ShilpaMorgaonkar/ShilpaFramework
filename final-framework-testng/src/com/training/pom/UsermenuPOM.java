package com.training.pom;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class UsermenuPOM {
	
	private WebDriver driver; 
	String retvalue= null;
	
	public UsermenuPOM(WebDriver driver) {
		this.driver = driver; 
		PageFactory.initElements(driver, this);
	}
	
		
	@FindBy(xpath="//i[@class='fa fa-user-o']")
	private WebElement Usericon;		
	
	@FindBy(xpath="//span[contains(text(),'LOGIN / REGISTER')]")
	private WebElement loginicon;
	
	@FindBy(xpath="//span[contains(text(),'MY ORDERS')]")
	private WebElement myorders;
	
	@FindBy(xpath="//ul[@class='dropdown-menu tb_list_1']//li[3]")
	private WebElement myorders1;
	
	@FindBy(linkText="MY ORDERS")
	private WebElement selectmyorderlink; 
	 
	
	@FindBy(xpath="//span[contains(text(),'LOGOUT')]")    
	private WebElement logoutbtn; 

	public void moveusermenu()
	{
		Actions action = new Actions(driver);
		action.clickAndHold(Usericon).build().perform();
		}
	
	public  void clickloginicon() {
		Actions action = new Actions(driver);
		action.moveToElement(loginicon).click().perform();
	
	}
	
	public void moveusermenu1()
	{
		Actions action = new Actions(driver);
		action.clickAndHold(Usericon).build().perform();
		this.loginicon.click();
		action.moveToElement(Usericon).release();
		}
	public void selectmyproducts() 
	{
		Actions action = new Actions(driver);
		action.clickAndHold(Usericon).build().perform();
		this.myorders.click();
		action.moveToElement(Usericon).release();
		
		}
	
	public void logoutuser() 
	{
		
		Actions action = new Actions(driver);
		action.clickAndHold(Usericon).build().perform();
		this.logoutbtn.click();
		action.moveToElement(Usericon).release();
		
		
		
	}
	
	// 5. Open admin site in new window
			public void openadminSiteWindow() {
			//((JavascriptExecutor) driver).executeScript("window.open()");
			//ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
			//driver.switchTo().window(tabs.get(1));
			driver.get("http://retail.upskills.in/admin");
			}
	
}
