package com.training.pom;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class CheckoutPOM {
	private WebDriver driver; 
	String retvalue= null;
		
		public CheckoutPOM(WebDriver driver) {
			this.driver = driver; 
			PageFactory.initElements(driver, this);
		}
		
		@FindBy(xpath="//input[@id='input-email']")
		private WebElement email; 
		
		@FindBy(xpath="//input[@id='input-password']")
		private WebElement password; 
		
		@FindBy(xpath="//input[@id='button-login']")
		private WebElement loginbtn; 
		
		@FindBy(xpath="//input[@value='new']")
		private WebElement newaddradiobtn; 
		
		@FindBy(xpath="//input[@id='input-payment-firstname']")
		private WebElement name; 
		
		@FindBy(xpath="//input[@id='input-shipping-firstname']")
		private WebElement shipname; 
		
		@FindBy(xpath="//input[@id='input-payment-lastname']")
		private WebElement surname;
		
		@FindBy(xpath="//input[@id='input-shipping-lastname']")
		private WebElement shipsurname;
		
		@FindBy(xpath="//input[@id='input-payment-address-1']")
		private WebElement addressone;
		
		@FindBy(xpath="//input[@id='input-shipping-address-1']")
		private WebElement shipaddressone;
		
		@FindBy(xpath="//input[@id='input-payment-city']")
		private WebElement inpcity; 	
		
		@FindBy(xpath="//input[@id='input-shipping-city']")
		private WebElement shipinpcity; 
		
		@FindBy(xpath="//input[@id='input-payment-postcode']")
		private WebElement postalcode; 
		
		@FindBy(xpath="//input[@id='input-shipping-postcode']")
		private WebElement shippostalcode; 
		
		@FindBy(xpath="//select[@id='input-payment-country']")
		private WebElement selectcountry; 
		
		@FindBy(xpath="//select[@id='input-shipping-country']")
		private WebElement shipselectcountry; 
		
		@FindBy(xpath="//select[@id='input-payment-zone']")
		private WebElement selectstate; 
		
		@FindBy(xpath="//select[@id='input-shipping-zone']")
		private WebElement shipselectstate; 
		
		
		@FindBy(xpath="//input[@id='button-payment-address']")
		private WebElement continuebtn; 
		
		@FindBy(xpath="//input[@id='button-shipping-address']")
		private WebElement shipcontinuebtn; 
		
		@FindBy(xpath="//*[@id=\"button-shipping-address\"]")
		private WebElement continuebtn3;
		
		@FindBy(xpath="//input[@id='button-shipping-method']")
		private WebElement shipmethodcontinuebtn; 
		
		@FindBy(xpath="//input[@id='button-payment-method']")
		private WebElement continueafterchkbox; 
		
		@FindBy(xpath="//textarea[@name='comment']")
		private WebElement inptextarea; 
		
		@FindBy(xpath="//input[@value='1']")
		private WebElement termschkbox; 
		
		@FindBy(xpath="//input[@value='Confirm Order']")
		private WebElement confirmorderbtn; 
		
		@FindBy(xpath="//p[contains(text(),'Your order has been successfully processed!')]")
		private WebElement confirmordermsg; 
        
        @FindBy(xpath="//div[@id='collapse-shipping-address']//div[@class='panel-body']//div[3]//label[1]//input[1]")
        private WebElement shipnewaddressradio; 
        
        @FindBy(xpath="//div[@class='radio']")
        private List<WebElement> radiobtnlist; 
        
        
		public void sendemail(String emailid)
		{
			this.email.clear();
			this.email.sendKeys(emailid);
		}
		
		public void sendpassword(String password)
		{
			this.password.clear();
			this.password.sendKeys(password);
		}
		
		public void clicklogin()
		{
			this.loginbtn.click();
		}
		
		public void selectnewaddress()
		{
			this.newaddradiobtn.click();		
		}
		
		public void sendfirstname(String fstname)
		{
			this.name.clear();
			this.name.sendKeys(fstname);
		}
		
		public void sendlastname(String lastname)
		{
			this.surname.clear();
			this.surname.sendKeys(lastname);
		}
		
		public void sendaddone(String addone)
		{
			this.addressone.clear();
			this.addressone.sendKeys(addone);
		}
		
		public void sendacity(String city)
		{
			this.inpcity.clear();
			this.inpcity.sendKeys(city);
		}
		
		public void sendpost(String post)
		{
			this.postalcode.clear();
			this.postalcode.sendKeys(post);
		}
		
		public void selectcountry(String country)
		{
			Select s = new Select(selectcountry);
			s.selectByVisibleText(country);
			
		}
		
		public void selectstate(String state)
		{
			Select s = new Select(selectstate);
			s.selectByVisibleText(state);
			
		}
		
		public void clickcontinuebtn()
		{
			
			this.continuebtn.click();
		}
		
		public void shipclicknewadd()
		{
			this.radiobtnlist.size();
			this.radiobtnlist.get(2).click();
		}
		
		public void shipsendfirstname(String fstname)
		{
			this.shipname.clear();
			this.shipname.sendKeys(fstname);
		}
		
		public void shipsendlastname(String lastname)
		{
			this.shipsurname.clear();
			this.shipsurname.sendKeys(lastname);
		}
		
		public void shipsendaddone(String addone)
		{
			this.shipaddressone.clear();
			this.shipaddressone.sendKeys(addone);
		}
		
		public void shipsendacity(String city)
		{
			this.shipinpcity.clear();
			this.shipinpcity.sendKeys(city);
		}
		
		public void shipsendpost(String post)
		{
			this.shippostalcode.clear();
			this.shippostalcode.sendKeys(post);
		}
		
		public void shipselectcountry(String country)
		{
			Select s = new Select(shipselectcountry);
			s.selectByVisibleText(country);
			
		}
		
		public void shipselectstate(String state)
		{
			Select s = new Select(shipselectstate);
			s.selectByVisibleText(state);
			
		}
		
		public void shipclickcontinuebtn()
		{
			//this.shipcontinuebtn.click();
			this.continuebtn3.click();
		}
		
		public void sendinptestarea(String textarea)
		{
			this.inptextarea.clear();
			this.inptextarea.sendKeys(textarea);
		}
		
		public void shipmethodclickcontinuebtn()
		{
			this.shipmethodcontinuebtn.click();
			
		}
		
		public void termsncond() 
		{
			
			this.termschkbox.click();
		}
		
		public void continueaftertermsncond() 
		{
			
			this.continueafterchkbox.click();
		}
		
		public void confirmorderbtnclick() 
		{
			
			this.confirmorderbtn.click();
		}
		
		public String  confirmordermessage() 
		{
			
			return this.confirmordermsg.getText();
		}
		
		
		
		 
		

}
