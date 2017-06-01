package assignment3_DS;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * The graph contains the entirety of all nodes and arcs
 *
 * @author Martin Krebs
 */



public class Graph {
    private Map<Integer, Node> nodes;
    private List<Arc> arcs;
    /**
     *  creates a graph
      * @param nodes
     * @param arcs
     */
    public Graph(Map<Integer, Node> nodes, List<Arc> arcs) {
        this.nodes = nodes;
        this.arcs= arcs;
    }

    /**
     * creates a new graph object
     * @return nodes
     */
    public Map<Integer, Node> getNodes() {
        return nodes;
    }

    /**
     *
     * @param id
     * @return the nodes id
     */
    public Node getNodeById(int id) {
        return nodes.get(id);

    }

    /**
     * searches for all arcs connected to a node
     * @param nodeID
     * @return list of arcs connected to node
     */
    public List<Arc> getAllConnectedArcsByNodeID(int nodeID) {
         List<Arc> arcList = new ArrayList<>();
         for(Arc arc : arcs){
            if(arc.getStart().getID() == nodeID){
                arcList.add(arc);
            }
         }
         return arcList;
    }
}
