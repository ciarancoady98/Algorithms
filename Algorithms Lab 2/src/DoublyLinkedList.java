import java.util.Iterator;
import java.util.ListIterator;
import java.util.NoSuchElementException;

// -------------------------------------------------------------------------
/**
 *  This class contains the methods of Doubly Linked List.
 *
 *  @author  
 *  @version 01/10/18 17:35:49
 */


/**
 * Class DoublyLinkedList: implements a *generic* Doubly Linked List.
 * @param <T> This is a type parameter. T is used as a class name in the
 * definition of this class.
 *
 * When creating a new DoublyLinkedList, T should be instantiated with an
 * actual class name that extends the class Comparable.
 * Such classes include String and Integer.
 *
 * For example to create a new DoublyLinkedList class containing String data: 
 *    DoublyLinkedList<String> myStringList = new DoublyLinkedList<String>();
 *
 * The class offers a toString() method which returns a comma-separated sting of
 * all elements in the data structure.
 * 
 * This is a bare minimum class you would need to completely implement.
 * You can add additional methods to support your code. Each method will need
 * to be tested by your jUnit tests -- for simplicity in jUnit testing
 * introduce only public methods.
 */
class DoublyLinkedList<T extends Comparable<T>>
{

    /**
     * private class DLLNode: implements a *generic* Doubly Linked List node.
     */
    private class DLLNode
    {
        public final T data; // this field should never be updated. It gets its
                             // value once from the constructor DLLNode.
        public DLLNode next;
        public DLLNode prev;
    
        /**
         * Constructor
         * @param theData : data of type T, to be stored in the node
         * @param prevNode : the previous Node in the Doubly Linked List
         * @param nextNode : the next Node in the Doubly Linked List
         * @return DLLNode
         */
        public DLLNode(T theData, DLLNode prevNode, DLLNode nextNode) 
        {
          data = theData;
          prev = prevNode;
          next = nextNode;
        }
    }

    // Fields head and tail point to the first and last nodes of the list.
    private DLLNode head, tail;

    /**
     * Constructor of an empty DLL
     * @return DoublyLinkedList
     */
    public DoublyLinkedList() 
    {
    	head = null;
    	tail = null;
    }

    /**
     * Tests if the doubly linked list is empty
     * @return true if list is empty, and false otherwise
     *
     * Worst-case asymptotic running time cost: O(1)
     *
     * Justification:
     *  As there is only an if else statement used, no loops
     *  or calls to other functions. so only the constant time
     *  required to execute an if else statement.
     */
    public boolean isEmpty()
    {
    	if(head == null && tail == null)
    	{
    		return true;
    	}
    	else
    		return false;
    }
    
    //Runtime Theta(N) because of while loop
    //Returns the size of the doublyLinkedList
    private int size(){
    	int size;
    	if(isEmpty()) {
    		size = 0;
    	}
    	else {
    		size = 1;
        	DLLNode currentNode = this.head;
        	while(currentNode.next != null && currentNode.next != null){
        		currentNode = currentNode.next;
        		size++;
        	}
    	}
    	return size;
    }
    
  //Runtime Theta(1) because of constant time operations
    //Inserts an element to the start of the list
    private boolean insertFirst(T data){
    	boolean inserted = false;
    	if(data != null){
    		if(this.size() == 0){
    			DLLNode newNode = new DLLNode(data, this.tail, this.head);
            	this.head = newNode;
            	this.tail = newNode;
            	inserted = true;
    		}
    		else if(this.size() > 0){
    			DLLNode newNode = new DLLNode(data, null, this.head);
    			this.head.prev = newNode;
    			this.head = newNode;
    			inserted = true;
    		}
    	}
    	if(inserted)
    		return true;
    	else
    		return false;
    }
    
    //Runtime Theta(1) because of constant time operations
    //Inserts an element to the end of the list
    private boolean insertLast(T data){
    	boolean inserted = false;
    	if(data != null){
    		if(this.size() == 0){
    			DLLNode newNode = new DLLNode(data, this.tail, this.head);
            	this.head = newNode;
            	this.tail = newNode;
            	inserted = true;
    		}
    		else if(this.size() > 0){
    			DLLNode newNode = new DLLNode(data, this.tail, null);
            	this.tail.next = newNode;
            	this.tail = newNode;
    			inserted = true;
    		}
    	}
    	if(inserted)
    		return true;
    	else
    		return false;
    }

