package testData;

import java.io.File;
import java.io.FileInputStream;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

//Class to read the Excel Data using Apache POI
public class GenericExcelReader {
	XSSFWorkbook wb;
	XSSFSheet sheet1;

	public GenericExcelReader(String excelPath) {
		try {
			File scr = new File(excelPath);
			FileInputStream fis = new FileInputStream(scr);
			wb = new XSSFWorkbook(fis);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	//Method to fetch the actual data based on the Sheet number and (row,column) index
	public String getData(int sheetNumber, int row, int column) {
		sheet1 = wb.getSheetAt(sheetNumber);
		String data = sheet1.getRow(row).getCell(column).getStringCellValue();
		return data;
	}

	//Method to obtain the row count
	public int getRowCount(int sheetIndex) {
		int row = wb.getSheetAt(sheetIndex).getLastRowNum();
		row = row + 1;
		return row;
	}
}
