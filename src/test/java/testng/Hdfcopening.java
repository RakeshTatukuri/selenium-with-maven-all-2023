package testng;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class Hdfcopening {

	@Test()
	void Alert() throws InterruptedException
	{
		//System.setProperty("webdriver.chrome.driver", "D:\\chromedriver.exe");
		  WebDriver driver = new ChromeDriver();
		  //driver.get("https://netbanking.hdfcbank.com/netbanking/");
		  driver.navigate().to("https://netbanking.hdfcbank.com/netbanking");
		  driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		  driver.switchTo().frame("login_page");
		  //driver.findElement(By.xpath("//a[contains(text(),'CONTINUE')]")).click();
		  driver.findElement(By.linkText("CONTINUE")).click();
		  Alert HdfcAlert=driver.switchTo().alert();
		  // Here we are getting the text message displayed on alert window
		  String actualResult=HdfcAlert.getText();
		  Thread.sleep(1000);
		 // Here we are clicking on OK button on alert window
		  HdfcAlert.accept();//
		  driver.switchTo().defaultContent();// This method will take back to main window mean comes out of the login frame.
		  System.out.println(actualResult);
		  String expectedResult="Customer ID  cannot be left blankfff.";
		 // Assert.assertEquals(actualResult,expectedResult);
		  //Assert.assertEquals(actualResult,expectedResult,"actual result and expected results are not matching");
		 SoftAssert softAssert = new SoftAssert();
		 //softAssert.assertEquals(actualResult, expectedResult);
		 softAssert.assertEquals(actualResult, expectedResult,"Actual and expected are not matching");
		 softAssert.assertAll();
	}
	
}
