package arraysAndStrings;

// Pr. 1.3 Page 48
public class RemoveDuplicatesInString {

	public static void removeDuplicates(String s) {
		if(s == null) return;
		if(s.length() < 2) return;
		
		char []charArray = s.toCharArray();
		boolean []lookUpArray = new boolean[256];
		int tail = 1;	
		lookUpArray[charArray[0]] = true;
		for(int index = 1; index < s.length(); index++) {
			int el = charArray[index];
			if(lookUpArray[el] == true) { // el is a duplicate
				
			} else {
				lookUpArray[el] = true;
				charArray[tail] = charArray[index];
				tail++;				
			}			
		}
		if(tail < s.length()) {
			charArray[tail] = 0; // terminating null char			
			for (int j = tail+1; j < s.length(); j++) {
				charArray[j] = 0;
			}		
		}
			
		System.out.println(charArray);
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		removeDuplicates("aba");
	}

}
