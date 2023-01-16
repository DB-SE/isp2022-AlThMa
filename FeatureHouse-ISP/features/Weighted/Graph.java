import java.util.ArrayList;

public class Graph {
	
	private int weight = 0;
	
	public void add(List<List<Integer>> edges, int node1, int node2, int weight) {
		original();
		//System.err.println("Das d�rfte nicht passieren. Du hast add in Weighted aufgerufen.");
		this.weight = weight;
	}

	@Override
	public boolean isWeighted() {
		return true;
	}

	public int getWeight() {
		return this.weight;
	}
}

