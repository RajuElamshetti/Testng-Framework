package april7;

import static org.testng.Assert.assertEquals;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Asserts {
	WebDriver driver;
	@Test
	public void test()
	{
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		driver.navigate().to("https://google.com/");
		String expected = "google";
		String actual =driver.getTitle();
		try {

			Assert.assertEquals(actual, expected,"title not matching");
		}catch (Throwable t)
		{
			System.out.println(t.getMessage());
		}
		driver.quit();


	}
}
