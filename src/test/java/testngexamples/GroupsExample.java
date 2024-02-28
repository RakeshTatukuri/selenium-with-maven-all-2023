package testngexamples;

import org.testng.annotations.Test;

public class GroupsExample {

	@Test(groups="regression")
	void testCase1()
	{
		System.out.println("Inside test case one and in regression");
	}
	@Test(groups={"regression", "smoke"})
	void testCase2()
	{
		System.out.println("In both regression and smoke testing");
	}
}
