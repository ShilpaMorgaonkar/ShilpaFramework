package com.training.pom;
import java.util.List;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class ProductsPOM {
	    private WebDriver driver;
		private Alert alrt;
		boolean bValue = false;
		String mesgretvalue =null;
			
		
		public ProductsPOM(WebDriver driver) {
			this.driver = driver; 
			PageFactory.initElements(driver, this);
		}
		
		@FindBy(xpath="//input[@type='checkbox']")
		private List<WebElement> prodlist; 
		
		//@FindBy(xpath="//tbody//tr[3]//td[1]//input[@value='726']")
		//private WebElement prodselect; 
		
		@FindBy(xpath="//button[@type='button']")
		private WebElement deletebutton; 
		
		@FindBy(xpath="//div[@class='alert alert-success']")
		private WebElement msg;
		
		@FindBy(id="input-name")
		private WebElement productname;
		
		@FindBy(id="input-price")
		private WebElement productprise;
		
		@FindBy(id="button-filter")
		private WebElement filterbutton;
		
		@FindBy(xpath="//tbody//tr[1]//td[3][contains(text(),'Diamond ring')]")
		private WebElement selectedprodname;
		
		@FindBy(xpath="//tbody//tr[1]//td[5]")
		private WebElement selectedprodprice;
		
		public void selectprodchkbox() throws InterruptedException
		{
		this.prodlist.get(2).click();
		Thread.sleep(5000);
		}
		
		
		public String deleteselectproduct() throws InterruptedException{
		bValue=prodlist.get(2).isSelected();
		if (bValue = true)
		{
			deletebutton.click();
			Thread.sleep(5000);
			alrt = driver.switchTo().alert();
			Thread.sleep(5000);
			alrt.accept(); //to click on OK button
			mesgretvalue= msg.getText();
			driver.switchTo().defaultContent();
		}  
		
		    return mesgretvalue;
		}
		
		public void sendproductname(String ProductName) {
			this.productname.clear();
			this.productname.sendKeys(ProductName);
		}
		
		public void sendproductprise(String ProductPrise) {
			this.productprise.clear(); 
			this.productprise.sendKeys(ProductPrise); 
		}
		
		public String clickNameFilterBtn() {
			this.filterbutton.click(); 
			String nameofproduct = selectedprodname.getText();
			return nameofproduct;
		}
		
		public String clickPriceFilterBtn() {
			this.filterbutton.click(); 
			String priceofproduct = selectedprodprice.getText();
			return priceofproduct;
		}
}
