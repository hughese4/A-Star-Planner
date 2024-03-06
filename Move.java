public class Move extends Operator{
    private String moveFrom;
    private String moveTo;

    // check preconditions
    public boolean applicable(WorldState state) {
        if (!state.getMonkeyLoc().equals(moveFrom)) {
            return false;
        }

        if (!state.getMonkeyHeight().equals("high")) {
            return false;
        }
        return true;
    }

    // apply effects
    public WorldState apply(WorldState state) {
        state.setMonkeyLoc(moveTo);
        return state;
    }
}
