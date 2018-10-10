package CommandLine;

import java.util.ArrayList;

public class Dictionary {
	private static ArrayList<Word> dictionary   ;
	public Dictionary() {
		dictionary = new ArrayList<>();
	}

	public ArrayList<Word> getDictionary() {
		return dictionary;
	}

	public void setDictionary(ArrayList<Word> dictionary) {
		Dictionary.dictionary = dictionary;
	}
	
}
