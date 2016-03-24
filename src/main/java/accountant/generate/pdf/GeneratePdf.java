package accountant.generate.pdf;

import java.io.IOException;

import org.apache.pdfbox.exceptions.COSVisitorException;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.edit.PDPageContentStream;
import org.apache.pdfbox.pdmodel.font.PDFont;
import org.apache.pdfbox.pdmodel.font.PDType1Font;

public class GeneratePdf {

	private static PDPageContentStream contentStream;
	
	public static void main(String[] args) throws COSVisitorException, IOException {
		GeneratePdf gnpdf= new GeneratePdf();
		gnpdf.generate();
	}

	public void generate() throws IOException, COSVisitorException {
		PDDocument document = new PDDocument();

		// Create a new blank page and add it to the document
		PDPage page = new PDPage();
		document.addPage( page );

		
		// Create a new font object selecting one of the PDF base fonts
	

		// Start a new content stream which will "hold" the to be created content
		contentStream = new PDPageContentStream(document, page);
		decoratePdf();

		// Define a text content stream using the selected font, moving the cursor and drawing the text "Hello World"
		
		// Save the newly created document
		document.save("/tmp/company/BlankPage1.pdf");

		// finally make sure that the document is properly
		// closed.
		document.close();
	}

	private void decoratePdf () throws IOException{
		PDFont font = PDType1Font.HELVETICA_BOLD;
		contentStream.beginText();
		contentStream.setFont( font, 12 );
		contentStream.moveTextPositionByAmount( 100, 700 );
		contentStream.drawString( "Hello World" );
		contentStream.endText();

		// Make sure that the content stream is closed:
		contentStream.close();
	}
}