import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertNull;

import org.junit.Test;
import org.junit.Ignore;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

//-------------------------------------------------------------------------
/**
 *  Test class for Doubly Linked List
 *
 *  @author  
 *  @version 13/10/16 18:15
 */
@RunWith(JUnit4.class)
public class DoublyLinkedListTest
{
    //~ Constructor ........................................................
    @Test
    public void testConstructor()
    {
      new DoublyLinkedList<Integer>();
    }

    //~ Public Methods ........................................................

    // ----------------------------------------------------------
    /**
     * Check if the insertBefore works
     */
    @Test
    public void testInsertBefore()
    {
        // test non-empty list
        DoublyLinkedList<Integer> testDLL = new DoublyLinkedList<Integer>();
        testDLL.insertBefore(0,1);
        testDLL.insertBefore(1,2);
        testDLL.insertBefore(2,3);

        testDLL.insertBefore(0,4);
        assertEquals( "Checking insertBefore to a list containing 3 elements at position 0", "4,1,2,3", testDLL.toString() );
        testDLL.insertBefore(1,5);
        assertEquals( "Checking insertBefore to a list containing 4 elements at position 1", "4,5,1,2,3", testDLL.toString() );
        testDLL.insertBefore(2,6);       
        assertEquals( "Checking insertBefore to a list containing 5 elements at position 2", "4,5,6,1,2,3", testDLL.toString() );
        testDLL.insertBefore(-1,7);        
        assertEquals( "Checking insertBefore to a list containing 6 elements at position -1 - expected the element at the head of the list", "7,4,5,6,1,2,3", testDLL.toString() );
        testDLL.insertBefore(7,8);        
        assertEquals( "Checking insertBefore to a list containing 7 elemenets at position 8 - expected the element at the tail of the list", "7,4,5,6,1,2,3,8", testDLL.toString() );
        testDLL.insertBefore(700,9);        
        assertEquals( "Checking insertBefore to a list containing 8 elements at position 700 - expected the element at the tail of the list", "7,4,5,6,1,2,3,8,9", testDLL.toString() );

        // test empty list
        testDLL = new DoublyLinkedList<Integer>();
        testDLL.insertBefore(0,1);        
        assertEquals( "Checking insertBefore to an empty list at position 0 - expected the element at the head of the list", "1", testDLL.toString() );
        testDLL = new DoublyLinkedList<Integer>();
        testDLL.insertBefore(10,1);        
        assertEquals( "Checking insertBefore to an empty list at position 10 - expected the element at the head of the list", "1", testDLL.toString() );
        testDLL = new DoublyLinkedList<Integer>();
        testDLL.insertBefore(-10,1);        
        assertEquals( "Checking insertBefore to an empty list at position -10 - expected the element at the head of the list", "1", testDLL.toString() );
     }

    @Test
    public void testDeleteAt()
    {
    	DoublyLinkedList<Integer> testDLL = new DoublyLinkedList<Integer>();
    	
    	//test list with 5 elements
        testDLL.insertBefore(0,1);
        testDLL.insertBefore(1,2);
        testDLL.insertBefore(2,3);
        testDLL.insertBefore(0,4);
        testDLL.insertBefore(1,5);
        assertEquals( "Checking insertBefore to a list containing 4 elements at position 1", "4,5,1,2,3", testDLL.toString() );
        testDLL.deleteAt(1);
        assertEquals( "Checking deleteAt to a list containing 5 elements at position 1", "4,1,2,3", testDLL.toString() );
        testDLL.deleteAt(0);
        assertEquals( "Checking deleteAt to a list containing 4 elements at position 0", "1,2,3", testDLL.toString() );
        testDLL.deleteAt(2);
        assertEquals( "Checking deleteAt to a list containing 3 elements at position 2", "1,2", testDLL.toString() );
        testDLL.deleteAt(1);
        assertEquals( "Checking deleteAt to a list containing 2 elements at position 1", "1", testDLL.toString() );
        testDLL.deleteAt(0);
        assertEquals( "Checking deleteAt to a list containing 1 element at position 0", "", testDLL.toString() );
        
        //test a list with 1 element
        testDLL = new DoublyLinkedList<Integer>();
        testDLL.insertBefore(0,1);
        testDLL.deleteAt(0);
        assertEquals( "Checking deleteAt to a list containing 1 element at position 0", "", testDLL.toString() );
        
        //test a list with 2 elements
        testDLL = new DoublyLinkedList<Integer>();
        testDLL.insertBefore(0,1);
        testDLL.insertBefore(1,2);
        testDLL.deleteAt(0);
        assertEquals( "Checking deleteAt to a list containing 2 elements at position 0", "2", testDLL.toString() );
        testDLL.insertBefore(0,1);
        testDLL.deleteAt(1);
        assertEquals( "Checking deleteAt to a list containing 2 elements at position 1", "1", testDLL.toString() );
        
        //test a list with no elements
        testDLL = new DoublyLinkedList<Integer>();
        testDLL.deleteAt(0);
        assertEquals( "Checking deleteAt to a list containing no elements", "", testDLL.toString() );
        
    }
    
