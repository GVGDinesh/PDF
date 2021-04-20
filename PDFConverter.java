package pdfConverter;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class PDFConverter {

	 private static final String orig = "/uploads/input.html";
	    private static final String output = "/myfiles/";

	    public static void main(String[] args) throws IOException {
	        File htmlSource = new File(orig);
	        File pdfDest = new File(output + "output.pdf");
	        HtmlConverter.convertToPdf(new FileInputStream(htmlSource), new FileOutputStream(pdfDest));	
	        
	        
	        System.out.println("PDF Converter");
	    
	    
	    }

}
