package SamplesProject.examples;

import java.util.ArrayList;

public class Heap {

	public Heap(){
        /*MinHeap h1 = new MinHeap();
        MaxHeap h2 = new MaxHeap();
        
        h2.insert(10);
        System.out.println(h1.toString());
        System.out.println(h2.toString());
        if((h2.getMaxSize() - h1.getMinSize())> 1){
        	//move elements from max to min
        	h1.insert(h2.removeElement());
        }
        System.out.println(h1.toString());
        System.out.println(h2.toString());
        
        System.out.println(" Median " + h2.peekMaxElement());
        
        if(5 < h2.peekMaxElement()){
            h2.insert(5);	
        } else {
        	h1.insert(5);
        }
        System.out.println(h1.toString());
        System.out.println(h2.toString());
        if((h2.getMaxSize() - h1.getMinSize())> 1){
        	//move elements from max to min
        	h1.insert(h2.removeElement());
        }
        System.out.println(h1.toString());
        System.out.println(h2.toString());
        
        System.out.println(" Median " + h2.peekMaxElement());
        
        if(12 < h2.peekMaxElement()){
            h2.insert(12);
        } else {
        	h1.insert(12);
        }
        System.out.println(h1.toString());
        System.out.println(h2.toString());
        if((h2.getMaxSize() - h1.getMinSize())> 1){
        	//move elements from max to min
        	h1.insert(h2.removeElement());
        }
        System.out.println(h1.toString());
        System.out.println(h2.toString());
        
        System.out.println(" Median " + h2.peekMaxElement());
        
        if(3 < h2.peekMaxElement()){
            h2.insert(3);
        } else {
        	h1.insert(3);
        }
        System.out.println(h1.toString());
        System.out.println(h2.toString());
        if((h2.getMaxSize() - h1.getMinSize())> 1){
        	//move elements from max to min
        	h1.insert(h2.removeElement());
        }
        System.out.println(h1.toString());
        System.out.println(h2.toString());
        
        System.out.println(" Median " + h2.peekMaxElement());
        
        if(7 < h2.peekMaxElement()){
            h2.insert(7);
        } else {
        	h1.insert(7);
        }
        System.out.println(h1.toString());
        System.out.println(h2.toString());
        if((h2.getMaxSize() - h1.getMinSize())> 1){
        	//move elements from max to min
        	h1.insert(h2.removeElement());
        }
        System.out.println(h1.toString());
        System.out.println(h2.toString());
        
        System.out.println(" Median " + h2.peekMaxElement());*/
	}
	
}