    @Test
    public void testReverse()
    {
    	DoublyLinkedList<Integer> testDLL = new DoublyLinkedList<Integer>();
    	
    	//test a list with 5 elements
        testDLL.insertBefore(0,1);
        testDLL.insertBefore(1,2);
        testDLL.insertBefore(2,3);
        testDLL.insertBefore(0,4);
        testDLL.insertBefore(1,5);
        assertEquals( "Checking insertBefore to a list containing 4 elements at position 1", "4,5,1,2,3", testDLL.toString() );
        testDLL.reverse();
        assertEquals( "Checking was the list with 5 elements reversed", "3,2,1,5,4", testDLL.toString() );
        
        //test a list with 1 element
        testDLL = new DoublyLinkedList<Integer>();
        testDLL.insertBefore(0,1);
        testDLL.reverse();
        assertEquals( "Checking was the list with 1 element reversed", "1", testDLL.toString() );
        
        //test a list with 2 elements
        testDLL = new DoublyLinkedList<Integer>();
        testDLL.insertBefore(0,1);
        testDLL.insertBefore(1,2);
        testDLL.reverse();
        assertEquals( "Checking was the list with 2 elements reversed", "2,1", testDLL.toString() );
        
        //test a list with no elements
        testDLL = new DoublyLinkedList<Integer>();
        testDLL.reverse();
        assertEquals( "Checking was the list with 0 elements reversed", "", testDLL.toString() );
    }
    
    @Test
    public void testUnique()
    {
    	DoublyLinkedList<Integer> testDLL = new DoublyLinkedList<Integer>();
    	//test a list of 5 elements with 2 repeating elements
    	testDLL.insertBefore(0,1);
        testDLL.insertBefore(1,2);
        testDLL.insertBefore(2,1);
        testDLL.insertBefore(5,4);
        testDLL.insertBefore(5,4);
        testDLL.makeUnique();
        assertEquals( "Checking makeUnique with a list of 5 elements with 2 repeating elements", "1,2,4", testDLL.toString() );
        
      //test a list of 5 elements with 5 repeating elements
        testDLL = new DoublyLinkedList<Integer>();
    	testDLL.insertBefore(0,1);
        testDLL.insertBefore(1,1);
        testDLL.insertBefore(2,1);
        testDLL.insertBefore(4,1);
        testDLL.insertBefore(5,1);
        testDLL.makeUnique();
        assertEquals( "Checking makeUnique with a list of 5 elements with 5 repeating elements", "1", testDLL.toString() );
        
        //test a list of 6 elements with 0 repeating elements
        testDLL = new DoublyLinkedList<Integer>();
        testDLL.insertBefore(0,1);
        testDLL.insertBefore(1,2);
        testDLL.insertBefore(2,3);
        testDLL.insertBefore(100,6);
        testDLL.insertBefore(100,8);
        testDLL.insertBefore(100,9);
        testDLL.makeUnique();
        assertEquals( "Checking makeUnique with a list of 6 elements with 0 repeating elements", "1,2,3,6,8,9", testDLL.toString() );
        
        //test a list with 1 element
        testDLL = new DoublyLinkedList<Integer>();
        testDLL.insertBefore(0,1);
        testDLL.makeUnique();
        assertEquals( "Checking with a list of 1 element", "1", testDLL.toString() );
        
        //test a list with 2 unique elements
        testDLL = new DoublyLinkedList<Integer>();
        testDLL.insertBefore(0,1);
        testDLL.insertBefore(1,2);
        testDLL.makeUnique();
        assertEquals( "Checking with a list of 2 unique elements", "1,2", testDLL.toString() );
        
        //test a list with 2 of the same elements
        testDLL = new DoublyLinkedList<Integer>();
        testDLL.insertBefore(0,6);
        testDLL.insertBefore(1,6);
        testDLL.makeUnique();
        assertEquals( "Checking with a list of 2 non-unique elements", "6", testDLL.toString() );
        
        //test a list with no elements
        testDLL = new DoublyLinkedList<Integer>();
        testDLL.makeUnique();
        assertEquals( "Checking with a list of 0 elements", "", testDLL.toString() );
        
    }
    
