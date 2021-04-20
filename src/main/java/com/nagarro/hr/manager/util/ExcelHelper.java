package com.nagarro.hr.manager.util;

import java.io.IOException;
import java.io.InputStream;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.web.multipart.MultipartFile;

import com.nagarro.hr.manager.model.Employee;

public class ExcelHelper {

	private static final String TYPE = "application/vnd.openxmlformats-officedocument.spreadsheetml.sheet";
	private static final String SHEET = "sheet1";
	// for reference only in switch statement
	// private static final String[] HEADERS = { "code", "name", "location", "email", "dateOfBirth" };

	private ExcelHelper() {
		// Empty On Purpose
	}

	public static boolean hasExcelFormat(MultipartFile file) {

		if (!TYPE.equals(file.getContentType())) {
			return false;
		}

		return true;
	}

	public static List<Employee> excelToEmployees(InputStream is) {
		try {
			Workbook workbook = new XSSFWorkbook(is);

			Sheet sheet = workbook.getSheet(SHEET);
			Iterator<Row> rows = sheet.iterator();

			List<Employee> employees = new ArrayList<>();

			int rowNumber = 0;
			while (rows.hasNext()) {
				Row currentRow = rows.next();

				// skip header
				if (rowNumber == 0) {
					rowNumber++;
					continue;
				}

				Iterator<Cell> cellsInRow = currentRow.iterator();

				Employee employee = new Employee();

				int cellIndex = 0;
				while (cellsInRow.hasNext()) {
					Cell currentCell = cellsInRow.next();

					switch (cellIndex) {
					case 0:
						try {
							employee.setCode((long) currentCell.getNumericCellValue());
						} catch (Exception e) {
							employee.setCode(Long.parseLong(currentCell.getStringCellValue()));
						}
						break;

					case 1:
						employee.setName(currentCell.getStringCellValue());
						break;

					case 2:
						employee.setLocation(currentCell.getStringCellValue());
						break;

					case 3:
						employee.setEmail(currentCell.getStringCellValue());
						break;

					case 4:
						employee.setDateOfBirth(LocalDate.parse(currentCell.getStringCellValue()));
						break;

					default:
						break;
					}

					cellIndex++;
				}

				employees.add(employee);
			}

			workbook.close();

			return employees;
		} catch (IOException e) {
			throw new RuntimeException("fail to parse Excel file: " + e.getMessage());
		}
	}
}