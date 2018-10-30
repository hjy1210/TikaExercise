package tw.org.dzudge.tikaexercise;

import java.io.IOException;

import org.apache.tika.langdetect.OptimaizeLangDetector;
import org.apache.tika.language.detect.LanguageDetector;
import org.apache.tika.language.detect.LanguageResult;

public class LanguageDetectorExample {
	
    public String detectLanguage(String text) throws IOException {
    	LanguageDetector detector = new OptimaizeLangDetector().loadModels();
        LanguageResult result = detector.detect(text);
        return result.getLanguage();
    }
}