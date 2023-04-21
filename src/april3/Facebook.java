package april3;

import java.io.FileInputStream;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class Facebook {
WebDriver driver;
Properties a;
@Test
public void data() throws Throwable
{
	a = new Properties();
	a.load(new FileInputStream("Facebook.properties"));
	driver = new ChromeDriver();
	driver.manage().window().maximize();
	driver.get(a.getProperty("url"));
	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	driver.findElement(By.xpath(a.getProperty("objuser"))).sendKeys(a.getProperty("enteruser"));
	driver.findElement(By.xpath(a.getProperty("objpass"))).sendKeys(a.getProperty("enterpass"));
	driver.findElement(By.xpath(a.getProperty("objlogin"))).click();
	driver.close();
	
	
		
	
}
}
