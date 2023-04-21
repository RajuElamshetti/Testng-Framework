package april7;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Exp1 {
	WebDriver driver;
	@Test
	public void test()
	{
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		driver.navigate().to("https://flipkart.com/");
		String expected = "google";
		String actual =driver.getTitle();
		try {

		Assert.assertTrue(actual.equalsIgnoreCase(expected),"title not matching");
		}catch (Throwable t)
		{
			System.out.println(t.getMessage());
		}
		driver.quit();
	}
}
