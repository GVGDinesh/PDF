package unlockPDF;

import java.io.IOException;

import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfReader;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.kernel.pdf.ReaderProperties;

public class UnLockPDF {
	 private static final String ORIG = "/uploads/unlock.pdf";
	    private static final String OUTPUT_FOLDER = "/myfiles/";
	    private static final byte[] OWNERPASS = "owner".getBytes();

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		  ReaderProperties readerProperties = new ReaderProperties().setPassword(OWNERPASS);
	        PdfReader pdfReader = new PdfReader(ORIG, readerProperties);
	        PdfDocument pdfDocument = new PdfDocument(pdfReader, new PdfWriter(OUTPUT_FOLDER + "Unlocked.pdf"));
	        pdfDocument.close();
	        
	        System.out.println("PDF Unlock Successful");

	}

}
