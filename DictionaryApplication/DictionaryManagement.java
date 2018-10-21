package Dictionary;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.io.Reader;
import java.io.UnsupportedEncodingException;
import java.io.Writer;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;




public class DictionaryManagement {
	private static ArrayList<Word> dictionary = new ArrayList<Word>() ;

	public DictionaryManagement() {
		super();
	}

	public ArrayList<Word> getDictionary() {
		return dictionary;
	}

	public void setDictionary(ArrayList<Word> dictionary) {
		this.dictionary = dictionary;
	}
	public void inputDictionary() {
		try {
			File inFile =new File ("dictionary.txt");
			FileInputStream fileInPutStream = new FileInputStream(inFile);
                        Reader fileReader = new java.io.InputStreamReader(fileInPutStream, "utf8");
			BufferedReader reader = new BufferedReader(fileReader);
			String line = null ;
			while ((line = reader.readLine()) != null){
				String word_target ;
				ArrayList<String> detail = new ArrayList<>();
				String[] str = line.split(",");
				int size = str.length;
				word_target = str[0];
				for (int i=1;i<size;i++) {
					detail.add(str[i]);
				}
				Word word1 = new Word(word_target,detail);
				this.dictionary.add(word1);
			}
			reader.close();
			
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}
	public int dictionaryLookUp(String str){
		int a=1;
		int b = this.getDictionary().size()-1 ;
		while (a<=b) {
			int mid = (a+b)/2;
			if (this.getDictionary().get(mid).getWord_target().compareToIgnoreCase(str) > 0) {
				b=mid-1;
			}
			else if (this.getDictionary().get(mid).getWord_target().compareToIgnoreCase(str) < 0) {
				a=mid+1;
			}
			else return mid;	
		}
		return -1;
	}
        public int seach(String str){
         int a=1;
         int b = this.getDictionary().size()-1;
         while (a<=b) {
                 int mid = (a+b)/2;
                 if (this.getDictionary().get(mid).getWord_target().toLowerCase().startsWith(str.toLowerCase()) ){
                     if (this.getDictionary().get(mid-1).getWord_target().toLowerCase().startsWith(str.toLowerCase())){
                         b=mid-1;
                     }
                     else return mid ;
                 }
                 else {
                     if (str.compareToIgnoreCase(this.getDictionary().get(mid).getWord_target()) < 0){
                         b=mid-1;
                     }
                     else{
                         a=mid+1;
                     }
                 }
         }
         return -1;
         
     }
	 public ArrayList<String> resultSearch(String str){
		 ArrayList<String> result = new ArrayList<>();
		 int index = seach(str);
                 if (index < 0 ) return result;
		 while (index < this.getDictionary().size()&&this.getDictionary().get(index).getWord_target().toLowerCase().startsWith(str.toLowerCase())) {
			 result.add(this.getDictionary().get(index).getWord_target());
			 index++;
		 }
		 return result;
	}
         public void add (Word word) {
	 	 int a=1;
		 int b = this.getDictionary().size()-1 ;
		 int index = 1 ;
		 while (a<=b) {
			int mid = (a+b)/2;
			if (this.getDictionary().get(mid).getWord_target().compareToIgnoreCase(word.getWord_target()) > 0) {
				if (this.getDictionary().get(mid-1).getWord_target().compareToIgnoreCase(word.getWord_target()) < 0) {
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
			if (this.getDictionary().get(this.getDictionary().size()-1).getWord_target().compareToIgnoreCase(word.getWord_target()) < 0) {
				index = this.getDictionary().size();
			}
		 }
		 this.getDictionary().add(index, word);
	 }
	 public void addTxt() throws FileNotFoundException, UnsupportedEncodingException  {
		 File file = new File("dictionary.txt");
                FileOutputStream fileOutputStream= new FileOutputStream(file);
                OutputStreamWriter outPutStreamWriter = new OutputStreamWriter(fileOutputStream,"utf8");
                BufferedWriter writer = new BufferedWriter(outPutStreamWriter);

            try {
                writer.append("\r\n");
                for (int i=1;i<this.getDictionary().size();i++) {
                             writer.append(this.getDictionary().get(i).getWord_target()+",");
                             for (String str : this.getDictionary().get(i).getDetail()) {
                                 if (!"".equals(str)) writer.append(str+",");
                             }
                             if(i<this.getDictionary().size()-1 )writer.append("\r\n");
                         }
                writer.flush();
                writer.close();
                
            } catch (IOException ex) {
                Logger.getLogger(DictionaryManagement.class.getName()).log(Level.SEVERE, null, ex);
            }
	 }
         
	public static void main(String[] args) {
		DictionaryManagement DM= new DictionaryManagement();
                DictionaryManagement Dm = new DictionaryManagement();
                DM.inputDictionary();
                System.out.println(DM.dictionaryLookUp("a"));
                System.out.println(Dm.seach("a"));
		
           
	}

}
