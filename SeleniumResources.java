package seleniumStart;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SeleniumResources {
	WebDriver driver;

	public SeleniumResources(WebDriver driver) {
		this.driver = driver;
	}
	
	
	
	public WebElement getElement(String locator, String type) {
		type = type.toLowerCase();
		WebElement element = null;
		
		if (type.equals("id")) {
			element = this.driver.findElement(By.id(locator));}
		
		else if (type.equals("name")) {
			element = this.driver.findElement(By.name(locator));}
		
		else if (type.equals("xpath")) {
			element = this.driver.findElement(By.xpath(locator));}
		
		else if (type.equals("css")) {
			element = this.driver.findElement(By.cssSelector(locator));}
		
		else if (type.equals("linktext")) {
			element = this.driver.findElement(By.linkText(locator));}
		
		else if (type.equals("partiallinktext")) {
			element = this.driver.findElement(By.partialLinkText(locator));}
		
		else if (type.equals("classname")) {
			element = this.driver.findElement(By.className(locator));}
		
		else if (type.equals("tagname")) {
			element = this.driver.findElement(By.tagName(type));}
		
		else {System.out.println("Locator type not supported");}
		
		System.out.println("Element found with " + type + ": " + locator);
		
		return element;
	}
	
	
	
	public List<WebElement> getElementList(String locator, String type) {
		type = type.toLowerCase();
		List<WebElement> elementList = new ArrayList<WebElement>();
		
		if (type.equals("id"))
			elementList = this.driver.findElements(By.id(locator));
		
		else if (type.equals("name"))
			elementList = this.driver.findElements(By.name(locator));
		
		else if (type.equals("xpath"))
			elementList = this.driver.findElements(By.xpath(locator));
		
		else if (type.equals("css"))
			elementList = this.driver.findElements(By.cssSelector(locator));
		
		else if (type.equals("classname"))
			elementList = this.driver.findElements(By.className(locator));
		
		else if (type.equals("tagname"))
			elementList = this.driver.findElements(By.tagName(locator));
		
		else if (type.equals("linktext"))
			elementList = this.driver.findElements(By.linkText(locator));
		
		else if (type.equals("partiallinktext"))
			elementList = this.driver.findElements(By.partialLinkText(locator));
		
		else System.out.println("Locator type not supported");
		
		if (elementList.isEmpty())
			System.out.println("Element not found with " + type +": " + locator);
		else System.out.println("Element found with " + type +": " + locator);
		
		return elementList;
	}
	
	
	
	public boolean isElementPresent(String locator, String type) {
		return getElementList(locator, type).size() > 0;
	}
	
	
	
	public WebElement waitElement(By locator, int timeout) {
		WebElement element = null;
		try {element = new WebDriverWait(driver, timeout).until(ExpectedConditions.visibilityOfElementLocated(locator));}
		catch (Exception e) {System.out.println("no. wait fail.");}
		return element;
	}
	
	
	
	public void waitClick(By locator, int timeout) {
		WebElement element = null;
		try {element = new WebDriverWait(driver, timeout).until(ExpectedConditions.elementToBeClickable(locator));
			element.click();}
		catch(Exception e) {System.out.println("no. wait click fail.");}
	}
}