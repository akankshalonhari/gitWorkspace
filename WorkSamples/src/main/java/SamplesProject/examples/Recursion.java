package SamplesProject.examples;

import java.util.ArrayList;

public class Recursion {

	private static int[][] mat = new int[][]{  
		{1, 2, 3},
		{4, 5, 6},
		{7, 8, 9}
	};
	private static int totalRows = 3;
	private static int totalColumns = 3;
	
	Recursion(){
	 	int[] nums = new int[]{1,5, 9,11, 15, 17, 20};
	    int k = 21;
	    //System.out.println("result " + findIndex(nums, k, 0, nums.length-1));
	   
	    String str = "Pune";
	    System.out.println("Permutations of String : " + findAllPerms(str));
	    
	    String path = "";
        findPaths(0, 0 , path);

        int[] input = new int[]{3, 6, 2, 1, 8, 0, 4};
        System.out.println("Magic index is: " + magicIndex(input, 0, input.length-1));
	}
	
	/* All subsets of a set */
    public static void subsets(ArrayList<String> olist){
    	// subsets will add all single characters and all other combos of the string
    	//same code as permutations just added 2 lines below : 
    	//permutations.add(word);
    	//permutations.add(String.valueOf(first));
    }
    
    /* return i such that a[i]=i in a sorted input array */
    public static int magicIndex(int[] input, int start, int end){
		int index = -1;
    	if(start == end){
			if(input[start] == start)
    			return start;    		
    		else 
    			return -1;
		} else {
	    	int mid = (start + end)/2;
	    	if(input[mid] == mid){
	    		return mid;
	    	} else {
	    		int indexL = magicIndex(input, start, mid-1);
	    		int indexR = magicIndex(input, mid+1, end);
	    		if(indexL != -1){
	    			index = indexL;
	    		} else if(indexR != -1){
	    			index = indexR;
	    		}
	    	} 
		}
    	return index;
    }
    
    /* Permutation of string */
    public static ArrayList<String> findAllPerms(String str){
    	ArrayList<String> permutations = new ArrayList<String>();
    	if(str == null)
    		return null;
    	if(str.length() == 1){
    		permutations.add(str);
    		return permutations;
    	}
    	char first = str.charAt(0);
    	String remStr = str.substring(1, str.length());
    	ArrayList<String> words = findAllPerms(remStr);
    	for(String word : words){
    		//permutations.add(word);
    		for(int j=0; j<= word.length() ; j++){
    			permutations.add(insertCharAt(word, first,j));
    		}
    	}
    	//permutations.add(String.valueOf(first));
    	return permutations;
    }
    
    private static String insertCharAt(String s, char toBeInserted, int positionOfInsertion){
    	String start = s.substring(0, positionOfInsertion);
    	String end = s.substring(positionOfInsertion, s.length());
    	String result = start + toBeInserted + end;
    	return result;
    }
    
    /* Recursive binary search */
    public static int findIndex(int[] nums, int k, int start, int end){
    	//base case
    	if(start > end){
    		return -1;
    	}
    	int mid = (start + end) /2;
   		if(k == nums[mid])
   			return mid;
   		else if(k < nums[mid]){
   			return findIndex(nums, k, start, mid-1); //left sub problem
   		} else {
   			return findIndex(nums, k, mid+1, end); //right sub problem
   		}
    }
    

    /* Print all paths if we can traverse only right and down */
    public static void findPaths(int currRow, int currCol, String path){
    	if(currRow == totalRows-1){
    		for(int j=currCol;j<totalColumns;j++){
    			path = path + " " + mat[currRow][j];
    		}
    		System.out.println("Path : " + path);
    		return;
    	}
    	if(currCol == totalColumns-1){
    		for(int j=currRow;j<totalRows;j++){
    			path = path + " " + mat[j][currCol];
    		}
    		System.out.println("Path : " + path);
    		return;
    	}
    	path = path + " " + mat[currRow][currCol];
    	findPaths(currRow+1, currCol, path);
    	findPaths(currRow, currCol+1, path);
    }
    
    /* Recursive fibonacci series*/
    public static int fibFunc(int n){
    	if(n == 0)
    		return 0;
    	if(n == 1)
    		return 1;
    	//we need 2 previous elements to calculate current element
    	return fibFunc(n-1) + fibFunc(n-2);
    }   	
}