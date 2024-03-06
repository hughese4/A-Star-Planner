public class Grab extends Operator{
    
    // Pre: Monkey and bananas are in the same room, and the monkey is at height high
    // Post: Monkey has the bananas
    public boolean applicable(WorldState state) {
        if (state.getMonkeyLoc().equals(state.getRoomLoc()) && state.getMonkeyHeight().equals("high")) {
            return true;
        }
        return false;
    }

    public WorldState apply(WorldState state) {
        state.setHasBananas(true);
        return state;
    }
}
