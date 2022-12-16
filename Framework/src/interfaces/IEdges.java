package interfaces;

import java.util.ArrayList;
import java.util.List;

import main.Edge;

public interface IEdges {
	
	public void add(List<java.util.List<Integer>> edges, int node1, int node2, int weight);
	
	public boolean isWeighted();
	public String classtyp();
	
}