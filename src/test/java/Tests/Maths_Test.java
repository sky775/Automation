package Tests;

import java.util.Arrays;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class Maths_Test {

	@Test(enabled=false)
	public void addition()
	{
		System.out.print("In Addition");
	}
	@Parameters({"URL"})
	@Test(groups={"smoke"}, dependsOnMethods= {"division"})
	public void substraction(String urlname)
	{
		
		System.out.println("In Substraction");
		System.out.println(urlname);
	}
	@Test
	public void division()
	{
		System.out.print("In division");
	}
		@Test(groups="smoke",dataProvider="getData")
		public void multiplication(String a, String b)
		{
			System.out.print("In multiplication");
			System.out.print(a);
			System.out.print(b);

		}
		@DataProvider
		public String[][] getData()
		{
			String[][] data = new String[3][2];
			data[0][1]= "username";
			data[1][1]= "username";
			return data;
		}
	}

