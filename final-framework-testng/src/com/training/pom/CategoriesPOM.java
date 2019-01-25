package com.training.pom;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

import org.openqa.selenium.Alert;

public class CategoriesPOM {
	private WebDriver driver; 
	private Alert alrt;
	boolean bValue = false;
	String mesg = null;
	
	public CategoriesPOM(WebDriver driver) {
		this.driver = driver; 
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//input[@type='checkbox']")
	private List<WebElement> categorylist; 
	
	//@FindBy(xpath="//tbody//tr[3]//td[1]//input[@value='512']")
	//private WebElement categoryselect; 
	
	@FindBy(xpath="//button[@type='button']")
	private WebElement deletebutton; 
	
	@FindBy(xpath="//div[@class='alert alert-success']")
	private WebElement msg; 
	
	public void selectchkbox() throws InterruptedException
	{
		this.categorylist.get(6).click();
	}
		
	
	public String deleteselectchkbox() throws InterruptedException{
		bValue=categorylist.get(6).isSelected();
		if (bValue = true)
		{
			deletebutton.click();
			Thread.sleep(5000);
			alrt = driver.switchTo().alert();
			Thread.sleep(5000);
			alrt.accept(); //to click on OK button
			mesg = msg.getText();
			driver.switchTo().defaultContent();
			
		}
		return mesg;  
	}
	
	}
	
	

