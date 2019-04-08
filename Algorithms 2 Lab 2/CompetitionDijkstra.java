import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;

/*
 * A Contest to Meet (ACM) is a reality TV contest that sets three contestants at three random
 * city intersections. In order to win, the three contestants need all to meet at any intersection
 * of the city as fast as possible.
 * It should be clear that the contestants may arrive at the intersections at different times, in
 * which case, the first to arrive can wait until the others arrive.
 * From an estimated walking speed for each one of the three contestants, ACM wants to determine the
 * minimum time that a live TV broadcast should last to cover their journey regardless of the contestants’
 * initial positions and the intersection they finally meet. You are hired to help ACM answer this question.
 * You may assume the following:
 *     Each contestant walks at a given estimated speed.
 *     The city is a collection of intersections in which some pairs are connected by one-way
 * streets that the contestants can use to traverse the city.
 *
 * This class implements the competition using Dijkstra's algorithm
 */

public class CompetitionDijkstra {
    /**
     * @param filename: A filename containing the details of the city road network
     * @param sA, sB, sC: speeds for 3 contestants
    */
	//Total number of intersections in the city
	private int N;
	//Total number of streets in the city
	private int S;
	//city road network (stored as adjacency array)
	private EdgeWeightedDigraph roadNetwork;
	double[] distTo; //distTo[v] = distance of shortest s->v path
	int[] edgeTo; //edge[v] = last edge on shortest s->v path
	private PriorityQueue<Integer> pq; //priority queue of vertices
	private int slowestSpeed; //walking speed of the slowest contestant
    CompetitionDijkstra (String filename, int sA, int sB, int sC){
    	/*
    	 * Code for Reading in from file and constructing the graph
    	 */
    	//get the walking speed of the slowest contestant
    	this.slowestSpeed = slowestPerson(sA, sB, sC);
    	try {
    		String line = "init";
			FileReader fileReader = new FileReader(filename);
			BufferedReader bufferedReader = new BufferedReader(fileReader);
			Scanner scanner = new Scanner(line);
			int lineCount = 1;
			while((line = bufferedReader.readLine()) != null) {
				if(lineCount == 1) {
					//reading first line
					//number of intersections (N)
					N = Integer.valueOf(line);
					//System.out.println("N = " + N);
				}
				else if(lineCount == 2) {
					//reading second line
					//total number of streets (S)
					S = Integer.valueOf(line);
					//System.out.println("S = " + S);
					//create adjacency array to store information
					roadNetwork = new EdgeWeightedDigraph(N, S);
				}
				else {
					//need to parse line into separate pieces of information
					scanner = new Scanner(line);
					int from = scanner.nextInt();
					int to = scanner.nextInt();
					double weight = scanner.nextDouble();
					//create edge
					DirectedEdge edge =  new DirectedEdge(from, to, weight);
					roadNetwork.addEdge(edge);
				}
				lineCount++;
			}
			bufferedReader.close();
			fileReader.close();
			scanner.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
    	/*
    	 * End of file reading and graph building code
    	 */
    }


    /**
    * @return int: minimum minutes that will pass before the three contestants can meet
     */
    public int timeRequiredforCompetition(){
    	if(this.slowestSpeed == -1 || this.roadNetwork == null) {
    		return -1;
    	}
    	double timeRequired = -1;
    	//this is the longest path a contestant will have to travel
    	double longestPath = -1;
    	//starting at every vertex
    	for(int source = 0; source < this.N; source++) {
    		//calculate the shortest paths to every other vertex
    		double[] shortestPaths = dijkstra(this.roadNetwork, source);
    		for(int destination = 0; destination < this.N; destination++) {
    			//check if any of the vertices are unreachable from source
    			if(shortestPaths[destination] == Double.POSITIVE_INFINITY) {
    				return -1;
    			}
    			//check is the path we found longer than others
    			else if(shortestPaths[destination] > longestPath) {
    				longestPath = shortestPaths[destination];
    			}
    		}
    	}
    	//convert km to meters and calculate the time it will take
    	timeRequired = (longestPath * 1000) / slowestSpeed;
    	//round up the result to the nearest integer
        return (int) Math.ceil(timeRequired);
    }
    
    //find the slowest person in the competition
    private int slowestPerson(int a, int b, int c) {
    	if(a < 50 || a > 100 || b < 50 || b > 100 || c < 50 || c > 100 )
    		return -1;
    	else {
    		int temp = Math.min(a, b);
        	return Math.min(temp, c);
    	}
    }
    
    private double[] dijkstra(EdgeWeightedDigraph graph, int source) {
    	//distance from source to a vertex
		distTo = new double[this.N];
		//the last vertex we came through to get here
        edgeTo = new int[this.N];
        //Initialize the values to infinite
        for(int i = 0; i < distTo.length; i++) {
        	distTo[i] = Double.POSITIVE_INFINITY;
        }
        //initialize the distance from the source to itself to 0
      	distTo[source] = 0;
      	//initialize the priority queue with a comparator for our purposes
        pq = new PriorityQueue<Integer>(new Comparator<Integer>() {
			public int compare(Integer a, Integer b) {
				if (distTo[a] > distTo[b])
				return 1;
				else if (distTo[a] < distTo[b])
					return -1;
				else
					return 0;
			}});
        pq.add(source);
        //start at the source vertex
        int vertex = source;
        //if the queue is empty we are done
        boolean queueEmpty = false;
        while(!queueEmpty) {
        	//if the vertex has edges coming from it
        	if(!this.roadNetwork.adjacentEdges(vertex).isEmpty()) {
            	for(DirectedEdge edge : this.roadNetwork.adjacentEdges(vertex)) {
                	relax(edge);
                }
                if(!pq.isEmpty()) {
                	//get the next closest vertex to relax from
            		vertex = pq.poll();
            	}
            	else
            		//we've exhausted all options and are done
            		queueEmpty = true;
            }
        }
        //return the distances to each vertex from the passed source
    	return distTo;
    }
    
    //relax the passed edge and update the data structures accordingly
    private void relax(DirectedEdge edge) {
        int vertexFrom = edge.from, vertexTo = edge.to;
        if (distTo[vertexTo] > distTo[vertexFrom] + edge.weight) {
            distTo[vertexTo] = distTo[vertexFrom] + edge.weight;
            edgeTo[vertexTo] = edge.from;
            if (pq.contains(vertexTo)) {
            	//update the queue with the new value
            	pq.remove(vertexTo);
            }
            pq.add(vertexTo);
        }
    }
    
    /*
     * Used for debugging
    public String toString() {
		return this.roadNetwork.toString();
	}
	*/
}
