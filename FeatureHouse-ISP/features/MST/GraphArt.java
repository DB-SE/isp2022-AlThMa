import java.util.Collections;

/**
 * TODO description
 */
public class GraphArt {

	
	
	public void runMST(GraphArt graph) {
		int n = graph.getN();
		List<List<Integer>> edgeList = graph.getEdgeList();
		
		boolean[] visited = new boolean[n]; // besuchte Nodes
		List<Edge> edges = Collections.EMPTY_LIST;
		GraphArt mst = new GraphArt(n);
		for (int i = 0; i < n; i++) {
			if (!visited[i]) {
				int min = Integer.MAX_VALUE;
				int node = 0;
				for (int j = 0; j < n; j++) {
					if (edgeList.get(i).get(j) != 0) {
						if (edgeList.get(i).get(j) < min) {
							min = edgeList.get(i).get(j);
							node = j;
						}
					}
				}
				mst.addEdge(new Edge(i, node, min),mst);
				visited[node] = true;
			}
		}
		
		System.out.println();
		System.out.println("Minimal Baum");
		System.out.println("\n");
		System.out.println(mst.toAdjMatrix());
	}
	
    public void addEdge(Edge edge, GraphArt g){
        int n1 = edge.node1;
        int n2 = edge.node2;

        // falls Ein neuer Knoten finzugef?gt wurde:
        int n = Math.max(g.getN(), Math.max(n1, n2));

        for (int i = edgeList.size(); i <= 3*n; i++) {
            edgeList.add(new ArrayList<Integer>());
            for (int j = edgeList.get(i).size(); j <= 3*n; j++) {
                edgeList.get(i).add(0);
            }
        }

        edgeList.get(n1).set(n2, edge.value);
        edgeList.get(n2).set(n1, edge.value);
    }
}