package aqui;

import java.io.*;
import java.util.*;





public class Main {

	public static class Trie {
		public static  class Node {
			Node[] childs;
			boolean isEnd;
			String str;
			
			Node(){
				childs = new Node[26];
			}
		}
		
		final private Node root;
		/** initialize your data structure here. */
		public Trie() {
			root= new Node();
		}
		
		/** insert a word into the trie */
		public void insert (String word) {
			Node curr = root;
			for(int i=0; i<word.length();i++) {
				char ch= word.charAt(i);
				
				if (curr.childs[ch-'a']== null) {
					curr.childs[ch-'a'] = new Node();
				}
				curr = curr.childs[ch-'a'];
			}
			curr.isEnd=true;
		}
		/** returns if the word is in the trie */
		public boolean search (String word) {
			
			Node curr =root;
			for(int i=0; i<word.length();i++) {
				char ch= word.charAt(i);
				
				if(curr.childs[ch-'a']==null)return false;
				curr = curr.childs[ch-'a'];
							
			}
			return curr.isEnd;
	
		}
		/** returns if there is any word in the trie
		 * that stars with the given prefix. */
		 
		 public boolean startsWith (String prefix) {
			 Node curr =root;
				for(int i=0; i<prefix.length();i++) {
					char ch= prefix.charAt(i);
					
					if(curr.childs[ch-'a']==null)return false;
					curr = curr.childs[ch-'a'];
								
				}
				return true;
		 }
		 
	}
	public static void main(String[] args) throws Exception {
	    BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
	    String keys[] = {"the", "a", "there", "answer", "any",
                "by", "bye", "their"};

	    String output[] = {"Not present in trie", "Present in trie"};
	    Trie obj = new Trie();
	    
	    
	    for(int i=0;i<keys.length;i++)
	    	obj.insert(keys[i]);
	    
	    if(obj.search("the") == true)
            System.out.println("the --- " + output[1]);
        else System.out.println("the --- " + output[0]);
         
        if(obj.search("these") == true)
            System.out.println("these --- " + output[1]);
        else System.out.println("these --- " + output[0]);
         
        if(obj.search("their") == true)
            System.out.println("their --- " + output[1]);
        else System.out.println("their --- " + output[0]);
         
        if(obj.search("thaw") == true)
            System.out.println("thaw --- " + output[1]);
        else System.out.println("thaw --- " + output[0]);
	    
	   

	  } 
}

