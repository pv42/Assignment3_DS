package assignment3_DS;

/**
 * @author Julius Lochbaum
 */
public class Main {
    public static void main(String[] args) {
        //loads graph from "res/nodes.csv","res/arces.csv" using CSVLoader
        //finds the shortest path using Pathfinder
        //prints this path (path.toString() might be useful)
        //prints the time it took (see f.e with System.nanoTime())

        test(); //todo remove
    }

    private static void test() { //todo remove
        System
                .out
                .println(
                        Pathfinder.
                        findFastestPath(
                                CSVLoader.
                                loadGraph(
                                        "res/nodes.csv",
                                        "res/arces.csv"
                                ),
                                1,
                                21
                        )
                );
    }
}