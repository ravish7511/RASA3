package generic;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.Reporter;

public class Excel implements Auto_const {

	public static String readData(String sheet,int row,int cell)
	{
		String val="";
		try {
			FileInputStream fis=new FileInputStream(excel_path);
			Workbook wb = WorkbookFactory.create(fis);
			Cell c = wb.getSheet(sheet).getRow(row).getCell(cell);
			val=c.getStringCellValue();
		} catch (Exception e) {
			
			Reporter.log("unable to read", true);
		}
		return val;
	}
	
	public static void writeData(String sheet,int row,int cell,String value)
	{
		String val="";
		try {
			FileInputStream fis=new FileInputStream(excel_path);
			Workbook wb = WorkbookFactory.create(fis);
			Cell c = wb.getSheet(sheet).getRow(row).createCell(cell);
			c.setCellValue(value);
			FileOutputStream fout=new FileOutputStream(excel_path);
			wb.write(fout);
		} catch (Exception e) {
			
			Reporter.log("unable to write", true);
		}
	}
	
}
