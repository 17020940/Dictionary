package CommandLine;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

public class DictionaryManagement  {
	private Dictionary dictionary ;
	
	public DictionaryManagement(Dictionary dictionary) {
		this.dictionary = dictionary;
	}
	public DictionaryManagement() {
		dictionary = new Dictionary();
	}
	public Dictionary getDictionary() {
		return dictionary;
	}
	public void setDictionary(Dictionary dictionary) {
		this.dictionary = dictionary;
	}

	Scanner cin = new Scanner(System.in);
	public void insertFromCommandline () {
		int size ;
		size=cin.nextInt();
		cin.nextLine();
		for (int i=0;i<size;i++) {
			String word_target;
			String word_explain;
			word_target= cin.nextLine();
			word_explain = cin.nextLine();
			Word word = new Word (word_target,word_explain);
			this.addDictionary(word);
		}
	}
	public void insertFromFile () {
		File file = new File("dictionary.txt");
		try(Scanner cin = new Scanner(file)) {
		
			while (cin.hasNext()) {
					String line = cin.nextLine();
	
					String str[] = line.split("	");
					Word word = new Word (str[0],str[1]);
			
					this.addDictionary(word);
				}
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		
	}
	public int dictionaryLookUp(String str){
		int a=0;
		int b = dictionary.getDictionary().size()-1 ;
		while (a<=b) {
			int mid = (a+b)/2;
			if (dictionary.getDictionary().get(mid).getWord_target().compareToIgnoreCase(str) > 0) {
				b=mid-1;
			}
			else if (dictionary.getDictionary().get(mid).getWord_target().compareToIgnoreCase(str) < 0) {
				a=mid+1;
			}
			else return mid;	
		}
		return -1;
	}
	 public void addDictionary (Word word) {
	 	 int a=0;
		 int b = dictionary.getDictionary().size()-1 ;
		 int index = 0 ;
		 if (b<1) {
			 if (b==0) {
					if (dictionary.getDictionary().get(0).getWord_target().compareToIgnoreCase(word.getWord_target()) > 0) {
						dictionary.getDictionary().add(0,word);
					}
					else dictionary.getDictionary().add(word);
			 }
			 else {
				 dictionary.getDictionary().add(word);
			 }
		 }
		 else {
			 while (a<=b) {
					int mid = (a+b)/2;
					if (dictionary.getDictionary().get(mid).getWord_target().compareToIgnoreCase(word.getWord_target()) > 0) {
						if (mid==0) {
							index = mid ;
							break ;
						}
						if (dictionary.getDictionary().get(mid-1).getWord_target().compareToIgnoreCase(word.getWord_target()) < 0) {
							index = mid ;
							break ;
						}
						else {
							b=mid -1 ;
						}
					}
					else {
						a=mid+1;
					}
			}
			 if (dictionary.getDictionary().get(dictionary.getDictionary().size()-1).getWord_target().compareToIgnoreCase(word.getWord_target())<0) {
				 dictionary.getDictionary().add(word);
			 }else {
				 dictionary.getDictionary().add(index, word);
			 }
		 }
	 }	
	 public void dictionaryExportToFile() {
		 File file = new File("dictionary.txt");
		 try {
			PrintWriter writer = new PrintWriter(file);
			writer.println();
			for (Word word : dictionary.getDictionary()) {
				writer.print(word.getWord_target()+ "	");
				writer.println(word.getWord_explain());
			}
			writer.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	 }
 	 public void deleteWord(String word_target) {
 		 int index = this.dictionaryLookUp(word_target);
 		 dictionary.getDictionary().remove(index);
 	 }

	
}
