package seleniumexamples;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class HrmLogin {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "C:\\Ashok\\chromedriver.exe");
		ChromeDriver driver=new ChromeDriver();
		//driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		driver.navigate().to("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		Thread.sleep(1000);
		//driver.navigate().forward();
		//driver.navigate().back();
		//driver.navigate().refresh();
		driver.manage().window().maximize();
		driver.findElement(By.name("username")).sendKeys("Admin");
		driver.findElement(By.name("password")).sendKeys("admin123");
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		driver.close();
		
	}

}
