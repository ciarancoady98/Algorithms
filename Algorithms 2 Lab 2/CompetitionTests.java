import static org.junit.jupiter.api.Assertions.*;
import org.junit.Test;

public class CompetitionTests {
/*
 * 1. Justify the choice of the data structures used in CompetitionDijkstra and CompetitionFloydWarshall
 *    In both files, the graph is represented by a 2D array. This reduces object overhead when referring
 *    to the graph, as each vertex is simply an index to the array and each edge is an index into it, so
 *    there is no object overhead in regards to each vertex and edge. The 2D array works well with Floyd
 *    Warshall which needs a 2D array anyway, so putting the graph into one means that the algorithm can
 *    be in-place. For this reason a 2D array saves space for Floyd Warshall, meaning we only need the 2D
 *    array rather than another representation of the graph plus a 2D array. This graph representation was
 *    also chosen for Dijkstra as the same implementation was required for both programs, just with different
 *    algorithms. By using the same graph data structure for both files, it was easy to see how to differently
 *    use the two algorithms on the same graph representation. A 2D array also has the advantage of having
 *    a fixed size no matter how many edges are added to the graph.
 *    In terms of additional data structures, none were needed for Floyd Warshall as mentioned above. For 
 *    Dijkstra, a priority queue was implemented. This is because as each vertex was relaxed, additional
 *    vertices were viable to be the next ones added to the final solution. Therefore each vertex
 *    had a specific priority based on its distance to the source. As each vertex had a specific priority,
 *    it made sense to put them into a priority queue where function calls could remove the most relevant 
 *    one and a comparator based on distanceTo[] could be specified, rather than searching through the array
 *    each time. This assisted with code readability and went along with the advice given in lectures to 
 *    use a java.util.PriorityQueue. An additional 1D array, distanceTo, was also used to store the result
 *    of Dijkstra for each source vertex. This was necessary for the algorithm and held the shortest path
 *    a vertex to every other vertex. This array could be parsed to find the worst case shortest path from
 *    that vertex.
 * 2. Explain theoretical differences in the performance of Dijkstra and Floyd-Warshall algorithms
 *    in the given problem. Also explain how would their relative performance be affected by the
 *    density of the graph. Which would you choose in which set of circumstances and why? 
 *    Dijkstra has a time complexity of O(ElogV) where E is the number of edges and V is the number of 
 *    vertices. However, Dijkstra is only a single-source shortest path algorithm. The question requires an
 *    all-pairs shortest path algorithm, which means Dijkstra must be run once for every vertex as the source.
 *    Therefore the runtime for an all-pairs Dijkstra solution is VElogV.
 *    The time complexity of Floyd Warshall is V^3, given by its three nested for loops. However Floyd Warshall
 *    is already an all-pairs problem so this means that the total runtime for this problem is also V^3.
 *    We know that Floyd Warshall only depends on the size of V so is not affected by the density of the
 *    graph (number of edges). However Dijkstra obviously is. If the number of edges is equal to the number of
 *    vertices (quite a sparse graph), we can sub in V for E, giving our problem a runtime of V^2logV, which
 *    is better than Floyd Warshall. However for a densely populated graph, i.e. a connected graph where E is
 *    almost V^2, the runtime becomes V^3logV. It is clear then that the runtime of Dijkstra varies with E.
 *    For a sparse graph Dijkstra has a better all-pairs runtime, whereas for a dense graph Floyd Warshall
 *    does. Therefore you would choose your algorithm based on how many edges are in the graph and whether
 *    it is above or below the threshold of Floyd Warshall being better than Dijkstra. Floyd Warshall may also be
 *    considered in this implementation where space is important (my implementation is in-place) or where there
 *    are negative edges (as Dijkstra doesn't work on them). However neither implementation would work with 
 *    negative cycles.
 */
	@Test
	public void basicTest() {
		// test equality of both algorithms for both file types with various edge cases
		CompetitionDijkstra dijkstra = new CompetitionDijkstra("tinyEWD.txt", 50, 50, 50);
		CompetitionFloydWarshall fw = new CompetitionFloydWarshall("tinyEWD.txt", 50, 50, 50);
		assertEquals(dijkstra.timeRequiredforCompetition(), fw.timeRequiredforCompetition());

		dijkstra = new CompetitionDijkstra("1000EWD.txt", 50, 50, 50);
		fw = new CompetitionFloydWarshall("1000EWD.txt", 50, 50, 50);
		assertEquals(dijkstra.timeRequiredforCompetition(), fw.timeRequiredforCompetition());
		
		dijkstra = new CompetitionDijkstra("1000EWD.txt", 100, 100, 100);
		fw = new CompetitionFloydWarshall("1000EWD.txt", 100, 100, 100);
		assertEquals(dijkstra.timeRequiredforCompetition(), fw.timeRequiredforCompetition());
		
		dijkstra = new CompetitionDijkstra("1000EWD.txt", 100, 100, 100);
		fw = new CompetitionFloydWarshall("1000EWD.txt", 100, 100, 100);
		assertEquals(dijkstra.timeRequiredforCompetition(), fw.timeRequiredforCompetition());
	}
	@Test
	public void testSpeedOutOfBounds() {
		// test when speed is out of bounds for both algorithms
		CompetitionDijkstra dijkstra = new CompetitionDijkstra("tinyEWD.txt", 20, 50, 50);
		assertEquals(dijkstra.timeRequiredforCompetition(), -1);
		dijkstra = new CompetitionDijkstra("tinyEWD.txt", 50, 20, 50);
		assertEquals(dijkstra.timeRequiredforCompetition(), -1);
		dijkstra = new CompetitionDijkstra("tinyEWD.txt", 50, 50, 20);
		assertEquals(dijkstra.timeRequiredforCompetition(), -1);
		
		
		CompetitionFloydWarshall fw = new CompetitionFloydWarshall("tinyEWD.txt", 30, 50, 50);
		assertEquals(fw.timeRequiredforCompetition(), -1);
		fw = new CompetitionFloydWarshall("tinyEWD.txt", 50, 30, 50);
		assertEquals(fw.timeRequiredforCompetition(), -1);
		fw = new CompetitionFloydWarshall("tinyEWD.txt", 50, 50, 30);
		assertEquals(fw.timeRequiredforCompetition(), -1);
		
		dijkstra = new CompetitionDijkstra("tinyEWD.txt", 110, 70, 50);
		assertEquals(dijkstra.timeRequiredforCompetition(), -1);
		dijkstra = new CompetitionDijkstra("tinyEWD.txt", 50, 110, 70);
		assertEquals(dijkstra.timeRequiredforCompetition(), -1);
		dijkstra = new CompetitionDijkstra("tinyEWD.txt", 50, 70, 110);
		assertEquals(dijkstra.timeRequiredforCompetition(), -1);
		
		fw = new CompetitionFloydWarshall("tinyEWD.txt", 120, 60, 80);
		assertEquals(fw.timeRequiredforCompetition(), -1);
		fw = new CompetitionFloydWarshall("tinyEWD.txt", 60, 120, 80);
		assertEquals(fw.timeRequiredforCompetition(), -1);
		fw = new CompetitionFloydWarshall("tinyEWD.txt", 60, 80, 120);
		assertEquals(fw.timeRequiredforCompetition(), -1);
	}
	
	@Test
	public void testNoFile() {
		// test both algorithms don't throw an exception when given no file
		CompetitionDijkstra dijkstra = new CompetitionDijkstra("FakeFileName.txt", 50, 60, 60);
		assertEquals(dijkstra.timeRequiredforCompetition(), -1);
		
		CompetitionFloydWarshall fw = new CompetitionFloydWarshall("FakeFileName.txt", 60, 50, 70);
		assertEquals(fw.timeRequiredforCompetition(), -1);
		
	}
	
	@Test
	public void testConnectedComponents() {
		// test that both return -1 when not all vertices are connected
		CompetitionDijkstra dijkstra = new CompetitionDijkstra("testfile", 50, 50, 50);
		assertEquals(dijkstra.timeRequiredforCompetition(), -1);
		
		CompetitionFloydWarshall fw = new CompetitionFloydWarshall("testfile", 50, 50, 50);
		assertEquals(fw.timeRequiredforCompetition(), -1);
	}
}
