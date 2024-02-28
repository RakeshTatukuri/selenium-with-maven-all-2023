package testngexamples;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class SearchEmployeeExample {
	//System.setProperty("webdriver.chrome.driver", "C:\\Ashok\\chromedriver.exe");
	WebDriver driver=new ChromeDriver();
	//driver=new ChromeDriver();
	void search(String userName)
	{
		
		driver.findElement(By.xpath("//*[@id='app']/div[1]/div[2]/div[2]/div/div[1]/div[2]/form/div[1]/div/div[1]/div/div[2]/input")).sendKeys(userName);
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		String actualResult=driver.findElement(By.xpath("//*[@id='app']/div[1]/div[2]/div[2]/div/div[2]/div[3]/div/div/div/div/div/div[2]/div[1]/div/div[2]")).getText();
		String expectedResult="Admin";
		SoftAssert softassert=new SoftAssert();
		softassert.assertEquals(actualResult,expectedResult);
	}
	void search(int index)
		{

			WebElement element=driver.findElement(By.xpath("//*[@id='app']/div[1]/div[2]/div[2]/div/div[1]/div[2]/form/div[1]/div/div[2]/div/div[2]/div/div/div[1]"));
			Select select=new Select(element);
			select.selectByIndex(index);
		}	
	@BeforeMethod()
	void login() throws InterruptedException
	{

		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		driver.findElement(By.name("username")).sendKeys("Admin");
		driver.findElement(By.name("password")).sendKeys("admin123");
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		Thread.sleep(1000);
		driver.findElement(By.linkText("Admin")).click();
	}
		
	void search(String userName,String empName)
	{
		driver.findElement(By.xpath("//*[@id='app']/div[1]/div[2]/div[2]/div/div[1]/div[2]/form/div[1]/div/div[1]/div/div[2]/input")).sendKeys(userName);
		driver.findElement(By.xpath("//*[@id='app']/div[1]/div[2]/div[2]/div/div[1]/div[2]/form/div[1]/div/div[3]/div/div[2]/div/div/input")).sendKeys(empName);
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		String expectedEmpName="Paul Collings";
		String actEmpName=driver.findElement(By.xpath("//*[@id='app']/div[1]/div[2]/div[2]/div/div[2]/div[3]/div/div/div/div/div/div[1]/div[1]/div/div/div[2]")).getText();
	SoftAssert softassert=new SoftAssert();
	softassert.assertEquals(actEmpName,expectedEmpName);
	}

	@Test()
	void searchwithUserName()
	{
		search("Admin");
	
	}
	@Test()
	void searchUserRole()
	{
		search(1);
	}
	@Test()
	void searchEmpNameAndUserName()
	{
		search("Admin", "Paul Collings");
	}
	@AfterMethod
	void logout()
	{
		driver.findElement(By.linkText("Logout")).click();
	}
}
