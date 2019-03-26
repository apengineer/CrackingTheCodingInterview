package arraysAndStrings;

import java.util.HashMap;
import java.util.Map;

public class UniqueCharsInString {

	// very bad solution
	public static boolean hasAllUniquChars(String s) {
		Map<Character, Integer> countMap = new HashMap<Character, Integer>();
		char []charArray = s.toCharArray();
		
		for(char c: charArray) {
			if(countMap.containsKey(c)) {
				return false;
			} else {
				Character ch = new Character(c);
				countMap.put(ch, 1);
			}
		}
		
		return true;
	}
	
	/* use boolean array. Consider only ASCII characters. Hence 256.
	 * int val = s.charAt(i) is the key. This returns ASCII value of the character
	*/
	public static boolean hasAllUniqueCharsGoodSol(String s) {
		boolean []charArray = new boolean[256];
		for (int i = 0; i < s.length(); i++) {
			int val = s.charAt(i);
			System.out.println(val);
			if(charArray[val]) {
				return false;
			} else {
				charArray[val] = true;
			}
		}
		return true;
	}
	
	public static void main(String[] args) {
		String s = "!abc";
		System.out.println(hasAllUniquChars(s));
		System.out.println(hasAllUniqueCharsGoodSol(s));
	}

}
