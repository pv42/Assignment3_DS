package assignment3_DS;

import java.awt.peer.ScrollbarPeer;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by pv42 on 29.05.2017.
 * @author Sebastian Nolte
 */
public class Path {
    private static final double DEFAULT_START_SPEED = 1;

    private List <Arc> arcList;

    // initialisiert neue Liste
    public Path(){
        List<Arc> path = new ArrayList<>();
    }

    public Path(Path path) {}

    // greifen auf letztes Element in der Liste zu
    public Node getEndNode() {
        return arcList.get(arcList.size()-1).getEnd();
    }

    // fuegen neue Arc/Kante hinzu
    public void addArc(Arc arc) {
        arcList.add(arc);
    }

    public double getTimeNeeded() { //default : startspeed = 1;
        return getTimeNeeded(DEFAULT_START_SPEED);

    public double getTimeNeeded(double startSpeed) {
            int distance = 0;
            double speed = DEFAULT_START_SPEED;
            double totalTime = 0.0;
            for (int i = 0; i < arcList.size(); i++) {
                distance =  arcList.get(i).getDistance();
                speed = arcList.get(i).getStart().applySpeedModifier(speed);
                totalTime = totalTime + (distance/speed);
            }
            return totalTime;
        }
    }

    public double getEndSpeed() { //default : startspeed = 1;
        double speed = DEFAULT_START_SPEED;
        double totalSpeed = 0.0;
        for (int i = 0; i < arcList.size(); i++){
            speed = arcList.get(i).getStart().applySpeedModifier(speed);
            totalSpeed = totalSpeed + speed;
        }
        return totalSpeed;
    }

    public double getEndSpeed(double startSpeed) {
        return 0;
    }

    public boolean isBetterThan(Path path) {
        return getEndSpeed() >= path.getEndSpeed() && getTimeNeeded() <= path.getTimeNeeded();
    }

    @Override
    public String toString() {
        return "Path{}";
    }

}
