public class Grab extends Operator{
    
    // Pre: Monkey and bananas are in the same room, and the monkey is at height high
    // Post: Monkey has the bananas
    public boolean applicable(WorldState state) {
        if (state.getMonkeyLoc().equals(state.getBananaLoc()) && state.getMonkeyHeight().equals("high")) {
            return true;
        }
        return false;
    }

    public WorldState apply(WorldState currentState) {
        WorldState newState = new WorldState(currentState.getMonkeyLoc(),
                                         currentState.getBoxLoc(),
                                         currentState.getBananaLoc(),
                                         currentState.getMonkeyHeight(),
                                         true); // Monkey has bananas now
        newState.setParent(currentState);
        newState.setAction(this);
        return newState;
    }

    public String toString() {
        return "Grab ()";
    }
}
