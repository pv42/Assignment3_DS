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
        long mt0 = System.currentTimeMillis();
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
                                0,
                                21
                        )
                );
        long mt1 = System.currentTimeMillis();
        System.out.println("After " + ((mt1 - mt0 )/ 1000.0) + "s");
    }
}