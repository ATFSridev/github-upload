package toolsQA;

import org.testng.annotations.Test;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;

public class Seleniums {
	
	WebDriver driver;
	@BeforeMethod
	public void launch()
	{
		
		String chpath="D:\\chromedriver.exe";
		System.setProperty("webdriver.chrome.driver", chpath);
		driver = new ChromeDriver();
		//driver = new FirefoxDriver();
		driver.get("http://www.Orbitz.com");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(5000,TimeUnit.SECONDS);
		
	}
	
	@Test
	public void tset()
	{
		System.out.println("Open the QA");
		//Click on the packages
		driver.findElement(By.id("tab-package-tab"));

		
		//Enter from and destination
		driver.findElement(By.id("package-origin")).sendKeys("EWR");
		driver.findElement(By.id("package-destination")).sendKeys("LHR");
		
		//Enter Dates
				//click on departing
		driver.findElement(By.id("package-departing")).click();
		driver.findElement(By.xpath("//button[@class='datepicker-cal-date' and @data-year='2017' and @data-month='6'  and @data-day='29']")).click();;
				
		driver.findElement(By.id("package-returning")).click();
		driver.findElement(By.xpath("//button[@class='datepicker-cal-date' and @data-year='2017' and @data-month='7'  and @data-day='9']")).click(); 
						//button[@class='datepicker-cal-date' and @data-year="2017" and @data-month="7"  and @data-day="9"]
		System.out.println("Dates");
		//Enter Rooms Adults, childrens
		
				Select sel =new Select(driver.findElement(By.id("package-1-adults")));
				sel.selectByValue("3");
				List <WebElement> selopt = sel.getOptions();
				
				for(int i=0;i<selopt.size();i++)
				{
					System.out.println(" Option " + i + selopt.get(i).getText());
				}
				
				
		//Chk the Hotel chkbox
		WebElement chkele=driver.findElement(By.id("partialHotelBooking"));
		//chkele.click();
		//String chkatt=chkele.getAttribute("checked");
		/*if(chkatt=="")
		{
			System.out.println("Enabled the Checkbox");
		}*/
		
		//chkele.click();
		
		Select classb=new Select(driver.findElement(By.id("package-advanced-preferred-class")));
		classb.selectByIndex(2);
		
		//Search
		driver.findElement(By.id("search-button")).click();
		
		WebDriverWait wait = new WebDriverWait(driver,35);
		
		wait.until(ExpectedConditions.elementToBeClickable(By.id("primary-header-flight")));
		String title=driver.getTitle();
		System.out.println("Title:: "+ title);
		driver.findElement(By.id("star3")).click();
		
	}
	 
	
	@AfterTest
	public void quitdriver()
	{
		driver.quit();
	}
	
	

}
