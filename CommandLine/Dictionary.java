package CommadLine;

import java.util.HashMap;
import java.util.Map;

public class Dictionary {
	private Map<String,String> map = new HashMap<String, String>();
	public void cinDictionary (Word newWord) {
		this.map.put(newWord.getWord_target(), newWord.getWord_explain());
	}
	public Dictionary () {
	}
	public Map<String, String> getMap() {
		return map;
	}
	public void setMap(Map<String, String> map) {
		this.map = map;
	}
	
}
