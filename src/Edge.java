public class Edge {
    int node1, node2, value, direction;
    public static final int NODE_1 = 1;
    public static final int NODE_2 = 2;

    /**
     * Constructor for an undirected Edge
     * @param node1 Index of one Node
     * @param node2 Index of another Node
     * @param value Label of the node
     */
    public Edge(int node1, int node2, int value) {
        this.node1 = node1;
        this.node2 = node2;
        this.value = value;
        this.direction = NODE_2;
    }

    /**
     *
     * @param node1 Index of one Node
     * @param node2 Index of another Node
     * @param direction Index of the node to which the edge is directed | can be 1 or 2, or 0 for no direction
     * @param value Labeldirection of the node
     */
    public Edge(int node1, int node2, int direction, int value) {

        this.node1 = node1;
        this.node2 = node2;
        this.value = value;
        this.direction = direction < 1 ? NODE_1 : direction > 2 ? NODE_2 : direction;

    }
}
