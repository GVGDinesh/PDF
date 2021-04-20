package mergePDF;

import java.io.IOException;

import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfReader;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.kernel.utils.PdfMerger;

public class PDFMerge {
	
	private static final String file_1 = "/uploads/first.pdf";
    private static final String file_2 = "/uploads/second.pdf";
    private static final String output_folder = "/myfiles/";

    public static void main(String args[]) throws IOException {
        PdfDocument pdfDoc1 = new PdfDocument(new PdfReader(file_1), new PdfWriter(output_folder + "merged.pdf"));
        PdfDocument pdfDoc2 = new PdfDocument(new PdfReader(file_2));

        PdfMerger merg= new PdfMerger(pdfDoc1);
        merg.merge(pdfDoc2, 1, pdfDoc2.getNumberOfPages());

        pdfDoc2.close();
        pdfDoc1.close();
        
        System.out.println("PDF Merged Successful");
	}
    
}

