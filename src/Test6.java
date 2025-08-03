


import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.Test;

public class Test6 {

	@Test
	public void readExcel() throws IOException

	{

		// Specify the path of the Excel file
		String filePath = "C:\\Users\\iamar\\eclipse-workspace\\Learning\\Excel\\TestExcel1.xlsx";

		// Create an object of FileInputStream class to read the Excel file
		FileInputStream inputStream = new FileInputStream(new File(filePath));

		// Create an object of XSSFWorkbook class to work with the Excel file
		Workbook workbook = new XSSFWorkbook(inputStream);

		// Specify the sheet name or index from which data needs to be read
		Sheet sheet = workbook.getSheet("Sheet1"); // Assuming sheet name is "Sheet1"

		// Iterate through each row of the sheet and read the data
		for (Row row : sheet) {
			// Iterate through each cell of the row
			for (Cell cell : row) 
			{
				switch (cell.getCellType()) {
	              case STRING:
	                System.out.print(cell.getStringCellValue() + "\t");
	                break;
	              case NUMERIC:
	                System.out.print(cell.getNumericCellValue() + "\t");
	                break;
	              default:
	            }
			}
			// Move to the next row
			System.out.println();
		}

		// Close the workbook and input stream objects
		workbook.close();
		inputStream.close();
		
		
		
	}
	
	@Test
	public void WriteExcel() throws IOException
	{
		String filePath = "C:\\Users\\iamar\\eclipse-workspace\\Learning\\Excel\\TestExcel1.xlsx";
		FileInputStream inputStream = new FileInputStream(new File(filePath));
		Workbook workbook = new XSSFWorkbook(inputStream);
		Sheet sheet = workbook.getSheet("Sheet2"); 
		
		for(int i=0;i<10;i++) 
		{
			Row row= sheet.createRow(i);
			Cell cell = row.createCell(5);
			cell.setCellValue("HEllo World");
		}
		FileOutputStream fos = new FileOutputStream("C:\\Users\\iamar\\eclipse-workspace\\Learning\\Excel\\TestExcel1.xlsx");
		workbook.write(fos);
		fos.close();
		System.out.println("Data written in Excel");
	}
}