package com.utility;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.ui.pojo.User;

public class ExcelReaderUtility {
	
	public static Iterator<User> readExcelFile(String filename)  {
		
		File xlsxFile = new File (System.getProperty("user.dir") + "\\testData\\" + filename );
		XSSFWorkbook xssfWorkbook = null;
		List<User> userList = null;
		XSSFSheet xssfSheet;
		Iterator <Row> rowIterator;
		
		try {
			xssfWorkbook = new XSSFWorkbook(xlsxFile);
			userList = new ArrayList<User>();
			Row row ;
			Cell emailAddresscell;
			Cell passwordcell;
			User user;
			
			xssfSheet =xssfWorkbook.getSheet("LoginTestData");
			rowIterator = xssfSheet.iterator();
			rowIterator.next();//skipping the column name
			
			while (rowIterator.hasNext()) {
				
				row = rowIterator.next();
				emailAddresscell =row.getCell(0);
				passwordcell =row.getCell(1);
				user = new User(emailAddresscell.toString(),passwordcell.toString());
				userList.add(user);	
				xssfWorkbook.close();
				
			}
		} catch (InvalidFormatException e) {
			e.printStackTrace();
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		return userList.iterator();
	}

}
