import java.util.ArrayList;

public class Node {
    private ArrayList<Node> next;
    private static int biggest_label;
    private int label;

    public Node () {
        next = new ArrayList<>();
        label = biggest_label++;
    }

    public int getLabel() {
        return label;
    }

    void addNext(Node node) {
        this.next.add(node);
    }
}