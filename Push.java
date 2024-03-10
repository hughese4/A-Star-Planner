public class Push extends Operator {
    public String pushFrom;
    public String pushTo;

    public Push(String from, String to) {
        this.pushFrom = from;
        this.pushTo = to;
    }

    // Pre: Monkey and box are in room x, and monkey is at height low
    // Post: Monkey and box are in room y, and no longer in room x
    public boolean applicable(WorldState state) {
        if (!state.getMonkeyLoc().equals(state.getBoxLoc()) || !state.getMonkeyHeight().equals("low")) {
            return false;
        } else {
            return true;
        }
    }

    public WorldState apply(WorldState currentState) {
        WorldState newState = new WorldState(pushTo, // monkey moves to new room
                                         pushTo, // box moves to new room too
                                         currentState.getBananaLoc(),
                                         currentState.getMonkeyHeight(), 
                                         currentState.getHasBananas());
        newState.setParent(currentState);
        newState.setAction(this);
        return newState;
    }

    public String toString() {
        return "Push (" + pushFrom + "," + pushTo + ")";
    }    
}
                                                                                                 