package seleniumStart;

import java.util.List;
import java.util.concurrent.TimeUnit;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class JUnitStart {
	
	private WebDriver driver;
	private String baseURL;
	private SeleniumResources gs;
	private String search = "16 binary";
	WebElement searchBar;
	WebElement searchButton;
	List<WebElement> searchResults;
	String testName;
	
	

//	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		System.out.println("Before class... is empty.");
	}

	
	
//	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		System.out.println("After class... is empty.");
	}
	
	

	@Before
	public void setUp() throws Exception {
//		System.out.println("Before...");
		
		System.out.println("Initializing the driver...");
		driver = new ChromeDriver();
		gs = new SeleniumResources(driver);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		System.out.println("Done!");
		
		driver.manage().window().maximize();
		System.out.println("Window maximized.");
	}
	
	

	@After
	public void tearDown() throws Exception {
//		System.out.println("After...");
		System.out.println(testName + " test complete!");
		driver.close();
		System.out.println("Driver closed.");
	}
	
	
	
	@Test
	public void google() throws Exception {
		System.out.println("Testing Google...");
		testName = "Google";
		
		baseURL = "http://www.google.com";
		driver.get(baseURL);
		
		searchBar = gs.getElement("q", "name");
		searchButton = gs.getElement("btnK", "name");
		
		searchBar.sendKeys(search);
		searchMessage();
		searchButton.click();
		
		searchResults = gs.getElementList("LC20lb", "classname");
		System.out.println("Number of elements: " + searchResults.size());
		googleSearchList(searchResults);
	}
	
	
	
	@Test
	public void wolfram() throws Exception {
		System.out.println("Testing Wolfram...");
		testName = "Wolfram";
		
		baseURL = "https://www.wolframalpha.com/";
		driver.get(baseURL);
		
		searchBar = gs.getElement("._3mX7MD-u", "css");
		searchButton = gs.getElement("button._2HkkNXzH:nth-child(2)", "css");
		
		searchBar.sendKeys(search);
		searchMessage();
		searchButton.click();
		
		Thread.sleep(3000);
		searchResults = gs.getElementList("//img[@class='ZbCdqua6']", "xpath");
		System.out.println("Number of Elements: " + searchResults.size());
		wolframList(searchResults);
	}
	
	
	
	private void searchMessage() {
		System.out.println("Searching for '" + search + "'");
	}
	private void googleSearchList(List<WebElement> searchResults) {
		int peopleAlsoAsk = 0;
		for (int i = 0;i < searchResults.size();i++) {
			if ("".equals(searchResults.get(i).getText())) {
				peopleAlsoAsk++;
				System.out.println(i + 1 + ". Related result " + peopleAlsoAsk);
				continue;
			}
			System.out.println(i + 1 + ". " + searchResults.get(i).getText());
		}
	}
	private void wolframList(List<WebElement> searchResults) {
		
		for (int i = 0;i<searchResults.size();i++) {
			System.out.println(i + 1 + ". " + searchResults.get(i).getAttribute("alt"));
		}
	}
}