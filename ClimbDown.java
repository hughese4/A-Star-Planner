public class ClimbDown extends Operator{
    
    // Pre: Monkey and box are in the same room, and the monkey is at height high
    // Post: Monkey is at height low
    public boolean applicable(WorldState state) {
        if (state.getMonkeyLoc().equals(state.getBoxLoc()) && state.getMonkeyHeight().equals("high")) {
            return true;
        }
        return false;
    }

    public WorldState apply(WorldState state) {
        state.setMonkeyheight("low");
        return state;
    }
}
