package seletest2;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFDataFormat;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.hssf.util.HSSFColor;
import org.openqa.selenium.mobile.NetworkConnection;

public class ExcelGenerator {

	public static void main(String[] args) {
		try {
			
			DCPContent content = new DCPContent("Aspirobot", "France", "Validé", "Super CGU","CGU" );
			FileOutputStream fileOut = new FileOutputStream("poi-test.xls");
			HSSFWorkbook workbook = new HSSFWorkbook();
			HSSFSheet worksheet = workbook.createSheet("POI Worksheet");

			// index from 0,0... cell A1 is cell(0,0)
			HSSFRow row1 = worksheet.createRow((short) 0);

			HSSFCell cellA1 = row1.createCell((short) 0);
			cellA1.setCellValue("Projet");

			HSSFCell cellB1 = row1.createCell((short) 1);
			cellB1.setCellValue("Pays");

			HSSFCell cellC1 = row1.createCell((short) 2);
			cellC1.setCellValue("Type");

			HSSFCell cellD1 = row1.createCell((short) 3);
			cellD1.setCellValue("Nom");
			
			HSSFCell cellE1 = row1.createCell((short) 4);
			cellE1.setCellValue("Statut");

			
			HSSFRow row2 = worksheet.createRow((short) 1);
			List<HSSFCell> listCell = new ArrayList<HSSFCell>();
			for(int i=0; i<=4; i++) {
				listCell.add(row2.createCell((short) i));
			}
			Iterator<HSSFCell> iterator = listCell.iterator();
			while (iterator.hasNext()) {
				iterator.next().setCellValue(content.getProject());
				iterator.next().setCellValue(content.getCountry());
				iterator.next().setCellValue(content.getType());
				iterator.next().setCellValue(content.getName());
				iterator.next().setCellValue(content.getStatus());
			}
			workbook.write(fileOut);
			fileOut.flush();
			fileOut.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
