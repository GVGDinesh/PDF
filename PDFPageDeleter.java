package pdfPageDeleter;

import java.io.IOException;

import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfReader;
import com.itextpdf.kernel.pdf.PdfWriter;

public class PDFPageDeleter {

	private static final String ORIG = "/uploads/delete.pdf";
    private static final String OUTPUT_FOLDER = "/myfiles/";

    public static void main(String[] args) throws IOException {
        PdfDocument pdfDocument = new PdfDocument(new PdfReader(ORIG), new PdfWriter(OUTPUT_FOLDER + "deleted.pdf"));
        pdfDocument.removePage(1); 
        //Note that as you remove a page the number of pages in your PDF will change
        pdfDocument.close();
        
        System.out.println("PDF Page Delete is Successful");

	}

}
