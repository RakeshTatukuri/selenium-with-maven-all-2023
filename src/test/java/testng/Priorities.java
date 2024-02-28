package testng;

import org.testng.annotations.Test;

public class Priorities {
	@Test(priority=1)
	void login()
	{
		System.out.println("Login code");
	}
	@Test(priority=0)
	void registerAccount()
	{
		System.out.println("Register account code");
	}
	@Test(priority=2)
	void sendEmail()
	{
		System.out.println("Send email code");
	}

}
