package april7;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class Reports {
WebDriver driver;
ExtentReports a;
ExtentTest b;
@BeforeTest
public void Report()
{
	//default path html
  a = new ExtentReports("./reports/Demo.html");
}
@BeforeMethod
public void setup()
{
	driver = new ChromeDriver();
	driver.manage().window().maximize();
	driver.get("https://google.com/");
}
@Test
public void testpass()
{
	b = a.startTest("test pass");
	b.assignAuthor("Raju");
	b.assignCategory("functional");
	String expected = "google";
	String actual = driver.getTitle();
	if (actual.equalsIgnoreCase(expected))
	{
		b.log(LogStatus.PASS, "title matching::"+expected+"  "+actual);
	}
	else
	{
	b.log(LogStatus.FAIL, "title not matching::"+expected+"   "+actual);	
	}
}
@Test
public void testfail()
{
	b = a.startTest("test fail");
	b.assignAuthor("Raju");
	b.assignCategory("functional");
	String expected = "amazon";
	String actual = driver.getTitle();
	if (actual.equalsIgnoreCase(expected))
	{
		b.log(LogStatus.PASS, "title  matching::"+expected+"  "+actual);
	}
	else
	{	
		b.log(LogStatus.FAIL, "title not matching::"+expected+"   "+actual);	
	}
}
@AfterMethod
public void teardown()
{
	a.endTest(b);
	a.flush();
	driver.quit();
}
}

