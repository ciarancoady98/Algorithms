import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
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
	//city road network
	//private double[][] roadNetwork;
	private EdgeWeightedDigraph roadNetwork;
	double[] distTo; //distTo[v] = distance of shortest s->v path
	DirectedEdge[] edgeTo; //edge[v] = last edge on shortest s->v path
	private IndexMinPQ<Double> pq; //priority queue of vertices
    CompetitionDijkstra (String filename, int sA, int sB, int sC){
    	/*
    	 * Code for Reading in from file and constructing the tree
    	 */
    	int walkingSpeedA = sA;
    	int walkingSpeedB = sB;
    	int walkingSpeedC = sC;
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
					System.out.println("N = " + N);
				}
				else if(lineCount == 2) {
					//reading second line
					//total number of streets (S)
					S = Integer.valueOf(line);
					System.out.println("S = " + S);
					//create adjacency matrix to store information
					roadNetwork = new EdgeWeightedDigraph(N, S);
				}
				else if(lineCount > 2) {
					//need to parse line into separate things
					scanner = new Scanner(line);
					int from = scanner.nextInt();
					int to = scanner.nextInt();
					double weight = scanner.nextDouble();
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
    	 * End of file reading and tree building code
    	 */
    }


    /**
    * @return int: minimum minutes that will pass before the three contestants can meet
     */
    public int timeRequiredforCompetition(){

        //TODO implement dijkstras
    	//if a path does not exist between 2 intersections
    	//then break out and return -1
    	double longestPath = -1;
    	for(int i = 0; i < this.N; i++) {
    		// relax vertices in order of distance from s
    		//s is the source vertex
    		distTo = new double[this.N];
            edgeTo = new DirectedEdge[this.N];
            pq = new IndexMinPQ<Double>(this.N);
            pq.insert(i, distTo[i]);
            while (!pq.isEmpty()) {
                int v = pq.delMin();
                for (DirectedEdge e : G.adj(v))
                    relax(e);
            }
    	}
    	
        return -1;
    }
    
    // relax edge e and update pq if changed
    private void relax(DirectedEdge e) {
        int v = e.from(), w = e.to();
        if (distTo[w] > distTo[v] + e.weight()) {
            distTo[w] = distTo[v] + e.weight();
            edgeTo[w] = e;
            if (pq.contains(w)) pq.decreaseKey(w, distTo[w]);
            else                pq.insert(w, distTo[w]);
        }
    }
    
    public String toString() {
		return this.roadNetwork.toString();
	}
    
    public static void main(String[] args)
    {
    	CompetitionDijkstra comp = new CompetitionDijkstra("tinyEWD.txt", 1, 1, 1);
    	System.out.print(comp.toString());
    }

}
