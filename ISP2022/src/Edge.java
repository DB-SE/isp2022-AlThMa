public class Edge {
    int node1, node2, value;
    boolean direction;
    public static final boolean NODE_1 = false;
    public static final boolean NODE_2 = true;

    /**
     *
     * @param node1 Index of one Node
     * @param node2 Index of another Node
     */
    public Edge(int node1, int node2) {
        this.node1 = node1;
        this.node2 = node2;
        this.value = 0;
        this.direction = NODE_2;
    }

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
     * @param direction Boolean value whether the direction should be towards second node
     */
    public Edge(int node1, int node2, boolean direction) {

        this.node1 = node1;
        this.node2 = node2;
        this.value = 0;
        this.direction = direction;

    }

    /**
     *
     * @param node1 Index of one Node
     * @param node2 Index of another Node
     * @param direction Boolean value whether the direction should be towards second node
     * @param value Label of the node
     */
    public Edge(int node1, int node2, boolean direction, int value) {

        this.node1 = node1;
        this.node2 = node2;
        this.value = value;
        this.direction = direction;

    }
    
}