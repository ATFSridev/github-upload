package com.comcast.Regression;

import org.testng.annotations.Test;

import Automation.BaseClass;
import pages.HomePage;

public class Testcaseex extends BaseClass{
	
	//@Test
	public void TestHomepage()
	{
		
			//HomePage.navigatetoURL("https://www.orbitz.com/");
	}	
	
	@Test
	public void flightSearch()
	{
		//HomePage.navigatetoURL("https://www.orbitz.com/");
		HomePage.enterFlightDetails();
		
	}
}


