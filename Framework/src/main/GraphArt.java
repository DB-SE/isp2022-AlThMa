package main;

import java.util.*;

import com.sun.source.util.Plugin;

import interfaces.IAlgorithms;
import interfaces.IEdges;
import interfaces.INodeMarkers;
import interfaces.IOutput;
import loader.PluginLoader;

public class GraphArt {
    private List<List<Integer>> edgeList;	// Gewichte
    private List<Node> nodes;				// Knoten
    private int n;
    
    // #if Colored
//@    private List<Integer> colors;
    // #endif

    public GraphArt(int n) {
        this.n = n;
        this.edgeList = new ArrayList<>();
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
    
    public void add(int node1, int node2, int weight){
    	
    	int max = Math.max(node1, node2);

    	// Vergrößere die Adjazenzmatrix wenn nötig -> in beide Richtung gleichermaßen
    	for (int i = edgeList.size(); i <= max; i++) {
    		edgeList.add(new ArrayList<>());
    	}
    	
    	for (int i = 0; i <= max; i++) {
    		for (int j = edgeList.get(i).size(); j <= max; j++) {
    			edgeList.get(i).add(0);
    		}
    	}
    	
    	for (int i = nodes.size(); i <= max; i++) {
    		nodes.add(new Node());
    	}
    	
    	// füge die edge hinzu
		//edgeList.get(node1).set(node2, weight);
		//edgeList.get(node2).set(node1, weight);
    	
    	n = max;
    	
    	
    	List<IEdges> iedgesPlugins = PluginLoader.load(IEdges.class);

    	// falls es keine Gewichte gibt, setzte alle gewichte auf 1
    	for (IEdges iedges : iedgesPlugins) { 
			if (iedges.classtyp() == "weighted" && !iedges.isWeighted()) weight = 1;
		}
    	// füge je nach Feature eine beitseitige oder einseitige Verbindung hinzu:
		for (IEdges iedges : iedgesPlugins) { 
			if (iedges.classtyp() == "direction")
				iedges.add(edgeList, node1, node2, weight);
		}
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
  	
    //#if BFS
    public List<Integer> breitensuche(Node start) {
    	
    	List<Integer> nodes = new ArrayList<>();
    	LinkedList<Node> queue = new LinkedList<Node>();
    	List<Integer> visited = new ArrayList<>();
    	
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
    //#endif
      
  	public String toAdjMatrix() {
  		
  		/*StringBuilder out = new StringBuilder("  ");
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
        out.append("\n");
        return String.valueOf(out);*/
  		
  		List<IOutput> outPlugins = PluginLoader.load(IOutput.class);
		return outPlugins.get(outPlugins.size()-1).toAdjMatrix(this);
		
  	}
}
