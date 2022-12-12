import java.util.ArrayList;

import interfaces.Edge;
import interfaces.Edges;
import interfaces.List;

public class Directed implements Edges {

	@Override
	public boolean isDirected() {
		return true;
	}

	@Override
	public int getWeight() {
		return 0;
	}

	@Override
	public List<Edge> add (List<Edge> edgeList){
		
		return edgeList;
	}
	
}
