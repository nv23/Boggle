import java.util.*;



public class BinarySearchLexicon implements ILexicon {

    private ArrayList<String> myWords;
    
    public BinarySearchLexicon() {
        myWords = new ArrayList<String>();
    }
    
    public void load(Scanner s) {
        myWords.clear();
        while (s.hasNext()){
            myWords.add(s.next().toLowerCase());
        }
        Collections.sort(myWords);
    }

    public void load(ArrayList<String> list) {
        myWords.clear();
        myWords.addAll(list);
        Collections.sort(myWords);
    }

    public LexStatus wordStatus(StringBuilder s) {
        return wordStatus(s.toString());
    }

    public LexStatus wordStatus(String s) {

    	// You need to make this code use Binary Search
    	int val = Collections.binarySearch(myWords, s);
    	if (val >= 0) return LexStatus.WORD;
    	else {
    		if ((val * -1) - 1 < myWords.size()) {
    			if (s.length() <= myWords.get((val * -1) - 1).length()) {
    				if (myWords.get((val * -1) - 1).startsWith(s)) { 
    					return LexStatus.PREFIX;
    				}
    			}
    		}
    	}

        return LexStatus.NOT_WORD;
    }

    public Iterator<String> iterator() {
        return myWords.iterator();
    }

    public int size() {
        return myWords.size();
    }

}
