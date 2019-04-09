//@Author:Ciaran Coady
import static org.junit.Assert.assertEquals;

import java.util.PriorityQueue;

import org.junit.Test;

public class CompetitionTests {
/*
 * Performance Discussion
 * 
 * 1. Justify the choice of the data structures used in CompetitionDijkstra and CompetitionFloydWarshall
 * 
 * For my implementation of Dijkstra's shortest path I used an adjacency-list representation of the graph,
 * which I stored in the EdgeWeightedDigraph class. I made this choice as it very space effective for 
 * sparse graphs as we only populate the adjacency-lists with edges that exist in the graph. For my testing
 * I was only using sparse graphs as they are faster to process, so it made sense to use an adjacency-list.
 * It is also much faster to iterate over all the edges (to print them for example) in a sparse graph using
 * an adjacency-list over a 2D-array as we don't need to iterate over array indexes that don't contain edges.
 * Dijkstra does not require us to update and edge weights in the graph representation itself, so the longer
 * search time for an edge in an adjacency-list doesn't matter. Instead all path information is stored in 
 * two vertex indexed arrays:
 * edgeTo - this stores the last vertex we came through to get to the vertex at the index number
 * distTo - this stores the distance from the source vertex to the vertex at the index number
 * Dijkstra also makes use of a priority queue to choose which path to pursue next, as it a greedy algorithm
 * and will take the option that looks best at that specific moment.
 * As a result of needing these extra data structures along with the graph itself, it made sense to save as
 * much space as possible, and even though an adjacency-list can be slower than a 2D-array when it comes to 
 * finding a specific edge the savings we get in other regards made it a good choice to use with 
 * Dijkstra.
 * 
 * For my implementation of FloydWarshall I used a 2D-array adjacency matrix implementation. I made this
 * choice as FloydWarshall finds the shortest path from every node to every other node in a graph. This 
 * is achieved by populating the 2D-array with all the edges in the graph, all other elements of the array
 * get initialized to infinite as no edge exists between those 2 nodes. If an edge exists between Vertex
 * i and vertex j, the weight of that edge (path) will be found at graph[i][j]. After this the algorithm
 * starts at the lowest index and calculates distances from one vertex to another based on the information
 * currently contained in the 2D-array. If a path does not exist between two vertices, the value in the 
 * array will remain infinite. A 2D-array implementation makes sense for FloydWarshall as we make use 
 * of all previous results to calculate new shortest paths, updating values as we find them. Because of 
 * this if we were to use an adjacency-list representation of the graph we would not benefit from any
 * space savings and also incur losses in speed when it comes to finding a particular edge. We would also
 * introduce all the extra overhead that is involved with an adjacency-list, including objects, linked
 * lists etc. Hence making a 2D-array implementation a good choice to use with FlyodWarshall
 * 
 * 
 * 2. Explain theoretical differences in the performance of Dijkstra and FloydWarshall algorithms in
 * the given problem. Also explain how would their relative performance be affected by the density of
 * the graph. Which would you choose in which set of circumstances and why?
 * 
 * Dijkstra has a time complexity of O(ElogV) where E = no of edges and V no of vertices. For a single
 * source and single destination vertex, it does not calculate the shortest path for every combination
 * of vertices. However for this problem it is required to calculate the shortest path from every vertex
 * to every other vertex as we need to calculate the longest show runtime. This means that we need to run
 * Dijkstra for every set of source and destination vertices, so the runtime becomes VElogV.
 * 
 * For FloydWarshall the runtime is always V^3 due to the nested for-loops that is uses. The thing 
 * about FloydWarshall is that it is insensitive to input so the runtime remains the same for graphs
 * with few edges as many edges. It also calculates the shortest paths from every vertex to every other
 * vertex. Whereas Dijkstra has a varying runtime based on the input provided (many edges? dense graph?).
 * 
 * For a sparse graph (few edges) Dijkstra will perform better as its runtime is correlated to the number 
 * of edges, where as FloydWarshall will run V^3 times regardless of the number of edges provided. For a
 * dense graph lets say a fully connected graph, Dijkstra becomes slower than FloydWarsall.
 * 
 * For a sparsely connected graph I would choose Dijkstra as it has a shorter runtime and a smaller memory
 * usage over FloydWarshall because it does not need to fully populate its adjacency-list. 
 * However for a dense graph I would choose FloydWarshall as it has a shorter runtime for dense graphs and 
 * also less memory usage because of its 2D-array implementation having less overhead to the near full adjacency
 * list representation that is used in Dijkstra.
 */
	@Test
	public void normalScenario() {
		// test if both algorithms agree with the slowest speed and smallest file
		CompetitionDijkstra dijkstra = new CompetitionDijkstra("tinyEWD.txt", 50, 50, 50);
		CompetitionFloydWarshall floydWarshall = new CompetitionFloydWarshall("tinyEWD.txt", 50, 50, 50);
		assertEquals(dijkstra.timeRequiredforCompetition(), floydWarshall.timeRequiredforCompetition());

		// test if both algorithms agree with the slowest speed and large file
		dijkstra = new CompetitionDijkstra("tinyEWD.txt", 50, 50, 50);
		floydWarshall = new CompetitionFloydWarshall("tinyEWD.txt", 50, 50, 50);
		assertEquals(dijkstra.timeRequiredforCompetition(), floydWarshall.timeRequiredforCompetition());
		
		// test if both algorithms agree with the fastest speed and large file
		dijkstra = new CompetitionDijkstra("tinyEWD.txt", 100, 100, 100);
		floydWarshall = new CompetitionFloydWarshall("tinyEWD.txt", 100, 100, 100);
		assertEquals(dijkstra.timeRequiredforCompetition(), floydWarshall.timeRequiredforCompetition());
		
	}
	
