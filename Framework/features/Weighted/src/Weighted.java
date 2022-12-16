import java.util.List;

import interfaces.IEdges;

public class Weighted implements IEdges {
	
	@Override
	public void add(List<List<Integer>> edges, int node1, int node2, int weight) {
		// TODO Auto-generated method stub
		System.err.println("Das dürfte nicht passieren. Du hast add in Weighted aufgerufen.");
	}

	@Override
	public boolean isWeighted() {
		return true;
	}
	
	@Override
	public String classtyp() {
		// TODO Auto-generated method stub
		return "weighted";
	}
}
