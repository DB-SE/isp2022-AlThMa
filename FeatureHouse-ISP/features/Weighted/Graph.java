import java.util.ArrayList;

public class Graph {
	
	@Override
	public void add(List<List<Integer>> edges, int node1, int node2, int weight) {
		System.err.println("Das d�rfte nicht passieren. Du hast add in Weighted aufgerufen.");
	}

	@Override
	public boolean isWeighted() {
		return true;
	}
	
	@Override
	public String classtyp() {
		return "weighted";
	}
}

