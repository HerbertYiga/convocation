package com.convocation.excelviewclass;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.hssf.usermodel.HSSFFont;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.hssf.util.HSSFColor;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Font;
import org.springframework.web.servlet.view.document.AbstractExcelView;

import com.convocation.bean.StudentsForm;

public class ExcelBuilder extends AbstractExcelView {

	@Override
	protected void buildExcelDocument(Map<String, Object> model,
			HSSFWorkbook  workbook, HttpServletRequest request, HttpServletResponse reponse)
			throws Exception {
	
		
		
		
		List<StudentsForm>liststudentdetails=(List<StudentsForm>) model.get("list");
		
		
		//creating a new Excel sheet
		HSSFSheet sheet=workbook.createSheet("StudentDetails");
		sheet.setDefaultColumnWidth(30);
		//styling the excel sheet
		
		
		CellStyle style=workbook.createCellStyle();
		Font font=workbook.createFont();
		font.setFontName("Arial");
	    style.setFillForegroundColor(HSSFColor.BLUE.index);
	    style.setFillPattern(CellStyle.SOLID_FOREGROUND);
	    font.setBoldweight(HSSFFont.BOLDWEIGHT_BOLD);
	    font.setColor(HSSFColor.WHITE.index);
	     style.setFont(font);
	     
	     //create header row
	     
	     HSSFRow header=sheet.createRow(0);
	     header.createCell(0).setCellValue("id");
	     header.getCell(0).setCellStyle(style);
	     
	     
	     
	     header.createCell(1).setCellValue("Full Name");
	     header.getCell(1).setCellStyle(style);
	     
	     
	     header.createCell(2).setCellValue("Phone Number");
	     header.getCell(2).setCellStyle(style);
	     
	     header.createCell(3).setCellValue("Email");
	     header.getCell(3).setCellStyle(style);
	     
	     header.createCell(4).setCellValue("Course Studied");
	     header.getCell(4).setCellStyle(style);
	     
	     header.createCell(5).setCellValue("RegNo");
	     header.getCell(5).setCellStyle(style);
	     
	     
	     
	     //creating data rows
	     int rowCount=1;
	     for(StudentsForm studentdetails:liststudentdetails){
	    	 
	    	 
	    	 
	    	 HSSFRow aRow=sheet.createRow(rowCount++);
	    	 aRow.createCell(0).setCellValue(studentdetails.getId());
	    	 
	    	 aRow.createCell(1).setCellValue(studentdetails.getFullName());
	    	 aRow.createCell(2).setCellValue(studentdetails.getPhoneNumber());
	    	 aRow.createCell(3).setCellValue(studentdetails.getEmail());
	    	 aRow.createCell(4).setCellValue(studentdetails.getCourseStudied());
	    	 aRow.createCell(5).setCellValue(studentdetails.getRegNo());
	    	 
	    	 
	    	 
	     }
	     
	
	     
	     
	     
		
		
		
		
		
		
		
		
		
		
	}
	
	
	
	
	

}
