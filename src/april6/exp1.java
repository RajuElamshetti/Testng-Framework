package april6;

	import java.io.File;
	import java.io.FileInputStream;
	import java.io.FileNotFoundException;
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

	public class exp1  
	{
		WebDriver dr;
		XSSFWorkbook wb;
		String ippath = "D:\\lol.xlsx";
		String oppath ="D:\\res.xlsx";
		@BeforeTest
		public void setUp() {
			dr = new ChromeDriver();
		}
		@Test
		public void login() throws Throwable
		{
			FileInputStream fi = new FileInputStream(ippath);
			wb = new XSSFWorkbook(fi);
			XSSFSheet ws = wb.getSheet("mm");
			int rc = ws.getLastRowNum();
			Reporter.log("no of rows "+rc,true);
			for(int i =1;i<=rc;i++)
			{
				String us = ws.getRow(i).getCell(0).getStringCellValue();
				String pa = ws.getRow(i).getCell(1).getStringCellValue();
				dr.get("http://orangehrm.qedgetech.com/");
				dr.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
				dr.manage().window().maximize();
				dr.findElement(By.xpath("//input[@id='txtUsername']")).sendKeys(us);
				dr.findElement(By.xpath("//input[@id='txtPassword']")).sendKeys(pa);
				dr.findElement(By.className("button")).click();
				// String exp = "dashboard";
				String exp = "http://orangehrm.qedgetech.com/symfony/web/index.php/dashboard";
				dr.manage().window().maximize();
				dr.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
				String act = dr.getCurrentUrl();
				if(act.equalsIgnoreCase(exp)) 
				{
					ws.getRow(i).createCell(2).setCellValue("login sucess");
					ws.getRow(i).createCell(3).setCellValue("pass");
					Reporter.log("Login sucess",true);
					XSSFCellStyle style = wb.createCellStyle();
					XSSFFont font = wb.createFont();
					font.setColor(IndexedColors.GREEN.getIndex());
					font.setBold(true);
					font.setBoldweight(XSSFFont.BOLDWEIGHT_BOLD);
					style.setFont(font);
					ws.getRow(i).getCell(3).setCellStyle(style);

				}
				else {
					File screen = ((TakesScreenshot)dr).getScreenshotAs(OutputType.FILE);
					FileUtils.copyFile(screen, new File("./screenshot/itreration"+i+"login.jpg"));
					String emsg = dr.findElement(By.xpath("//span[@id='spanMessage']")).getText();
					ws.getRow(i).createCell(2).setCellValue(emsg);
					ws.getRow(i).createCell(3).setCellValue("fail");
					Reporter.log(emsg,true);
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
			FileOutputStream fo = new FileOutputStream(oppath);
			wb.write(fo);
			fo.close();
			wb.close();

		}
		@AfterTest
		public void teaDown()
		{
			dr.close();
		}

	}

