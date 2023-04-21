package april3;

import java.io.FileInputStream;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class Propertyfile {
	WebDriver driver;
	Properties  p;
	@Test
	public void login() throws Throwable
	{
		p = new Properties();
		p.load(new FileInputStream("OrangeHrm.properties"));
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get(p.getProperty("Url"));;
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.findElement(By.xpath(p.getProperty("objuser"))).sendKeys(p.getProperty("enteruser"));
	driver.findElement(By.xpath(p.getProperty("objpass"))).sendKeys(p.getProperty("enterpass"));
		driver.findElement(By.xpath(p.getProperty("objlogin"))).click();
		driver.close();

	}
}
