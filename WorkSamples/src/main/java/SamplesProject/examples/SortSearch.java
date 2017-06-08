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
    }

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
	
}