    @Test
    public void testGet() {
    	DoublyLinkedList<Integer> testDLL = new DoublyLinkedList<Integer>();
    	
    	//test a list with 7 elements
    	testDLL.insertBefore(0, 5);
    	testDLL.insertBefore(1, 6);
    	testDLL.insertBefore(2, 7);
    	testDLL.insertBefore(3, 8);
    	testDLL.insertBefore(4, 9);
    	testDLL.insertBefore(5, 11);
    	testDLL.insertBefore(6, 1);
    	assertEquals( "getting the first element of the list", "5", testDLL.get(0).toString() );
    	assertEquals( "getting the middle element of the list", "8", testDLL.get(3).toString() );
    	assertEquals( "getting the last element of the list", "1", testDLL.get(6).toString() );
    	
    	 //test a list with 1 element
        testDLL = new DoublyLinkedList<Integer>();
        testDLL.insertBefore(0,1);
        assertEquals( "getting the first element of the list", "1", testDLL.get(0).toString() );
        
        //test a list with 2 unique elements
        testDLL = new DoublyLinkedList<Integer>();
        testDLL.insertBefore(0,1);
        testDLL.insertBefore(1,2);
        assertEquals( "getting the second element of the list", "2", testDLL.get(1).toString() );
        
        //test a list with no elements
        testDLL = new DoublyLinkedList<Integer>();
        assertEquals( "Checking with a list of 0 elements", null, testDLL.get(0) );
    }
    
    @Test
    public void testPush() {
    	DoublyLinkedList<Integer> testDLL = new DoublyLinkedList<Integer>();
    	
    	//test a list with 7 elements
    	testDLL.push(5);
    	testDLL.push(6);
    	testDLL.push(7);
    	testDLL.push(8);
    	testDLL.push(9);
    	testDLL.push(11);
    	testDLL.push(1);
    	assertEquals( "Checking push", "1,11,9,8,7,6,5", testDLL.toString() );
    }
    
    @Test
    public void testPop() {
    	DoublyLinkedList<Integer> testDLL = new DoublyLinkedList<Integer>();
    	
    	//test a list with 7 elements
    	testDLL.push(5);
    	testDLL.push(6);
    	testDLL.push(7);
    	testDLL.push(8);
    	testDLL.push(9);
    	testDLL.push(11);
    	testDLL.push(1);
    	assertEquals( "Checking push", "1,11,9,8,7,6,5", testDLL.toString() );
    	
    	testDLL.pop();
    	assertEquals( "Checking pop", "11,9,8,7,6,5", testDLL.toString() );
    	testDLL.pop();
    	assertEquals( "Checking pop", "9,8,7,6,5", testDLL.toString() );
    	testDLL.pop();
    	assertEquals( "Checking pop", "8,7,6,5", testDLL.toString() );
    	testDLL.pop();
    	assertEquals( "Checking pop", "7,6,5", testDLL.toString() );
    	testDLL.pop();
    	assertEquals( "Checking pop", "6,5", testDLL.toString() );
    	testDLL.pop();
    	assertEquals( "Checking pop", "5", testDLL.toString() );
    	testDLL.pop();
    	assertEquals( "Checking pop", "", testDLL.toString() );
    }
    
    @Test
    public void testEnqueue() {
    	DoublyLinkedList<Integer> testDLL = new DoublyLinkedList<Integer>();
    	
    	//test a list with 7 elements
    	testDLL.enqueue(5);
    	testDLL.enqueue(6);
    	testDLL.enqueue(7);
    	testDLL.enqueue(8);
    	testDLL.enqueue(9);
    	testDLL.enqueue(11);
    	testDLL.enqueue(1);
    	assertEquals( "Checking enqueue of 7 numbers", "5,6,7,8,9,11,1", testDLL.toString() );
    }
    
    @Test
    public void testDequeue() {
    	DoublyLinkedList<Integer> testDLL = new DoublyLinkedList<Integer>();
    	
    	//test a list with 7 elements
    	testDLL.enqueue(5);
    	testDLL.enqueue(6);
    	testDLL.enqueue(7);
    	testDLL.enqueue(8);
    	testDLL.enqueue(9);
    	testDLL.enqueue(11);
    	testDLL.enqueue(1);
    	assertEquals( "Checking enqueue of 7 numbers", "5,6,7,8,9,11,1", testDLL.toString() );
    	
    	testDLL.dequeue();
    	assertEquals( "Checking dequeue of 5", "6,7,8,9,11,1", testDLL.toString() );
    	testDLL.dequeue();
    	assertEquals( "Checking dequeue of 6", "7,8,9,11,1", testDLL.toString() );
    	testDLL.dequeue();
    	assertEquals( "Checking dequeue of 7", "8,9,11,1", testDLL.toString() );
    	testDLL.dequeue();
    	assertEquals( "Checking dequeue of 8", "9,11,1", testDLL.toString() );
    	testDLL.dequeue();
    	assertEquals( "Checking dequeue of 9", "11,1", testDLL.toString() );
    	testDLL.dequeue();
    	assertEquals( "Checking dequeue of 11", "1", testDLL.toString() );
    	testDLL.dequeue();
    	assertEquals( "Checking dequeue of 1", "", testDLL.toString() );
    }
}

