package pages; 
import org.openqa.selenium.By;
import org.testng.Assert;

import  Automation.BaseClass;
import utilities.TAFUtilities;;

public class HomePage  {

	
	
	
	public static void enterFlightDetails()
	{
		//BaseClass b = new BaseClass();
		if((TAFUtilities.getElement("OrbitzHeader")).isDisplayed())
		{
			Assert.assertTrue(TAFUtilities.getElement("OrbitzHeader").isDisplayed(), "Page Loaded Issue");
			System.out.println("Home page displayed");
		}
		/*//props.getProperty("OrbitzHeader")
		driver.findElement(By.xpath("//input[@id='package-origin']")).sendKeys("LHR");
		driver.findElement(By.xpath("//input[@id='package-destination']")).sendKeys("EWR");	
		driver.findElement(By.xpath("//input[@id='package-departing']")).click();
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		driver.findElement(By.xpath("//table//tr//td//button[@data-year='2017' and @data-month='5'  and @data-day='17']")).click();
		driver.findElement(By.xpath("//input[@id='package-returning']")).click();
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		driver.findElement(By.xpath("//table//tr//td//button[@data-year='2017' and @data-month='6'  and @data-day='1']")).click();
		driver.findElement(By.xpath("//button[@id='search-button']")).click();
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
		
	}
	
	

}
