public class ClimbUp extends Operator{
    
    // Pre: monkey and box must be in the same room, and monkey is at height low.
    // Post: monkey is at height high.
    
    public boolean applicable(WorldState state) {
        if (state.getMonkeyLoc().equals(state.getBoxLoc()) && state.getMonkeyHeight().equals("low")) {
            return true;
        }
        return false;
    }

    public WorldState apply(WorldState state) {
        state.setMonkeyheight("high");
        return state;
    }

}
