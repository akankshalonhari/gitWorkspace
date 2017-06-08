package SamplesProject.examples;

import java.util.Iterator;
import java.util.PriorityQueue;

public class Heap_PriorityQueue {

	public Heap_PriorityQueue(){
	  int[] elems = new int[]{1,8,10, 2, 7, 15, 9, 11};
	  topKHeap(elems, 5);
	}
	
	 public static void topKHeap(int[] A, int K){
	    	PriorityQueue<Integer> heap = new PriorityQueue<Integer>();
	    	int count=0;
	    	for(int i : A){
	    		if(heap.peek() == null){ //whenever heap is empty keep adding 1st K elements
	    			heap.add(i);
	    	    	count++;
	    		} else if(heap.peek() < i || count <= K) { //if element is greater than peak then only add 
	    			if(count == K){ //removing min value on top if latest element is to be added
	    				int temp = heap.remove();
	    				count--;
	    			}
	    			heap.add(i);
	    	    	count++;
	    		}
	    	}
	    	Iterator<Integer> iter = heap.iterator();
	    	System.out.println("Top K elements of heap : ");
	    	while(iter.hasNext()){
	    		System.out.println(iter.next() + " ");
	    	}
	    }
}
