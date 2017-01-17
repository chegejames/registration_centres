import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.tika.Tika;
import org.apache.tika.exception.TikaException;
import org.apache.tika.metadata.Metadata;
import org.apache.tika.parser.ParseContext;
import org.apache.tika.parser.Parser;
import org.apache.tika.parser.pdf.PDFParser;
import org.apache.tika.sax.BodyContentHandler;
import org.xml.sax.ContentHandler;
import org.xml.sax.SAXException;

public class PDF {
	
	public PDF(){
	}
		
	public static void main(String[] args) throws IOException, TikaException, SAXException{
			FileInputStream stream = new FileInputStream(new File("gazette-vol--141222016-special-iebc-roaroregistration-centres-2.pdf"));
			FileOutputStream out = new FileOutputStream(new File("gazette-vol--141222016-special-iebc-roaroregistration-centres-2.txt"));
			Metadata meta = new Metadata();
			ParseContext context = new ParseContext();
			Parser parser = new PDFParser();
			ContentHandler handler = new BodyContentHandler(out);
			parser.parse(stream, handler, meta, context);
			stream.close();
			out.close();
			
	}

}
