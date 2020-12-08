package Automation;

import java.io.File;
import utilities.TAFUtilities;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class BaseClass {
	public static WebDriver  driver;
	//public static  vProperties  props;
	@BeforeSuite
	public void initialize() throws IOException
	{
		TAFUtilities.loadApplicationProperty();
		TAFUtilities.loadObjectProperty();
		TAFUtilities.loadrunProperty();
		setBrowser("Chrome");
		//driver = new FirefoxDriver();
	}
	   
	@BeforeMethod
	public void navigatetoURL(String url) throws IOException
	{
		
		    String applicationurl=TAFUtilities.props.getProperty("orbitzURL");
			driver.get(applicationurl);
			driver.manage().window().maximize();
			try {
				Thread.sleep(5000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		System.out.println("Before methd Login to the app" );
	}
	@AfterSuite
	public void QuitDriver()
	{
		driver.quit();
	}
	
	public static void setBrowser(String BROWSER)
	{
	   TAFUtilities.loadallproperties("D:/NJ/JavaTest/src/Applications/Application.properties");
	    if (BROWSER.equals("Chrome"))
		{
			String Chpath= TAFUtilities.props.getProperty("Chromedriverpath");
			System.out.println("Chrome path"+Chpath);
			System.setProperty("webdriver.chrome.driver", Chpath);
			driver = new ChromeDriver();
		}
		else if (BROWSER.equals("Firefox"))
		{
			driver = new FirefoxDriver();
		}
	}

	
	//@Test
	public void print() throws InterruptedException, IOException
	{
		 System.out.println("Hi"); 

		driver.get("https://www.orbitz.com/");
		driver.manage().window().maximize();
		Thread.sleep(5000);
		driver.quit();
		
	}
}