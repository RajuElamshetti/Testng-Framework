package april1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class FirstTestngclass {
	WebDriver driver;
	@BeforeMethod
	public void setup() throws Throwable
	{
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://calc.qedgetech.com/");
		Thread.sleep(3000);
		Reporter.log("Running pre condition");
	}
	@Test (enabled = true)
	public void addition() throws Throwable
	{
		driver.findElement(By.xpath("(//input[@id='btn'])[1]")).sendKeys("2365");
		Thread.sleep(3000);
		driver.findElement(By.xpath("(//input[@id='btn'])[6]")).click();
		driver.findElement(By.xpath("(//input[@id='btn'])[1]")).sendKeys("7854");
		Thread.sleep(3000);
		driver.findElement(By.xpath("(//input[@id='btn'])[20]")).click();
		Reporter.log("Exeecuting addition test",true);
	}
	@Test 
	public void multiplication() throws Throwable
	{
		driver.findElement(By.xpath("(//input[@id='btn'])[1]")).sendKeys("6598");
		Thread.sleep(3000);
		driver.findElement(By.xpath("(//input[@id='btn'])[16]")).click();
		driver.findElement(By.xpath("(//input[@id='btn'])[1]")).sendKeys("2365");
		Thread.sleep(3000);
		driver.findElement(By.xpath("(//input[@id='btn'])[20]")).click();
		Reporter.log("Exeecuting multiplication test",true);

	}
	@Test
	public void division() throws Throwable
	{
		driver.findElement(By.xpath("(//input[@id='btn'])[1]")).sendKeys("126");
		Thread.sleep(3000);
		driver.findElement(By.xpath("(//input[@id='btn'])[21]")).click();
		driver.findElement(By.xpath("(//input[@id='btn'])[1]")).sendKeys("965");
		Thread.sleep(3000);
		driver.findElement(By.xpath("(//input[@id='btn'])[20]")).click();
		Reporter.log("Exeecuting division test",true);

	}
	@AfterMethod
	public void teardown() throws Throwable
	{
		Thread.sleep(3000);
		Reporter.log("Running post condition",true);
		driver.close();
	}


}
