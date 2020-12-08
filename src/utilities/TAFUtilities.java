package utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import Automation.BaseClass;

public class TAFUtilities  {
	//protected static WebDriver  driver;
	public static Properties  props;
	public static void loadApplicationProperty() throws IOException
   {
		 loadallproperties("D:/NJ/JavaTest/src/Applications/Application.properties");	
   }
   public static void loadObjectProperty() throws IOException
   {		  
	    loadallproperties("D:/NJ/JavaTest/src/Applications/ObjectRepository.properties");
   }
   public static void loadrunProperty() throws IOException
   {	  
	    loadallproperties("D:/NJ/JavaTest/src/Applications/ObjectRepository.properties");
   }

   public static void setBrowser(String BROWSER)
	{
	   loadallproperties("D:/NJ/JavaTest/src/Applications/Application.properties");
	    if (BROWSER.equals("Chrome"))
		{
			String Chpath= props.getProperty("Chromedriverpath");
			System.out.println("Chrome path"+Chpath);
			System.setProperty("webdriver.chrome.driver", Chpath);
			//driver = new ChromeDriver();
		}
		else if (BROWSER.equals("Firefox"))
		{
			//driver = new FirefoxDriver();
		}
	}

	public static void loadallproperties(String Propspath)
	{
		 	File  fsc = new File(Propspath);
			FileInputStream Fis = null;
			try {
				Fis = new FileInputStream(fsc);
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			props = new Properties();
			try {
				props.load(Fis);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	}
	public static WebElement getElement(String property)
	{
		WebElement returnproperty=null;
		String[] properties=((String) property).split(";");
		String element = properties[1];
		switch (element)
		{
		case "id" :
			returnproperty=BaseClass.driver.findElement(By.id(properties[1]));
			break;
		case "xpath" :
			returnproperty=BaseClass.driver.findElement(By.xpath(properties[1]));
			break;
		}
		return returnproperty;
		
	}
	
	
}
