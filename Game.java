package cs146F20.tang.project1;

// simulates a game with n prisoners in a line that loops where every kth prisoner is not freed.
// prisoners are eliminated for freedom until 1 prisoner remains
public class Game {

	private CircularLinkedList list;;
	
	/*
	 * initializes a CircularLinkedList
	 */
	public Game() {
		list = new CircularLinkedList();
	}
	
	/*
	 * Add nodes (prisoners) into the CircularLinkedList
	 * @param x the amount of nodes to add into the CircularLinkedList
	 */
	public void addNodes(int x) {
		
		long start = System.nanoTime(); // variable to store the starting time of this method
		
		for(int i = 1; i <= x; i++) {
			list.add(i);
		}
		
		long time = System.nanoTime() - start; // subtracts the starting time from the end time to get the time it took to run this method
		System.out.println("Nanoseconds to make linkedlist with " + x + " node(s): " + time);
	}
	
	/*
	 * calculates the position a prisoner should stand at if every kth prisoner is eliminated
	 * @param k the kth prisoner that is eliminated
	 * @return the position of the last prisoner left
	 */
	public int calculatePosition(int k) {
		
		long start = System.nanoTime(); // variable to store the starting time of this method
				
		Node current = list.getHead();
		
		while(list.getHead() != list.getTail()) { //unless there is one prisoner left, keep eliminating
			for(int i = 0; i < k; i++) {
				current = current.getNext();
			}
			
			list.delete(current.getValue());
			current = current.getNext();
		}
		
		long time = System.nanoTime() - start; // subtracts the starting time from the end time to get the time it took to run this method
		System.out.println("Nanoseconds to calculate the winning position: " + time);
		return current.getValue();
	}
}
