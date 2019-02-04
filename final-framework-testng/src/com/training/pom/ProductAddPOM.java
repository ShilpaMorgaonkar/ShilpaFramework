package com.training.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class ProductAddPOM {
	
		private WebDriver driver;
		boolean bValue = false;
		String mesgretvalue =null;
		
		public ProductAddPOM(WebDriver driver) {
			this.driver = driver; 
			PageFactory.initElements(driver, this);
		}
		@FindBy(xpath="//a[contains(text(),'Data')]")
		private WebElement dataoption; 
		
		@FindBy(xpath="//input[@id='input-name1']")
		private WebElement prodname; 
		
		@FindBy(xpath="//input[@id='input-meta-title1']")
		private WebElement prodtitle; 
		
		@FindBy(xpath="//input[@id='input-model']")
		private WebElement prodmodel; 
		
		@FindBy(xpath="//input[@id='input-price']")
		private WebElement prodprice; 
		
		@FindBy(xpath="//input[@id='input-quantity']")
		private WebElement prodquantity; 
		
		@FindBy(xpath="//a[contains(text(),'Links')]")
		private WebElement linksoptions; 
		
		@FindBy(xpath="//input[@id='input-category']")
		private WebElement categorylist; 
		
		@FindBy(linkText="Earrings")
		private WebElement selectedcategory; 
		
		
		@FindBy(xpath="//i[@class='fa fa-save']")
		private WebElement savebtn; 
		
		public void selectdataoption() throws InterruptedException
		{
		this.dataoption.click();
		}
		
		public void selectlinksoption() throws InterruptedException
		{
		this.linksoptions.click();
		}
		
		public void sendprodname(String prodname) 
		{
			this.prodname.clear();
			this.prodname.sendKeys(prodname);
		}
		
		public void sendprodTitle(String prodtitle) throws InterruptedException 
		{
			this.prodtitle.clear();
			this.prodtitle.sendKeys(prodtitle);
			Thread.sleep(3000);
		}
		
		public void sendprodmodel(String prodmodel) throws InterruptedException 
		{
			this.prodmodel.clear();
			this.prodmodel.sendKeys(prodmodel);
			Thread.sleep(3000);
		}
		
		public void sendprodprice(String prodprice) throws InterruptedException 
		{
			this.prodprice.clear();
			this.prodprice.sendKeys(prodprice);
			Thread.sleep(3000);
		}
		
		public void sendprodquantity(String prodquantity) throws InterruptedException 
		{
			this.prodquantity.clear();
			this.prodquantity.sendKeys(prodquantity);
			Thread.sleep(3000);
		}
		
		public void selecetcategory() throws InterruptedException 
		{
				
				this.categorylist.click(); 
				Thread.sleep(2000);
				Actions actions = new Actions(driver);
				actions.moveToElement(this.selectedcategory).click().perform();
				
			
		}
		public void savedetails() 
		{
			this.savebtn.click();
			
		}
		
		
				
		}

