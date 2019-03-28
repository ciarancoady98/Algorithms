import java.util.ArrayList;

public class EdgeWeightedDigraph {
	private int numberOfVertices;
	private int numberOfEdges;
	private Bag<DirectedEdge>[] adj;    // adj[v] = adjacency list for vertex v
    private int[] indegree;             // indegree[v] = indegree of vertex v
	EdgeWeightedDigraph(int numberOfVertices, int numberOfEdges){
		this.numberOfEdges = numberOfEdges;
		this.numberOfVertices = numberOfVertices;
		this.adj = (Bag<DirectedEdge>[]) new Bag[numberOfVertices];
	}
	public void addEdge(DirectedEdge edge) {
		
	}
	public Iterable<DirectedEdge> adjacentEdges(int vertex){
		return null;
	}
	public Iterable<DirectedEdge> edges(){
		return null;
	}
	public void setNumberOfVertices(int number) {
		this.numberOfVertices = number;
	}
	public int getNumberOfVertices() {
		return this.numberOfVertices;
	}
	public void setNumberOfEdges(int number) {
		this.numberOfEdges = number;
	}
	public int getNumberOfEdges() {
		return this.numberOfEdges;
	}
	public String toString() {
		return null;
	}
}
