public class Push extends Operator {
    public String box_loc;

    // Pre: Monkey and box are in room x, and monkey is at height low
    // Post: Monkey and box are in room y, and no longer in room x
    public boolean applicable(WorldState state) {
        if (!state.getMonkeyLoc().equals(state.getBoxLoc())) {
            return false;
        }
        if (!state.getMonkeyHeight().equals("low")) {
            return false;
        }
        return true;
    }

    // Applies postconditions of operator action
    public WorldState apply(WorldState state) {
        state.setBoxLoc(box_loc);
        state.setMonkeyLoc(box_loc);
        return state;s
    }
}
                                                                                                 