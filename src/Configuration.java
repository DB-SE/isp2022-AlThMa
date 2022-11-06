public class Configuration {

    private final boolean directed;

    private final boolean labeled;

    private final boolean weighted;

    @Override
    public String toString() {
        return "Configuration: { " +
                "directed = " + directed +
                ", labeled = " + labeled +
                ", weighted = " + weighted +
                " }";
    }

    public Configuration(boolean directed, boolean labeled, boolean weighted) {
        this.directed = directed;
        this.labeled = labeled;
        this.weighted = weighted;
        System.out.println(this.toString());
    }

    public boolean isDirected() {
        return directed;
    }

    public boolean isLabeled() {
        return labeled;
    }

    public boolean isWeighted() {
        return weighted;
    }
}
