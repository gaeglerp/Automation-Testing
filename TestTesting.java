package seleniumStart;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
//import org.openqa.selenium.By.ByCssSelector;
import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
//import org.openqa.selenium.firefox.FirefoxDriver;
//import org.openqa.selenium.ie.InternetExplorerDriver;

public class TestTesting {
	public static void main(String[] args) throws InterruptedException {
//		WebDriver driver = new FirefoxDriver();
//		WebElement element = driver.findElement(By.id(""));
		
		WebDriver driver;
		
//		FIREFOX 
		
//		System.setProperty("webdriver.gecko.driver", "C:\\Users\\gce\\Desktop\\Coding\\Selenium\\geckodriver.exe");
//		driver = new FirefoxDriver();
		
//		CHROME
		
//		System.setProperty("webdriver.chrome.driver", "C:\\Users\\gce\\Desktop\\Coding\\Selenium\\chromedriver.exe");
		driver = new ChromeDriver();
		
//		IE
		
//		System.setProperty("webdriver.ie.driver","C:\\Users\\gce\\Desktop\\Coding\\Selenium\\IEDriverServer.exe");
//		driver = new InternetExplorerDriver();
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		String baseURL = "http://www.google.com";
		driver.get(baseURL);

		driver.findElement(By.xpath("//*[@id=\"tsf\"]/div[2]/div[1]/div[1]/div/div[2]/input")).sendKeys("cat videos");
		driver.findElement(By.name("btnK")).click();
		Thread.sleep(6000);
		driver.close();
		
	}
}