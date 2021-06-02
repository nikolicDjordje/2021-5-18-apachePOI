package domaciApache;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ApachePoiZbir {

	public static void main(String[] args) {
		
		/*  Napisati program koji racuna sumu brojeva koji se nalaze prvom sheet-u excel
		 *  tabele koji se zove Brojevi. U tabeli svi brojevi se nalaze u prvoj koloni. 
		 *  Program treba da cita red po red iz tabele i upisane brojeve dodaje na sumu. 
		 *  Ukupnu sumu na kraju treba ispisati na standardnom izlazu. 
		 *  Potrebno je omoguciti da program radi i ukoliko se u datu tabelu doda jos brojeva.
*/
		
		File f = new File ("domaci.xlsx");
		
		try {
			InputStream is = new FileInputStream(f);
			XSSFWorkbook wb = new XSSFWorkbook(is);
			Sheet sheet = wb.getSheetAt(0);
			Row row = sheet.getRow(0);
			Cell cell = row.getCell(0);
			
			double zbir = 0; 
			for (int i = 0; i <= sheet.getLastRowNum(); i++) {
			 
					row = sheet.getRow(i);
					zbir = zbir + row.getCell(0).getNumericCellValue();
				}
				System.out.println(zbir);
			wb.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.out.println("Fajl nije pronadjen!");
			e.printStackTrace();
		}

	}

}
