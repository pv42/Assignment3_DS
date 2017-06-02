package assignment3_DS;

import java.awt.peer.ScrollbarPeer;
import java.util.ArrayList;
import java.util.List;

/**
 * This class is used to show a path and calculates time and speed within the graph
 *
 * @author Sebastian Nolte
 */
public class Path {
    private static final double DEFAULT_START_SPEED = 1;

    private List <Arc> arcList;

    /**
     * Creates a path
     *
     */
    public Path(){
        arcList = new ArrayList<>();
    }

    public Path(Path path) {

    }

    /**
     * Returns the last Node in arcList
     *
     * @return last Node
     */
    public Node getEndNode() {
        return arcList.get(arcList.size()-1).getEnd();
    }

    /**
     * Adds a new Arc to arcList
     *
     * @param arc Adds arc
     */
    public void addArc(Arc arc) {
        arcList.add(arc);
    }

    /**
     * Calculates the total time needed to finish the path once
     *
     * @return total Time needed to finish path
     */
    public double getTimeNeeded() { //default : startspeed = 1;
        return getTimeNeeded(DEFAULT_START_SPEED);
    }

    /**
     * Calculates the total time needed to finish the path once
     *
     * @param startSpeed startspeed is equal DEFAULT_START_SPEED
     * @return total Time needed to finish path
     */
    public double getTimeNeeded(double startSpeed) { //default : startspeed = 1;
            int distance = 0;
            double speed = startSpeed;
            double totalTime = 0.0;
            for (int i = 0; i < arcList.size(); i++) {
                distance =  arcList.get(i).getDistance();
                speed = arcList.get(i).getStart().applySpeedModifier(speed);
                totalTime = totalTime + (distance/speed);
            }
            return totalTime;
    }

    /**
     *  Calculates the end speed the path reaches after one cycle
     *
     * @return total speed after one cycle
     */
    public double getEndSpeed() { //default : startspeed = 1;
        return getEndSpeed(DEFAULT_START_SPEED);
    }

    /**
     *  Calculates the end speed the path reaches after one cycle
     *
     * @param startSpeed startspeed of node
     * @return total speed after one cycle
     */
    public double getEndSpeed(double startSpeed) {
        double speed = startSpeed;
        for (int i = 0; i < arcList.size(); i++){
            speed = arcList.get(i).getStart().applySpeedModifier(speed);
        }
        return speed;
    }

    /**
     *
     * @param path
     * @return
     */
    public boolean isBetterThan(Path path) {
        return getEndSpeed() >= path.getEndSpeed() && getTimeNeeded() <= path.getTimeNeeded();
    }

    @Override
    public String toString() {
        String out = "";
        for (int i = 0; i < arcList.size(); i++){
            out = out + arcList.get(i).getStart();
            if (i < (arcList.size()-1)){
                out = out + ",";
            }
        }
        return "Path{" + out + "}";
    }

}
