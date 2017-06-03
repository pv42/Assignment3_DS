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
        long nt0 = System.nanoTime();
        Graph graph = CSVLoader.loadGraph("res/nodes.csv", "res/arces.csv");
        long nt1 = System.nanoTime();
        Path p = Pathfinder.findFastestPath(graph, 0, 21);
        long nt2 = System.nanoTime();
        System.out.println(p);
        System.out.println("After " + ((nt1 - nt0 )/1000000.0) +" + " + ((nt2 - nt1 )/1000000.0) + "ms");
    }
}