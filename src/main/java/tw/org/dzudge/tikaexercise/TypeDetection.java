package tw.org.dzudge.tikaexercise;
import java.io.File;

import org.apache.tika.Tika;

public class TypeDetection {

   public static void main(String[] args) throws Exception {

      //assume example.mp3 is in your current directory
      File file = new File("d:\\mia\\img_1902dup.txt");//
      
      //Instantiating tika facade class 
      Tika tika = new Tika();
      
      //detecting the file type using detect method
      String filetype = tika.detect(file);
      System.out.println(filetype);
   }
}