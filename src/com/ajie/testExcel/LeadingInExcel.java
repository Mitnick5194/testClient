package com.ajie.testExcel;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;

/**
 * @author niezhenjie
 * 
 */
public class LeadingInExcel {

	public static void main(String[] args) throws IOException {
		FileInputStream input = new FileInputStream("/home/mitnick/传统长租包车档案表.xls");
		Workbook work = new HSSFWorkbook(input);
		Sheet sheet = work.getSheetAt(0);
		List<Archive> archives = new ArrayList<>();
		for (Row row : sheet) {
			int i = 0;
			if (row.getRowNum() < 5)
				continue;
			String unit = row.getCell(i++).getStringCellValue();
			String journey = row.getCell(i++).getStringCellValue();
			String vehicle = row.getCell(i++).getStringCellValue();
			String driver = row.getCell(i++).getStringCellValue();
			String passage = row.getCell(i++).getStringCellValue();
			String receipt = row.getCell(i++).getStringCellValue();
			Archive archive = new Archive(unit, journey, vehicle, driver, passage, receipt);
			archives.add(archive);
		}
		
		for (Archive archive : archives) {
			System.out.println(archive.toString());
		}
		
	}
}

class Archive {
	String unit;
	String journey;
	String vehicle;
	String driver;
	String passage;
	String receipt;

	public Archive(String unit, String journey, String vehicle, String driver, String passage,
			String receipt) {
		this.unit = unit;
		this.journey = journey;
		this.vehicle = vehicle;
		this.driver = driver;
		this.passage = passage;
		this.receipt = receipt;
	}

	public String toString() {
		return unit + "\t" + journey + "\t" + vehicle + "\t" + driver + "\t" + passage + "\t"
				+ receipt;
	}
}
