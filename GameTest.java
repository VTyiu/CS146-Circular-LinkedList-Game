package cs146F20.tang.project1;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class GameTest {

	Game test;
	CircularLinkedList prisoners;
	
	@BeforeEach
	void setUp() {
		test = new Game();
		prisoners = new CircularLinkedList();
	}
	
	// test to see if linkedlist is created properly, insert works, delete for special cases works
	@Test
	void testLinkedListInsertDelete() {
		
		assertTrue(prisoners.isEmpty()); //before inserting, list is empty
		assertEquals(0, prisoners.getSize()); // size is 0
		prisoners.add(5);
		assertFalse(prisoners.isEmpty()); // after inserting element, list is not empty
		assertEquals(1, prisoners.getSize()); //size is 1;
		
		prisoners.add(4);
		prisoners.add(3);
		prisoners.add(2);
		prisoners.add(1);
		assertFalse(prisoners.isEmpty()); // after inserting elements, list is not empty
		assertEquals(5, prisoners.getSize()); //size should be 5 since 5 prisoners were added;
		prisoners.delete(1); // tests delete at head
		System.out.println(); //better spacing
		assertEquals(4, prisoners.getSize()); //size is 4
		prisoners.delete(5); // tests delete at tail
		System.out.println(); //better spacing
		assertEquals(3, prisoners.getSize()); //size is 3
		System.out.println("-------------------------------------------");
		System.out.println();

	}
	
	// test to see the time it takes to delete a node that is in the middle of a linkedlist of size 7
	@Test
	void testDeleteMiddle() {
		System.out.println("Test Delete Middle");
		prisoners.add(7);
		prisoners.add(6);
		prisoners.add(5);
		prisoners.add(4);
		prisoners.add(3);
		prisoners.add(2);
		prisoners.add(1);
		prisoners.delete(4);
		System.out.println();
		System.out.println("-------------------------------------------");
		System.out.println();
	}
	
	// 5 test cases to see if winning position is calculated correctly
	// sysout lines for better spacing
	@Test
	void testCalculateWinner1() {
		test.addNodes(6);
		assertEquals(1, test.calculatePosition(2));
		System.out.println();
		System.out.println("-------------------------------------------");
		System.out.println();
	}
	
	@Test
	void testCalculateWinner2() {
		test.addNodes(1);
		assertEquals(1, test.calculatePosition(9));
		System.out.println();
		System.out.println("-------------------------------------------");
		System.out.println();
	}
	
	@Test
	void testCalculateWinner3() {
		test.addNodes(7);
		assertEquals(4, test.calculatePosition(7));
		System.out.println();
		System.out.println("-------------------------------------------");
		System.out.println();
	}
	
	@Test
	void testCalculateWinner4() {
		test.addNodes(12);
		assertEquals(2, test.calculatePosition(8));
		System.out.println();
		System.out.println("-------------------------------------------");
		System.out.println();
	}
	
	@Test
	void testCalculateWinner5() {
		test.addNodes(5);
		assertEquals(3, test.calculatePosition(1));
		System.out.println();
		System.out.println("-------------------------------------------");
		System.out.println();
	}
}
