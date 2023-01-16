import java.util.*; 
import java.util.List; import java.util.ArrayList; public   class  GraphArt {
	
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

	
	
	public void runDFS(GraphArt graph) {
		// TODO Auto-generated method stub
		int n = graph.getN();
		boolean[] visited = new boolean[n]; // besuchte Nodes

        List<Integer> nodes = new ArrayList<Integer>();

        // Von allen Knoten geht man zu allen Knoten, bis man alle Knoten besucht hat
        for (int i = 0; i < n; i++) {
            if (!visited[i]) tiefensuche(i, visited, nodes, graph.getEdgeList());
        }

        System.out.print("DFS: ");
        System.out.println(nodes);
	}

	
	
	private void tiefensuche(int node, boolean[] visited, List<Integer> nodeList, List<List<Integer>> edgeList) {
        visited[node] = true;
        int n = 10;//graph.getN();

        System.out.print(node + " ");
        nodeList.add(node);

        for (int i = 0; i < n; i++) {
            if (edgeList.get(node).get(i) != 0) {
                if (!visited[i]) {
                    //tiefensuche(i, visited, nodeList);
                }
            }
        }
    }

	
	public List<Integer> breitensuche(Node start) {
    	
    	List<Integer> nodes = new ArrayList<Integer>();
    	LinkedList<Node> queue = new LinkedList<Node>();
    	List<Integer> visited = new ArrayList<Integer>();
    	
    	queue.add(start);
    	nodes.add(start.getLabel());
    	visited.add(start.getLabel());

    	
    	while(!queue.isEmpty()) {
    		Node firstNode = queue.remove();
    		ArrayList<Node> adjNodes = firstNode.getAdjacentNodes();
    		for (Node adj : adjNodes) {
				if(visited.contains(adj.getLabel())) {
					queue.add(adj);
					nodes.add(adj.getLabel());
					visited.add(adj.getLabel());
				}
			}
    		
    	}
		
    	return nodes;
    	
    }

	
	public Node getFirstNode() {
		return nodes.get(0);
	}

	
	
  	public String toAdjMatrix() {
  		
        StringBuilder out = new StringBuilder("  ");
        out.append("\n");
        for (int i = 0; i < n; i++) {
            out.append(i).append(" ");
            for (int j = 0; j < n; j++) {
                out.append(edgeList.get(i).get(j)).append(" ");
            }
            out.append("\n");
        }
        return String.valueOf(out);
	}


}
