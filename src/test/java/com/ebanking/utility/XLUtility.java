package com.ebanking.utility;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class XLUtility {
	
	public static FileInputStream fi;
	public static FileOutputStream fo;
	public static XSSFWorkbook wb;
	public static XSSFSheet ws;
	public static XSSFRow row;
	public static XSSFCell cell;
	
	public static int getRowCount(String xlfile, String xlSheet) throws IOException{
		
		fi =new FileInputStream(xlfile);
		wb= new XSSFWorkbook(fi);
		ws=wb.getSheet(xlSheet);
		int rowCount=ws.getLastRowNum();
		wb.close();
		fi.close();
		return rowCount;
	}
	
    public static int getCellCount(String xlfile, String xlSheet , int rownum) throws IOException{
		
		fi =new FileInputStream(xlfile);
		wb= new XSSFWorkbook(fi);
		ws=wb.getSheet(xlSheet);
		row=ws.getRow(rownum);
		int cellCount=row.getLastCellNum();
		wb.close();
		fi.close();
		return cellCount;
	
    }
	
	
    public static String  getCellData(String xlfile, String xlSheet , int rownum,int colnum) throws IOException{
		
 		fi =new FileInputStream(xlfile);
 		wb= new XSSFWorkbook(fi);
 		ws=wb.getSheet(xlSheet);
 		row=ws.getRow(rownum);
 		cell=row.getCell(colnum);
 		String data;
 		
 		try{
 			DataFormatter formater=new DataFormatter();
 			String cellData=formater.formatCellValue(cell);
 			return cellData;
 		}catch(Exception e){
 			data="";
 		}
 		wb.close();
 		fi.close();
 		return data;
 	
     }
	
     public static void setCellData(String xlfile, String xlSheet , int rownum,int colnum, String data) throws IOException{
		
 		fi =new FileInputStream(xlfile);
 		wb= new XSSFWorkbook(fi);
 		ws=wb.getSheet(xlSheet);
 		row=ws.getRow(rownum);
 		cell=row.createCell(colnum);
 		cell.setCellValue(data);
 		
 		fo =new FileOutputStream(xlfile);
 		wb.write(fo);
 		wb.close();
 		fi.close();
 		fo.close();
 	
     }
	
	
	
	
	
	

}
