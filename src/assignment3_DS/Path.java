package assignment3_DS;

import java.util.ArrayList;
import java.util.List;

/**
 * This class is used to show a path and calculates time and speed within the graph
 *
 * @author Sebastian Nolte
 */
public class Path {
    private static final double DEFAULT_START_SPEED = 1;
    private Node startNode;
    private List<Arc> arcList;
    private double timeNeeded;
    private double endSpeed;

    /**
     * Creates a path
     */
    public Path(Node startNode) {
        this.startNode = startNode;
        arcList = new ArrayList<>();
        timeNeeded = 0;
        endSpeed = DEFAULT_START_SPEED;
    }

    /**
     * Makes a copy of our first arcList
     *
     * @param path path to copy
     */
    public Path(Path path) {
        arcList = new ArrayList<>(path.arcList);
        startNode = path.startNode;
        timeNeeded = path.timeNeeded;
        endSpeed = path.endSpeed;
    }

    /**
     * Returns the arcList
     *
     * @return arcList
     */
    public List<Arc> getArcList() {
        return arcList;
    }

    /**
     * returs the paths start node
     *
     * @return the start node
     */
    public Node getStartNode() {
        return startNode;
    }

    /**
     * Returns the last Node in arcList
     *
     * @return last Node
     */
    public Node getEndNode() {
        if(arcList.isEmpty()) return startNode;
        return arcList.get(arcList.size() - 1).getEnd();
    }

    /**
     * Adds a new Arc to arcList
     *
     * @param arc Adds arc
     */
    public void addArc(Arc arc) {
        if(arc.getStart().getID() == getEndNode().getID()) {
            arcList.add(arc);
            timeNeeded = timeNeeded + (arc.getDistance()/endSpeed);
            endSpeed = arc.getEnd().applySpeedModifier(endSpeed);
            if(endSpeed <= 0) timeNeeded = Double.POSITIVE_INFINITY;
        } else {
            throw new IllegalArgumentException("Arcs start must be last arcs end");
        }
    }

    /**
     * Calculates the total time needed to finish the path once with speed is equal DEFAULT_START_SPEED(=1) at the begin
     *
     * @return total Time needed to finish path
     */
    public double getTimeNeeded() {
        return timeNeeded;
    }

    /**
     * Calculates the end speed the path reaches after one cycle
     *
     * @return total speed after one cycle
     */
    public double getEndSpeed() { //default : startspeed = 1;
        return getEndSpeed(DEFAULT_START_SPEED);
    }

    /**
     * Calculates the end speed the path reaches after one cycle
     *
     * @param startSpeed speed before running through the path
     * @return total speed after one cycle
     */
    public double getEndSpeed(double startSpeed) {
        return endSpeed;
    }

    /**
     * indicates if a path is better than an other, meaning generates higher speed and is faster
     * @param path path to compare with
     * @return true if this path is faster and generates more speed false otherwise
     */
    public boolean isBetterThan(Path path) {
        return getEndSpeed() >= path.getEndSpeed() && getTimeNeeded() <= path.getTimeNeeded();
    }

    @Override
    public String toString() {
        String out = "";
        for (int i = 0; i < arcList.size(); i++) {
            out = out + "Node:" +  arcList.get(i).getStart().getID();
            out = out + ",";
        }
        out = out + "Node:" +  getEndNode().getID();
        return "Path{" + out + "} after " + getTimeNeeded() + " with v=" + getEndSpeed();
    }

}
