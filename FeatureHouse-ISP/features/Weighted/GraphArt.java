import java.util.ArrayList;

public class GraphArt {
	
	private int weight = 0;
	
	public void add(List<List<Integer>> edges, int node1, int node2, int weight) {
		original(edges,node1,node2,weight);
		this.weight = weight;
	}

	public boolean isWeighted() {
		return true;
	}

	public int getWeight() {
		return this.weight;
	}
}

