package assignment3_DS.model;

import assignment3_DS.controller.MyObservable;
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
    private MyObservable arcCountObservable;
    private MyObservable nodeCountObservable;
    private MyObservable sumArcWeightObservable;
    private MyObservable mainTextObservable;

    public Model() {
        graph = new Graph(new HashMap<>(), new ArrayList<>()); // empty graph
        arcCountObservable = new MyObservable();
        nodeCountObservable = new MyObservable();
        sumArcWeightObservable = new MyObservable();
        mainTextObservable = new MyObservable();
        //arcCountObservable
    }

    public void requestNodeList(){
        mainTextObservable.notifyChanged("Node List:");
    }

    public void requestOperationList(){
        mainTextObservable.notifyChanged("Ops List:");
    }

    public void setGraph(Graph graph) {
        this.graph = graph;
    }

    public void registerObservers(Observer arcCountObserver, Observer nodeCountObserver, Observer sumArcWeightObserver, Observer mainTextObserver) {
        arcCountObservable.addObserver(arcCountObserver);
        nodeCountObservable.addObserver(nodeCountObserver);
        sumArcWeightObservable.addObserver(sumArcWeightObserver);
        mainTextObservable.addObserver(mainTextObserver);
    }
}
