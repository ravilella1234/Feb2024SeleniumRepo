package excelDataDriven;

import java.io.FileInputStream;
import java.io.FileOutputStream;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class DatawriterByName 
{

	public static void main(String[] args) throws Exception 
	{
		FileInputStream fis = new FileInputStream("C:\\Users\\ravi\\Desktop\\testdata1.xlsx");
		XSSFWorkbook wb = new XSSFWorkbook(fis);
		XSSFSheet sheet = wb.getSheet("login");
		XSSFRow row = sheet.getRow(0);
		XSSFCell cell = null;
		
		int cellIndex = -1;
		for(int i=0;i<row.getLastCellNum();i++)
		{
			if(row.getCell(i).getStringCellValue().trim().equals("Result"))
				cellIndex = i ;
		}
		
		row = sheet.getRow(2);
		cell = row.getCell(cellIndex);
		cell.setCellValue("Failed");
		
		FileOutputStream fos = new FileOutputStream("C:\\Users\\ravi\\Desktop\\testdata1.xlsx");
		wb.write(fos);
		wb.close();
		fis.close();
	}

}
