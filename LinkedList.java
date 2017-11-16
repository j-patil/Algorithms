// A java implementation of Singly Linked List for integer value
public class LinkedList {

	// By default head is initialized to null
	Node head; 
	
	static class Node{
		int data;
		Node next;
		Node(int d){
			data = d;
			next = null;
		}
	}
	
	// Print all the data in the LinkedList
	public void printall(){
		Node n = head;
		while(n != null){
			System.out.print(n.data + " ");
			n = n.next;
		}
	}
	
	//Insert element at the front of Linked List
	public void insertfront(int new_data){
		if(head == null)
			head = new Node(new_data);
		else{
			Node n = new Node(new_data);
			n.next = head;
			head = n;
		}
	}
	
	// Insert the data as the last element
	public void insertlast(int new_data){
		if(head == null){
			head = new Node(new_data);}
		else{
			Node n = new Node(new_data);
			Node temp = head;
			while(temp.next != null){
				temp = temp.next;
			}
			temp.next = n;
		}
	}
	
	//Deletes the first element with key
	public void deletefirst(int key){
		if(head != null && head.data == key){
			head = head.next;
		}else{
			Node temp = head;
			Node prev = head;
			while(temp != null && temp.data != key){
				prev = temp;
				temp = temp.next;
			}
			if(temp == null){
				System.out.println("Element with "+ key + " not found");}
			else{
				prev.next = temp.next;
			}
		}
	}
	
	//Deleting element at specific location
	public void deletespecific(int position){
		if(position < 1) 
			System.out.println("Location Error");
		else if(head==null){
			System.out.println("Linked List is NULL");}
		else if(position == 1){
			head = head.next;
		}else{
			Node temp = head;
			Node prev = head;
			for(int i = position; i>1 && temp!= null; i--){
				prev = temp;
				temp = temp.next;
			}
			if(temp==null){
				System.out.println("Position out of bound");
			}else{
				prev.next = temp.next;
			}
		}
	}
	
	// Counts the number of elements 
	public int countall(){
		if(head == null){
			return 0;
		}else{
			int count = 0;
			Node n = head;
			while(n!=null){
				count++;
				n = n.next;
			}
			return count;
		}	
	}
	
	// Shows nth node data; -1 if n is below 0; -2 if n is more than the elements in the Linked List
	public int NthNode(int n){
		if(n<1) return -1;
		else{
			Node nth = head;
			for(int i=n; i>1 && nth!=null; i--){
				nth = nth.next;
			}
			if(nth == null) return -2;
			else return nth.data;
		}
	}
	
	// Prints the middle element's data
	public int printmiddle(){
		if(head == null || head.next == null) return -1;
		else{
			Node slow = head;
			Node fast = head;
			while(fast!=null && fast.next!=null){
				slow = slow.next;
				fast = fast.next.next;
			}
			return slow.data;
		}
	}
	
	// reversing the Linked List - Recursive function
	public Node reversecall(Node curr, Node prev){
		if(curr.next == null){
			head = curr;
			curr.next = prev;
			return null;
		}
		Node nextnode = curr.next;
		curr.next = prev;
		reversecall(nextnode, curr);
		return head;
	}
	
	public void reverse(){
		if(head!=null || head.next!=null){
			head = reversecall(head, null);
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LinkedList l = new LinkedList();
		LinkedList l1 = new LinkedList();
		l.head = new Node(1);
		l.insertfront(234);
		l.insertfront(24);
		l.insertfront(4);
		l.insertlast(78);
		l.printall();
		l.deletefirst(4);
		System.out.println();
		l.printall();
		l.deletespecific(1);
		System.out.println();
		l.printall();
		System.out.println("Number of elements: "+l.countall());
		System.out.println("Nth Element is : "+l.NthNode(3));
		l.insertlast(56);
		l.insertlast(98);
		l.printall();
		System.out.println("Middle Element is : "+l.printmiddle());
		l.reverse();
		l.printall();
	}

}
