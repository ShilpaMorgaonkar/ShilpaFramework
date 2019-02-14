package com.training.pom;

import static org.testng.Assert.assertTrue;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProductReturnPOM {
	
	private WebDriver driver; 
	String retvalue= null;
	String reason1= "Dead On Arrival";
	String reason2= "Faulty, please supply details";
	String reason3= "Order Error";
	String reason4= "Other, please supply details";
	String reason5= "Received Wrong Item";
	
	public ProductReturnPOM(WebDriver driver) {
		this.driver = driver; 
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//input[@id='input-quantity']")
	private WebElement quantity; 
	
	@FindBy(xpath="//div[@class='col-sm-10']//div")
	private List<WebElement> listradiobtn; 
	
	@FindBy(xpath="//input[@type='radio']")
	private List<WebElement> listradiobtn1; 
	
	
	@FindBy(xpath="//div[@class='col-sm-10']/label[1]")
	private WebElement productisoprnYES; 
	
	@FindBy(xpath="//div[@class='col-sm-10']//label[2]")
	private WebElement productisoprnNO; 
	
	@FindBy(xpath="//textarea[@id='input-comment']")
	private WebElement faultydetails; 
	
	@FindBy(xpath="//input[@value='Submit']")
	private WebElement submitbtn; 
	
	@FindBy(xpath="//p[contains(text(),'Thank you for submitting your return request. Your')]")
	private WebElement meslineone; 
	
	@FindBy(xpath="//p[contains(text(),'You will be notified via e-mail as to the status o')]")
	private WebElement meslinetwo; 
	
	public void sendquantity(String prodquan) 
	{
		this.quantity.sendKeys(prodquan);
	}

	public void selectreason(String textofradiobtn) 
	{
		for (int i=1;i<=5;i++)
		{
			if(textofradiobtn.contains(this.listradiobtn.get(i).getText()))
			{
				this.listradiobtn1.get(i-1).click();	
			}
			
		}
		
		
	}
	
	public void selectisopen(String isopen) 
	{
		if (isopen == "YES")
				
		{this.productisoprnYES.click();}
		
		else {this.productisoprnNO.click();}
		
		
	}
	
	public void sendfaultydetails(String details) 
	{
		this.faultydetails.sendKeys(details);
	}
	
	public void clicksubmitbtn() 
	{
		this.submitbtn.click();
		
	}
	public String retmsg()
	{
		return this.meslineone.getText();
	}
}
