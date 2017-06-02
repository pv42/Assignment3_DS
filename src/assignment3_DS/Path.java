package assignment3_DS;

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

        // time = getDistance() / (applySpeedModifier();
        // zeit = weg / geschwindigkeit
        return getTimeNeeded(DEFAULT_START_SPEED);
    }

    public double getTimeNeeded(double startSpeed) {
        return 0;
    }

    public double getEndSpeed() { //default : startspeed = 1;
        // hier muss ich die gesamtzeit erfassen, also alle zeiten zusammenrechnen
        return getEndSpeed(DEFAULT_START_SPEED);
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
