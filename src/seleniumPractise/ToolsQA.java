package seleniumPractise;

import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

public class ToolsQA {
	
	@Test
	public void toolsqatest()
	{
		WebDriver driver = new FirefoxDriver();
		driver.get("http://toolsqa.com/automation-practice-switch-windows/");
		driver.findElement(By.id("button1")).click();
		String pwindow=driver.getWindowHandle();
		Set<String>childwindows=driver.getWindowHandles();
	}

}