	@Test
	public void invalidFile() {
		// test if the result is -1 when an invalid filename is given
		CompetitionDijkstra dijkstra = new CompetitionDijkstra("helloworld.txt", 50, 50, 50);
		assertEquals(dijkstra.timeRequiredforCompetition(), -1);
		
		CompetitionFloydWarshall floydWarshall = new CompetitionFloydWarshall("helloworld.txt", 50, 50, 50);
		assertEquals(floydWarshall.timeRequiredforCompetition(), -1);
		
		// test if the result is -1 when an invalid file is given
		dijkstra = new CompetitionDijkstra("helloworld.txt", 50, 50, 50);
		assertEquals(dijkstra.timeRequiredforCompetition(), -1);
		
		floydWarshall = new CompetitionFloydWarshall("helloworld.txt", 50, 50, 50);
		assertEquals(floydWarshall.timeRequiredforCompetition(), -1);
		
		
		
		
	}
	
	@Test
	public void invalidSpeed() {
		// test when speed is out of bounds for both algorithms
		// test speed too slow
		CompetitionDijkstra dijkstra = new CompetitionDijkstra("tinyEWD.txt", 20, 50, 50);
		assertEquals(dijkstra.timeRequiredforCompetition(), -1);
		CompetitionFloydWarshall floydWarshall = new CompetitionFloydWarshall("tinyEWD.txt", 20, 50, 50);
		assertEquals(floydWarshall.timeRequiredforCompetition(), -1);
		
		// test speed too slow
		dijkstra = new CompetitionDijkstra("tinyEWD.txt", 50, 20, 50);
		assertEquals(dijkstra.timeRequiredforCompetition(), -1);
		floydWarshall = new CompetitionFloydWarshall("tinyEWD.txt", 50, 20, 50);
		assertEquals(floydWarshall.timeRequiredforCompetition(), -1);
		
		// test speed too slow
		dijkstra = new CompetitionDijkstra("tinyEWD.txt", 50, 50, 20);
		assertEquals(dijkstra.timeRequiredforCompetition(), -1);
		floydWarshall = new CompetitionFloydWarshall("tinyEWD.txt", 50, 50, 20);
		assertEquals(floydWarshall.timeRequiredforCompetition(), -1);
		
		// test with speed too fast
		dijkstra = new CompetitionDijkstra("tinyEWD.txt", 100, 50, 50);
		floydWarshall = new CompetitionFloydWarshall("tinyEWD.txt", 100, 50, 50);
		assertEquals(dijkstra.timeRequiredforCompetition(), floydWarshall.timeRequiredforCompetition());
		
		// test with speed too fast
		dijkstra = new CompetitionDijkstra("tinyEWD.txt", 50, 100, 50);
		floydWarshall = new CompetitionFloydWarshall("tinyEWD.txt", 50, 100, 50);
		assertEquals(dijkstra.timeRequiredforCompetition(), floydWarshall.timeRequiredforCompetition());
		
		// test with speed too fast
		dijkstra = new CompetitionDijkstra("tinyEWD.txt", 50, 50, 100);
		floydWarshall = new CompetitionFloydWarshall("tinyEWD.txt", 50, 50, 100);
		assertEquals(dijkstra.timeRequiredforCompetition(), floydWarshall.timeRequiredforCompetition());
		
		// test with speed too fast
		dijkstra = new CompetitionDijkstra("tinyEWD.txt", 100, 100, 100);
		floydWarshall = new CompetitionFloydWarshall("tinyEWD.txt", 100, 100, 100);
		assertEquals(dijkstra.timeRequiredforCompetition(), floydWarshall.timeRequiredforCompetition());
		
		// test with speed too slow
		dijkstra = new CompetitionDijkstra("tinyEWD.txt", 0, 0, 0);
		floydWarshall = new CompetitionFloydWarshall("tinyEWD.txt", 0, 0, 0);
		assertEquals(dijkstra.timeRequiredforCompetition(), floydWarshall.timeRequiredforCompetition());
		
		// test with mixed speeds
		dijkstra = new CompetitionDijkstra("tinyEWD.txt", 0, 10000, 10);
		floydWarshall = new CompetitionFloydWarshall("tinyEWD.txt", 2000, -1, 3);
		assertEquals(dijkstra.timeRequiredforCompetition(), floydWarshall.timeRequiredforCompetition());
		
	}
	
