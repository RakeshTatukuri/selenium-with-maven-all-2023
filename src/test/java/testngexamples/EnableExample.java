package testngexamples;

import org.testng.annotations.Test;

public class EnableExample {
@Test(enabled=false)
void testCase1()
{
	System.out.println("In test case 1");
}
@Test()
void testCase2()
{
	System.out.println("Inside case 2 ");
}
}
