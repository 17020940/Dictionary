package CommandLine;



public class DictionaryCommandline {
	private Dictionary dictionary = new Dictionary() ;
	public DictionaryCommandline() {

	}
	public DictionaryCommandline(Dictionary dictionary) {
		this.dictionary = dictionary;
	}
	public Dictionary getDictionary() {
		return dictionary;
	}
	public void setDictionary(Dictionary dictionary) {
		this.dictionary = dictionary;
	}
	public void showAllWords () {
		System.out.printf("%-5s %-20s %-20s \n" ,"No","| English","| Vietnamses");
		int i=1;
		for (Word word : dictionary.getDictionary()) {
			System.out.printf("%-5s %-20s %-20s \n" ,i,"| "+word.getWord_target(),"| "+word.getWord_explain());
			i++;
		}
	}
	public void dictionaryBasic() {
		DictionaryManagement DM = new DictionaryManagement();
		DictionaryCommandline DC = new DictionaryCommandline();
		DM.insertFromCommandline();
		DC.showAllWords();
	}
	public void dictionaryAdvanced () {
		DictionaryManagement DM = new DictionaryManagement();
		DictionaryCommandline DC = new DictionaryCommandline();
		DM.insertFromFile();
		DC.showAllWords();
	}
	public int seach(String str){
        int a=0;
        int b = dictionary.getDictionary().size()-1;
        while (a<=b) {
                int mid = (a+b)/2;
                if (dictionary.getDictionary().get(mid).getWord_target().toLowerCase().startsWith(str.toLowerCase()) ){
               	 if (mid==0) return mid ;
                    if (dictionary.getDictionary().get(mid-1).getWord_target().toLowerCase().startsWith(str.toLowerCase())){
                        b=mid-1;
                    }
                    else return mid ;
                }
                else {
                    if (str.compareToIgnoreCase(dictionary.getDictionary().get(mid).getWord_target()) < 0){
                        b=mid-1;
                    }
                    else{
                        a=mid+1;
                    }
                }
        }
        return -1;
    }
	 
	public void resultSearch(String str){
			 int index = seach(str);
			 if (index <0) {
				 System.out.println("Khong co tu nao trong danh sach");
			 }
			 else
			 while (index< dictionary.getDictionary().size()&&dictionary.getDictionary().get(index).getWord_target().toLowerCase().startsWith(str)) {
				 System.out.println(dictionary.getDictionary().get(index).getWord_target());
				 index++;
			 }
		}

	
}
