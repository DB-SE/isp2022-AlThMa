	import java.util.ArrayList; 

	public  class  Node {
	
	    private ArrayList<Node> next;

	
	    private static int biggest_label;

	

	    public Node () {
	        next = new ArrayList<Node>();
	    }

	
	    
	    void addNext(Node node) {
	        this.next.add(node);
	    }

	

		public ArrayList<Node> getAdjacentNodes() {
			return next;
		}


}
