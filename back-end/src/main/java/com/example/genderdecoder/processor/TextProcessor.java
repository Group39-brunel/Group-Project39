package com.example.genderdecoder.processor;
import opennlp.tools.stemmer.PorterStemmer;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;


@Component("textProcessor")
public class TextProcessor {
	String[] feminineCodedWords = {
	                        "agree",
	                        "affectionate",
	                        "child",
	                        "cheer",
	                        "collab",
	                        "commit",
	                        "communal",
	                        "compassion",
	                        "connect",
	                        "considerate",
	                        "cooper",
	                        "depend",
	                        "emotiona",
	                        "empath",
	                        "feel",
	                        "flatterable",
	                        "gentle",
	                        "honest",
	                        "interdependen",
	                        "interperson",
	                        "interdepend",
	                        "kind",
	                        "kinship",
	                        "loyal",
	                        "modesty",
	                        "nag",
	                        "nurtur",
	                        "pleasant",
	                        "polite",
	                        "quiet",
	                        "respon",
	                        "sensitiv",
	                        "submissive",
	                        "support",
	                        "sympath",
	                        "tender",
	                        "together",
	                        "trust",
	                        "understand",
	                        "warm",
	                        "whine",
	                        "enthusias",
	                        "inclusive",
	                        "yield",
	                        "share",
		};
	
	String[] masculineCodedWords = {
	                         "active",
	                         "adventurous",
	                         "aggress",
	                         "ambitio",
	                         "analy",
	                         "assert",
	                         "athlet",
	                         "autonom",
	                         "battle",
	                         "boast",
	                         "challeng",
	                         "champion",
	                         "compet",
	                         "confident",
	                         "courag",
	                         "decid",
	                         "decision",
	                         "decisive",
	                         "defend",
	                         "determin",
	                         "domina",
	                         "dominant",
	                         "driven",
	                         "fearless",
	                         "fight",
	                         "force",
	                         "greedy",
	                         "headstrong",
	                         "hierarch",
	                         "hostil",
	                         "impulsive",
	                         "independen",
	                         "individual",
	                         "intellect",
	                         "lead",
	                         "logic",
	                         "objective",
	                         "opinion",
	                         "outspoken",
	                         "persist",
	                         "principle",
	                         "reckless",
	                         "selfreli",
	                         "selfsuffici",
	                         "selfconfid",
	                         "selfrelian",
	                         "stubborn",
	                         "superior",
	                         "unreasonab"
		};
	
