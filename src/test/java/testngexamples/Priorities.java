package testngexamples;

import org.testng.annotations.Test;

public class Priorities {
	
	@Test(priority=0)
	void openBrowser()
	{
		System.out.println("Code to open the browser");
	}
	@Test(priority=1)
	void registerAnAccount()
	{
		System.out.println("Registration of account code");
	}
	@Test(priority=1)
	void login()
	{
		System.out.println("Login code1");
	}
	@Test(priority=3)
	void sendEmail()
	{
		System.out.println("Send email code");
	}
}
