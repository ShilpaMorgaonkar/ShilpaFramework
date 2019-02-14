package com.training.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RetailhomeUserPOM {
	private WebDriver driver; 
	String retvalue= null;
		
		public RetailhomeUserPOM(WebDriver driver) {
			this.driver = driver; 
			PageFactory.initElements(driver, this);
		}
		
		@FindBy(xpath="//span[contains(text(),'Shop Now')]")
		private WebElement shopnow; 
		
		@FindBy(xpath="//span[contains(text(),'Ethnic')]")
		private WebElement shopnowehhnic; 
		
		@FindBy(xpath="//a[contains(text(),'Integer vitae iaculis massa')]")
		private WebElement selectethnicproduct;
		
		@FindBy(xpath="//div[@class='clear2 clear3 clear4 clear5 clear6 clear7 clear8 clear9 clear10 clear11 clear12 tb_size_3_last tb_size_4_last tb_size_5_last tb_size_6_last tb_size_7_last tb_size_8_last tb_size_9_last tb_size_10_last tb_size_11_last tb_size_12_last']//a[@class='btn btn-plain btn-sm tb_icon_16 fa-search']")
		private WebElement quickview;
		
		@FindBy(xpath="//button[contains(text(),'Add to Cart')]")
		private WebElement addtocartbtn;
		
		@FindBy(xpath="//ul[@class='noty_cont noty_layout_topRight']")
		private WebElement closeaddtocardmsg;
		
		@FindBy(xpath="//a[@class='close']")
		private WebElement closebox;
		
		@FindBy(xpath="//i[@class='tb_icon ico-linea-ecommerce-bag']")
		private WebElement shopingcarticon;
		
		@FindBy(xpath="//div[@class='col_M4SE9 col col-xs-12 col-sm-6 col-md-6 col-lg-6 col-valign-top']")
		private WebElement frame2;
		
		@FindBy(xpath="//iframe[@scrolling='none']")
		private WebElement frame1;
		
		@FindBy(xpath="//a[@class='btn btn-primary']")
		private WebElement checkoutbtn;
		
		
		public void moveshopnowicon()
		{
			Actions action = new Actions(driver);
			//action.moveToElement(shopnow).release();
			action.clickAndHold(shopnow).build().perform();
			
			action.moveToElement(shopnow).release();
			this.shopnowehhnic.click();
		}

		public void movetoquickmove()
		{
			Actions action = new Actions(driver);
			action.clickAndHold(selectethnicproduct).build().perform();
			this.quickview.click();
			action.moveToElement(selectethnicproduct).release();
			
		}
		
		public void addtocard()
		{
			
			driver.switchTo().frame(frame1);
			this.addtocartbtn.click();		
			driver.switchTo().defaultContent();
			this.closebox.click();
		}
		
		public void shoppingcart()
		{
			Actions action = new Actions(driver);
			action.moveToElement(shopingcarticon).click().perform();
			this.checkoutbtn.click();
		}
}

