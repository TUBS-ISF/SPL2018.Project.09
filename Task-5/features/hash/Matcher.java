import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;





public class Matcher {
	
	public ArrayList<Integer> search(String p, String text) {
		ArrayList<Integer> ans = new ArrayList<Integer>();
		long h = 1;
		for(int i =0; i < p.length(); i++) {
			h *= p.charAt(i);
		}
		long[] ha = Hash.getHashArray(text);
		for(int i =0; i < text.length() - p.length()+1; i++) {
			if(h == Hash.getHash(ha,i, i+p.length()-1)) {
				ans.add(i);
			}
		}
		return ans;
	}
}