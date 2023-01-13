import java.util.*; import java.util.List; 

public   class  GraphArt {
	
	    private ArrayList<List<Integer>> edgeList;

		// Gewichte
	    private ArrayList<Node> nodes;

					// Knoten
	    public int n;

	

	    public GraphArt(int n) {
	        this.n = n;
	        this.edgeList = new ArrayList<List<Integer>>();
	        this.nodes = new ArrayList<Nodes>();
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