    /**
     * Inserts an element in the doubly linked list
     * @param pos : The integer location at which the new data should be
     *      inserted in the list. We assume that the first position in the list
     *      is 0 (zero). If pos is less than 0 then add to the head of the list.
     *      If pos is greater or equal to the size of the list then add the
     *      element at the end of the list.
     * @param data : The new data of class T that needs to be added to the list
     * @return none
     *
     * Worst-case asymptotic running time cost: Theta(N)
     *
     * Justification:
     *  The method has all constant time operations 
     *  and calls to constant time functions but 
     *  the for loop causes a worst case asymptotic 
     *  running time of Theta(N) as it could go through
     *  nearly all the elements of the linked list
     *  N.
     */
    public void insertBefore( int pos, T data ) 
    {
    	if(pos == 0 || pos < 0 /*|| pos == this.size()-1*/)
    	{
    		insertFirst(data);
    	}
    	else if(pos >= this.size())
    	{
    		insertLast(data);
    	}
    	else {
    		
    		DLLNode newNode = new DLLNode(data, null, null);
    		DLLNode tempNode = this.head;
    		for(int index = 0; index < pos; index++) {
    			tempNode = tempNode.next;
    		}
    		DLLNode moveNode = tempNode.prev;
    		moveNode.next = newNode;
    		newNode.prev = moveNode;
    		tempNode.prev = newNode;
    		newNode.next = tempNode;
    	}
    }

    /**
     * Returns the data stored at a particular position
     * @param pos : the position
     * @return the data at pos, if pos is within the bounds of the list, and null otherwise.
     *
     * Worst-case asymptotic running time cost: Theta(N)
     *
     * Justification:
     * The method has all constant time operations
     * but the for loop causes a worst case asymptotic 
     * running time of Theta(N) as it could go through
     * nearly all the elements of the linked list
     * N.
     *
     */
    public T get(int pos) 
    {
    	T data;
    	if(pos < this.size() && pos >= 0)
    	{
    		//item is in the list
    		DLLNode currentNode = this.head;
    		if(currentNode.next != null){
    			for(int index = 0; index < pos; index++){
            		currentNode = currentNode.next;
            	}
            	data = currentNode.data;
    		}
    		else 
    			data = currentNode.data;
    	}
    	else
    		data = null;
    	
    	return data;
    }

    /**
     * Deletes the element of the list at position pos.
     * First element in the list has position 0. If pos points outside the
     * elements of the list then no modification happens to the list.
     * @param pos : the position to delete in the list.
     * @return true : on successful deletion, false : list has not been modified. 
     *
     * Worst-case asymptotic running time cost: Theta(N)
     *
     * Justification:
     *  All operations in this method are 
     *  constant time operations other than
     *  the for-loop which has a worst-case
     *  asymptotic running time cost Theta(N).
     */
    public boolean deleteAt(int pos) 
    {
    	boolean deleted = false;
    	int size = this.size();
    	if(pos < size && pos >= 0)
    	{
    		//find the element we are trying to delete
    		DLLNode currentNode = this.head;
    		if(currentNode.next != null){
    			for(int index = 0; index < pos; index++){
            		currentNode = currentNode.next;
            	}
    		}
    		
    		if(size == 1) {
    			this.head = null;
    			this.tail = null;
    			deleted = true;
    		}
    		else if(size >= 2) {
    			if(currentNode.prev != null) {
    				currentNode.prev.next = currentNode.next;
    			}
    			if(currentNode.next != null) {
    				currentNode.next.prev = currentNode.prev;
    			}
    			if(currentNode == this.head) {
    				this.head = currentNode.next;
    				if(size == 2) {
    					this.head.next = null;
    					this.tail = this.head;
    				}
    			}
    			if(currentNode == this.tail) {
    				this.tail = currentNode.prev;
    				if(size == 2) {
    					this.tail.prev = null;
    					this.head = this.tail;
    				}
    			}
    			currentNode = null;
    			deleted = true;
    		}
    	}
    	return deleted;
    }

    /**
     * Reverses the list.
     * If the list contains "A", "B", "C", "D" before the method is called
     * Then it should contain "D", "C", "B", "A" after it returns.
     *
     * Worst-case asymptotic running time cost: Theta(N)
     *
     * Justification:
     *  The method contains a while loop
     *  which traverses the list (Theta(N)) and reverses
     *  all the pointers and then using constant
     *  time operations swaps the head with the tail
     *  completing the list reversal.
     */
    public void reverse()
    {
    	if(this.size() > 1) {
    		DLLNode temp = this.head;
    		DLLNode currentNode = this.head;
    		while(currentNode != this.tail) {
    			DLLNode nodeBeingReversed = currentNode.next;
    			currentNode.next = currentNode.prev;
    			currentNode.prev = nodeBeingReversed;
    			currentNode = currentNode.prev;
    		}
    		this.tail.next = this.tail.prev;
    		this.tail.prev = null;
    		this.head = this.tail;
    		temp.prev = temp.next;
    		temp.next = null;
    		tail = temp;
    	}
    }

