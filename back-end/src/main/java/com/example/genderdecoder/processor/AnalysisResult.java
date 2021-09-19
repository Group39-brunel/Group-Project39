package com.example.genderdecoder.processor;

public class AnalysisResult {
	int countMasculine;
	int countFeminine;
	String genderMap;
	
	public AnalysisResult() {
		countMasculine = 0;
		countFeminine = 0;
		genderMap = new String();
	}

	public int getCountMasculine() {
		return countMasculine;
	}

	public void incrementCountMasculine() {
		this.countMasculine++;
	}

	public int getCountFeminine() {
		return countFeminine;
	}

	public void incrementCountFeminine() {
		this.countFeminine++;
	}

	public String getGenderMap() {
		return genderMap;
	}

	public void insertGenderMap(char code) {
		StringBuffer str= new StringBuffer(genderMap);
		str.append(code);
		genderMap = str.toString();
	}

	
	
}
