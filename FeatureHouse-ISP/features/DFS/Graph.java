import java.util.List;
import java.util.ArrayList;

public class Main {
	public void run(GraphArt graph) {
		// TODO Auto-generated method stub
		int n = graph.getN();
		boolean[] visited = new boolean[n]; // besuchte Nodes

        List<Integer> nodes = new ArrayList<>();

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
}