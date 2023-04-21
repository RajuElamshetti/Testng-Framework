package april5;

import java.io.FileInputStream;
import java.io.FileOutputStream;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Writenewbook {

	public static void main(String[] args) throws Throwable {
		FileInputStream fi  = new FileInputStream("D:\\Example.xlsx");
		XSSFWorkbook wb = new XSSFWorkbook(fi);
		XSSFSheet ws = wb.getSheet("Raju");
		int rc = ws.getLastRowNum();
		System.out.println("no of rows are::"+rc);
		for(int i=1;i<=rc;i++)
		{
			ws.getRow(i).createCell(4).setCellValue("false");
		}
	fi.close();
	FileOutputStream fo = new FileOutputStream("D:\\Results.xlsx");
	wb.write(fo);
	fi.close();
	wb.close();
	}

}