/*
public class MaxHeap{
	ArrayList<Integer> values = new ArrayList<Integer>(10);
	
	public String toString(){
		return this.values.toString();
	}
	
	public int getMaxSize(){
		return this.values.size();
	}
	
	public int peekMaxElement(){
		int peek = -1;
		if(this.values.size() != 0){
			peek = this.values.get(0);
		}
		return peek;
	}
	
	public int removeElement(){
		int removed = this.values.remove(0);
		return removed;
	}
	
	public void insert(int val){
		System.out.println("inserting in Max" + val);
		this.values.add(val);
		bubble_up(this.values.size()-1);
	}
	
	public int getMax(){
		if(this.values.size() ==0)
			return -1;
		else{
			int max = this.values.get(0);
			//this.values.remove(0);
			
		//	System.out.println("Values after max remove" + this.values.toString());
			int last = this.values.get(values.size()-1);
			this.values.set(0, last);
			this.values.remove(values.size()-1);
		//	System.out.println("Values after last remove" + this.values.toString());
			
			bubble_down(0);
			return max; 
		}
	}
	
	public void bubble_up(int n){
		//System.out.println("n " + n);
		if(n == 0)
			return;
		int parent = (n-1)/2;
		if(this.values.get(parent) < this.values.get(n)){
			//System.out.println("parent" + parent);
			int temp = this.values.get(n);
			this.values.set(n, this.values.get(parent));
			this.values.set(parent, temp);
			bubble_up(parent);
		}
	}
	
	public void bubble_down(int n){
		//System.out.println("N " + n);
		int c1Index = 2*n + 1;
		int c2Index = 2*n + 2;
		int parent = this.values.get(n);
	//	System.out.println("parent" + parent + "has 2 child" + c1Index + " 2nd " + c2Index);
		if((c1Index < this.values.size()-1) && (c1Index < this.values.size()-1)){
				//System.out.println("has 2 child");
				
				int child1 = this.values.get(c1Index);
				int child2 = this.values.get(c2Index);
				if(child1 > child2){
					//System.out.println("has child1<child2");
					if(child1 > this.values.get(n)){
						int temp = this.values.get(n);
						this.values.set(n, child1);
						this.values.set(c1Index, temp);
						bubble_down(c1Index);
					}
				} else {
					//System.out.println("has child2<child1");
					if(child2 > this.values.get(n)){
						int temp = this.values.get(n);
						this.values.set(n, child2);
						this.values.set(c2Index, temp);
						bubble_down(c2Index);
					}
				}
		} else if(c1Index < this.values.size()-1 && (c2Index > this.values.size()-1)){
			//System.out.println("has only child1 ");
			int child1 = this.values.get(c1Index);
			if(child1 > this.values.get(n)){
				int temp = this.values.get(n);
				this.values.set(n, child1);
				this.values.set(c1Index, temp);
				bubble_down(c1Index);
			}
		} else if(c1Index > this.values.size()-1 && (c2Index > this.values.size()-1)){
			//System.out.println("has no child1 ");
			return;
		}
	}
}

public class MinHeap{
	ArrayList<Integer> values = new ArrayList<Integer>(10);
	
	public String toString(){
		return this.values.toString();
	}
	
	public int getMinSize(){
		return this.values.size();
	}
	

	public int peekMinElement(){
		int peek = -1;
		if(this.values.size() != 0){
			peek = this.values.get(0);
		}
		return peek;
	}
	
	public int removeElement(){
		int removed = this.values.remove(0);
		return removed;
	}
	
	public void insert(int val){
		System.out.println("inserting in Min" + val);
		this.values.add(val);
		bubble_up(this.values.size()-1);
	}
	
	public int getMin(){
		if(this.values.size() ==0)
			return -1;
		else{
			int min = this.values.get(0);
			//this.values.remove(0);
			
			//System.out.println("Values after min remove" + this.values.toString());
			int last = this.values.get(values.size()-1);
			this.values.set(0, last);
			this.values.remove(values.size()-1);
			//System.out.println("Values after last remove" + this.values.toString());
			
			bubble_down(0);
			return min; 
		}
	}
	
	public void bubble_up(int n){
		//System.out.println("n " + n);
		if(n == 0)
			return;
		int parent = (n-1)/2;
		if(this.values.get(parent) > this.values.get(n)){
			//System.out.println("parent" + parent);
			int temp = this.values.get(n);
			this.values.set(n, this.values.get(parent));
			this.values.set(parent, temp);
			bubble_up(parent);
		}
	}
	
	public void bubble_down(int n){
		//System.out.println("N " + n);
		int c1Index = 2*n + 1;
		int c2Index = 2*n + 2;
		int parent = this.values.get(n);
		//System.out.println("parent" + parent + "has 2 child" + c1Index + " 2nd " + c2Index);
		if((c1Index < this.values.size()-1) && (c1Index < this.values.size()-1)){
				//System.out.println("has 2 child");
				
				int child1 = this.values.get(c1Index);
				int child2 = this.values.get(c2Index);
				if(child1 < child2){
					//System.out.println("has child1<child2");
					if(child1 < this.values.get(n)){
						int temp = this.values.get(n);
						this.values.set(n, child1);
						this.values.set(c1Index, temp);
						bubble_down(c1Index);
					}
				} else {
					//System.out.println("has child2<child1");
					if(child2 < this.values.get(n)){
						int temp = this.values.get(n);
						this.values.set(n, child2);
						this.values.set(c2Index, temp);
						bubble_down(c2Index);
					}
				}
		} else if(c1Index < this.values.size()-1 && (c2Index > this.values.size()-1)){
			//System.out.println("has only child1 ");
			int child1 = this.values.get(c1Index);
			if(child1 < this.values.get(n)){
				int temp = this.values.get(n);
				this.values.set(n, child1);
				this.values.set(c1Index, temp);
				bubble_down(c1Index);
			}
		} else if(c1Index > this.values.size()-1 && (c2Index > this.values.size()-1)){
			//System.out.println("has no child1 ");
			return;
		}
	}
}
*/