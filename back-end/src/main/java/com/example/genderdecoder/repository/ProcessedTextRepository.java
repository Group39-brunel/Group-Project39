package com.example.genderdecoder.repository;

import com.example.genderdecoder.model.ProcessedText;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProcessedTextRepository extends JpaRepository<ProcessedText, Long>{

}






