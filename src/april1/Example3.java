package april1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Reporter;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class Example3 {
	WebDriver driver;
	@BeforeSuite
	public void setup() throws Throwable
	{
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://flights.qedgetech.com/");
		Thread.sleep(3000);
		driver.findElement(By.partialLinkText("Regist")).click();
		Reporter.log("Running pre condition");
	}
	@Test
	public void a()
	{
		driver.findElement(By.name("name")).sendKeys("Raju");
		driver.findElement(By.name("contact")).sendKeys("8106599658");
		driver.findElement(By.name("email")).sendKeys("rajuelamshetti15@gmail.com");
		driver.findElement(By.name("password")).sendKeys("123456");
		driver.findElement(By.name("gender")).click();
		driver.findElement(By.name("dob")).click();
		driver.findElement(By.partialLinkText("18")).click();
		driver.findElement(By.id("flexCheckChecked")).click();
		driver.findElement(By.name("submit")).click();

	}
	@AfterSuite
	public void teardown() throws Throwable
	{
		Thread.sleep(3000);
		driver.close();
	}
}






