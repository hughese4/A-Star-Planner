

public class WorldState {
    private String bananas_loc;
    private String monkey_loc;
    private String monkey_height;
    private String box_loc;
    private boolean has_bananas;

    public WorldState(String bananas_loc, String monkey_loc, String box_loc, boolean has_bananas) {
        this.bananas_loc = bananas_loc;
        this.monkey_loc = monkey_loc;
        this.box_loc = box_loc;
        this.has_bananas = has_bananas;
    }

    // Returns true if all the conditions are met for the monkey to grab the bananas
    public boolean isGoalState() {
        return (monkey_loc.equals(bananas_loc) && has_bananas);
    }

    public String getRoomLoc() {
        return bananas_loc;
    }

    public String getMonkeyLoc() {
        return monkey_loc;
    }

    public String getMonkeyHeight() {
        return monkey_height;
    }

    public String getBoxLoc() {
        return box_loc;
    }

    public boolean getHasBananas() {
        return has_bananas;
    }

    public void setMonkeyLoc(String loc) {
        monkey_loc = loc;
    }

    public void setMonkeyheight(String height) {
        monkey_height = height;
    }

    public void setBoxLoc(String loc) {
        box_loc = loc;
    }

    public void setHasBananas(boolean bananas) {
        has_bananas = bananas;
    }

    public void printState() {
        System.out.println("The monkey is in room " + bananas_loc);
        System.out.println("The monkey is in room " + monkey_loc);
        System.out.println("The box is in room " + box_loc);
        System.out.println("The bananas are in room " + has_bananas);
    }

}
