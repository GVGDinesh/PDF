package pdfRotations;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;



import com.itextpdf.text.pdf.PdfDictionary;
import com.itextpdf.text.pdf.PdfName;
import com.itextpdf.text.pdf.PdfNumber;
import com.itextpdf.text.pdf.PdfReader;
import com.itextpdf.text.pdf.PdfStamper;

@WrapToTest
public class PDFRotations {

	public static final String src = "resources/pdfs/pages.pdf";
    public static final String dest = "results/stamper/pages_rotated90degrees.pdf";

    public static void main(String[] args) throws IOException {
        File file = new File(dest);
        file.getParentFile().mkdirs();
        new PDFRotations().manipulatePdf(src, dest);
        
        System.out.println("Add 90 degrees rotation to the PDF");
    }


    public void manipulatePdf(String src1, String dest1) throws IOException {
        PdfReader reader = new PdfReader(src1);
        int n = reader.getNumberOfPages();
        PdfDictionary page;
        PdfNumber rotate;
        for (int p = 1; p <= n; p++) {
            page = reader.getPageN(p);
            rotate = page.getAsNumber(PdfName.ROTATE);
            if (rotate == null) {
                page.put(PdfName.ROTATE, new PdfNumber(90));
            }
            else {
                page.put(PdfName.ROTATE, new PdfNumber((rotate.intValue() + 90) % 360));
            }
        }
        PdfStamper stamper = new PdfStamper(reader, new FileOutputStream(dest1));
        stamper.close();
        reader.close();
        
        
	}

}