	//public static String[] stopwords = {"a", "as", "able", "about", "above", "according", "accordingly", "across", "actually", "after", "afterwards", "again", "against", "aint", "all", "allow", "allows", "almost", "alone", "along", "already", "also", "although", "always", "am", "among", "amongst", "an", "and", "another", "any", "anybody", "anyhow", "anyone", "anything", "anyway", "anyways", "anywhere", "apart", "appear", "appreciate", "appropriate", "are", "arent", "around", "as", "aside", "ask", "asking", "associated", "at", "available", "away", "awfully", "be", "became", "because", "become", "becomes", "becoming", "been", "before", "beforehand", "behind", "being", "believe", "below", "beside", "besides", "best", "better", "between", "beyond", "both", "brief", "but", "by", "cmon", "cs", "came", "can", "cant", "cannot", "cant", "cause", "causes", "certain", "certainly", "changes", "clearly", "co", "com", "come", "comes", "concerning", "consequently", "consider", "considering", "contain", "containing", "contains", "corresponding", "could", "couldnt", "course", "currently", "definitely", "described", "despite", "did", "didnt", "different", "do", "does", "doesnt", "doing", "dont", "done", "down", "downwards", "during", "each", "edu", "eg", "eight", "either", "else", "elsewhere", "enough", "entirely", "especially", "et", "etc", "even", "ever", "every", "everybody", "everyone", "everything", "everywhere", "ex", "exactly", "example", "except", "far", "few", "ff", "fifth", "first", "five", "followed", "following", "follows", "for", "former", "formerly", "forth", "four", "from", "further", "furthermore", "get", "gets", "getting", "given", "gives", "go", "goes", "going", "gone", "got", "gotten", "greetings", "had", "hadnt", "happens", "hardly", "has", "hasnt", "have", "havent", "having", "he", "hes", "hello", "help", "hence", "her", "here", "heres", "hereafter", "hereby", "herein", "hereupon", "hers", "herself", "hi", "him", "himself", "his", "hither", "hopefully", "how", "howbeit", "however", "i", "id", "ill", "im", "ive", "ie", "if", "ignored", "immediate", "in", "inasmuch", "inc", "indeed", "indicate", "indicated", "indicates", "inner", "insofar", "instead", "into", "inward", "is", "isnt", "it", "itd", "itll", "its", "its", "itself", "just", "keep", "keeps", "kept", "know", "knows", "known", "last", "lately", "later", "latter", "latterly", "least", "less", "lest", "let", "lets", "like", "liked", "likely", "little", "look", "looking", "looks", "ltd", "mainly", "many", "may", "maybe", "me", "mean", "meanwhile", "merely", "might", "more", "moreover", "most", "mostly", "much", "must", "my", "myself", "name", "namely", "nd", "near", "nearly", "necessary", "need", "needs", "neither", "never", "nevertheless", "new", "next", "nine", "no", "nobody", "non", "none", "noone", "nor", "normally", "not", "nothing", "novel", "now", "nowhere", "obviously", "of", "off", "often", "oh", "ok", "okay", "old", "on", "once", "one", "ones", "only", "onto", "or", "other", "others", "otherwise", "ought", "our", "ours", "ourselves", "out", "outside", "over", "overall", "own", "particular", "particularly", "per", "perhaps", "placed", "please", "plus", "possible", "presumably", "probably", "provides", "que", "quite", "qv", "rather", "rd", "re", "really", "reasonably", "regarding", "regardless", "regards", "relatively", "respectively", "right", "said", "same", "saw", "say", "saying", "says", "second", "secondly", "see", "seeing", "seem", "seemed", "seeming", "seems", "seen", "self", "selves", "sensible", "sent", "serious", "seriously", "seven", "several", "shall", "she", "should", "shouldnt", "since", "six", "so", "some", "somebody", "somehow", "someone", "something", "sometime", "sometimes", "somewhat", "somewhere", "soon", "sorry", "specified", "specify", "specifying", "still", "sub", "such", "sup", "sure", "ts", "take", "taken", "tell", "tends", "th", "than", "thank", "thanks", "thanx", "that", "thats", "thats", "the", "their", "theirs", "them", "themselves", "then", "thence", "there", "theres", "thereafter", "thereby", "therefore", "therein", "theres", "thereupon", "these", "they", "theyd", "theyll", "theyre", "theyve", "think", "third", "this", "thorough", "thoroughly", "those", "though", "three", "through", "throughout", "thru", "thus", "to", "together", "too", "took", "toward", "towards", "tried", "tries", "truly", "try", "trying", "twice", "two", "un", "under", "unfortunately", "unless", "unlikely", "until", "unto", "up", "upon", "us", "use", "used", "useful", "uses", "using", "usually", "value", "various", "very", "via", "viz", "vs", "want", "wants", "was", "wasnt", "way", "we", "wed", "well", "were", "weve", "welcome", "well", "went", "were", "werent", "what", "whats", "whatever", "when", "whence", "whenever", "where", "wheres", "whereafter", "whereas", "whereby", "wherein", "whereupon", "wherever", "whether", "which", "while", "whither", "who", "whos", "whoever", "whole", "whom", "whose", "why", "will", "willing", "wish", "with", "within", "without", "wont", "wonder", "would", "would", "wouldnt", "yes", "yet", "you", "youd", "youll", "youre", "youve", "your", "yours", "yourself", "yourselves", "zero"};
	
	HashSet<String> masculineCodedSet;
	HashSet<String> feminineCodedSet;
	//HashSet<String> stopWordsSet;
	PorterStemmer porterStemmer;
	
	public TextProcessor() {
		masculineCodedSet = new HashSet<String>();
		feminineCodedSet  = new HashSet<String>();
		//stopWordsSet = new HashSet<String>(Arrays.asList(stopwords));
		
		porterStemmer = new PorterStemmer();
		for (String word : masculineCodedWords) {
			String stem = this.porterStemmer.stem(word);
			masculineCodedSet.add(stem);
		}
		for (String word : feminineCodedWords) {
			String stem = porterStemmer.stem(word);
			feminineCodedSet.add(stem);
		}
				
	}

	public AnalysisResult analyze(String text) {
		AnalysisResult result = new AnalysisResult();
		
	   List<String> tokenizedText = Arrays.asList(text.toLowerCase().split(" "));
		
		for (String token : tokenizedText) {
			//if(stopWordsSet.contains(token))
			//	continue;	
		    String stem = porterStemmer.stem(token.replace("-", ""));
		    if (masculineCodedSet.contains(stem)) {
		    	result.incrementCountMasculine();
		     	result.insertGenderMap('m');
		    } 	
		    else if(feminineCodedSet.contains(stem)) {
		    	result.incrementCountFeminine();
		    	result.insertGenderMap('f');
		    }else {
		    	result.insertGenderMap('n');
		    }
		}
		
		return result;
				
	}
}
