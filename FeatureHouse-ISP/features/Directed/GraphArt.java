import java.util.List;

public class GraphArt {
	
	public boolean isWeighted() {
		// TODO Auto-generated method stub
		return false;
	}
	
	
	private void add(List<java.util.List<Integer>> edges, int node1, int node2, int weight) {
		edges.get(node1).set(node2, weight);
		edges.get(node2).set(node1, weight);
	}
	
    private void padd(int node1, int node2, int weight){
    	original(node1,node2,weight);
    	add(getEdgeList(),node1,node2,weight);
    }
	
	public String classtyp() {
		return "direction";
	}
}