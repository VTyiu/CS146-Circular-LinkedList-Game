package cs146F20.tang.project1;

// Models a circularlinkedlist to be used for the game

public class CircularLinkedList {
	
	private Node head;
	private Node tail;
	private int size; // tracks the size of the linkedlist
	
	/*
	 * sets the size to 0
	 * sets head and tail to null
	 */
	public CircularLinkedList() {
		head = null;
		tail = null;
		size = 0;
	}
	
	/*
	 * adds a node to the end of this CircularLinkedList
	 * @param x the integer value of the node that is to be added to this CircularLinkedList
	 */
	public void add(int x) {
		Node newNode = new Node(x);
		if(head == null) { // special case: empty list
			head = newNode;
		}
		else {
			tail.setNext(newNode);
		}
		
		// sets the newNode as the new tail and sets the next reference to the head
		tail = newNode;
		tail.setNext(head);
		size++;
	}
	
	/*
	 * deletes a node from this CircularLinkedList
	 * @param x the Node with the value of x to be deleted from this CircularLinkedList
	 */
	public void delete(int x) {
		
		long start = System.nanoTime(); // variable to store the starting time of this method
		
		Node prev = tail;
		Node current = head;
		
		// looks for the Node to be deleted
		while(current.getValue() != x) {
			prev = prev.getNext();
			current = current.getNext();
		}
		
		// special case: delete tail
		if(current == tail) {
			tail = prev;
			tail.setNext(head);
			current = current.getNext();
		}
		
		// special case: delete head
		else if(current == head) {
			head = current.getNext();
			tail.setNext(head);
			current = head;
		}
		
		// Vanilla case
		else {
			prev.setNext(current.getNext());
			current = current.getNext();
		}
		
		long time = System.nanoTime() - start; // subtracts the starting time from the end time to get the time it took to run this method
		System.out.println("Nanoseconds to delete one node: " + time);
			
		size--; // subtracts 1 from size
	}
	
	/*
	 * Gets the head of this CircularLinkedList
	 * @return the head of this CircularLinkedList
	 */
	public Node getHead() {
		return head;
	}
	
	/*
	 * Gets the tail of this CircularLinkedList
	 * @return the tail of this CircularLinkedList
	 */
	public Node getTail() {
		return tail;
	}
	
	/*
	 * Finds out if this CircularLinkedList is empty
	 * @return true if this CircularLinkedList is empty, false if it is not
	 */
	public boolean isEmpty() {
		if(size == 0)
			return true;
		return false;
	}
	
	/*
	 * Gets the size of this CircularLinkedList
	 * @return the size of this CircularLinkedList
	 */
	public int getSize() {
		return size;
	}

}
