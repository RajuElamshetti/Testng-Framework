package march31;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Reporter;
import org.testng.annotations.AfterTest;

public class TestngFirst {
	WebDriver driver;
	@BeforeTest
	public void setup () throws Throwable {
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://primusbank.qedgetech.com/");
		Thread.sleep(3000);
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		Reporter.log("Running pre condition",true);
	}
	@Test 
	public void Cbanking() throws Throwable {
		driver.findElement(By.xpath("(//img)[5]")).click();
		Reporter.log("Executing C banking ",true);
		Thread.sleep(3000);
	}
	@Test
	public void Pbanking() throws Throwable {
		driver.findElement(By.xpath("(//img[position()=1])[4]")).click();
		Reporter.log("Executing P banking",true);
		Thread.sleep(3000);
	}
	@Test
	public void Ibanking() throws Throwable {
		driver.findElement(By.xpath("(//img)[6]")).click();
		Reporter.log("Executing I banking",true);
		Thread.sleep(3000);
	}

	@AfterTest
	public void teardown() throws Throwable {
		Thread.sleep(2000);
		driver.close();
		Reporter.log("Running post condidtion",true);
	}

}
