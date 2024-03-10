public class ClimbDown extends Operator{
    
    // Pre: Monkey and box are in the same room, and the monkey is at height high
    // Post: Monkey is at height low
    public boolean applicable(WorldState state) {
        if (state.getMonkeyLoc().equals(state.getBoxLoc()) && state.getMonkeyHeight().equals("high")) {
            return true;
        }
        return false;
    }

    public WorldState apply(WorldState currentState) {
        WorldState newState = new WorldState(currentState.getMonkeyLoc(),
                                         currentState.getBoxLoc(),
                                         currentState.getBananaLoc(),
                                         "low", // changes height
                                         currentState.getHasBananas());
        
        newState.setParent(currentState);
        newState.setAction(this);
        return newState;
    }

    public String toString() {
        return "ClimbDown ()";
    }
}
