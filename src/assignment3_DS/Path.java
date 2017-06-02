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
        arcList = new ArrayList<>();
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
    }

    public double getTimeNeeded(double startSpeed) {
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

    public double getEndSpeed() { //default : startspeed = 1;
        return getEndSpeed(DEFAULT_START_SPEED);
    }

    public double getEndSpeed(double startSpeed) {
        double speed = startSpeed;
        for (int i = 0; i < arcList.size(); i++){
            speed = arcList.get(i).getStart().applySpeedModifier(speed);
        }
        return speed;
    }

    public boolean isBetterThan(Path path) {
        return getEndSpeed() >= path.getEndSpeed() && getTimeNeeded() <= path.getTimeNeeded();
    }

    @Override
    public String toString() {
        String out = "";
        for (int i = 0; i < arcList.size(); i++){
            out = out + arcList.get(i).getStart();
            if (i < (arcList.size()-1)){ out = out + ",";}
        }
        return "Path{" + out + "}";
    }

}
