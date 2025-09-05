package com.food.utility;

import com.food.entity.FoodSell;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.stereotype.Component;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.List;

@Component
public class ExcelExporter {

    public ByteArrayOutputStream exportSellFoodRegisterToExcel(List<FoodSell> selldFood) throws IOException {

        Workbook workbook = new XSSFWorkbook() ;
        Sheet sheet = workbook.createSheet("Sell-Food-Register");

        // Create a cell style for borders
        CellStyle borderStyle = workbook.createCellStyle();
        borderStyle.setBorderBottom(BorderStyle.THIN);
        borderStyle.setBorderTop(BorderStyle.THIN);
        borderStyle.setBorderLeft(BorderStyle.THIN);
        borderStyle.setBorderRight(BorderStyle.THIN);

        // Create a font for the header row (bold)
        Font boldFont = workbook.createFont();
        boldFont.setBold(true);

        // Create a cell style for the header row with bold font
        CellStyle headerStyle = workbook.createCellStyle();
        headerStyle.setFont(boldFont);
        headerStyle.setBorderBottom(BorderStyle.THIN);
        headerStyle.setBorderTop(BorderStyle.THIN);
        headerStyle.setBorderLeft(BorderStyle.THIN);
        headerStyle.setBorderRight(BorderStyle.THIN);

        Row headerRow = sheet.createRow(0);
        headerRow.createCell(0).setCellValue("Sr No");
        headerRow.createCell(1).setCellValue("Farmer Id");
        headerRow.createCell(2).setCellValue("Farmer Name");
        headerRow.createCell(3).setCellValue("Feed Name");
        headerRow.createCell(4).setCellValue("Quantity");
        headerRow.createCell(5).setCellValue("Rate");
        headerRow.createCell(6).setCellValue("Total Amount");
        headerRow.createCell(7).setCellValue("Payment Status");

        for (int i = 0; i < 8; i++) {
            headerRow.getCell(i).setCellStyle(headerStyle);
        }

        BigDecimal totalSellAmount = BigDecimal.ZERO;

        int rowNum = 1;
        for(FoodSell sellItem : selldFood){
            Row row = sheet.createRow(rowNum++);

            row.createCell(0).setCellValue(rowNum-1);
            row.createCell(1).setCellValue(sellItem.getFarmerId());
            row.createCell(2).setCellValue(sellItem.getFarmerName());
            row.createCell(3).setCellValue(sellItem.getProductName());
            row.createCell(4).setCellValue(sellItem.getQty());
            row.createCell(5).setCellValue(sellItem.getSellingRate());
            row.createCell(6).setCellValue(sellItem.getTotalAmount());
            row.createCell(7).setCellValue(sellItem.getPaymentStatus());

            totalSellAmount = totalSellAmount.add(BigDecimal.valueOf(sellItem.getTotalAmount()));
            for (int i = 0; i < 8; i++) {
                if(row.getCell(i) != null) {
                    row.getCell(i).setCellStyle(borderStyle);
                }
            }
        }
        System.out.println("******"+totalSellAmount);
        System.out.println("******"+rowNum);

        // Add the total row at the bottom of the data
        Row totalRow = sheet.createRow(rowNum);
        System.out.println("******"+totalRow);

        totalRow.createCell(3).setCellValue("Total Amount ");  // In the Quantity Sold column
        totalRow.createCell(5).setCellValue(totalSellAmount.doubleValue());  // Total Amount
        totalRow.getCell(3).setCellStyle(headerStyle);  // Bold Total label
        totalRow.getCell(5).setCellStyle(headerStyle);  // Bold Total value

        if (totalRow.getCell(3) == null) {
            totalRow.createCell(3).setCellValue("Total Amount");
        }
        if (totalRow.getCell(5) == null) {
            totalRow.createCell(5).setCellValue(totalSellAmount.doubleValue());
        }

        // Apply borders to the total row
        for (int i = 0; i < 8; i++) {
            totalRow.createCell(i).setCellStyle(borderStyle);
        }

        for (int i = 0; i < rowNum+1; i++) {
            sheet.autoSizeColumn(i);
        }

        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        workbook.write(outputStream);
        workbook.close();
        return outputStream;
    }
}
