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

    boolean found;
    
    /**
     * creates a graph
     *
     * @param nodes the graphs nodes
     * @param arcs  the graphs arcs
     */
    public Graph(Map<Integer, Node> nodes, List<Arc> arcs) {
        this.nodes = nodes;
        this.arcs = arcs;
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
    
    
    //methodes added with Assignment4

    // todo ignore not connected
    public Iterator<Node> getAllNodes() { //a
        List<Node> list = new ArrayList<Node>();
        for (int i = 0; i < nodes.size(); i++){
        	list.add(nodes.get(i));
        }
        return list.iterator();
    }
    
    // todo ignore not connected
    public int getNodeNumber() { //b
        return nodes.size();
    }
    
    //todo ...
    public List<String> getNodeOperations() { //c
        List<String> list = new ArrayList<String>();
    	
    	for (int i = 0; i < nodes.size(); i++){
    		found = false;
        	int id = nodes.get(i).getID();
        	suche(0, id); //???
        	
        	if (found){	 //always false ...
        		String operation = nodes.get(i).getSpeedModifier();
	        	if (!list.contains(operation)){
	        		list.add(operation);
	        	}
        	}
        }
    	
    	return list;
    }
    
    //todo ignore not connected arcs
    public int getArcNumber() { //d
        return arcs.size();
    }

    //todo what is this
    public int getArcLengthSum() { //e
        int sum = 0;
        for (int i = 0; i < arcs.size(); i++){
        	found = false;
        	int id = arcs.get(i).getStart().getID();
        	suche(0, id);
        	
        	if (found){	
        		sum = sum + arcs.get(i).getDistance();
        	}
        }
    	return sum;
    }

    /**
     * remove all arcs from the graph with length under a threshold
     * @param x threshold
     */
    public void removeArcsLongerThan(final int x) { //f
        arcs.removeIf(arc -> arc.getDistance() > x);
    }
    
    //todo what does this function? , it throws StackOverflowsErrors
    void suche(int start, int end) {
    	for (int i = 0; i < arcs.size(); i++){
    		if (arcs.get(i).getStart().getID() == start){
    			if (arcs.get(i).getEnd().getID() == end){
        			found = true;
        		}
    			suche(arcs.get(i).getStart().getID(), end);
    		}
    	}
    }
    
    
}
