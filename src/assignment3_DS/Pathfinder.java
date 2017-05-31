package assignment3_DS;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * This class is used to find the fastest path between 2 nodes in a graph
 *
 * @author J&ouml;rn Roth
 */
public class Pathfinder {
    /**
     * No instances of Pathfinder should be created
     */
    private Pathfinder() {
    }

    //todo @null

    /**
     * Finds the fastest path between 2 nodes
     *
     * @param graph       the graph containing both nodes
     * @param startNodeID the start nodes id
     * @param endNodeID   the end nodes id
     * @return the fastest path between the nodes or null if  there is no valid path
     */
    public static Path findFastestPath(Graph graph, int startNodeID, int endNodeID) {
        Node startNode = graph.getNodeById(startNodeID);
        Node endNode = graph.getNodeById(endNodeID);
        if (startNode == null || endNode == null) return null; // there is no such node with this id
        /*
         *
         */
        Map<Node, List<Path>> pathsToNode = new HashMap<>();
        List<Path> activePaths = new ArrayList<>();
        Path initPath = new Path();
        activePaths.add(initPath); // startpath
        addInHahMapList(pathsToNode, startNode, initPath);
        while (true) {
            sortPathList(activePaths);
            Path path = activePaths.get(0);
            if (path.getEndNode().getID() == endNodeID) break;
            List<Arc> arcs = graph.getAllConnectedArcsByNodeID(path.getEndNode().getID());
            activePaths.remove(path);
            for (Arc arc : arcs) {
                Path p = new Path(path);
                if(!isWorseThanInHML(pathsToNode,p)) {
                    p.addArc(arc);
                    activePaths.add(p);
                    addInHahMapList(pathsToNode,p.getEndNode(),p);
                }
            }
        }
        return activePaths.get(0);
    }

    /**
     * Inserts an element in a HashMap of Lists of paths with mapkeytype node
     * @param map map to insert
     * @param key key determining witch list
     * @param path object(path) to be inserted
     */
    private static void addInHahMapList(Map<Node, List<Path>> map, Node key, Path path) {
        map.computeIfAbsent(key, k -> new ArrayList<>()); //lambda for if null create
        map.get(key).add(path);
    }

    private static boolean isWorseThanInHML(Map<Node, List<Path>> map, Path path) {
        List<Path> list = map.get(path.getEndNode());
        if (list == null) return false;
        for (Path p : list) {
            if (!p.isBetterThan(path)) return false;
        }
        return true;
    }

    /**
     * Sorts a list of paths based on their time needed using bubble-sort
     * @param pathList list to sort
     */
    private static void sortPathList(List<Path> pathList) {
        boolean changed;
        do {
            changed = false;
            for (int i = 0; i < pathList.size() - 1; i++) {
                if (pathList.get(i).getTimeNeeded() > pathList.get(i + 1).getTimeNeeded()) {
                    Path tmp = pathList.get(i);
                    pathList.set(i, pathList.get(i + 1));
                    pathList.set(i + 1, tmp);
                    changed = true;
                }
            }
        } while (changed);
    }
}
