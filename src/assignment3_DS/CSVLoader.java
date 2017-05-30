package assignment3_DS;

import java.io.*;
import java.util.List;

/**
 * Created by pv42 on 29.05.2017.
 * This Class is used to load CSV node/arc files.
 */
public class CSVLoader {
    /**
     * loads both the node and arcs from CSV files and creates a graph
     *
     * @param nodeFilePath indicates the absolute or relative path of the cvs file containing the nodes
     * @param arcFilePath  indicates the absolute or relative path of the cvs file containing the arcs
     * @return the graph with nodes and arcs loaded from files or {@code null} if there was a problem
     */
    public static Graph loadGraph(String nodeFilePath, String arcFilePath) {
        List<Node> nodes = getNodes(nodeFilePath);
        List<Arc> arcs = getArcs(arcFilePath, nodes);
        if (arcs == null) return null;
        else return new Graph(nodes, arcs);
    }

    /**
     * loads the nodes from the csv file using a BufferedReader
     *
     * @param nodeFilePath indicates the absolute or relative path of the cvs file containing the nodes
     * @return a list of nodes read from the resource file
     */
    private static List<Node> getNodes(String nodeFilePath) {
        List<Node> nodes = null;
        String line = "";
        String splitBy = ";";
        String[] firstLine = new String[]{"ID", "modifier"};
        BufferedReader bufferedReader = null;

        try {
            bufferedReader = new BufferedReader(new FileReader(nodeFilePath));
            while ((line = bufferedReader.readLine()) != null) {

                String[] nodeAttributes = line.split(splitBy);
                if (nodeAttributes != firstLine) {
                    Node curNode = new Node(Integer.valueOf(nodeAttributes[0]), nodeAttributes[1]);
                    nodes.add(curNode);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (bufferedReader != null) {
                try {
                    bufferedReader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return nodes;
    }

    /**
     * loads the arcs from the csv file using a BufferedReader
     *
     * @param arcFilePath indicates the absolute or relative path of the cvs file containing the arcs
     * @param nodes       the list of nodes which will be connected by the arcs
     * @return a list of arcs read from the resource file or {@code null} if an arc doesn't find a start or end node
     */
    private static List<Arc> getArcs(String arcFilePath, List<Node> nodes) {
        List<Arc> arcs = null;
        String line = "";
        String splitBy = ";";
        String[] firstLine = new String[]{"from", "to", "distance"};
        BufferedReader bufferedReader = null;

        try {
            bufferedReader = new BufferedReader(new FileReader(arcFilePath));
            while ((line = bufferedReader.readLine()) != null) {

                String[] arcAttributes = line.split(splitBy);
                if (arcAttributes != firstLine) {
                    Node start = null, end = null;

                    for (Node node : nodes) {
                        if (node.getID() == Integer.valueOf(arcAttributes[0])) {
                            start = node;
                        }
                        if (node.getID() == Integer.valueOf(arcAttributes[1])) {
                            end = node;
                        }
                    }
                    if (start == null || end == null) {
                        return null;
                    } else {
                        Arc curArc = new Arc(start, end, Integer.valueOf(arcAttributes[2]));
                        arcs.add(curArc);
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (bufferedReader != null) {
                try {
                    bufferedReader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return arcs;
    }

}
