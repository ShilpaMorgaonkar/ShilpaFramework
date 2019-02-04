package com.training.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrderPOM {

	private WebDriver driver; 
	String actual= null;
	String retnbr = null;
		
		public OrderPOM(WebDriver driver) {
			this.driver = driver; 
			PageFactory.initElements(driver, this);
		}
		
		@FindBy(xpath="//i[@class='fa fa-shopping-cart fw']")
		private WebElement salesmenu; 
		
		@FindBy(xpath="//li[@id='menu-sale']//a[contains(text(),'Orders')]")
		private WebElement order; 
				
		@FindBy(xpath="//tbody//tr[1]//td[8]//a[1]")
		private WebElement vieworder; 
		
		@FindBy(xpath="//h1[contains(text(),'Orders')]")
		private WebElement pageheading; 
		
		@FindBy(xpath="//button[@id='button-invoice']")
		private WebElement generateinvoicebtn; 
		
		@FindBy(xpath="//i[@class='fa fa-refresh']")
		private WebElement refreshinvoicenbrbtn; 
		
		@FindBy(xpath="//td[@id='invoice']")
		private WebElement invnbr; 
		
		@FindBy(xpath="//input[@id='input-customer']")
		private WebElement custname; 
		
		@FindBy(xpath="//button[@id='button-filter']")
		private WebElement filterbycustname; 
		
		public void movesales()
		{
			Actions action = new Actions(driver);
			action.moveToElement(salesmenu).click().perform();
		}
		
		public void clickorder()
		{
			this.order.click();
		}
		
		public void filterorder(String name)
		{
			this.custname.clear();
			this.custname.sendKeys(name);
			this.filterbycustname.click();
		}
			
		public void vieworder() {
			this.vieworder.click();
		}
		
		public String retmsg() {
			String retvalue= this.pageheading.getText();
			return retvalue;
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
}
