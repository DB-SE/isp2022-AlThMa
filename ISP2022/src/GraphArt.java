import java.util.*;

public class GraphArt {
    private List<List<Integer>> edgeList;
    private List<List<Edge>> edges;
    private int n;
    
    // #if Colored
    private List<Integer> colors;
    // #endif

    public GraphArt(List<Edge> edges, int n) {
        this.n = n;

        // Adjazenzmatrix
        edgeList = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            edgeList.add(new ArrayList<>());
            for (int j = 0; j < n; j++) {
                edgeList.get(i).add(0);
            }
        }

        // add all edges
        for (Edge edge: edges) {
            int n1 = edge.node1;
            int n2 = edge.node2;

            // #if Directed 
            edgeList.get(n1).set(n2, edge.value);
            edgeList.get(n2).set(n1, edge.value);
            // #endif
            
            // #if Undirected 
//@            edgeList.get(n1).set(n2, edge.value);
            // #endif

        }
        
     // #if Colored
        colors = new ArrayList<>();
        for (int i = 0; i < 30; i++) {
        	colors.add(0 + (int)(Math.random() * (ConsoleColors.COLOR_ARRAY.length - 1)));
        }
     // #endif
    }
    
    public int getN() {
    	return n;
    }
    
    public List<List<Integer>> getEdgeList(){
    	return edgeList;
    }
    
    public void addEdge(Edge edge, GraphArt g){
        int n1 = edge.node1;
        int n2 = edge.node2;

        // falls Ein neuer Knoten finzugef?gt wurde:
        int n = Math.max(g.getN(), Math.max(n1, n2));

        for (int i = edgeList.size(); i <= 3*n; i++) {
            edgeList.add(new ArrayList<>());
            for (int j = edgeList.get(i).size(); j <= 3*n; j++) {
                edgeList.get(i).add(0);
            }
        }

        edgeList.get(n1).set(n2, edge.value);
        edgeList.get(n2).set(n1, edge.value);
    }
    
	// #if MST 
//@  	public void minimalTree(GraphArt g){
//@  
//@          //(minimal) spanning trees only exist for undirected graphs
//@  		int n = g.getN();
//@  		List<List<Integer>> edgeList = g.getEdgeList();
//@  		
//@          boolean[] visited = new boolean[n]; // besuchte Nodes
//@          List<Edge> edges = Collections.emptyList();
//@          GraphArt mst = new GraphArt(edges,n);
//@          for (int i = 0; i < n; i++) {
//@              if (!visited[i]) {
//@                  int min = Integer.MAX_VALUE;
//@                  int node = 0;
//@                  for (int j = 0; j < n; j++) {
//@                      if (edgeList.get(i).get(j) != 0) {
//@                          if (edgeList.get(i).get(j) < min) {
//@                              min = edgeList.get(i).get(j);
//@                              node = j;
//@                          }
//@                      }
//@                  }
//@                  mst.addEdge(new Edge(i, node, min),mst);
//@                  visited[node] = true;
//@              }
//@          }
//@  
//@          System.out.println();
//@          System.out.println("Minimal Baum");
//@          System.out.println("\n");
//@          System.out.println(mst.toAdjMatrix());
//@      }
  	//#endif
  	
  	// #if DFS
  	public List<Integer> tiefensuche() {
          boolean[] visited = new boolean[n]; // besuchte Nodes

          List<Integer> nodes = new ArrayList<>();

          // Von allen Knoten geht man zu allen Knoten, bis man alle Knoten besucht hat
          for (int i = 0; i < n; i++) {
              if (!visited[i]) tiefensuche(i, visited, nodes);
          }
          return nodes;
      }

      // Funktion zum Ausf?hren einer DFS-Durchquerung des Diagramms auf einem Diagramm
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
  	//#endif
  	
  	//#if Adjazenzmatrix

    // Farbausgabe in Eclipse funktioniert nur mit Plugin "ANSI Escape in Console"
    // Andernfalls das Feature bitte deaktivieren
  	public String toAdjMatrix() {
  		
          StringBuilder out = new StringBuilder("  ");
          for (int i = 0; i < n; i++) {
        	  // #if ShowColors
              out.append(ConsoleColors.COLOR_ARRAY[colors.get(i)][0]);
              // #endif
              out.append(i).append(" ");
          }
          out.append("\n");
          for (int i = 0; i < n; i++) {
        	  // #if ShowColors
              out.append(ConsoleColors.COLOR_ARRAY[colors.get(i)][0]);
              // #endif
              out.append(i).append(" ");
        	  // #if ShowColors
              out.append(ConsoleColors.RESET);
              // #endif
              for (int j = 0; j < n; j++) {
                  out.append(edgeList.get(i).get(j)).append(" ");
              }
        	  // #if ShowColors
              out.append(ConsoleColors.RESET);
              // #endif
              out.append("\n");
          }
          out.append(ConsoleColors.RESET);
          return String.valueOf(out);
  	}
  	//#endif
}
