package Aeq3;
import java.io.*;
import java.security.PublicKey;
import java.util.StringTokenizer;

public class Main {
	
	public static class Node {
		Node childs[] = new Node[26];
		String str;
		boolean isEndOfWord;
	}
	public static void insertReplaceword(Node root, String s) {
		
		for(int i=0;i<s.length();i++) {
			char ch =s.charAt(i);
			
			if(root.childs[ch-'a']==null) {
				root.childs[ch-'a']=new Node();
			}
			root=root.childs[ch-'a'];
			if(root.str!=null) {
				return ;
			}
		}
		root.str=s;
	}
	
	public static void insertPalabra(Node root, String s) {

		Node pCrawl = root;
		 
        for (int i = 0; i < s.length(); i++) {
            int index = s.charAt(i) - 'a';
            if (pCrawl.childs[index] == null)
                pCrawl.childs[index] = new Node();
 
            pCrawl = pCrawl.childs[index];
        }
 
        // mark last node as leaf
        pCrawl.isEndOfWord = true;
        
	}
	 public static boolean search(Node root, String key)
	    {
	        Node pCrawl = root;
	 
	        for (int i = 0; i < key.length(); i++) {
	            int index = key.charAt(i) - 'a';
	            if (pCrawl.childs[index] == null)
	                return false;
	 
	            pCrawl = pCrawl.childs[index];
	        }
	 
	        return (pCrawl != null && pCrawl.isEndOfWord);
	    }
	
	public static String searchPrefix(Node root, String s) {
		
		for(int i=0;i<s.length();i++) {
			char ch= s.charAt(i);
			if(root.childs[ch-'a']==null) {
				return null;
			}
			root = root.childs[ch-'a'];
			if(root.str!=null) {
				return root.str;
			}
		}
		return null;
		
	}
	
	
	public static String replaceWords(String dictionary[], String sentence) {
	    Node root = new Node();
	    
	    for( String s: dictionary) {
	    	insertReplaceword(root,s);
	    }
	    StringBuilder ans = new StringBuilder();
	    StringTokenizer st = new StringTokenizer(sentence);
	    
	    while(st.hasMoreTokens()) {
	    	String word=st.nextToken();
	    	
	    	String prefix= searchPrefix(root,word);
	    	if(prefix !=null) {
	    		ans.append(prefix);
	    	}else {
				ans.append(word);
			}
	    	ans.append(" ");
	    }
	    ans.deleteCharAt(ans.length()-1);
	    return ans.toString();
	    
	  }
	 static boolean isEmpty(Node root)
	    {
	        for (int i = 0; i < 26; i++)
	            if (root.childs[i] != null)
	                return false;
	        return true;
	    }
	 
	    
	    static Node remove(Node root, String key, int depth)
	    {
	        
	        if (root == null)
	            return null;
	 
	       
	        if (depth == key.length()) {
	 
	            
	            if (root.isEndOfWord)
	                root.isEndOfWord = false;
	 
	            
	            if (isEmpty(root)) {
	                root = null;
	            }
	 
	            return root;
	        }
	 
	        
	        int index = key.charAt(depth) - 'a';
	        root.childs[index] =
	            remove(root.childs[index], key, depth + 1);
	 
	      
	        if (isEmpty(root) && root.isEndOfWord == false){
	            root = null;
	        }
	 
	        return root;
	    }
	    
}
