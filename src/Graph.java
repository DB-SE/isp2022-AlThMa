import java.util.*;

public class Graph {
    private List<List<Integer>> edgeList;
    private List<List<Edge>> edges;
    private int n;

    public Graph(List<Edge> edges, int n) {
        this.n = n;
        edgeList = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            edgeList.add(new ArrayList<>());
        }

        for (Edge edge: edges) {
            int n1 = edge.node1;
            int n2 = edge.node2;

            edgeList.get(n1).add(n2);
            edgeList.get(n2).add(n1);

            // damit es ein ungerichteter Graph ist
            edgeList.get(n2).add(n2);
            edgeList.get(n1).add(n1);

            //this.edges.get(n1).add(edge);
            //this.edges.get(n2).add(edge);
        }
    }

    public int getN() {
        return n;
    }

    public void addEdge(Edge edge){
        int n1 = edge.node1;
        int n2 = edge.node2;

        // falls Ein neuer Knoten finzugefügt wurde:
        n = Math.max(n, n1);
        n = Math.max(n, n2);

        edgeList.get(n1).add(n2);
        edgeList.get(n2).add(n1);

        // damit es ein ungerichteter Graph ist
        edgeList.get(n2).add(n2);
        edgeList.get(n1).add(n1);

        //this.edges.get(n1).add(edge);
        //this.edges.get(n2).add(edge);
    }

    public void prim() {
        List<Edge> edges = Collections.emptyList();
        int start = 0;
        Graph mst = new Graph(edges, 0);

        for (List<Integer> m: edgeList) {
            if (!m.isEmpty()) {
                start = m.get(0);
                return;
            }
        }

        while (n != mst.n) {
            Edge minEdge = new Edge(0,0, Integer.MAX_VALUE);
            for (Edge edge: this.edges.get(start)){
                if (edge.value < minEdge.value) minEdge = edge;
            };

            mst.addEdge(minEdge);
        }

        mst.tiefensuche();
    }

    public List<Integer> tiefensuche() {
        boolean[] visited = new boolean[n]; // besuchte Nodes

        List<Integer> nodes = new ArrayList<>();

        // Von allen Knoten geht man zu allen Knoten, bis man alle Knoten besucht hat
        for (int i = 0; i < n; i++) {
            if (!visited[i]) tiefensuche(i, visited, nodes);
        }
        return nodes;
    }

    // Funktion zum Ausführen einer DFS-Durchquerung des Diagramms auf einem Diagramm
    private void tiefensuche(int node, boolean[] visited, List<Integer> nodeList) {
        visited[node] = true;

        System.out.print(node + " ");
        nodeList.add(node);

        for (int u: edgeList.get(node)) {
            if (!visited[u]) {
                tiefensuche(u, visited, nodeList);
            }
        }
    }
}
