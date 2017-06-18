package SamplesProject.examples;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class RandomImp {

	public RandomImp(){
		 String[] strings = new String[]{"dale", "lead", "eadl", "kjui",  "listen", "silent", "cheating", "eathcing"};
	     System.out.println("result " + groupAnagrams(strings));
	}
	
	 /* Function to create groups of anagrams in a given list */
	 public static List<List<String>> groupAnagrams(String[] strs) {
	    	List<List<String>> result = new ArrayList<List<String>>();
	     
	    	String[][] resultN =  new String[100][100];;
	        HashMap<String, ArrayList<String>> map = new HashMap<String, ArrayList<String>>();
	        for(String str: strs){
	        	
	        	/* Creating signature of n-letters word to create a key*/
	        	char[] arr = new char[26];
	            for(char s : str.toCharArray()){
	            	arr[s-'a']++;
	            }
	  
	            String ns = new String(arr);
	            if(map.containsKey(ns)){
	                map.get(ns).add(str);
	            }else{
	                ArrayList<String> al = new ArrayList<String>();
	                al.add(str);
	                map.put(ns, al);
	            }
	        }
	     
	       result.addAll(map.values());
	    
	        //trial, ignore the below conversion
	        Object[] res1 = map.values().toArray();
	        int k=0;
			for(ArrayList<String> v : map.values()){
		        String[] n = new String[v.size()];
	        	int i =0;
	        	for(String j : v){
	        		n[i] = j;
	        		i++;
	        	}
	        	resultN[k] = n;
	        	k++;
	        }
	        System.out.println("result 0 " + Arrays.toString(resultN[0]));
	        System.out.println("result 1 " + Arrays.toString(resultN[1]));
	        System.out.println("result 2 " + Arrays.toString(resultN[2]));
	            
	        
	        return result;
	    }
	
}
