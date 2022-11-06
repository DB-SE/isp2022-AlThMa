import java.util.*;

public class Graph {
    private List<List<Integer>> edgeList;
    private List<List<Edge>> edges;
    private final Configuration configuration;
    private int n;

    public Graph(List<Edge> edges, int n, Configuration c) {
        this.n = n;
        this.configuration = c;

        edgeList = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            edgeList.add(new ArrayList<>());
            for (int j = 0; j < n; j++) {
                edgeList.get(i).add(0);
            }
        }

        for (Edge edge: edges) {
            int n1 = edge.node1;
            int n2 = edge.node2;

            //edgeList.get(n1).add(n2);
            //edgeList.get(n2).add(n1);

            edgeList.get(n1).set(n2, edge.value);
            edgeList.get(n2).set(n1, edge.value);

            // damit es ein ungerichteter Graph ist
            //edgeList.get(n2).add(n2);
            //edgeList.get(n1).add(n1);

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
        n = Math.max(n, Math.max(n1, n2));

        for (int i = edgeList.size(); i <= 3*n; i++) {
            edgeList.add(new ArrayList<>());
            for (int j = edgeList.get(i).size(); j <= 3*n; j++) {
                edgeList.get(i).add(0);
            }
        }

        edgeList.get(n1).set(n2, edge.value);
        edgeList.get(n2).set(n1, edge.value);
    }

    public String toString() {
        StringBuilder out = new StringBuilder("  ");
        for (int i = 0; i < n; i++) {
            out.append(i).append(" ");
        }
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

    public void minimalTree(){

        //(minimal) spanning trees only exist for undirected graphs
        if(this.configuration.isDirected()){
            System.err.println("Directed graohs do not support spanning trees");
        }

        boolean[] visited = new boolean[n]; // besuchte Nodes
        List<Edge> edges = Collections.emptyList();
        Graph mst = new Graph(edges, n, this.configuration);

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
                mst.addEdge(new Edge(i, node, min));
                visited[node] = true;
            }
        }

        System.out.println();
        System.out.println("Minimal Baum");
        mst.tiefensuche();
        System.out.println("\n");
        System.out.println(mst.toString());
    }

    // Funktioniert nicht, bitte ignorieren
    public void prim() {
        List<Edge> edges = Collections.emptyList();
        int start = 0;
        Graph mst = new Graph(edges, 0, this.configuration);
        boolean[] visited = new boolean[n]; // besuchte Nodes

        while (n != mst.getN()) {
            int min = Integer.MAX_VALUE;
            int minNode = 0;
            for (int i = 0; i < edgeList.get(start).size(); i++) {
                if (edgeList.get(start).get(i) != 0 && !visited[i]) {
                    if (edgeList.get(start).get(i) < min) {
                        min = edgeList.get(start).get(i);
                        minNode = i;
                    }
                }
            }

            if (min == Integer.MAX_VALUE) break;

            visited[minNode] = true;
            mst.addEdge(new Edge(start, minNode, min));
            start = minNode;
        }

        System.out.println();
        System.out.print("Prim out: ");
        mst.tiefensuche();
        System.out.println("\n");
        System.out.print(mst.toString());
        System.out.println("\n");
        System.out.print(toString());

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

        for (int i = 0; i < n; i++) {
            if (edgeList.get(node).get(i) != 0) {
                if (!visited[i]) {
                    tiefensuche(i, visited, nodeList);
                }
            }
        }
    }
}
