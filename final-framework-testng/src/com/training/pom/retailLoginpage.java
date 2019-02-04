package com.training.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class retailLoginpage {
private WebDriver driver; 
String retvalue= null;
	
	public retailLoginpage(WebDriver driver) {
		this.driver = driver; 
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id="input-username")
	private WebElement userName; 
	
	@FindBy(id="input-password")
	private WebElement password;
	
	@FindBy(xpath="//button[@type='submit']")
	private WebElement loginBtn; 
	
	@FindBy(xpath="//h1[contains(text(),'Dashboard')]")
	private WebElement pagetitle; 
	
	
	@FindBy(xpath="//a[@href='http://retail.hommelle.com/account/logout']")    //added 2 lines for logout
	private WebElement logoutbtn; 
	
	public void sendUserName(String userName) {
		this.userName.clear();
		this.userName.sendKeys(userName);
	}
	
	public void sendPassword(String password) {
		this.password.clear(); 
		this.password.sendKeys(password); 
	}
	
	public String clickLoginBtn() {
		this.loginBtn.click();
		retvalue= this.pagetitle.getText();
		return retvalue;	}
	
	public void clickLogoutbtn() {
		this.logoutbtn.click();}
	}
	




