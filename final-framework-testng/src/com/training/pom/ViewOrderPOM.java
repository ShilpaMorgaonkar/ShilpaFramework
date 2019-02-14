package com.training.pom;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class ViewOrderPOM {
	private WebDriver driver; 
	String actual= null;
	String retnbr = null;
	
	public ViewOrderPOM(WebDriver driver) {
		this.driver = driver; 
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//i[@class='fa fa-shopping-cart fw']")
	private WebElement salesmenu; 
	
	@FindBy(xpath="//button[@id='button-invoice']")
	private WebElement generateinvoicebtn; 
	
	@FindBy(xpath="//i[@class='fa fa-refresh']")
	private WebElement refreshinvoicenbrbtn; 
	
	@FindBy(xpath="//td[@id='invoice']")
	private WebElement invnbr; 
	
	@FindBy(xpath="//select[@id='input-order-status']")
	private WebElement orderstatuslist; 
	
	@FindBy(xpath="//button[@class='btn btn-primary']")
	private WebElement addhisbtn;
	
	@FindBy(xpath="//div[@class='alert alert-success']")
	private WebElement successalert;
	
	
	public void selectstatus()
	{
		//Robot robot = new Robot();
		//robot.keyPress(KeyEvent.VK_DOWN);
		//robot.keyRelease(KeyEvent.VK_DOWN); 
		
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,900)");
		

		Select dropdown = new Select(this.orderstatuslist);
		dropdown.selectByVisibleText("Complete");
	}
	
	public void clickaddhistorybtn() 
	{
		this.addhisbtn.click();
	}
	
	
	
	public String generateinvoice() 
	{
	if 	(this.refreshinvoicenbrbtn.isDisplayed())
	{
	retnbr = invnbr.getText();
	}
	else if(this.generateinvoicebtn.isEnabled())
	{
		this.generateinvoicebtn.click();
		retnbr = invnbr.getText();
		}
	return retnbr;
	}
	
	public String chksuccessmsg() 
	{
		return this.successalert.getText();
	}

}
