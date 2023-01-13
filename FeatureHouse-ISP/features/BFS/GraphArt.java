import java.util.ArrayList;
import java.util.List;

public class GraphArt {
	public List<Integer> breitensuche(Node start) {
    	
    	List<Integer> nodes = new List<Integer>();
    	LinkedList<Node> queue = new LinkedList<Node>();
    	List<Integer> visited = new List<Integer>();
    	
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