    /**
     * Removes all duplicate elements from the list.
     * The method should remove the _least_number_ of elements to make all elements unique.
     * If the list contains "A", "B", "C", "B", "D", "A" before the method is called
     * Then it should contain "A", "B", "C", "D" after it returns.
     * The relative order of elements in the resulting list should be the same as the starting list.
     *
     * Worst-case asymptotic running time cost: Theta(N^2)
     *
     * Justification:
     * The method uses nested for-loops to take every
     * element of the list and check if it occurs more 
     * than once. These loops have a worst case asymptotic
     * running time of Theta(N) giving the nested loops 
     * a worst case running time of the product of both 
     * loops Theta(N^2).
     * (note i had attempted to use bubble sort to 
     * first sort the algorithm and then i was going
     * to check if any elements were the same while 
     * sorting and that way i could have a more efficient 
     * algorithm. But due to generics i had no method
     * of comparing magnitude of elements and thus couldn't 
     * sort them)
     */
     public void makeUnique()
    {
    	 int size = this.size();
    	 if(!this.isEmpty() && size > 1) {
    		 DLLNode currentNode = this.head;
    		 for(int index = 0; index < size; index++) {
    			 T data = currentNode.data;
    			 DLLNode nextNode = currentNode.next;
    			 for(int index2 = index+1; index2 < size; index2++) {
    				 T data2 = nextNode.data;
    				 if(data == data2) {
    					 this.deleteAt(index2);
    					 size--;
    					 index2 = index;
    					 nextNode = currentNode.next;
    				 }
    				 else
    					 nextNode = nextNode.next;
    			 }
    			 currentNode = currentNode.next;
    		 }
    	 }
    }


    /*----------------------- STACK API 
     * If only the push and pop methods are called the data structure should behave like a stack.
     */

    /**
     * This method adds an element to the data structure.
     * How exactly this will be represented in the Doubly Linked List is up to the programmer.
     * @param item : the item to push on the stack
     *
     * Worst-case asymptotic running time cost: Theta(1)
     *
     * Justification:
     * This method uses all constant time operations and 
     * thus has a worst case asymptotic running time of
     * Theta(1)
     */
    public void push(T item) 
    {
    	if(item != null){
    		if(this.size() == 0){
    			DLLNode newNode = new DLLNode(item, this.tail, this.head);
            	this.head = newNode;
            	this.tail = newNode;
    		}
    		else if(this.size() > 0){
    			DLLNode newNode = new DLLNode(item, null, this.head);
    			this.head.prev = newNode;
    			this.head = newNode;
    		}
    	}
    }

    /**
     * This method returns and removes the element that was most recently added by the push method.
     * @return the last item inserted with a push; or null when the list is empty.
     *
     * Worst-case asymptotic running time cost: Theta(1)
     *
     * Justification:
     * This method uses all constant time operations and 
     * thus has a worst case asymptotic running time of
     * Theta(1)
     */
    public T pop() 
    {
      T data = null;
      if(this.head != null && this.head.data != null) {
    	  data = this.head.data;
    	  this.deleteAt(0);
      }
      return data;
    }

    /*----------------------- QUEUE API
     * If only the enqueue and dequeue methods are called the data structure should behave like a FIFO queue.
     */
 
    /**
     * This method adds an element to the data structure.
     * How exactly this will be represented in the Doubly Linked List is up to the programmer.
     * @param item : the item to be enqueued to the stack
     *
     * Worst-case asymptotic running time cost: Theta(1)
     *
     * Justification:
     * This method uses all constant time operations and 
     * thus has a worst case asymptotic running time of
     * Theta(1). It uses insertLast, which has a worst
     * case asymptotic running time of Theta(1).
     */
    public void enqueue(T item) 
    {
    	if(item != null){
    		if(this.size() == 0){
    			DLLNode newNode = new DLLNode(item, this.tail, this.head);
            	this.head = newNode;
            	this.tail = newNode;
    		}
    		else if(this.size() > 0){
    			this.insertLast(item);
    		}
    	}
    }

     /**
     * This method returns and removes the element that was least recently added by the enqueue method.
     * @return the earliest item inserted with an enqueue; or null when the list is empty.
     *
     * Worst-case asymptotic running time cost: Theta(1)
     *
     * Justification:
     * This method uses all constant time operations and 
     * thus has a worst case asymptotic running time of
     * Theta(1). The call to delete at is always going to
     * delete the first element(head) of the list and thus
     * will not cause any loops. This gives it a runtime in
     * this case of Theta(1).
     */
    public T dequeue() 
    {
    	T data = null;
        if(this.head != null && this.head.data != null) {
      	  data = this.head.data;
      	  this.deleteAt(0);
        }
        return data;
    }
 

    /**
     * @return a string with the elements of the list as a comma-separated
     * list, from beginning to end
     *
     * Worst-case asymptotic running time cost:   Theta(n)
     *
     * Justification:
     *  We know from the Java documentation that StringBuilder's append() method runs in Theta(1) asymptotic time.
     *  We assume all other method calls here (e.g., the iterator methods above, and the toString method) will execute in Theta(1) time.
     *  Thus, every one iteration of the for-loop will have cost Theta(1).
     *  Suppose the doubly-linked list has 'n' elements.
     *  The for-loop will always iterate over all n elements of the list, and therefore the total cost of this method will be n*Theta(1) = Theta(n).
     */
    public String toString() 
    {
      StringBuilder s = new StringBuilder();
      boolean isFirst = true; 

      // iterate over the list, starting from the head
      for (DLLNode iter = head; iter != null; iter = iter.next)
      {
        if (!isFirst)
        {
          s.append(",");
        } else {
          isFirst = false;
        }
        s.append(iter.data.toString());
      }

      return s.toString();
    }


}



