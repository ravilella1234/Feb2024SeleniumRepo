package excelDataDriven;

import org.testng.annotations.Test;

import java.util.Hashtable;

import org.testng.annotations.DataProvider;

public class DataManagementwithHashTable 
{
	
  @Test(dataProvider = "getData")
  public void f(Hashtable<String, String> str) 
  {
	  
  }

  @DataProvider
  public Object[][] getData() throws Exception 
  {
	  ExcelAPI e = new ExcelAPI("C:\\Users\\ravi\\Desktop\\suitex.xlsx");
		String sheetName = "data";
		String testName = "TestB";
		
		//To find the matching testcase row number
		int testStartRowNum = 0;
		while(!e.getCellData(sheetName, 0, testStartRowNum).equals(testName))
		{
			testStartRowNum++;
		}
		System.out.println(testName + "  Start row number iS :" + testStartRowNum);
		
		int colStartRowNum = testStartRowNum+1;
		int dataStartRowNum = testStartRowNum+2;
		
		int rows=0;
		//Calculate the rows of data
		while(!e.getCellData(sheetName, 0, dataStartRowNum+rows).equals(""))
		{
			rows++;
		}
		System.out.println("Total rows are : " + rows);
		
		int cols=0;
		//Calculate the columns of data
		while(!e.getCellData(sheetName, cols, colStartRowNum).equals(""))
		{
			cols++;
		}
		System.out.println("Total cols are : " + cols);
		
		//Read the test Data
		int dataRow = 0;
		Hashtable<String, String> table = null;
		Object[][] data = new Object[rows][1];
		for(int rNum=dataStartRowNum;rNum<dataStartRowNum+rows;rNum++)
		{
			table = new Hashtable<String, String>();
			for(int cNum=0;cNum<cols;cNum++)
			{
				//System.out.println(e.getCellData(sheetName, cNum, rNum));
				//data[dataRow][cNum] = e.getCellData(sheetName, cNum, rNum);
				String key = e.getCellData(sheetName, cNum, colStartRowNum);
				String value = e.getCellData(sheetName, cNum, rNum);
				table.put(key, value);
			}
			data[dataRow][0] = table;
			dataRow++;
		}
		return data;
  }
}
