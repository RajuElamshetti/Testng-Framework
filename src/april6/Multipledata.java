package april6;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.xssf.usermodel.XSSFCellStyle;
import org.apache.poi.xssf.usermodel.XSSFFont;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Reporter;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Multipledata {
	WebDriver driver;
	XSSFWorkbook wb;
	String inputpath = "D:\\Loginpage.xlsx";
	String outpath = "D:/Raju.xlsx";
	@BeforeTest
	public void setup()
	{
		driver = new ChromeDriver();
	}
	@Test
	public void logintest() throws Throwable
	{
		FileInputStream fi = new FileInputStream(inputpath);
		wb = new XSSFWorkbook(fi);
		XSSFSheet ws = wb.getSheet("Login");
		int rc = ws.getLastRowNum();
		Reporter.log("no of rows are::"+rc,true);
		for (int i =1;i<=rc;i++)
		{
			driver.get("http://orangehrm.qedgetech.com/symfony/web/index.php/auth/validateCredentials");
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
			//read username and password
			String user = ws.getRow(i).getCell(0).getStringCellValue();
			String pass = ws.getRow(i).getCell(1).getStringCellValue();
			driver.findElement(By.name("txtUsername")).sendKeys(user);
			driver.findElement(By.name("txtPassword")).sendKeys(pass);
			driver.findElement(By.name("Submit")).click();
			String expected = "dashboard";
			String actual = driver.getCurrentUrl();
			if(actual.contains(expected))
			{
				//write login as success into results
				ws.getRow(i).createCell(2).setCellValue("login success");
				//write pass into status
				Reporter.log("login success::"+expected+"   "+actual,true);
				XSSFCellStyle style = wb.createCellStyle();
				XSSFFont font = wb.createFont();
				font.setColor(IndexedColors.GREEN.getIndex());
				font.setBold(true);
				font.setBoldweight(XSSFFont.BOLDWEIGHT_BOLD);
				style.setFont(font);
				ws.getRow(i).getCell(3).setCellStyle(style);

			}
			else
			{
				File screen = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
				FileUtils.copyFile(screen,new File("./screenshot/iteration/"+i+"loginpage.jpg"));
				//write as error message to result
				String error_message = driver.findElement(By.xpath("//span[@id='spanMessage']")).getText();
				ws.getRow(i).createCell(2).setCellValue(error_message);
				ws.getRow(i).createCell(3).setCellValue("fail");
				Reporter.log(error_message+"    "+expected+"   "+actual,true);
				XSSFCellStyle style = wb.createCellStyle();
				XSSFFont font = wb.createFont();
				font.setColor(IndexedColors.RED.getIndex());
				font.setBold(true);
				font.setBoldweight(XSSFFont.BOLDWEIGHT_BOLD);
				style.setFont(font);
				ws.getRow(i).getCell(3).setCellStyle(style);

			}
		}
		fi.close();
		FileOutputStream fo = new FileOutputStream(outpath);
		wb.write(fo);
		wb.close();

	}

	@AfterTest
	public void tearoDown()
	{
		driver.quit();
	}


}
