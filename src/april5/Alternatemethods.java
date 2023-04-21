package april5;

import java.io.FileInputStream;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Alternatemethods {

	public static void main(String[] args) throws Throwable{
		FileInputStream fi  = new FileInputStream("D:\\Example.xlsx");
		XSSFWorkbook wb = new XSSFWorkbook(fi);
		XSSFSheet ws = wb.getSheet("Raju");
		int rc = ws.getLastRowNum();
		System.out.println("no of rows are::"+rc);
		String aname = ws.getRow(4).getCell(0).getStringCellValue();
		String bname = ws.getRow(3).getCell(1).getStringCellValue();
		String cname = ws.getRow(9).getCell(2).getStringCellValue();
		int a = (int)ws.getRow(5).getCell(3).getNumericCellValue();
		System.out.println(aname+"   "+bname+"   "+cname+"   "+a);
		fi.close();
		wb.close();
		
		
		
	}

}
