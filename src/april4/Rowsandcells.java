package april4;

import java.io.FileInputStream;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Rowsandcells {

	public static void main(String[] args) throws Throwable {
		// count no of rows in sheet and cells in first row
		//read path file
		FileInputStream a = new FileInputStream("D:\\Example.xlsx");
	//get workbook from file
		XSSFWorkbook b = new XSSFWorkbook(a);
		//get sheet from b
		XSSFSheet c = b.getSheet("Raju");
		//count no of rows
		int rc = c.getLastRowNum();
		//get first row from sheet
		XSSFRow row = c.getRow(0);
		//get cells from first  row
		int d = row.getLastCellNum();
		System.out.println("no of rows are ::"+rc+"  "+"no of cells in first row::"+d);
		a.close();
		b.close();
		
	}

}
