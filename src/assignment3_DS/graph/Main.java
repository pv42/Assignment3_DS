package assignment3_DS.graph;

import java.util.Observable;
import java.util.Observer;

/**
 * Main class
 *
 * @author Julius Lochbaum
 */
public class Main {
    // maincode

    public static void assignment3() {
    	long time1 = System.nanoTime();
    	
        //loads graph from "res/nodes.csv","res/arces.csv" using CSVLoader
    	Graph graph = CSVLoader.loadGraph("res/nodes.csv", "res/arces.csv");
        long time2 = System.nanoTime();  
        
        //finds the shortest path using Pathfinder
        Path path = Pathfinder.findFastestPath(graph, 0, 21);
    	long time3 = System.nanoTime();
        
        //prints this path
    	System.out.println("shortest Path: \n" + path.getRunThoughtString());
    	
    	//prints the time
    	System.out.println("loading graph time:  " + ((double) (time2 - time1) / 1000000) + " ms");
    	System.out.println("computing time:      " + ((double) (time3 - time2) / 1000000) + " ms");
    	System.out.println("total duration:      " + ((double) (time3 - time1) / 1000000) + " ms");
		Observer observer = new Observer() {
			@Override
			public void update(Observable o, Object arg) {

			}
		};
		Observable observable = new Observable();
    }

}
