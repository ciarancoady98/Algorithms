//@Author:Ciaran Coady
public class DirectedEdge {
	double weight;
	int from;
	int to;
	DirectedEdge(int from, int to, double weight){
		this.from = from;
		this.to = to;
		this.weight = weight;
	}
	/*
	public void setFrom(int vertex) {
		this.from = vertex;
	}
	public int getFrom() {
		return this.from;
	}
	public void setTo(int vertex) {
		this.to = vertex;
	}
	public int getTo(int vertex) {
		return this.to;
	}
	public void setWeight(double weight) {
		this.weight = weight;
	}
	public double getWeight() {
		return this.weight;
	}
	public String toString() {
		return "from = " + this.from + " to = " + this.to 
				+ " street length = " + this.weight;
	}
	*/
}
