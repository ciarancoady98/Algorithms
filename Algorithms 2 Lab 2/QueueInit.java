import java.util.Comparator;
import java.util.PriorityQueue;

public class QueueInit {
	QueueInit(){
		
	}
	
	public void makeQueue(){
    	//initialize the priority queue with a comparator for our purposes
      	Comparator<Integer> queueComparator = new Comparator<Integer>() {
        	@Override
			public int compare(Integer a, Integer b) {
				if (distTo[a] > distTo[b])
				return 1;
				else if (distTo[a] < distTo[b])
					return -1;
				else
					return 0;
			}
      	};
      	this.pq = new PriorityQueue<Integer>(this.N, queueComparator);
    }
}
