package CommadLine;

import java.util.Map.Entry;

public class DictionaryCommandline {
	public void showAllWords (Dictionary dictionary) {
		int j = 0 ;
		System.out.println("No  | English             | Vietnamese");
		for (Entry<String, String> s : dictionary.getMap().entrySet()) {
			String str="";
			for ( int i=s.getKey().length();i<20;i++) {
				str+=' ';
			}
			j++;
			System.out.println(j+"   | "+s.getKey()+str+"| "+s.getValue());
		}
	}
	public void dictionaryBasic(Dictionary dictionary) {
		DictionaryManagement DM = new DictionaryManagement();
		DictionaryCommandline DC = new DictionaryCommandline();
		DM.insertFromCommandline(dictionary);
		DC.showAllWords(dictionary);
	}
	public static void main (String[] args) {
		Dictionary dictionary=new Dictionary();
		DictionaryCommandline DC = new DictionaryCommandline();
		DC.dictionaryBasic(dictionary);
	}
}
