import java.io.IOException;

import com.itextpdf.text.Document;
import com.itextpdf.text.pdf.PdfReader;
import com.itextpdf.text.pdf.parser.PdfTextExtractor;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;

public class PdfDocRead {

    public String pdfDocReaderWithPdfbox(String fileName) {

        String pdfText = null;

        try {
            PDDocument document = PDDocument.load(getClass().getClassLoader().getResourceAsStream(fileName));
            pdfText = new PDFTextStripper().getText(document);

        } catch (IOException e) {
            e.printStackTrace();
        }
        return pdfText;
    }

    public String pdfDocReaderWithPdfReader(String fileName, int pageNumber) {

        String textFromPage = null;

        try {
            PdfReader reader = new PdfReader(getClass().getClassLoader().getResourceAsStream(fileName));
            //pageNumber = 1
            textFromPage = PdfTextExtractor.getTextFromPage(reader, pageNumber);
            reader.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
        return textFromPage;
    }
}
