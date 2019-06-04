package com.tikal.toledo.reporte;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFClientAnchor;
import org.apache.poi.hssf.usermodel.HSSFFont;
import org.apache.poi.hssf.usermodel.HSSFPatriarch;
import org.apache.poi.hssf.usermodel.HSSFPicture;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.hssf.util.HSSFColor;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.HorizontalAlignment;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.usermodel.Row;

import com.tikal.toledo.model.Producto;
import com.tikal.toledo.model.Tornillo;

public class ReporteInventario {

	public HSSFWorkbook getReporte(List<Producto> productos, List<Tornillo> tornillos) throws IOException{
		
		HSSFWorkbook workbook = new HSSFWorkbook();
		HSSFSheet sheet = workbook.createSheet();
		workbook.setSheetName(0, "Hoja excel");
		 HSSFFont font1 = workbook.createFont();
	 	 CellStyle style = workbook.createCellStyle();
         //  style.setBorderBottom(CellStyle.BORDER_THIN);
           style.setFillBackgroundColor(IndexedColors.AQUA.getIndex());
         //  style.setAlignment(HorizontalAlignment.CENTER);
           font1.setBold(true);
           font1.setFontHeightInPoints((short)11);
           font1.setColor(HSSFColor.BLACK.index);
           style.setFont(font1);

		String[] headers = new String[] { "CLAVE", "NOMBRE","MARCA", "PROVEEDOR", "ULTIMO PROVEEDOR", "MEDIDAS", "EXISTENCIAS","PRECIO MOSTRADOR","PRECIO MAYOREO","PRECIO CRÉDITO"};
		int[] ws = new int[] { 256*10, 256*50,256*15,256*20,256*15, 256*10, 256*10,256*20,256*20,256*20};
		CellStyle headerStyle = workbook.createCellStyle();
		Font font = workbook.createFont();
		font.setBoldweight(Font.BOLDWEIGHT_BOLD);
		headerStyle.setFont(font);

        HSSFRow headerRow = sheet.createRow(0);
        for (int i = 0; i < headers.length; ++i) {
            String header = headers[i];
            HSSFCell cell = headerRow.createCell(i);
            cell.setCellStyle(headerStyle);
            sheet.setColumnWidth(i,ws[i]);
            cell.setCellValue(header);
        }
        
        List<ReporteRenglon> renglones= new ArrayList<ReporteRenglon>();
        for(Producto p: productos){
        	renglones.add(new ReporteRenglon(p));
        }
        for(Tornillo t: tornillos){
        	renglones.add(new ReporteRenglon(t));
        }
        for(int i=0; i<renglones.size();i++){
        	ReporteRenglon reng= renglones.get(i);
        	HSSFRow dataRow = sheet.createRow(i + 1);
        	reng.llenarRenglon(dataRow);
        	
        }
        
//        HSSFPatriarch patriarch = sheet.createDrawingPatriarch();
//	       HSSFClientAnchor anchor;
//	       anchor = new HSSFClientAnchor(500,100,600,200,(short)0,0,(short)1,0);
//	      anchor.setAnchorType( 2 );
//	      anchor.setRow2(2);
//	      // alto= new HSSFCientA
//	       File file= new File("WEB-INF/Images/AutosolverLogo.jpg");
//	       
//	       HSSFPicture picture =  patriarch.createPicture(anchor, loadPicture(file, workbook ));
//	       
//	       Row fil = sheet.createRow(1);
//	       Cell celda = fil.createCell(2);
//	       celda.setCellValue("CORTE DE CAJA GLOBAL");
//	       celda.setCellStyle(style);
//        sheet.setColumnWidth(0, 13*256);
//        sheet.setColumnWidth(1, 35*256);
//        sheet.setColumnWidth(3, 15*256);
//        sheet.setColumnWidth(4, 20*256);
//        sheet.setColumnWidth(5, 25*256);
//        sheet.setColumnWidth(6, 40*256);
//        sheet.setColumnWidth(7, 13*256);
//        sheet.setColumnWidth(8, 13*256);
//        sheet.setColumnWidth(9, 13*256);
//        sheet.setColumnWidth(10, 20*256);
		return workbook;
	}
	
	private static int loadPicture( File path, HSSFWorkbook wb ) throws IOException
    {
    int pictureIndex;
   FileInputStream fis = null;
    ByteArrayOutputStream bos = null;
    try
    {
       // read in the image file
        fis = new FileInputStream(path);
        bos = new ByteArrayOutputStream( );
        int c;
       // copy the image bytes into the ByteArrayOutputStream
        while ( (c = fis.read()) != -1)
            bos.write( c );
    
       // add the image bytes to the workbook
        pictureIndex = wb.addPicture(bos.toByteArray(), HSSFWorkbook.PICTURE_TYPE_PNG );
 
    }
    finally
    {
        if (fis != null)
            fis.close();
        if (bos != null)
            bos.close();
    }
    return pictureIndex;
    }
}

