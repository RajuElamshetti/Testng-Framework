package april1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Reporter;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class SecondTestng {
	WebDriver driver;
	@BeforeSuite
	public void setup() throws InterruptedException
	{
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.get("http://primusbank.qedgetech.com/");
		driver.findElement(By.name("txtuId")).sendKeys("Admin");
		driver.findElement(By.name("txtPword")).sendKeys("Admin");
		driver.findElement(By.name("login")).click();
		Thread.sleep(3000);
		Reporter.log("Running pre condition");

	}
	@Test (priority = 4)
	public void branches() throws Throwable
	{
		driver.findElement(By.xpath("(//img)[5]")).click();
		Thread.sleep(3000);
		Reporter.log("Executing branch test",true);
	}
	@Test (priority = 2)
	public void roles() throws Throwable
	{
		driver.findElement(By.xpath("(//img)[6]")).click();
		Thread.sleep(3000);
		Reporter.log("Executing roles test",true);
	}
	@Test (priority = 1)
	public void users() throws Throwable
	{
		driver.findElement(By.xpath("(//img)[7]")).click();
		Thread.sleep(3000);
		Reporter.log("Executing users test",true);
	}
	@Test (priority = 3)
	public void employees() throws Throwable
	{
		driver.findElement(By.xpath("(//img)[8]")).click();
		Thread.sleep(3000);
		Reporter.log("Executing employees test",true);
	}
	@AfterSuite
	public void teardown() throws InterruptedException
	{
		Reporter.log("Running post condition",true);
		Thread.sleep(3000);
		driver.close();

	}

}


