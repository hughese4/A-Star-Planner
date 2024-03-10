public class Move extends Operator{
    private String moveFrom;
    private String moveTo;

    public Move(String moveFrom, String moveTo) {
        this.moveFrom = moveFrom;
        this.moveTo = moveTo;
    }

    // check preconditions
    public boolean applicable(WorldState state) {
        if (!state.getMonkeyLoc().equals(moveFrom) || !state.getMonkeyHeight().equals("low")) {
            return false;
        } else {
            return true;
        }
    }

    public WorldState apply(WorldState currentState) {
        WorldState newState = new WorldState(moveTo,
                                         currentState.getBoxLoc(), // monkey moves to new room
                                         currentState.getBananaLoc(),
                                         currentState.getMonkeyHeight(),
                                         currentState.getHasBananas());
        newState.setParent(currentState);
        newState.setAction(this);
        return newState;
    }

    public String toString() {
        return "Move (" + moveFrom + "," + moveTo + ")";
    }
}
