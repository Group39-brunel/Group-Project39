package com.example.genderdecoder.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "GenderText")
@EntityListeners(AuditingEntityListener.class)
@JsonIgnoreProperties(value = {"createdAt", "updatedAt"}, 
allowGetters = true)

public class ProcessedText implements Serializable {

		private static final long serialVersionUID = 1L;

		@Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Long id;

	    @NotBlank
	    private String text;
	    
	    @NotNull
	    private int countMasculine;
	    
	    @NotNull
	    private int countFeminine;
	    
	    private String genderMap;
	    
	    @Column(nullable = false, updatable = false)
	    @Temporal(TemporalType.TIMESTAMP)
	    @CreatedDate
	    private Date createdAt;

	    @Column(nullable = false)
	    @Temporal(TemporalType.TIMESTAMP)
	    @LastModifiedDate
	    private Date updatedAt;
	   
	    public ProcessedText() {
	    	
	    }

	    public ProcessedText(String text, 
	    					 int countMasculine, int countFeminine, 
	    					 String genderMap) {
	    	this.text = text;
	    	this.countMasculine = countMasculine;
	    	this.countFeminine = countFeminine;
	    	this.genderMap = genderMap;
	    	
	    }
	    
	 // Getters and Setters 
		public Long getId() {
			return id;
		}

		public void setId(Long id) {
			this.id = id;
		}

		public String getText() {
			return text;
		}

		public void setText(String text) {
			this.text = text;
		}

		public int getCountMasculine() {
			return countMasculine;
		}

		public void setCountMasculine(int countMasculine) {
			this.countMasculine = countMasculine;
		}

		public int getCountFeminine() {
			return countFeminine;
		}

		public void setCountFeminine(int countFeminine) {
			this.countFeminine = countFeminine;
		}
		
		public String getGenderMap() {
			return genderMap;
		}
		
		public void setGenderMap(String genderMap) {
			this.genderMap = genderMap;
		}
	    
}

