import java.util.ArrayList;
import java.util.List;

public class GraphArt {
	private List<List<Integer>> edgeList;
	private List<Node> nodes;				// Knoten
	private int n;

	public GraphArt(int n) {
		this.n = n;
	    this.nodes = new ArrayList<>();
	}
	    
	public int getN() {
    	return n;
    }
	    
    public List<List<Integer>> getEdgeList(){
    	return edgeList;
    }
	    
    public void addNode (Node node) {
    	nodes.add(node);
    }
}