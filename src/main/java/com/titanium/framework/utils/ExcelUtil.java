package com.titanium.framework.utils;

import com.titanium.framework.config.Constants;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Hashtable;

public class ExcelUtil {


	private static org.apache.poi.ss.usermodel.Cell cell;

    static Sheet wrksheet;
	static Workbook wrkbook =null;
	static Hashtable dict= new Hashtable();

    //Create a Constructor
	public ExcelUtil() throws IOException
	{
		//Initialize
		readExcel();

        //Call the column Dictionary to store column names
        ColumnDictionary();
	}

	public void readExcel() throws IOException {
		//Create an object of File class to open xlsx file, the excel file must be stored on src/main/resources
		File file = new File(Constants.RESOURCE_FILES_DIR + Constants.WORKBOOK_NAME);

		//Create an object of FileInputStream class to read excel file
		FileInputStream inputStream = null;
		try {
			inputStream = new FileInputStream(file);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}

		//Find the file extension by splitting file name in substring  and getting only extension name
		String fileExtensionName = Constants.WORKBOOK_NAME.substring(Constants.WORKBOOK_NAME.indexOf("."));

		switch (fileExtensionName){
			//Check condition if the file is xlsx file
			case ".xlsx":
				//If it is xlsx file then create object of XSSFWorkbook class
				wrkbook = new XSSFWorkbook(inputStream);
				break;
			//Check condition if the file is xls file
			case ".xls":
				//If it is xls file then create object of HSSFWorkbook class
				wrkbook = new HSSFWorkbook(inputStream);
				break;
			default:
				break;
		}
		wrksheet = wrkbook.getSheet(Constants.WORKSHEET_NAME);
	}

	//Returns the Number of Rows
	public static int RowCount()
	{
		return wrksheet.getLastRowNum()-wrksheet.getFirstRowNum();
	}

	//Returns the Cell value by taking row and Column values as argument
	public static String ReadCell(int column,int row)
	{
		String data = "";
		try{
			cell = wrksheet.getRow(row).getCell(column);
			// Convert data from cell to String
			if(cell.getCellType()== CellType.STRING){
				data = cell.getStringCellValue();
			}else if (cell.getCellType()== CellType.NUMERIC){
				data = String.valueOf(cell.getNumericCellValue());
			}
		}catch (Exception e){
			e.getStackTrace();
		}
		return data;
	}

    //Returns the Cell value by taking row and Column name values as argument
    public static String ReadCell(String colName, int rowNumber){
        return ReadCell(GetCell(colName),rowNumber);
    }

	//Create Column Dictionary to hold all the Column Names
	private static void ColumnDictionary()
	{
		//Iterate through all the columns in the Excel sheet and store the value in Hashtable
		for(int col=0;col < wrksheet.getRow(0).getLastCellNum();col++)
		{
			dict.put(ReadCell(col,0), col);
		}
	}

	//Read Column Names
	private static int GetCell(String colName)
	{
		try {
			int value;
			value = ((Integer) dict.get(colName)).intValue();
			return value;
		} catch (NullPointerException e) {
			return (0);

		}
	}
}
