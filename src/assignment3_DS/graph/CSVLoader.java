package assignment3_DS.graph;


import jdk.management.resource.internal.inst.FileOutputStreamRMHooks;

import java.io.*;
import java.util.*;

/**
 * This Class is used to load CSV node/arc files.
 *
 * @author Sebastian Neubert
 */
public class CSVLoader {
    /**
     * loads both the node and arcs from CSV files and creates a graph
     *
     * @param nodeFile indicates the file of the cvs file containing the nodes
     * @param arcFile  indicates the file of the cvs file containing the arcs
     * @return the graph with nodes and arcs loaded from files or {@code null} if there was a problem
     */
    public static Graph loadGraph(File nodeFile, File arcFile) throws IOException,NumberFormatException {
        System.out.println("loading nodes from " + nodeFile + " and arcs from " + arcFile);
        Map<Integer, Node> nodes = getNodes(nodeFile);
        List<Arc> arcs = getArcs(arcFile, nodes);
        if (arcs == null) return null;
        else return new Graph(nodes, arcs);
    }

    /**
     * loads both the node and arcs from CSV files and creates a graph
     *
     * @param nodeFilePath indicates the absolute or relative path of the cvs file containing the nodes
     * @param arcFilePath  indicates the absolute or relative path of the cvs file containing the arcs
     * @return the graph with nodes and arcs loaded from files or {@code null} if there was a problem
     */
    public static Graph loadGraph(String nodeFilePath, String arcFilePath) throws IOException,NumberFormatException {
        return loadGraph(new File(nodeFilePath), new File(arcFilePath));
    }

    /**
     * loads the nodes from the csv file using a BufferedReader
     *
     * @param nodeFile indicates the absolute or relative path of the cvs file containing the nodes
     * @return a list of nodes read from the resource file
     */
    private static Map<Integer, Node> getNodes(File nodeFile) throws IOException {
        Map<Integer, Node> nodes = new HashMap<>();
        String line;
        String splitBy = ";";
        BufferedReader bufferedReader = new BufferedReader(new FileReader(nodeFile));
        bufferedReader.readLine();
        while ((line = bufferedReader.readLine()) != null) {

            String[] nodeAttributes = line.split(splitBy);
            Node curNode = new Node(Integer.valueOf(nodeAttributes[0]), nodeAttributes[1]);
            nodes.put(curNode.getID(), curNode);
        }
        bufferedReader.close();
        return nodes;
    }

    /**
     * loads the arcs from the csv file using a BufferedReader
     *
     * @param arcFilePath indicates the absolute or relative path of the cvs file containing the arcs
     * @param nodes       the list of nodes which will be connected by the arcs
     * @return a list of arcs read from the resource file or {@code null} if an arc doesn't find a start or end node
     */
    private static List<Arc> getArcs(File arcFilePath, Map<Integer, Node> nodes) throws IOException, NumberFormatException {
        List<Arc> arcs = new ArrayList<>();
        String line;
        String splitBy = ";";
        BufferedReader bufferedReader = new BufferedReader(new FileReader(arcFilePath));
        bufferedReader.readLine();
        while ((line = bufferedReader.readLine()) != null) {
            String[] arcAttributes = line.split(splitBy);
            Node start = nodes.get(Integer.valueOf(arcAttributes[0]));
            Node end = nodes.get(Integer.valueOf(arcAttributes[1]));
            if (start == null || end == null) {
                return null;
            } else {
                Arc curArc = new Arc(start, end, Integer.valueOf(arcAttributes[2]));
                arcs.add(curArc);
            }
        }
        bufferedReader.close();
        return arcs;
    }

}
