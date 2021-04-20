package pdfSecurity;

import java.io.FileOutputStream;
import java.io.IOException;

import com.itextpdf.kernel.pdf.EncryptionConstants;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfReader;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.kernel.pdf.WriterProperties;

public class PDFSecurity {
	 private static final String ORIG = "/uploads/protect.pdf";
	    private static final String OUTPUT_FOLDER = "/myfiles/";
	    private static final byte[] USERPASS = "user".getBytes();
	    private static final byte[] OWNERPASS = "owner".getBytes();

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		PdfReader pdfReader = new PdfReader(ORIG);
        WriterProperties writerProperties = new WriterProperties();
        writerProperties.setStandardEncryption(USERPASS, OWNERPASS, EncryptionConstants.ALLOW_PRINTING, EncryptionConstants.ENCRYPTION_AES_128);
        PdfWriter pdfWriter = new PdfWriter(new FileOutputStream(OUTPUT_FOLDER + "Protected.pdf"), writerProperties);
        PdfDocument pdfDocument = new PdfDocument(pdfReader, pdfWriter);
        pdfDocument.close();
        
        System.out.println("PDF Security Successful");

	}

}
