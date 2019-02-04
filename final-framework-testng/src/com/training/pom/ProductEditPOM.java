package com.training.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProductEditPOM {
	private WebDriver driver;
	boolean bValue = false;
	String mesgretvalue =null;
		
	
	public ProductEditPOM(WebDriver driver) {
		this.driver = driver; 
		PageFactory.initElements(driver, this);
	}
	@FindBy(xpath="//a[contains(text(),'Data')]")
	private WebElement dataoption; 
	
	@FindBy(xpath="//input[@id='input-quantity']")
	private WebElement quantity; 
	
	@FindBy(xpath="//i[@class='fa fa-save']")
	private WebElement savebtn; 
	
	public void selectdataoption() throws InterruptedException
	{
	this.dataoption.click();
	
	}

	public void editselectdataoption() throws InterruptedException
	{
	this.quantity.clear();
	this.quantity.sendKeys("45");
	Thread.sleep(3000);
	
	}
	
	public void saveditedquantity() throws InterruptedException
	{
		this.savebtn.click();
		
    }
	 
}
