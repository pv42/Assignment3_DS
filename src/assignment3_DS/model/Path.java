package assignment3_DS.model;

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
     * @param startNode the Node, where the path starts
     */
    public Path(Node startNode) {
        this.startNode = startNode;
        arcList = new ArrayList<>();
        timeNeeded = 0;
        endSpeed = startNode.applySpeedModifier(DEFAULT_START_SPEED);
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
            timeNeeded += (arc.getDistance() / endSpeed);
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
    public double getEndSpeed() {
        return endSpeed;
    }

    @Override
    public String toString() {
        String out = "";
        for (int i = 0; i < arcList.size(); i++) {
            out = out +  arcList.get(i).getStart().getID();
            out = out + ",";
        }
        out = out + getEndNode().getID();
        return "P{" + out + "}(" + getTimeNeeded() + ", " + getEndSpeed()+")";
    }

    public String getRunThoughtString() {
        double speed = 1;
        double time = 0;
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < arcList.size(); i++) {
            Arc arc = arcList.get(i);
            speed = arc.getStart().applySpeedModifier(speed);
            stringBuilder.append(i+1).append(") from ").append(arc.getStart().getID());
            stringBuilder.append(" to ").append(arc.getEnd().getID());
            stringBuilder.append(" with speed ").append(String.format("%d",(long)speed));
            stringBuilder.append(" in ").append(arc.getDistance()/ speed).append(" timesteps (total: ");
            time += arc.getDistance()/ speed;
            stringBuilder.append(time).append(")\n");
        }
        return stringBuilder.toString();
    }

}
