package com.training.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrderHistoryPOM {
	private WebDriver driver; 
	String retvalue= null;
	
	public OrderHistoryPOM(WebDriver driver) {
		this.driver = driver; 
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//tbody//tr[1]//td[7]//a[1]//i[1]")
	private WebElement viewordericon; 
	
	@FindBy(xpath="//a[contains(text(),'View your order history')]")
	private WebElement orderhistory; 
	
	@FindBy(xpath="//tbody//tr[1]//td[1]")
	private WebElement userordernbr; 
	
	@FindBy(xpath="//tbody//tr[1]//td[4]")
	private WebElement userorderstatus; 
	
	
	public void clickorderhistory() {
		this.orderhistory.click();
		}
	
	public void clickvieworderbtn() {
		this.viewordericon.click();
		}
	
	public int retuserordernbr() 
	{
		String ordernbrstr= this.userordernbr.getText();
		String actual=ordernbrstr.substring(1, ordernbrstr.length());
		int orderininteger = Integer.parseInt(actual);
		return orderininteger;
		
	}
	
	public String retuserorderstatus() 
	{
		return this.userorderstatus.getText();
		
		
	}
	
		
	}
	
	
	


