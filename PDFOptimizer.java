package optimizedPDF;

import java.io.File;
import java.io.IOException;

import com.itextpdf.license.LicenseKey;
import com.itextpdf.pdfoptimizer.PdfOptimizer;
import com.itextpdf.pdfoptimizer.handlers.CompressionOptimizer;
import com.itextpdf.pdfoptimizer.handlers.FontDuplicationOptimizer;
import com.itextpdf.pdfoptimizer.handlers.ImageQualityOptimizer;
import com.itextpdf.pdfoptimizer.handlers.imagequality.processors.JpegCompressor;

public class PDFOptimizer {
	 public static String src = "input_to_be_optimized.pdf";
	    public static String dest = "output_optimized.pdf";

	    public static void main(String args[]) throws IOException {
	        PdfOptimizer_Sample test = new PdfOptimizer_Sample();
	        test.pdfOptimizerTest();
	        
	        System.out.println("PDF Compressed");
	    }

	    public void pdfOptimizerTest() throws IOException {
	        LicenseKey.loadLicenseFile("iText7_licensekey.xml");

	        PdfOptimizer opt = new PdfOptimizer();

	        opt.addOptimizationHandler(new FontDuplicationOptimizer());
	        opt.addOptimizationHandler(new CompressionOptimizer());

	        ImageQualityOptimizer jpeg_optimizer = new ImageQualityOptimizer();
	        jpeg_optimizer.setJpegProcessor(new JpegCompressor(0.5f));
	        opt.addOptimizationHandler(jpeg_optimizer);

	        opt.optimize(
	                new File(src),
	                new File(dest));

	}
	    

}
