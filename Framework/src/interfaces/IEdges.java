package interfaces;

import java.util.ArrayList;

import com.sun.tools.javac.util.List;

import Ed;

public interface IEdges {

	public boolean isDirected();
	public int getWeight();
	
	public List<Edge> add (List<Edge>);
	
}


