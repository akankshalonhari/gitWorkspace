package SamplesProject.examples;

import java.util.Arrays;

public class SortSearch {

	public SortSearch(){
	    int[] A = new int[9];
        A[0]=2;
        A[1]=3;
        A[2]=6;
        A[3]=7;
        A[4]=9;
        int[] B = new int[]{1,4, 5, 8};
        System.out.println("A : " + Arrays.toString(A));
        System.out.println("B : " + Arrays.toString(B));
        Arrays.toString(mergeArrs(A, B));
        System.out.println("Merged A : " + Arrays.toString(A));
        
        int[] Arr = new int[]{15, 16, 19, 20, 25, 1, 3, 4, 5,  7, 10, 14};
        //int[] Arr = new int[]{2, 2, 2, 3, 4, 2}; //array with duplicates
        System.out.println("Index of k-th element : " + rotatedSearch(Arr, 0, Arr.length-1, 3));
    
    }

	/* Merge 2 sorted arrays one having extra space at end for other */
	public static int[] mergeArrs(int[] A , int[] B) {
		int indexA = 0;
		while(A[indexA] != 0){
			indexA++;	
		}
		int totalIndex = (indexA + B.length)-1;
		indexA = indexA - 1;
		int indexB = B.length-1;
		while(indexB >= 0 && indexA >= 0) {
			if(A[indexA] > B[indexB]) {
				A[totalIndex] = A[indexA]; //copying A's element to end
				indexA--;
			} else {
				A[totalIndex] = B[indexB]; //copying B's element to end
				indexB--;
			}
			totalIndex--;
		}
		while(indexA>=0){
			A[totalIndex] = A[indexA]; //copying A's element to end
			indexA--;
			totalIndex--;
		}
		while(indexB >= 0){
			A[totalIndex] = B[indexB]; //copying B's element to end
			indexB--;
			totalIndex--;
		}
		return A;
	}
	
	/* Search K in a rotated sorted Array */
	public static int rotatedSearch(int[] Arr, int left, int right, int K){
    	int index = -1;
    	if(left > right){
    		return index;
    	}
    	int mid = (left + right) /2;
    	if(K == Arr[mid]){
    		index = mid;
    		return index;
    	}
    	
    	if(Arr[left] < Arr[mid]){  //array is sorted to left
    		if(Arr[left] <= K && K < Arr[mid]){
    			return rotatedSearch(Arr, left, mid-1, K); //search left
    		} else {
    			return rotatedSearch(Arr, mid+1, right, K); //search right
    		}
    	} else if(Arr[mid] < Arr[right]){//array is sorted to right
    		if(Arr[mid] <= K && K < Arr[right]){
    			return rotatedSearch(Arr, mid+1, right, K); //search right
    		} else {
    			return rotatedSearch(Arr, left, mid-1, K); //search left
    		}
    	} else if(Arr[left] == Arr[mid]){ //left and rights are all repeats
    		if(Arr[mid] != Arr[right]){ //if right is diff search it
    			return rotatedSearch(Arr, mid+1, right, K); 
    		} else { // else search all 
    			int result = rotatedSearch(Arr, left, mid-1, K); // search left
    			if(result == -1){ //let left search return -1 then only search right to avoid more calls
    				return rotatedSearch(Arr, mid+1, right, K);
    			} else {
    				return result;
    			}
    		}
    	}
    	
    	return index;
    }
	
}
