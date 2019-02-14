package com.training.pom;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class UserloginretailPOM {
	private WebDriver driver; 
	String retvalue= null;
		
	public UserloginretailPOM(WebDriver driver) {
		this.driver = driver; 
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//i[@class='fa fa-user-o']")
	private WebElement Usericon;		
	
	@FindBy(xpath="/span[contains(text(),'LOGIN / REGISTER')]")
	private WebElement loginicon;
				
	@FindBy(id="input-email")
	private WebElement userName; 
	
	@FindBy(id="input-password")
	private WebElement password;
	
	@FindBy(xpath="//input[@value='Login']")
	private WebElement loginBtn; 
	
	@FindBy(xpath="/span[contains(text(),'MY ORDERS')]")
	private WebElement myordericon; 
	
	@FindBy(xpath="//a[@title='View']")
	private WebElement viewordericon; 
	
	@FindBy(xpath="//h1[contains(text(),'Dashboard')]")
	private WebElement pagetitle; 
	
	
	
	public void sendUserName(String userName) {
		this.userName.clear();
		this.userName.sendKeys(userName);
	}
	
	public void sendPassword(String password) {
		this.password.clear(); 
		this.password.sendKeys(password); 
	}
	
	public void clickLoginBtn() {
		this.loginBtn.click();
			}
	
	
	}
	




