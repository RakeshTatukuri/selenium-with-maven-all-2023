package testngexamples;

import org.testng.annotations.Test;

public class TestNgPrioritites {

	@Test(priority=0)
	void openBrowser()
	{
		System.out.println("Open browser code");
	}
	@Test(priority=1)
	void registerAccount()
	{
		System.out.println("Registration of account");
	}
	@Test(priority=2)
	void login()
	{
		System.out.println("Login code");
	}
	@Test(priority=3)
	void sendAnEmail()
	{
		System.out.println("Send email code");
	}
	@Test(priority=4)
	void logOut()
	{
		System.out.println("Logout code");
	}
}
