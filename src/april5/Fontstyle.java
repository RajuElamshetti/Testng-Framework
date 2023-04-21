package april5;

import java.awt.Font;
import java.io.FileInputStream;
import java.io.FileOutputStream;

import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.xssf.usermodel.XSSFCellStyle;
import org.apache.poi.xssf.usermodel.XSSFFont;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Fontstyle {

	public static void main(String[] args) throws Throwable {
		FileInputStream fi  = new FileInputStream("D:\\Example.xlsx");
		XSSFWorkbook wb = new XSSFWorkbook(fi);
		XSSFSheet ws = wb.getSheet("Raju");
		int rc = ws.getLastRowNum();
		System.out.println("no of rows are::"+rc);
		for(int i=1;i<=rc;i++)
		{
		//ws.getRow(i).createCell(4).setCellValue("pass");
		//ws.getRow(i).createCell(4).setCellValue("false");
		ws.getRow(i).createCell(4).setCellValue("blocked");
		XSSFCellStyle a = wb.createCellStyle();
		XSSFFont b = wb.createFont();
		//b.setColor(IndexedColors.GREEN.getIndex());
		//b.setColor(IndexedColors.RED.getIndex());
		b.setColor(IndexedColors.BROWN.getIndex());
		b.setBold(true);
		b.setBoldweight(XSSFFont.BOLDWEIGHT_BOLD);
		a.setFont(b);
		ws.getRow(i).getCell(4).setCellStyle(a);
		}
		fi.close();
		FileOutputStream fo = new FileOutputStream("D:\\Results.xlsx");
		wb.write(fo);
		fo.close();
		wb.close();

}
}
