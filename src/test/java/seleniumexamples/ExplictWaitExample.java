package seleniumexamples;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ExplictWaitExample {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "C:\\Ashok\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.get("https://mail.google.com/mail/");
		// saving the GUI element reference into a "element" variable of WebElement type
	driver.findElement(By.name("identifier")).sendKeys("dummy@gmail.com");
	driver.findElement(By.id("identifierNext")).click();
	Thread.sleep(1000);
		// entering password
	driver.findElement(By.id("identifierNext")).sendKeys("password");
		// clicking signin button
	Thread.sleep(1000);
	driver.findElement(By.id("signIn")).click();
		// explicit wait - to wait for the compose button to be click-able
		WebDriverWait wait = new WebDriverWait(driver,30);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(text(),'COMPOSE')]")));
		// click on the compose button as soon as the "compose" button is visible
		driver.findElement(By.xpath("//div[contains(text(),'COMPOSE')]")).click();

	}

}
