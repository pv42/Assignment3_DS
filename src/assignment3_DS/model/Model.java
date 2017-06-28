package assignment3_DS.model;

import assignment3_DS.graph.Graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Observable;
import java.util.Observer;

/**
 * Created by pv42 on 24.06.2017.
 */
public class Model {
    private Graph graph;
    private Observable arcCountObservable;
    private Observable nodeCountObserable;
    private Observable sumArcWeightObserable;
    private Observable mainTextObservable;

    public Model() {
        graph = new Graph(new HashMap<>(),new ArrayList<>()); // empty graph
        arcCountObservable = new Observable();
        //arcCountObservable.
    }
    // todo remove static

    static public void requestNodeList(){
        //todo
    }

    static public void requestOperationList(){
        //todo
    }

    public void registerObservers(Observer arcCountObserver, Observer nodeCountObserver, Observer sumArcWeightObserver, Observer mainTextObserver) {
        arcCountObservable.addObserver(arcCountObserver);
        nodeCountObserable.addObserver(nodeCountObserver);
        sumArcWeightObserable.addObserver(sumArcWeightObserver);
        mainTextObservable.addObserver(mainTextObserver);
    }

}
