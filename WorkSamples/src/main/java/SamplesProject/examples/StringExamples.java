package SamplesProject.examples;

import java.util.Arrays;

import org.apache.commons.lang3.StringUtils;

public class StringExamples {

	public StringExamples(){
		//boolean result = isUnique("Akanksha");
        //boolean result = isPermutation("Akanksha", "akanksha");
        //String result = URLify("Mr John  Smith   ");
        //boolean result = isPermutationofPalindrome("Tact Coa");
        //boolean result = oneAway("pale", "bae");
        //String result = strCompression("abbbgtrrttuiii");
        //boolean result = isRotation("waterb", "erwabt");
        
	}
	
	 /* Assuming the input string is ASCII i.e 128 characters. Will have to use 256 characters set for Unicode*/
    public static boolean isUnique(String str){
    	if(str.length() > 128) return false;
    	boolean flag[] = new boolean[128];
    	for(int i =0; i<str.length(); i++){
    		int charS = str.charAt(i);
    		if(flag[charS] == true){ //this indicates the character was already present
    			return false;
    		}
    		flag[charS] = true;
    	}
    	/* Using O(nlogn)sorting algorithm
    	char strC[] = str.toCharArray();
    	Arrays.sort(strC);
    	for(int i=0; i<strC.length-1; i++){
    		if(strC[i] == strC[i+1]){
    			return false;
    		}
    	}*/
    	return true;
    }
    
    /* Checking if the 2 strings have same characters. Can also use above ASCII method */
    public static boolean isPermutation(String s , String t){
     	if(s.length() != t.length()) return false;
     	int[] flag = new int[128];
     	char[] sArr = s.toCharArray();
     	for(char c : sArr){
     		flag[c]++;
     	}
     	for(int i=0; i<t.length(); i++){
     		int tChar = t.charAt(i);
     		flag[tChar]--;
     		if(flag[tChar]<0)
     			return false;
     	}
     	/*
    	if(!sort(s).equals(sort(t))){
    		return false;
    	}*/
    	return true;
    }
    
    public static String sort(String s){
    	char[] sChar = s.toCharArray();
    	Arrays.sort(sChar);
    	return new String(sChar);
    }

    /* Converting given string to URL format */
    public static String URLify(String url){
    	StringBuilder newURL = new StringBuilder();
    	int spaces = 0;
    	url = url.replaceAll(" +", " ");
    	url = StringUtils.stripEnd(url, " ");
    	char[] charURL = url.toCharArray();
    	int lenURL = url.length();
    	/*for(char c : charURL){
    		if(c == ' ')
    			spaces++;
    	}*/
    	
    	for(int i=0; i<lenURL;){
    		if(charURL[i] == ' '){
    			newURL.append('%');
    			newURL.append('2');
    			newURL.append('0');
    			i++;
    		} else {
    			newURL.append(charURL[i]);
    			i++;
    		}
    	}
    	return newURL.toString();
    }

    /* Checking if a string is permutation of a palindrome */
    public static boolean isPermutationofPalindrome(String phrase){
    	int oddCount = 0;
    	int table[] = new int[Character.getNumericValue('z')-Character.getNumericValue('a')+1];

    	for(char c : phrase.toCharArray()){
    		int cInt = getCharNumber(c);
    		if(cInt != -1){
    			table[cInt]++;
    			if(table[cInt]%2 == 1){
    				oddCount++;
    			} else {
    				oddCount--;
    			}
    		}
    	}
    	return oddCount<=1;
    }
    
    /* Mapping a-z to 0-1-2... and all non-letter charcters to -1 */
    public static int getCharNumber(Character c){
		int a = Character.getNumericValue('a');
		int z = Character.getNumericValue('z');
		int curr = Character.getNumericValue(c);
		if(a<= curr && curr<=z){
			return curr-a;
		}
    	return -1;
    }

    /* Check if 2 strings are only one operation away - insert, remove, replace */
    public static boolean oneAway(String s, String t){
    	if(s.length() == 0 || t.length() == 0) return false;
    	if(s.length() == t.length())	
    		return oneEditReplace(s,t);
    	if(s.length()+1 == t.length())	
    		return oneEditInsert(s,t);
    	if(s.length()-1 == t.length())	
    		return oneEditInsert(s,t);
    	return false;
    }
    
    /* replace operation for one edit scenario */
    public static boolean oneEditReplace(String s, String t){
    	boolean replaceChars = false;
    	int count=0;
    	for(int i=0; i<s.length() ;i++){
    		if(s.charAt(i) != t.charAt(i)){
    			if(replaceChars && count ==1){
    				return false;
    			}
    			replaceChars = true;
    			count++;
    		}
    	}
    	return true;
    }

    /* insert/remove operation for one edit scenario */
    public static boolean oneEditInsert(String s, String t){
    	int i=0, j=0;
    	while(i<s.length() && j<t.length()){
    		if(s.charAt(i) != t.charAt(j)){
    			if(i != j){
    				return false;
    			}
    			if(s.length()>t.length())
    				i++;
    			else 
    				j++;
    		} else {
    			i++;
    			j++;
    		}
    	}
    	return true;
    }

    /* Compressing a string to count number of repeated characters back to back */
    public static String strCompression(String str){
    	StringBuilder newStr = new StringBuilder();
    	int count = 0;
    	int i=0;
    	for(i=0; i<str.length(); i++){
        	count++;
    		if(i+1<str.length() && str.charAt(i) != str.charAt(i+1)){
    			newStr.append(str.charAt(i));
    			if(count>1)
    				newStr.append(count);
    			count=0;
    		}
    	}
    	newStr.append(str.charAt(i-1));
    	if(count>1)
    		newStr.append(count);

    	if(newStr.length() > str.length()) return str;
    	return newStr.toString();
    }

	/* Checking if a string is a rotation of another string */
	 public static boolean isRotation(String s, String t){
	    	if(s.length() != t.length()) return false;
	    	boolean result = false;
	    	if(s.length() == t.length() && s.length() >0){
	    		String s1 = s+s;
	    		result = isSubstring(s1, t);
	    	}
	    	return result;
	    }
	    
	 /* Using sub string method to check rotation*/
	 public static boolean isSubstring(String big, String small){
	    	int i=0;
	    	int count = 0;
	    	for(int j=0; j<small.length(); ){
	    		if(i == big.length()){
	    			return false;
	    		}
	    		if(small.charAt(j) == big.charAt(i)){
	    			i++;
	    			j++;
	    			count++;
	    		} else {
	    			i++;
	    		}	
	    	}
	    	if(count == small.length()) return true;
	    	return false;
	 }
}
