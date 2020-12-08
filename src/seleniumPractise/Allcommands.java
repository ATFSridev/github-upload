package seleniumPractise;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.Properties;
import java.util.concurrent.TimeUnit;


import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.Test;

public class Allcommands {
	WebDriver driver;
	@Test
	public void testapp() throws IOException
	{
	WebDriver driver;
	Properties props;
	
	File fs = new File("D:/NJ/JavaTest/src/Applications/Application.properties");
	FileInputStream fis = new FileInputStream(fs);
	props=new Properties();
	props.load(fis);
	String chpath=props.getProperty("Chromedriverpath");
	System.out.println("hChrome pat" + chpath);
	System.setProperty("webdriver.chrome.driver", chpath);
	driver=new ChromeDriver();
	
	driver.get("https://www.facebook.com/");
	driver.manage().window().maximize();
	//driver.manage().timeouts().implicitlyWait(5000, TimeUnit.SECONDS);
	
	
	//Enter details
	driver.findElement(By.id("email")).sendKeys("testofb.sridev@gmail.com");
	driver.findElement(By.id("pass")).sendKeys("ss");
	WebElement ele=driver.findElement(By.xpath("//select[@id='month']"));
	
	Select sel =new Select(ele);
	List<WebElement> strmonth =sel.getOptions();
	Iterator itr=strmonth.iterator();
	while(itr.hasNext())
	{
		System.out.println("Month:: " +itr.next());
	}
	
	sel.selectByValue("2");
	Select sday=new Select(driver.findElement(By.xpath("//select[@id='day']")));
	sday.selectByValue("6");
	
	Select syear=new Select(driver.findElement(By.xpath("//select[@id='year']")));
	JavascriptExecutor js = (JavascriptExecutor)driver;
	js.executeScript("scroll(0,100)");
	syear.selectByValue("1998");
	driver.findElement(By.xpath("//input[@name='sex']//..//label[contains(.,'Female')]")).click();
	List<WebElement> items = (driver.findElements(By.xpath("//tbody/tr/td/a")));
	System.out.println("No of Links :"+ items.size());
	for(int i=0;i<items.size();i++)
	{
		String text=items.get(i).getText();
		System.out.println("Link :"+text);
	}
	
	try {
		Thread.sleep(5000);
	} catch (InterruptedException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	}
	@AfterSuite
	public void quitedriver()
	{	driver.quit();
	}
	
	public void returnElement(String element)
	
	{
		
	}
	

}