	@Test
	public void nullFile() {
		// test if the result is -1 for games with isolated vertices
		CompetitionDijkstra dijkstra = new CompetitionDijkstra(null, 50, 50, 50);
		assertEquals(dijkstra.timeRequiredforCompetition(), -1);
		
		CompetitionFloydWarshall floydWarshall = new CompetitionFloydWarshall(null, 50, 50, 50);
		assertEquals(floydWarshall.timeRequiredforCompetition(), -1);
	}
	
	@Test
	public void testfile() {
		// test if the result is -1 for games with isolated vertices
		CompetitionDijkstra dijkstra = new CompetitionDijkstra("testfile.txt", 60, 50, 75);
		assertEquals(dijkstra.timeRequiredforCompetition(), -1);
		
		CompetitionFloydWarshall floydWarshall = new CompetitionFloydWarshall("testfile.txt", 50, 50, 50);
		assertEquals(floydWarshall.timeRequiredforCompetition(), -1);
	}
	
	@Test
	public void emptyFile() {
		// test if the result is -1 for games with isolated vertices
		CompetitionDijkstra dijkstra = new CompetitionDijkstra("short.txt", 50, 50, 50);
		assertEquals(dijkstra.timeRequiredforCompetition(), -1);
		
		CompetitionFloydWarshall floydWarshall = new CompetitionFloydWarshall("short.txt", 50, 50, 50);
		assertEquals(floydWarshall.timeRequiredforCompetition(), -1);
	}
	
	@Test
	public void emptyFile2() {
		// test if the result is -1 for games with isolated vertices
		CompetitionDijkstra dijkstra = new CompetitionDijkstra("short2.txt", 50, 50, 50);
		assertEquals(dijkstra.timeRequiredforCompetition(), -1);
		
		CompetitionFloydWarshall floydWarshall = new CompetitionFloydWarshall("short2.txt", 50, 50, 50);
		assertEquals(floydWarshall.timeRequiredforCompetition(), -1);
	}
	
	@Test
	public void testQueue() {
		// test the queue
		CompetitionDijkstra dijkstra = new CompetitionDijkstra("tinyEWD.txt", 50, 50, 50);
		assertEquals(dijkstra.timeRequiredforCompetition(), 38);
		dijkstra.makeQueue();
		dijkstra.pq.add(1);
		dijkstra.pq.add(2);
		dijkstra.pq.add(2);
		dijkstra.pq.add(1);
		
	}
	
	
}
