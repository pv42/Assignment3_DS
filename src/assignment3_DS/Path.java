package assignment3_DS;

/**
 * Created by pv42 on 29.05.2017.
 * @author Sebastian Nolte
 */
public class Path {
    private static final double DEFAULT_START_SPEED = 1;

    public Path(){}

    public Path(Path path) {}

    public Node getEndNode() {
        return null;
    }

    public void addArc(Arc arc) {}

    public double getTimeNeeded() { //default : startspeed = 1
        return getTimeNeeded(DEFAULT_START_SPEED);
    }

    public double getTimeNeeded(double startSpeed) {
        return 0;
    }

    public double getEndSpeed() {
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
