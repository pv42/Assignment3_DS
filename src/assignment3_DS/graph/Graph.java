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

    public Iterator<Node> getAllNodes() { //a
        List<Node> list = new ArrayList<Node>();
        for (int i = 0; i < nodes.size(); i++){
        	list.add(nodes.get(i));
        }
        return list.iterator();
    }
    
    
    public int getNodeNumber() { //b
        return nodes.size();
    }
    
    
    public List<String> getNodeOperations() { //c
        List<String> list = new ArrayList<String>();
    	
    	for (int i = 0; i < nodes.size(); i++){
        	String operation = nodes.get(i).toString().split("'")[1];
        	if (!list.contains(operation)){
        		list.add(operation);
        	}
        }
    	
    	return list;
    }
    
    
    public int getArcNumber() { //d
        return arcs.size();
    }
    
    
    public int getArcLenghtSum() { //e
        int sum = 0;
        for (int i = 0; i < arcs.size(); i++){
        	sum += arcs.get(i).getDistance();
        }
    	return sum;
    }
    
    
    public void removeArcsLongerThan(final int x) { //f
        Iterator<Arc> it = arcs.iterator(); 
    	while(it.hasNext()){
    	    Arc arc = it.next();
    	    if(arc.getDistance() > x){
    	        it.remove();
    	    }
    	}
    }
}
