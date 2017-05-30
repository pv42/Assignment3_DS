package assignment3_DS;

/**
 * Created by pv42 on 29.05.2017.
 * Represnets a Node of the
 */
public class Node {

    private int id;
    private String mod;

    public Node(int id, String mod) {
        this.id = id;
        this.mod = mod;
    }

    /**
     * Calculates the speed when going through this node
     * @param currentSpeed speed when entering this node
     * @return speed when leaving this node
     */
    public double applySpeedModifier(double currentSpeed) {
        return 0;
    }

    /**
     * Returns the nodes identifier(ID)
     * @return the nodes ID
     */
    public int getID() {
        return 0;
    }
}