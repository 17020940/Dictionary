package CommadLine;

import java.util.Scanner;


public class DictionaryManagement {
	public void insertFromCommandline (Dictionary dictionary) {
		int size ;
		Scanner cin = new Scanner(System.in);
		size=cin.nextInt();
		cin.nextLine();
		for (int i=0;i<size;i++) {
		String word_target;
		String word_explain;
		word_target= cin.nextLine();
		word_explain = cin.nextLine();
		Word word = new Word (word_target,word_explain);
		dictionary.cinDictionary(word);
		}
	}
	
}
