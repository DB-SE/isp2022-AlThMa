import interfaces.Edges;

public class Directed implements Edges {

	@Override
	public boolean isDirected() {
		return true;
	}

	@Override
	public int getWeight() {
		return 0;
	}

}
