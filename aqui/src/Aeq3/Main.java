package Aeq3;
import java.io.*;
import java.util.StringTokenizer;


public class Main {
	
	public static class Node {
		Node childs[] = new Node[26];
		String str;
	}
	
	public static void insert(Node root, String s) {

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
	
	public static String searchPrefix(Node root, String s) {
		StringBuilder pre =new StringBuilder();
		
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
	    	insert(root,s);
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

	  }
}
