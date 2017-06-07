package SamplesProject.examples;

import java.util.Arrays;

public class QuickSort {

	public QuickSort(){
        int[] input = new int[]{10, 80, 30, 90, 40, 50, 70};
		quickSort(input, 0, input.length-1);
	}

    
    public static void quickSort(int[] input, int start, int end){
	    if(start < end){
	    	int pIndex = partition(input, start, end);
	    	
	    	quickSort(input, start, pIndex-1);
	    	quickSort(input, pIndex+1, end);
	    }
	    System.out.println(Arrays.toString(input));
    }

	   
	public static int partition(int[] input, int start, int end){
		int pivot = input[end];
	    int i=start-1;
	    int j=start;
	    while(j<end){
	    	if(input[j] < pivot){
	    		i++;
	    		int temp = input[j];
	    		input[j] = input[i];
	    		input[i] = temp;
	    	}
	    	j++;
	    }

	    int temp = input[end];
	    input[end] = input[i+1];
	    input[i+1] = temp;
	    	
	    return i+1;
	}
}