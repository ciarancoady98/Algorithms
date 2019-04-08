
import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class CompetitionTests {
/*

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
}
