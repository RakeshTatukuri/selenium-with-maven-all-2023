package testng;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataProviderExample {

	  private WebDriver driver;
	  //private String baseUrl;
	  
	  @DataProvider(name = "myTest")
	  public Object[][] createData1() {
	          return new Object[][] {
	            { "India"},
	            { "Brazil"},
	            { "Canada"},
	            { "Sri Lanka"},
	            { "England"},
	            { "United Kingdom"},
	            { "United States"},           
	          };
	  }
	  
	  @BeforeMethod
	  public void setUp() throws Exception {
	    //driver = new FirefoxDriver();
	    //baseUrl = "http://www.wikipedia.org/";
	    
	  }
	 
	  @Test(dataProvider = "myTest")
	  public void testSearchCountry(String country) throws Exception {
		
		System.setProperty("webdriver.chrome.driver", "C:\\Ashok\\chromedriver.exe");
		driver = new ChromeDriver();
	    driver.get("http://www.wikipedia.org/wiki/Main_Page");
	    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	  //  driver.findElement(By.id("searchInput")).clear();
	    driver.findElement(By.id("searchInput")).sendKeys(country);
	    //driver.findElement(By.xpath("//*[@id=\"searchform\"]/div/div/div[1]/input"))
	    Thread.sleep(1000);
	    //driver.findElement(By.id("searchform")).click();
	    driver.findElement(By.xpath("//*[@id=\"searchform\"]/div/button")).click();
	  //*[@id="searchform"]/div/div/div[1]/span/svg
	    Thread.sleep(2000);
	    String actualResult = driver.findElement(By.xpath("//*[@id=\"firstHeading\"]/span")).getText();
	    System.out.println("Actual result Value is : "+actualResult);
	    Assert.assertTrue(country.equals(actualResult.trim()));
	  }
	 
	 @AfterMethod
	  public void tearDown() throws Exception {
	    driver.quit();
}
}
