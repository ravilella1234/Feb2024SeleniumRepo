package excelDataDriven;

public class DataManagement 
{

	public static void main(String[] args) throws Exception 
	{
		ExcelAPI e = new ExcelAPI("C:\\Users\\ravi\\Desktop\\suitex.xlsx");
		String sheetName = "data";
		String testName = "TestA";
		
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
		for(int rNum=dataStartRowNum;rNum<dataStartRowNum+rows;rNum++)
		{
			for(int cNum=0;cNum<cols;cNum++)
			{
				System.out.println(e.getCellData(sheetName, cNum, rNum));
			}
		}
		
	}

}
