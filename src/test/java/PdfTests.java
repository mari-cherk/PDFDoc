
import java.io.File;

import com.itextpdf.text.Document;
import org.testng.Assert;
import org.testng.annotations.Test;

public class PdfTests {

    PdfDocRead pdfDocRead = new PdfDocRead();
    PdfDocWrite pdfDocWrite = new PdfDocWrite();

    @Test
    public void pdfDocReaderWithPdfboxTest() {
        String textFromPDF = pdfDocRead.pdfDocReaderWithPdfbox("retrieveCrashLogs.pdf");
        Assert.assertTrue(textFromPDF.contains("How to retrieve crash logs in OS X"));

        //extract title
        String title = textFromPDF.split("\\n")[0];
        System.out.println(title);
    }

    @Test
    public void pdfDocReaderWithPdfReaderTest() {
        String textFromPDF = pdfDocRead.pdfDocReaderWithPdfReader("sample.pdf", 2);

        Assert.assertTrue(textFromPDF.contains("Simple PDF File 2"));

        String title = textFromPDF.split("\\n")[0];
        System.out.println(title);
    }

    @Test
    public void pdfDocWriteTest(){
        pdfDocWrite.pdfDocWriteFromText();
        File createdFile = new File("E:/Auto/PDFDoc/src/newPdfDoc.pdf");
        Assert.assertTrue(createdFile.exists());
    }
}
