import java.util.LinkedList;

public class EdgeWeightedDigraph {
	@SuppressWarnings("unused")
	private final int numberOfVertices;
	@SuppressWarnings("unused")
	private int numberOfEdges;
	@SuppressWarnings("rawtypes")
	private LinkedList[] adj;
    private int[] indegree;
	EdgeWeightedDigraph(int numberOfVertices, int numberOfEdges){
		this.numberOfEdges = numberOfEdges;
		this.numberOfVertices = numberOfVertices;
		this.adj = new LinkedList[numberOfVertices];
		this.indegree = new int[numberOfVertices];
		//initialize linked lists for each starting vertex
		for(int i = 0; i < numberOfVertices; i++) {
			adj[i] = new LinkedList<DirectedEdge>(); 
		}
	}
	@SuppressWarnings("unchecked")
	public void addEdge(DirectedEdge edge) {
		adj[edge.from].add(edge);
		updateDegree(edge.from);
	}
	private void updateDegree(int vertex) {
		indegree[vertex] = indegree[vertex] + 1;
	}
	@SuppressWarnings("unchecked")
	public LinkedList<DirectedEdge> adjacentEdges(int vertex){
		return adj[vertex];
	}
	/*
	public DirectedEdge[] edges(){
		DirectedEdge[] edges = new DirectedEdge[this.numberOfEdges];
		int edgesIndex = 0;
		for(int i = 0; i < adj.length; i++) {
			LinkedList<DirectedEdge> temp = adj[i];
			for(DirectedEdge j : temp) {
				edges[edgesIndex] = j;
				edgesIndex++;
			}
		}
		return edges;
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
        StringBuilder s = new StringBuilder();
        s.append(numberOfVertices + " " + numberOfEdges + "\n");
        for (int v = 0; v < numberOfVertices; v++) {
            s.append(v + ": ");
            LinkedList<DirectedEdge> edges = adj[v];
            for (DirectedEdge e : edges) {
                s.append(e + "  ");
            }
            s.append("\n");
        }
        return s.toString();
    }
    */
}
