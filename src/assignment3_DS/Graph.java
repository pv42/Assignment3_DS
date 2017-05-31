package assignment3_DS;

import java.util.List;
import java.util.Map;

/**
 * A graph
 *
 * @author Martin Krebs
 */
public class Graph {

    public Graph(Map<Integer, Node> nodes, List<Arc> arcs) {
        System.out.println(nodes.toString() + arcs.toString()); //todo remove
        //...
    }

    public Map<Integer, Node> getNodes() {
        return null;
    }

    public Node getNodeById(int id) {
        return null;
    }

    public List<Arc> getAllConnectedArcsByNodeID(int nodeID) {
        return null;
    }
}
