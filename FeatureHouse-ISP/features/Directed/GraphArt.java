import java.util.List;

public class GraphArt {
	
	public boolean isWeighted() {
		// TODO Auto-generated method stub
		return false;
	}
	
	
	public void add(List<java.util.List<Integer>> edges, int node1, int node2, int weight) {
		edges.get(node1).set(node2, weight);
		edges.get(node2).set(node1, weight);
	}
	
	public String classtyp() {
		return "direction";
	}
}