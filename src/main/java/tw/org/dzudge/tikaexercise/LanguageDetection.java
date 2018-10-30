package tw.org.dzudge.tikaexercise;

import java.io.IOException;

import org.apache.tika.exception.TikaException;
//import org.apache.tika.language.LanguageIdentifier;

import org.xml.sax.SAXException;

public class LanguageDetection {

   public static void main(String args[])throws IOException, SAXException, TikaException {

      //LanguageIdentifier identifier = new LanguageIdentifier("同形異碼");
      //String language = identifier.getLanguage();
      //System.out.println("Language of the given content is : " + language);
      LanguageDetectorExample example=new LanguageDetectorExample();
      System.out.println(example.detectLanguage("中華民國同形異碼"));
      System.out.println(example.detectLanguage("同形異碼"));   }
}