package SamplesProject.examples;

import java.util.Arrays;

public class MergeSort {

	public static int COUNT = 0;
	
	public MergeSort(){
		int[] input = new int[]{2, 4, 1, 3, 5};
	    System.out.println( Arrays.toString(mergeSort(input, 0, input.length-1)) );
	    System.out.println("Inversion count" + COUNT);
	}
	public static int[] mergeSort(int[] input, int start, int end){
		   int[] left = new int[]{};
		   int[] right = new int[]{};
		   
		   if(start == end){
			   int[] result = new int[]{input[start]};
			   return result;
		   } else {
			   int mid = (start + end)/2;
			   left = mergeSort(input, start, mid);
			   right = mergeSort(input, mid+1, end);
		   }
		   return merge(left, right);
	   }
	   
	   public static int[] merge(int[] left, int[] right){
		   int total = left.length + right.length;
		   int[] result = new int[total];
		   int k=0;
		   int i=0;
		   int j=0;
			   	   while(i<left.length && j<right.length){
					   if(left[i] < right[j]){
						   result[k] = left[i];
						   i++;
					   } else {
						   COUNT = COUNT + (left.length-i);
						   result[k] = right[j];
						   j++;
					   }
					   k++;
					}
			   	   while(i<left.length){
			   		   result[k] = left[i];
			   		   i++;
				   	   k++;
			   	   }
			   	   while(j<right.length){
			   		   result[k] = right[j];
			   		   j++;
				   	   k++;
			   	   }
		   return result;
	   }
}
