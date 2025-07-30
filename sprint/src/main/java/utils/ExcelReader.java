package utils;

import java.io.File;
import java.io.FileInputStream;
import org.apache.poi.ss.usermodel.*;

public class ExcelReader {

    private Sheet sheet;

    public ExcelReader(String filePath, String sheetName) {
        try {
            FileInputStream file = new FileInputStream(new File(filePath));
            Workbook workbook = WorkbookFactory.create(file);
            sheet = workbook.getSheet(sheetName);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public int getRowCount() {
        return sheet.getPhysicalNumberOfRows();
    }

    public String getCellData(int row, int column) {
        Row r = sheet.getRow(row);
        if (r == null) return "";
        Cell cell = r.getCell(column);
        if (cell == null) return "";

        switch (cell.getCellType()) {
            case STRING:
                return cell.getStringCellValue().trim();
            case NUMERIC:
                return String.valueOf((int) cell.getNumericCellValue());
            case BOOLEAN:
                return String.valueOf(cell.getBooleanCellValue());
            default:
                return "";
        }
    }
}

