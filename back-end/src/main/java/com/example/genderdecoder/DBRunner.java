package com.example.genderdecoder;

import com.example.genderdecoder.model.ProcessedText;
import com.example.genderdecoder.processor.AnalysisResult;
import com.example.genderdecoder.processor.TextProcessor;
import com.example.genderdecoder.repository.ProcessedTextRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DBRunner implements CommandLineRunner{
	@Autowired 
	private ProcessedTextRepository sampleRepository;
	
	@Autowired
    TextProcessor textProcessor;
	
	@Override
    public void run(String... args) throws Exception {
        sampleRepository.deleteAll();
        
        String sampleText1 = "Looking for a cheerful Java developer";
        AnalysisResult result1 = textProcessor.analyze(sampleText1);
        sampleRepository.save(new ProcessedText(sampleText1, result1.getCountMasculine(), 
        		result1.getCountFeminine(), result1.getGenderMap()));
  
    }

}
