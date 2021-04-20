package splitePDF;

import java.io.File;
import java.io.IOException;
import java.util.List;

import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfReader;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.kernel.utils.PageRange;
import com.itextpdf.kernel.utils.PdfSplitter;

public class PDFSplite {

	 public static final String dest1 = "./target/sandbox/merge/splitDocument1_%s.pdf";

	    public static final String resource = "./src/main/resources/pdfs/Wrong.pdf";

	    public static void main(String[] args) throws IOException {
	        File file = new File(dest1);
	        file.getParentFile().mkdirs();

	        new PDFSplite().manipulatePdf(dest1);
	    }

	    protected void manipulatePdf(final String dest) throws IOException {
	        PdfDocument pdfDoc = new PdfDocument(new PdfReader(resource));

	        List<PdfDocument> splitDocuments = new PdfSplitter(pdfDoc) {
	            int partNumber = 1;

	            @Override
	            protected PdfWriter getNextPdfWriter(PageRange documentPageRange) {
	                return new PdfWriter(String.format(dest, partNumber++));
	            }

				public List<PdfDocument> splitBySize(int i) {
					// TODO Auto-generated method stub
					return null;
				}
	        }.splitBySize(200000);

	        for (PdfDocument doc : splitDocuments) {
	            doc.close();
	        }

	        pdfDoc.close();
	        
	        System.out.println("PDF Splitted Successfully");

	}

}
