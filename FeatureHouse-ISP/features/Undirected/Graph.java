public class Main {
	@Override
	public boolean isWeighted() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void add(List<java.util.List<Integer>> edges, int node1, int node2, int weight) {
		// TODO Auto-generated method stub
		edges.get(node1).set(node2, weight);
	}
	
	@Override
	public String classtyp() {
		// TODO Auto-generated method stub
		return "direction";
	}
}