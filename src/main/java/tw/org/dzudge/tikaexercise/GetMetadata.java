package tw.org.dzudge.tikaexercise;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.tika.exception.TikaException;
import org.apache.tika.metadata.Metadata;
import org.apache.tika.parser.AutoDetectParser;
import org.apache.tika.parser.ParseContext;
import org.apache.tika.parser.Parser;
import org.apache.tika.sax.BodyContentHandler;

import org.xml.sax.SAXException;

public class GetMetadata {

    public static void main(final String[] args) throws IOException, TikaException {

        // Assume that boy.jpg is in your current directory
        File file = new File("d:\\mia\\img_1902dup.txt");

        // Parser method parameters
        Parser parser = new AutoDetectParser();
        BodyContentHandler handler = new BodyContentHandler();
        Metadata metadata = new Metadata();
        FileInputStream inputstream = new FileInputStream(file);
        ParseContext context = new ParseContext();

        try {
            parser.parse(inputstream, handler, metadata, context);
        } catch (SAXException e) {
            // Auto-generated catch block
            e.printStackTrace();
        }
        System.out.println(handler.toString());

        // getting the list of all meta data elements
        String[] metadataNames = metadata.names();

        for (String name : metadataNames) {
            System.out.println(name + ": " + metadata.get(name));
        }
    }
}