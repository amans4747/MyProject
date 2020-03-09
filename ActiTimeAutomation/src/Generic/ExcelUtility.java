package Generic;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelUtility implements IAutoConstant {
	
	static Workbook wb;
	static FileInputStream fis;
	
	public static String getCellValue(String EXCEL_PATH, String sheet, int r, int c) throws EncryptedDocumentException, IOException{
		
		String cellData = "";
		fis = new FileInputStream(EXCEL_PATH);
		wb = WorkbookFactory.create(fis);
		cellData= wb.getSheet(sheet).getRow(r).getCell(c).toString();
		
		
		return cellData;
	}
	
	public static int getRowCount(String EXCEL_PATH, String sheet){
		int rowCount = 0;
			try {
			fis = new FileInputStream(EXCEL_PATH);
			wb = WorkbookFactory.create(fis);
			rowCount = wb.getSheet(sheet).getLastRowNum();
		} catch (Exception e) {
		}
		return rowCount;
	}


}
