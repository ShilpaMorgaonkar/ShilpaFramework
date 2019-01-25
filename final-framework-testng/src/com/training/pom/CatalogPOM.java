package com.training.pom;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class CatalogPOM {
private WebDriver driver; 
String actual= null;
	
	public CatalogPOM(WebDriver driver) {
		this.driver = driver; 
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//body/div[@id='container']/nav[@id='column-left']/ul[@id='menu']/li[@id='menu-catalog']/a[1]")
	private WebElement catlogmenu; 
	
	@FindBy(xpath="//a[contains(text(),'Categories')]")
	private WebElement catagories; 
	
	@FindBy(xpath="//a[text()='Products']")
	private WebElement products; 
	
	@FindBy(xpath="//h1[contains(text(),'Categories')]")
	private WebElement catepagetitle; 
	
	public void movecatalog()
	{
		Actions action = new Actions(driver);
		action.moveToElement(catlogmenu).click().perform();
		}
	
	public String clickcatagories() {
		this.catagories.click();
		actual = catepagetitle.getText();
		return actual;
	}
	
	public void clickproducts() {
		this.products.click();
	}
		
}
