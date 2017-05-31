package assignment3_DS;

public class Main {
    public static void main(String[] args) {
        //loads graph from "res/nodes.csv","res/arces.csv" using CSVLoader
        //finds the shortest path using Pathfinder
        //prints this path (path.toString() might be useful)
        CSVLoader.loadGraph("res/nodes.csv","res/arces.csv");
    }
}