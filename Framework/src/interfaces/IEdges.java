package interfaces;

import java.util.ArrayList;
import java.util.List;

import main.Edge;

public interface IEdges {

	public boolean isDirected();
	public int getWeight();
	
	public List<Edge> add (List<Edge> edges);
	
}