package april5;

import java.io.FileInputStream;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Rowcell {

	public static void main(String[] args) throws Throwable {
		//read the file
		FileInputStream a =  new FileInputStream("D:\\Example.xlsx");
		XSSFWorkbook b = new XSSFWorkbook(a);
		XSSFSheet c = b.getSheetAt(0);
		int rc = c.getLastRowNum();
		System.out.println("no of rows are::"+rc);
		XSSFRow row = c.getRow(5);
		XSSFCell c1 = row.getCell(0);
		XSSFCell c2 = row.getCell(1);
		XSSFCell c3 = row.getCell(2);
		XSSFCell c4 = row.getCell(3);
		String aname = c1.getStringCellValue();
		String bname = c2.getStringCellValue();
		String cname = c3.getStringCellValue();
		int eid = (int) c4.getNumericCellValue();
		System.out.println(aname+"   "+bname+"   "+cname+"   "+eid);
		a.close();
		b.close();
	
	
	
	}

}
