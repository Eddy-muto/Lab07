package Aeq3;
import java.io.*;
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
	 static boolean search(Node root, String key)
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
	 
	    // Recursive function to delete a key from given Trie
	    static Node remove(Node root, String key, int depth)
	    {
	        // If tree is empty
	        if (root == null)
	            return null;
	 
	        // If last character of key is being processed
	        if (depth == key.length()) {
	 
	            // This node is no more end of word after
	            // removal of given key
	            if (root.isEndOfWord)
	                root.isEndOfWord = false;
	 
	            // If given is not prefix of any other word
	            if (isEmpty(root)) {
	                root = null;
	            }
	 
	            return root;
	        }
	 
	        // If not last character, recur for the child
	        // obtained using ASCII value
	        int index = key.charAt(depth) - 'a';
	        root.childs[index] =
	            remove(root.childs[index], key, depth + 1);
	 
	        // If root does not have any child (its only child got
	        // deleted), and it is not end of another word.
	        if (isEmpty(root) && root.isEndOfWord == false){
	            root = null;
	        }
	 
	        return root;
	    }

	  public static void main(String[] args) throws Exception {
	    BufferedReader read = new BufferedReader(new InputStreamReader(System.in));

	    int n = Integer.parseInt(read.readLine());

	    String[]dictionary = new String[n];
	    
	    

	    for (int i = 0; i < n; i++) {
	      dictionary[i] = read.readLine();
	    }

	    String sentence = read.readLine();

	    String result = replaceWords(dictionary, sentence);
	    System.out.println(result);
	    
	    
	    String keys[] = { "the", "a", "there",
                "answer", "any", "by",
                "bye", "their", "hero", "heroplane" };
		int nu = keys.length;

		Node root = new Node();

// Construct trie
		for (int i = 0; i < nu; i++)
			insertPalabra(root, keys[i]);

// Search for different keys
		if (search(root, "the"))
			System.out.println("Yes");
		else
			System.out.println("No");

		if (search(root, "these"))
			System.out.println("Yes");
		else
			System.out.println("No");

		remove(root, "heroplane", 0);

		if (search(root, "hero"))
			System.out.println("Yes");
		else
			System.out.println("No");
		if (search(root, "heroplane"))
			System.out.println("Yes s");
		else
			System.out.println("Noa");
		remove(root, "asdr", 0);
		if (search(root, "by"))
			System.out.println("Yes");
		else
			System.out.println("No");
		if (search(root, "asdr"))
			System.out.println("Yes");
		else
			System.out.println("No");

	}

}
