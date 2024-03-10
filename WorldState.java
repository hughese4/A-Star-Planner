import java.util.Objects;

// Represents the state of the world
public class WorldState {
    private String bananas_loc;
    private String monkey_loc;
    private String monkey_height;
    private String box_loc;
    private boolean has_bananas;

    private WorldState parent;     
    private Operator action;   
    private double costSoFar; 

    public WorldState(String monkey_loc, String box_loc,  String bananas_loc, String monkey_height, boolean has_bananas) {
        this.bananas_loc = bananas_loc;
        this.monkey_loc = monkey_loc;
        this.box_loc = box_loc;
        this.has_bananas = has_bananas;
        this.monkey_height = monkey_height;
    }

    // had to override these because default equals and hashcode methods were causing infinite loops
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        WorldState that = (WorldState) obj;
        return has_bananas == that.has_bananas &&
            Objects.equals(bananas_loc, that.bananas_loc) &&
            Objects.equals(monkey_loc, that.monkey_loc) &&
            Objects.equals(monkey_height, that.monkey_height) &&
            Objects.equals(box_loc, that.box_loc);
    }

    @Override
    public int hashCode() {
        return Objects.hash(bananas_loc, monkey_loc, monkey_height, box_loc, has_bananas);
    }

    public void setParent(WorldState parent) {
        this.parent = parent;
    }

    public WorldState getParent() {
        return this.parent;
    }

    public void setAction(Operator action) {
        this.action = action;
    }

    public Operator getAction() {
        return this.action;
    }

    public void setCostSoFar(double cost) {
        this.costSoFar = cost;
    }

    public double getCostSoFar() {
        return this.costSoFar;
    }

    public void incrementCost(int actionCost) {
        this.costSoFar += actionCost;
    }

    // Returns true if all the conditions are met for the monkey to grab the bananas
    public boolean isGoalState() {
        return (this.monkey_loc.equals(bananas_loc) && this.has_bananas && this.monkey_height.equals("high"));
    }

    public String getBananaLoc() {
        return this.bananas_loc;
    }

    public String getMonkeyLoc() {
        return this.monkey_loc;
    }

    public String getMonkeyHeight() {
        return this.monkey_height;
    }

    public String getBoxLoc() {
        return this.box_loc;
    }

    public boolean getHasBananas() {
        return this.has_bananas;
    }

    public void setMonkeyLoc(String loc) {
        this.monkey_loc = loc;
    }

    public void setMonkeyheight(String height) {
        this.monkey_height = height;
    }

    public void setBoxLoc(String loc) {
        this.box_loc = loc;
    }

    public void setHasBananas(boolean bananas) {
        this.has_bananas = bananas;
    }
}
