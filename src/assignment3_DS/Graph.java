package assignment3_DS;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * A graph
 *
 * @author Martin Krebs
 */
public class Graph {
    private Map<Integer, Node> nodes;
    private List<Arc> arcs;
    public Graph(Map<Integer, Node> nodes, List<Arc> arcs) {
        this.nodes = nodes;
        this.arcs= arcs;
    }

    public Map<Integer, Node> getNodes() {
        return nodes;
    }

    public Node getNodeById(int id) {
        return nodes.get(id);

    }

    public List<Arc> getAllConnectedArcsByNodeID(int nodeID) {
         List<Arc> arcList = new ArrayList;
        return  ;
    }
}
