package toolsQA;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class toolsq {
	
	WebDriver driver;
	@BeforeMethod
	public void launch()
	{
		
		String chpath="D:\\chromedriver.exe";
		System.setProperty("webdriver.chrome.driver", chpath);
		driver = new ChromeDriver();
		//driver = new FirefoxDriver();
		driver.get("http://toolsqa.com/automation-practice-form/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(5000,TimeUnit.SECONDS);
		
	}
	
	@Test
	public void tset()
	{
		
		System.out.println("Test Started");
		//Enter first name and last name
		driver.findElement(By.name("firstname")).sendKeys(" Sri");
		driver.findElement(By.name("lastname")).sendKeys("Test");
		boolean statu = false;
		//select radio buttons
		WebElement male=driver.findElement(By.id("sex-0"));
		WebElement female=driver.findElement(By.id("sex-1"));
		if(male.isSelected())
		{
			female.click();
		}
		else
		{
			male.click();
		}
		//Years of exp
		
		List <WebElement> yexp= driver.findElements(By.xpath("//input[@name='exp']"));
		
		for(int i=0; i<yexp.size();i++)
		{
			String exp=yexp.get(i).getText();
			
			if(exp.equals("6"))
			{
				yexp.get(i).click();
			}
		}
		//Profession
		if(!(driver.findElement(By.xpath("//input[@name='profession' and @value='Automation Tester']")).isEnabled()))
		{
			driver.findElement(By.xpath("//input[@name='profession' and @value='Automation Tester']")).click();
			Assert.assertTrue(driver.findElement(By.xpath("//input[@name='profession' and @value='Automation Tester']")).isEnabled(), "Automation Tester is not enabled");
		}
		
		if(!(driver.findElement(By.xpath("//input[@name='profession' and @value='Manual Tester']")).isEnabled()))
		{
			System.out.println("Manual is not enabled");
		}
		
   		Select conti=new Select(driver.findElement(By.id("continents")));
		conti.selectByIndex(4);
		Select multicom =new Select(driver.findElement(By.id("selenium_commands")));
		multicom.selectByIndex(1);
		multicom.selectByIndex(2);
		multicom.selectByIndex(3);
		
		//Fetch no of links
		
		 List<WebElement> linkc=driver.findElements(By.xpath("//div[@class='control-group']/a"));
		 for(int i=0;i<linkc.size();i++)
		 {
			 System.out.println("Link Name :: " + linkc.get(i).getText());
		 }
		 
		 
		
	}
	
	
	
	@AfterTest
	public void quitdriver()
	{
		driver.quit();
	}

}
