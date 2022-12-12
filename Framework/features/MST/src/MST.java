import java.util.ArrayList;

import interfaces.Algorithms;

public class MST implements Algorithms {

	@Override
	public void run(GraphArt g) {
		// TODO Auto-generated method stub
		int n = g.getN();
		List<List<Integer>> edgeList = g.getEdgeList();
		
		boolean[] visited = new boolean[n]; // besuchte Nodes
		List<Edge> edges = Collections.emptyList();
		GraphArt mst = new GraphArt(edges,n);
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
	
	public void minimalTree(GraphArt g){
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

}
