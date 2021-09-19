package com.example.genderdecoder.controller;

import com.example.genderdecoder.exception.ResourceNotFoundException;
import com.example.genderdecoder.model.ProcessedText;
import com.example.genderdecoder.repository.ProcessedTextRepository;
import com.example.genderdecoder.processor.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/")
public class ProcessedTextController {

    @Autowired
    ProcessedTextRepository textRepository;
    
    @Autowired
    TextProcessor textProcessor;
    
    //Analyze a Job Text
    @PostMapping("/analyze")
    public ProcessedText analyzeProcessedText(@Valid @RequestBody ProcessedText text) {
        AnalysisResult result = textProcessor.analyze(text.getText());
        text.setCountFeminine(result.getCountFeminine());
        text.setCountMasculine(result.getCountMasculine());
        text.setGenderMap(result.getGenderMap());
    	return text;
    }

    // Get All Job Texts
    @GetMapping("/texts")
    public List<ProcessedText> getAllTexts() {
        return textRepository.findAll();
    }

    // Create a new Job Text
    @PostMapping("/texts")
    public ProcessedText createProcessedText(@Valid @RequestBody ProcessedText text) {
        ProcessedText processed = analyzeProcessedText(text);
    	return textRepository.save(processed);
    }

    // Get a Single Job Text
    @GetMapping("/texts/{id}")
    public ProcessedText getNoteById(@PathVariable(value = "id") Long textId) {
        return textRepository.findById(textId)
                .orElseThrow(() -> new ResourceNotFoundException("Text", "id", textId));
    }


    // Delete a Job Text
    @DeleteMapping("/texts/{id}")
    public ResponseEntity<?> deleteNote(@PathVariable(value = "id") Long textId) {
        ProcessedText text = textRepository.findById(textId)
                .orElseThrow(() -> new ResourceNotFoundException("Text", "id", textId));

        textRepository.delete(text);

        return ResponseEntity.ok().build();
    }
}
