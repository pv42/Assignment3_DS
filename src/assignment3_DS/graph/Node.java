package assignment3_DS.graph;

import java.util.Objects;

/**
 * Represnets a Node of the Graph
 * @author Clemens Deckwart
 */
public class Node {

    private int id;
    private String mod;

    /**
     * creates a Node
     *
     * @param id  nodes ID
     * @param mod Nodes Speedmodifier
     */
    public Node(int id, String mod) {
        this.id = id;
        this.mod = mod;
    }

    /**
     * Calculates the speed when going through this node
     *
     * @param currentSpeed speed when entering this node
     * @return speed when leaving this node
     */
    public double applySpeedModifier(double currentSpeed) {
        if (Objects.equals(mod, "-")) return currentSpeed;
        if (Objects.equals(mod, "*speed")) return currentSpeed * currentSpeed;
        if (mod.substring(0, 1).equals("+")) return currentSpeed + Double.valueOf(mod.substring(1));
        if (mod.substring(0, 1).equals("-")) return currentSpeed - Double.valueOf(mod.substring(1));
        if (mod.substring(0, 1).equals("*")) return currentSpeed * Double.valueOf(mod.substring(1));
        return 0;
    }

    /**
     * Returns the nodes identifier(ID)
     *
     * @return the nodes ID
     */

    public int getID() {
        return this.id;
    }

    @Override
    public String toString() {
        return "Node{" +
                "id=" + id +
                ", mod='" + mod + '\'' +
                '}';
    }
}