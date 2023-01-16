import java.util.ArrayList;

public class GraphArt {
	
	private int weight = 0;
	
	@Override
	public void add(int node1, int node2, int weight){
		 padd(node1, node2, weight);
	}

	public boolean isWeighted() {
		return true;
	}

	public int getWeight() {
		return this.weight;
	}
}

