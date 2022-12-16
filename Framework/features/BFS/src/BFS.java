import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import interfaces.Algorithms;
import main.GraphArt;
import main.Node;

public class BFS implements Algorithms {

	@Override
	public ArrayList<Integer> run(GraphArt) {
		// TODO Auto-generated method stub
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

}
