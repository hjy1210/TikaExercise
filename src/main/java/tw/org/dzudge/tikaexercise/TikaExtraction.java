package tw.org.dzudge.tikaexercise;

import java.io.File;

import java.io.IOException;

import org.apache.tika.Tika;
import org.apache.tika.exception.TikaException;


public class TikaExtraction {
	
   public static void main(final String[] args) throws IOException, TikaException {

      //Assume sample.txt is in your current directory		        
      File file = new File("d:\\downloads\\a.gpx");
      
      //Instantiating Tika facade class
      Tika tika = new Tika();
      String filecontent = tika.parseToString(file);
      System.out.println("Extracted Content: " + filecontent);
   }		 
}