package Dictionary;

import java.util.ArrayList;

public class Word {
	private String word_target;
	private ArrayList<String> detail ;
	public Word(String word_target, ArrayList<String> detail) {
		this.word_target = word_target;
		this.detail = detail;
	}
	public String getWord_target() {
		return word_target;
	}
	public void setWord_target(String word_target) {
		this.word_target = word_target;
	}
	public ArrayList<String> getDetail() {
		return detail;
	}
	public void setDetail(ArrayList<String> detail) {
		this.detail = detail;
	}
	
	
}
