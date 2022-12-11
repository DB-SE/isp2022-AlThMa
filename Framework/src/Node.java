import java.util.ArrayList;

public class Node {
    private ArrayList<Node> next;
    private static int biggest_label;
    
    //#if Labled 
    private int label;
    //#endif
    
    //#if Colored 
    private String color;
    //#endif

    public Node () {
        next = new ArrayList<>();
        //#if Labled 
        label = biggest_label++;
        //#endif
    }

    //#if Labled 
    public int getLabel() {
        return label;
    }
    //#endif
    
    //#if Colored
    	public String getColor() {
    		return color;
    	}
    //#endif
    
    void addNext(Node node) {
        this.next.add(node);
    }

	public ArrayList<Node> getAdjacentNodes() {
		return next;
	}
}
