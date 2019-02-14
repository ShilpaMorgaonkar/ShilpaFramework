package com.training.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrderInformationPOM {
	private WebDriver driver; 
	String retvalue= null;
	
	public OrderInformationPOM(WebDriver driver) {
		this.driver = driver; 
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//tbody//tr[1]//td[6]//a[2]//i[1]")
	private WebElement returnorderbtn; 
	
	public void clickreturnorderbtn() {
		this.returnorderbtn.click();
		}

}
