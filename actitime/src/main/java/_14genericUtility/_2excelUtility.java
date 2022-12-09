package _14genericUtility;

import java.io.FileInputStream;
import java.io.IOException;
import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class _2excelUtility {
	
	public String fetchDataFromExcelSheets(String sheetName, int row,int cell) throws EncryptedDocumentException, IOException {
		
		FileInputStream fis1=new FileInputStream("src/test/resources/ExcelData2.xlsx");
		Workbook workbook = WorkbookFactory.create(fis1);
		return workbook.getSheet(sheetName).getRow(row).getCell(cell).toString();
		
	}

}
