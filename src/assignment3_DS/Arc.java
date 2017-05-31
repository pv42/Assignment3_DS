package assignment3_DS;

/**
 * An arc is the connection between 2 nodes.
 * It contains the distance between the connected Nodes
 * @author Heinrich Sporys
 */
public class Arc {
    private Node startNode, endNode;
    private int distance;

    /**
     * Creates the new object Arc
     *
     * @param startNode
     * @param endNode
     * @param distance
     */
    public Arc(Node startNode, Node endNode, int distance) {
        this.startNode = startNode;
        this.endNode = endNode;
        this.distance = distance;
    }

    /**
     * Return an arcs length e.g. distance which must be overcome to reach the
     *
     * @return the distance from start to end
     */
    public int getDistance() {
        return distance;
    }

    /**
     * Returns the start of an arc (as Node)
     *
     * @return the startnode
     */
    public Node getStart() {
        return startNode;

    }

    /**
     * Returns the end of an arc (as Node)
     *
     * @return the endnode
     */
    public Node getEnd() {
        return endNode;

    }

    @Override
    public String toString() {
        return "Arc{" +
                "startNode=" + startNode +
                ", endNode=" + endNode +
                ", distance=" + distance +
                '}';
    }
}
