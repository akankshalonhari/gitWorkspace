package SamplesProject.examples;

import java.util.Stack;

public class LinkedListExamples {
	
	LinkedListExamples(){
		LinkedList list = new LinkedList();
		list.push(11);
		list.push(12);
		list.push(13);
		list.push(14);
		list.push(15);
		list.push(16);
		list.push(17);
		list.push(18);
		list.push(19);
		list.push(20);
		list.push(21);

		System.out.println("List to String :	" + list.toString());
		Node rlist = reverseList(list.head);
		list.head = rlist;
		System.out.println("List reverse:	" + list.toString());
		Node dlist = removeDups(list.head);
		list.head = dlist;
		System.out.println("List no dups:	" + list.toString()); 
		int k = 6;
		Node kthElement = kthToLast(list.head, k);
		System.out.println(k + "th element from end in List :	" + kthElement.data);
		//Node partitionList = partitionList();

		LinkedList list1 = new LinkedList();
		list1.push(2);
		list1.push(1);
		list1.push(6);
		list1.push(7);
		list1.push(8);
		list1.push(9);

		LinkedList list2 = new LinkedList();
		list2.push(0);
		list2.push(1);
		list2.push(1);
		list2.push(3);
		list2.push(6);
		list2.push(7);
		list2.push(8);
		list2.push(9);
		System.out.println("Lists for addition:	L1 : " + list1.toString() + "	L2:	" + list2.toString());
		Node intr = intersectionPt(list1, list2);
		System.out.println(" intersection" + intr.data);

		LinkedList list3 = new LinkedList();
		list3.push(2);
		list3.push(1);
		list3.push(6);
		list3.push(7);
		list3.push(8);
		list3.push(9);

		LinkedList list4 = new LinkedList();
		list4.push(0);
		list4.push(1);
		list4.push(1);
		list4.push(3);
		list4.push(6);
		list4.push(7);
		list4.push(8);
		list4.push(9);
		System.out.println("Lists for addition:	L3 : " + list3.toString() + "	L4:	" + list4.toString());
		Node suml = sumLists(list3, list4);
		list3.head = suml;
		//list3.head = reverseList(list3.head);
		System.out.println("Sum of Lists :	" + list3.toString());

		LinkedList alphaList = new LinkedList();
		alphaList.push(1);
		alphaList.push(2);
		alphaList.push(3);
		alphaList.push(5);
		alphaList.push(2);
		alphaList.push(1);
		boolean result = isPalindrome(alphaList);
		System.out.println("Is Palindrome : " + result);


		LinkedList loopList = new LinkedList();
		loopList.push(1);
		loopList.push(2);
		loopList.push(3);
		loopList.push(0);
		loopList.push(5);
		loopList.push(2);
		loopList.push(7);
		loopList.push(3);
		loopList.push(4);
		boolean result1 = isLoop(loopList);
		System.out.println("Is Loop : " + result1);
	}

/* Reverse a linklist */
public static Node reverseList(Node head){
	Node newhead = null;
	Node temp = null;
	Node prev = head;
	Node curr = head.next;
	while(curr != null){
		if(newhead == null){
			temp = curr.next;
			curr.next = prev;
			prev.next = newhead;
			newhead = curr;
		} else {
			temp = curr.next;
			curr.next = prev;
			newhead = curr;
		}
		prev = curr;
		curr = temp;
	}    	
	return newhead;
}

/* Removes sequential duplicates from the list */
public static Node removeDups(Node head){
	Node prev = head;
	Node curr = head.next;
	while(curr != null){
		if(curr.data == prev.data && curr.next == null){
			prev.next = null;
			break;
		}
		if(prev.data == curr.data){
			Node temp = curr.next;
			curr.next = null;
			curr = temp;
			prev.next = curr;
		} 
		prev = prev.next;
		curr = curr.next;
	}
	return head;
}

/* Find kth node from end of list */
public static Node kthToLast(Node head, int K){
	Node elementK = null;
	Node curr = head;
	Node prev = head;
	for(int i=0; i<K ; i++){
		if(curr == null) 
			return null;
		curr = curr.next;
	}
	while(curr != null){
		curr = curr.next;
		prev = prev.next;
	}
	elementK = prev;
	return elementK;
}

/*	public static Node partitionList(Node n){}*/

/* Add 2 numbers represented as lists */
public static Node sumLists(LinkedList list1 , LinkedList list2){
	int l1 = list1.length();
	int l2 = list2.length();
	if(l1 > l2){
		int pad = l1-l2;
		while(pad != 0){
			list2.push(0);
			pad--;
		}
	} else if(l2 >l1){
		int pad = l2-l1;
		while(pad != 0){
			list1.push(0);
			pad--;
		}
	}
	Node p1 = list1.head;
	Node p2 = list2.head;
	int sum = 0;
	int carry =0;
	while(p1 != null || p2 != null){
			sum = p1.data + p2.data + carry;
			if(sum>=10){
				carry = 1;
				p1.data = sum -10;
			} else {
				carry = 0;
				p1.data = sum;
			}
		p1 = p1.next;
		p2 = p2.next;
	}
	if(carry > 0){
		list1.push(carry);
	}
	return list1.head;
}

/* Iterative method to find if list is Palindrome */
public static boolean isPalindrome(LinkedList list){
	int len = list.length();
	int mid = 0;
	if(len%2 ==0)
		mid = len/2 - 1;
	else
		mid = len/2;
	
	Stack<Integer> stk = new Stack<Integer>(); 
	Node curr = list.head;
	for(int i=0; i<len ;i++){
		if(i<=mid)
			stk.push(curr.data);
		
		if(i>=mid){
			if(curr.data == stk.peek())
				stk.pop();
		}
		if((i!=mid) && (len%2==0)){
			curr = curr.next;
		}
	}	
	if(!stk.isEmpty())
		return false;
	return true;
}

/* Implement 2 runners solution*/
public static boolean isPalinMeth2(LinkedList list){return true;}

/* Find a point where 2 lists intersect */
public static Node intersectionPt(LinkedList l1, LinkedList l2){
	Node inter = null;
	Node head1 = l1.head;
	Node head2 = l2.head;
	int diff = 0;
	if(l1.length() > l2.length()){
		diff = l1.length() - l2.length();
		for(int i=0; i<diff; i++){
			head1 = head1.next;
		}
	} else {
		diff = l2.length() - l1.length();
		for(int i=0; i<diff; i++){
			head2 = head2.next;
		}
	}
	while( head1.data != head2.data){
		head1 = head1.next;
		head2 = head2.next;
	}
	inter = head1;
	return inter;
}

/* Finds if linkedlist is circular */
public static boolean isLoop(LinkedList list){
	Node head = list.head;
	Node p1 = head;
	Node p2 = head;
	while(p1 != null && p2 != null && p2.next != null){
		System.out.println(" p1 " + p1.data + " p2 " + p2.data);
		p1 = p1.next;
		p2 = p2.next.next;
		if(p1 == p2){
			System.out.println(" loop found" + p1.data + " p2 " + p2.data);
			return true;
		}
	}
	return false;
	}
}


class LinkedList{
	Node head = null;

	LinkedList(){
	}

public void push(int newVal){
	Node newnode = new Node(newVal);
	if(head == null){
		head = newnode;
	} else {
		Node curr = head;
		while(curr.next != null){
			curr = curr.next;
		}
		curr.next = newnode;
		if (newVal==4) //modification to make list circular -- isLoop method only
			newnode.next=head;
	}
}

public int length(){
	Node curr = head;
	int count = 0;
	while(curr != null){
		count++;
		curr = curr.next;
	}
	return count;
}

public String toString(){
	String string = "";
	Node curr = head;
	while(curr.next != null){
		string = string + String.valueOf(curr.data) + "->";
		curr = curr.next;
	}
	string = string + String.valueOf(curr.data);
	return string;
	}
}

class Node{
	int data;
	Node next;
	
	Node(int d){
		this.data = d;
		this.next = null;
	}	
}
