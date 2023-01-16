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
	        this.nodes = new ArrayList<Node>();
	    }

	
	    
	    public int getN() {
	    	return n;
	    }

	
	
	    public void add(int node1, int node2, int weight){
		    padd(node1, node2, 0);
	    }

	
	    
	     private void  padd__wrappee__Base  (int node1, int node2, int weight){
	    	
	    	int max = Math.max(node1, node2);

	    	// Vergr��ere die Adjazenzmatrix wenn n�tig -> in beide Richtung gleicherma�en
	    	for (int i = edgeList.size(); i <= max; i++) {
	    		edgeList.add(new ArrayList<Integer>());
	    	}
	    	
	    	for (int i = 0; i <= max; i++) {
	    		for (int j = edgeList.get(i).size(); j <= max; j++) {
	    			edgeList.get(i).add(0);
	    		}
	    	}
	    	
	    	for (int i = nodes.size(); i <= max; i++) {
	    		nodes.add(new Node());
	    	}
	    }

	
	
    private void padd(int node1, int node2, int weight){
    	padd__wrappee__Base(node1,node2,weight);
    	add(getEdgeList(),node1,node2,weight);
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

	
	
	
	private void add(List<java.util.List<Integer>> edges, int node1, int node2, int weight) {
		edges.get(node1).set(node2, weight);
		edges.get(node2).set(node1, weight);
	}

	
	
	public String classtyp() {
		return "direction";
	}


}
