//this is a bag object, you can place items in it but 
//not remove them, it is implemented using a linked list
public class Bag<T>{
	
	/**
     * Private node class.
     */
    private class Node {
        private DirectedEdge edge;         
        private Node next;
        
        public Node(DirectedEdge edge) {
            this.edge = edge;
            this.next = null;
        }
    }
	public Bag(){
		
	}

}
