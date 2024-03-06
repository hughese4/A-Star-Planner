public abstract class Operator {
    
    public abstract boolean applicable(WorldState state);

    public abstract WorldState apply(WorldState state);
}
