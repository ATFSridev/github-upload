package orbitz;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import Automation.BaseClass;
import utilities.TAFUtilities;

public class Orbitzapp {
	
	Properties props;
	Properties Oprops;
	
	WebDriver driver;
	@BeforeMethod
	public void initialize()
	{
		
		File  fsc = new File("D:/NJ/JavaTest/src/Applications/Application.properties");
		File  fscobj = new File("D:/NJ/JavaTest/src/Applications/ObjectRepository.properties");
		FileInputStream Fis = null,Fiso=null;;
		try {
			Fis = new FileInputStream(fsc);
			Fiso = new FileInputStream(fscobj);
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		props = new Properties();
		Oprops= new Properties();
		try {
			props.load(Fis);
			Oprops.load(Fiso);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		String Chpath= props.getProperty("Chromedriverpath");
		System.out.println("Chrome path"+Chpath);
		System.setProperty("webdriver.chrome.driver", Chpath);
		driver = new ChromeDriver();
	}
	
	@Test
	public void applicationtest()
	{
		driver.get(props.getProperty("orbitzURL"));
		driver.manage().window().maximize();
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("Login to the app" );
		Assert.assertTrue(driver.findElement(By.id("header-logo")).isDisplayed());
		System.out.println("Home page displayed");
		if((getElement("OrbitzHeader")).isDisplayed())
		{
			Assert.assertTrue(getElement("OrbitzHeader").isDisplayed(), "Page Loaded Issue");
			System.out.println("Home page displayed");
		}
		
		getElement("homepage.origin").sendKeys("EWR");
		getElement("homepage.destination").sendKeys("LHR");	
		getcalDates("2","3");
		driver.findElement(By.xpath("//button[@id='search-button']")).click();
		try {
			Thread.sleep(7000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		WebDriverWait  wait = new WebDriverWait(driver, 5000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("bCol")));
		System.out.println("Flight Search Results");
	}
	 
	public void getcalDates(String fromdate, String todate)
	{
		
		DateFormat dtformat = new SimpleDateFormat("yyyy/M/d");
		Date dt = new Date();
		String cdate = (dtformat).format(dt);
		String[] arrs=(cdate.split("/"));
		int[] arr=new int[arrs.length];
		for(int i=0;i<arr.length;i++)
		{
			arr[i]=Integer.parseInt(arrs[i]);
		}
		getElement("homepage.caldept").click();
		switch(fromdate)
		{
			case "1":driver.findElement(By.xpath("//table//tr//td//button[@data-year='"+arr[0]+"' and @data-month='"+(arr[1]-1)+"'  and @data-day='"+arr[2]+"']")).click();
				break;
			case "2":driver.findElement(By.xpath("//table//tr//td//button[@data-year='"+arr[0]+"' and @data-month='"+(arr[1])+"'  and @data-day='"+arr[2]+"']")).click();
				break;
			case "3":driver.findElement(By.xpath("//button[@class='datepicker-paging datepicker-next btn-paging btn-secondary next']")).click();
				driver.findElement(By.xpath("//table//tr//td//button[@data-year='"+arr[0]+"' and @data-month='"+((arr[1])+1)+"'  and @data-day='"+arr[2]+"']")).click();
			break;	
		}
		
		getElement("homepage.calcreturn").click();
		switch(todate )
		{
			case "1":driver.findElement(By.xpath("//table//tr//td//button[@data-year='"+arr[0]+"' and @data-month='"+(arr[1]-1)+"'  and @data-day='"+(arr[2]+2)+"']")).click();
				break;
			case "2":driver.findElement(By.xpath("//table//tr//td//button[@data-year='"+arr[0]+"' and @data-month='"+(arr[1])+"'  and @data-day='"+arr[2]+"']")).click();
				break;
			case "3":driver.findElement(By.xpath("//button[@class='datepicker-paging datepicker-next btn-paging btn-secondary next']")).click();
				WebElement ele=driver.findElement(By.xpath("//table//tr//td//button[@data-year='"+arr[0]+"' and @data-month='"+((arr[1])+1)+"'  and @data-day='"+(arr[2])+"']"));
				ele.click();
			break;	
		}
	}
	
	
	public  WebElement getElement(String property)
 	{
		String propertya = getproperty(property);
		WebElement returnproperty=null;
		String[] properties=((String) propertya).split(";");
		String element = properties[1];
		switch (properties[1])
		{
		case "id" :
			returnproperty=driver.findElement(By.id(properties[0]));
			break;
		case "xpath" :
			returnproperty=driver.findElement(By.xpath(properties[0]));
			break;
		 default:	System.out.println("Object Not found");
			
		}
		return returnproperty;
		
	}
	
	public String getproperty(String property)
	{
		return Oprops.getProperty(property);
		
	}
	
	@AfterMethod
	public void closedriver()
	{
		driver.quit();
	}
	

}
