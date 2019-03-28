package linkedLists;
import java.util.LinkedList;

import linkedLists.MyLL;
public class LLOperations {

	
	public static void main(String[] args) {
		MyLL myll = new MyLL();
		
		myll.add(4);
		myll.add(30);
		myll.add(15);
		
		System.out.println("Add");
		myll.show();
			
		
		myll.addAt(3, 20);
		System.out.println("Add At");
		myll.show();
		
		myll.delete();
		System.out.println("Deletion");
		myll.show();
		
		System.out.println("Delete at Index");
		myll.deleteAt(3);
		myll.show();
		
	}

}
