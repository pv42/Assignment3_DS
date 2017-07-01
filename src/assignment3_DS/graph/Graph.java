package assignment3_DS.graph;

import java.util.ArrayList;
import java.util.Iterator;
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
    private Node startNode;
    
    /**
     * creates a graph
     *
     * @param nodes the graphs nodes
     * @param arcs  the graphs arcs
     */
    public Graph(Map<Integer, Node> nodes, List<Arc> arcs) {
        this.nodes = nodes;
        this.arcs = arcs;
        startNode = nodes.get(0);
    }

    /**
     * creates a new graph object
     *
     * @return nodes
     */
    public Map<Integer, Node> getNodes() {
        return nodes;
    }

    /**
     * gets the node by id
     *
     * @param id id of the node
     * @return node with the id or null if it does not exist
     */
    public Node getNodeById(int id) {
        return nodes.get(id);

    }

    /**
     * returns the start node
     *
     * @return the start node
     */
    public Node getStartNode() {
        return startNode;
    }

    /**
     * set the start node for assingment4
     * @param startNode the node the assignment4 functions should start from
     */
    public void setStartNode(Node startNode) {
        this.startNode = startNode;
    }

    /**
     * searches for all arcs beginning at a node
     *
     * @param nodeID id of node
     * @return list of arcs connected to node
     */
    public List<Arc> getAllArcsBeginningAtNodeID(int nodeID) {
        List<Arc> arcList = new ArrayList<>();
        for (Arc arc : arcs) {
            if (arc.getStart().getID() == nodeID) {
                arcList.add(arc);
            }
        }
        return arcList;
    }
    
    
    //methods added with Assignment4


    private List<Node> getNodesAvailableFromList(Node startNode) { //a
        List<Node> usedNodes = new ArrayList<>();
        List<Node> foundNodes = new ArrayList<>();
        foundNodes.add(startNode);
        while(!foundNodes.isEmpty()) {
            Node node = foundNodes.remove(0);
            if(!usedNodes.contains(node)) usedNodes.add(node);
            getAllArcsBeginningAtNodeID(node.getID()).forEach(arc -> {
                if((!foundNodes.contains(arc.getEnd())) && (!usedNodes.contains(arc.getEnd())))
                    foundNodes.add(arc.getEnd());
            });
        }
        return usedNodes;
    }

    public Iterator<Node> getNodesAvailableFromIterator() {
        return getNodesAvailableFromList(startNode).iterator();
    }
    
    // todo comment
    public int getNodeNumber() { //b
        return getNodesAvailableFromList(startNode).size();
    }
    
    //todo comment
    public Iterator<String> getNodeOperations() { //c
        List<String> list = new ArrayList<>();
    	
    	for (Node node: getNodesAvailableFromList(startNode)){
            String operation = node.getSpeedModifier();
    	    if(!node.getSpeedModifier().equals("*speed"))
                operation = operation.substring(0,1);
            if (!list.contains(operation)){
                list.add(operation);
            }
        }
        for (int i = 0; i < list.size(); i++) {
    	    list.set(i,"Operation : '" + list.get(i) + "'");
        }
    	return list.iterator();
    }
    
    //todo comment // todo bed
    public int getArcNumber() { //d
        int count = 0;
        for(Node node : getNodesAvailableFromList(startNode)) {
            for (Arc arc : getAllArcsBeginningAtNodeID(node.getID())) {
                count ++;
            }
        }
        return count;
    }

    /**
     * retuns the sum af all arc length available from the startnode
     * @return the arc length sum
     */
    public int getArcLengthSum() { //e
        int sum = 0;
        for(Node node : getNodesAvailableFromList(startNode)) {
            for (Arc arc : getAllArcsBeginningAtNodeID(node.getID())) {
                sum += arc.getDistance();
            }
        }
        return sum;
    }

    /**
     * remove all arcs from the graph with length under a threshold
     * @param x threshold
     */
    public void removeArcsLongerThan(int x) { //f
        arcs.removeIf(arc -> arc.getDistance() > x);
    }

    
}
