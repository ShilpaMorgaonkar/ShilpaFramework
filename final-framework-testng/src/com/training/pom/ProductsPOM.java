package com.training.pom;
import java.util.List;
import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;


public class ProductsPOM {
	    private WebDriver driver;
		private Alert alrt;
		boolean bValue = false;
		String mesgretvalue =null;
		String editmsgvalue=null;
		String multidelmesgretvalue = null;
			
		
		public ProductsPOM(WebDriver driver) {
			this.driver = driver; 
			PageFactory.initElements(driver, this);
		}
		
		@FindBy(xpath="//input[@type='checkbox']")
		private List<WebElement> prodlist; 
				
		@FindBy(xpath="//button[@type='button']")
		private WebElement deletebutton; 
		
		@FindBy(xpath="//i[@class='fa fa-plus']")
		private WebElement addbutton; 
		
		@FindBy(xpath="//tbody//tr[1]//td[8]//a[1]")
		private WebElement editbutton; 
		
		@FindBy(xpath="//div[@class='alert alert-success']")
		private WebElement msg;
		
		@FindBy(id="input-name")
		private WebElement productname;
		
		@FindBy(id="input-price")
		private WebElement productprise;
		
		@FindBy(id="button-filter")
		private WebElement filterbutton;
					
		@FindBy(xpath="//tbody//tr[1]//td[3]")
		private WebElement selectedprodname;
		
		@FindBy(xpath="//tbody//tr[1]//td[5]")
		private WebElement selectedprodprice;
		
		@FindBy(xpath="//td[contains(text(),'SKU-003')]")
		private WebElement selectedprodmodel;
		
		@FindBy(xpath="//tbody//tr[1]//td[6]")
		private WebElement selectedprodquantity;
		
		@FindBy(xpath="//tbody//tr[1]//td[7]")
		private WebElement selectedprodstatus;
		
		@FindBy(xpath="//tbody//tr//td[2]")
		private WebElement selectedprodimage;
		
		@FindBy(xpath="//input[@placeholder='Model']")    //added web element for medium level cases
		private WebElement producttmodel;
		
		@FindBy(xpath="//input[@id='input-quantity']")    //added web element for medium level cases
		private WebElement productquantity;
		
		@FindBy(xpath="//select[@id='input-status']")     //added web element for medium level cases
		private WebElement productstatus; 
		
		@FindBy(xpath="//select[@id='input-image']")     //added web element for medium level cases
		private WebElement productimage; 
		
		@FindBy(xpath="//td[contains(text(),'Shilpa-Edit case test data')]//preceding-sibling::td[2]")     //added web element for medium level cases
		private WebElement chosesproductchkbox; 
		
		@FindBy(xpath="//td[contains(text(),'Shilpa-Edit case test data')]//following-sibling::td[5]//a[1]")     //added web element for medium level cases
		private WebElement chosesproducteditbtn; 
		
		public void selectprodchkbox() throws InterruptedException
		{
		this.prodlist.get(2).click();
		
		}
		
		public void addnewprod() 
		{
		this.addbutton.click();
		}
		
		public void editprodchkbox() throws InterruptedException
		{
		this.prodlist.get(1).click();
		boolean cValue=prodlist.get(1).isSelected();
		if (cValue = true)
		{
			this.editbutton.click();
		}
		}
		public void editselectedproduct() 
		{
			this.chosesproductchkbox.click();
			this.chosesproducteditbtn.click();
			
		}
		
		public void selectmultipleprodchkbox() throws InterruptedException
		{
		this.prodlist.get(1).click();
		this.prodlist.get(2).click();
		}
		
		public String delectmultipleprodchkbox() 
		{
		boolean dValue=prodlist.get(1).isSelected();
		boolean eValue=prodlist.get(2).isSelected();
		if ((dValue = true) && (eValue= true) )
			{
				deletebutton.click();
				alrt = driver.switchTo().alert();
				alrt.accept(); //to click on OK button
				multidelmesgretvalue= msg.getText();
				driver.switchTo().defaultContent();
			}  
			
			return multidelmesgretvalue;
			
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
		
		
		public void sendproductmodel(String Productmodel) {
			this.producttmodel.clear(); 
			this.producttmodel.sendKeys(Productmodel); 
		}
		
		public void sendproductquantity(String Productquantity) {
			this.productquantity.clear(); 
			this.productquantity.sendKeys(Productquantity);
			
		}
		
		public void selectstatus() {
			this.productstatus.click(); 
			Select sts = new Select(productstatus);
			sts.selectByVisibleText("Enabled");
			
		}
		
		public void selectimage() {
			this.productimage.click(); 
			Select img = new Select(productimage);
			img.selectByVisibleText("Enabled");
			
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
		
		public String clickModelFilterBtn() {
			this.filterbutton.click(); 
			String modelofproduct = selectedprodmodel.getText();
			return modelofproduct;
		}
		
		public String clickquantityFilterBtn() {
			this.filterbutton.click(); 
			String modelofproduct = selectedprodquantity.getText();
			return modelofproduct;
		}
		
		public String clickstatusFilterBtn() {
			this.filterbutton.click(); 
			String statusofproduct = selectedprodstatus.getText();
			return statusofproduct;
		}
		
		public void clickimageFilterBtn() {
			this.filterbutton.click(); 
			
		}
		
		public String returneditproductmessage() {
			editmsgvalue= msg.getText();
			return editmsgvalue;
			
		}
		public String returnaddproductmessage() {
			editmsgvalue= msg.getText();
			return editmsgvalue;
			
		}
}
