package commonUtils;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelUtil {

	public String getDataFromExcelFile(String Sheetname, int Rownum, int Cellnum) throws EncryptedDocumentException, IOException {
		
		//create the object of file input stream and store the path of excel file inside the constructor
		FileInputStream fis = new FileInputStream("src\\test\\resources\\Data.xlsx");
		//call a create method from WorkbookFactory class and store it inside a variable
		Workbook wb = WorkbookFactory.create(fis);
		//Call a method getSheet (String Sheetname)
		Sheet sh = wb.getSheet(Sheetname);
		//Call a method getRow(int RowNum)
		Row rw = sh.getRow(Rownum);
		//Call a method getcell(int cellNumber)
		Cell cl = rw.getCell(Cellnum);
		//Call a method getStringCellValue
		String value = cl.getStringCellValue();
		return value;
	}

}
