import java.util.*;

public class AStarPlanner {

    private static final int actionCost = 1;
    private static final String[] ROOMS = {"A", "B", "C"};
    
    // using priority queue to prioritize states to explore based on cost
    private PriorityQueue<WorldState> openSet;
    // keeps track of visited states
    private Set<WorldState> closedSet;
    
    /* 
     * We want the monkey to find and grab the bananas as fast as possible
     * and minimize the number of moves it makes (cost)
     */
    public AStarPlanner() {
        openSet = new PriorityQueue<WorldState>(new Comparator<WorldState>() {
            public int compare(WorldState s1, WorldState s2) {
                return Double.compare(f(s1), f(s2));
            }
        });
        closedSet = new HashSet<WorldState>();
    }

    // A* planning algorithm to find the shortest path to the goal
    public List<Operator> plan(WorldState initialState) {
        openSet.add(initialState);
        while (!openSet.isEmpty()) {
            WorldState currentState = openSet.poll();
            if (currentState.isGoalState()) return constructSolution(currentState);           

            closedSet.add(currentState);

            for (Operator action : getPossibleActions(currentState)) {
                if (action.applicable(currentState)) {
                    WorldState nextState = action.apply(currentState);
                    nextState.incrementCost(actionCost);

                    // If next state as already been evaluated, skip
                    if (closedSet.contains(nextState)) continue;

                    // Add nextState to open set if not present with a lower cost
                    if (!openSet.contains(nextState) || g(nextState) < g(currentState)) {
                        nextState.setParent(currentState);
                        nextState.setAction(action);
                        nextState.setCostSoFar(g(nextState));
                        openSet.add(nextState);
                    }
                }
            }
        }
        return null;
    }

    // parts of A* algorithm (f, g, h functions)
    public double f(WorldState state) {        
        return g(state) + h(state);
    }

    // cost so far
    public double g(WorldState state) {
        return state.getCostSoFar();
    }

    // heuristic function
    public double h(WorldState state) {
        double heuristicValue = 0;
        
        if (state.getHasBananas()) {
            return 0;
        }

        if (!state.getMonkeyHeight().equals("high")) {
            heuristicValue += 1;
        }
        
        if (!state.getMonkeyLoc().equals(state.getBoxLoc())) {
            heuristicValue += 1;
        }
        
        if (!state.getBoxLoc().equals(state.getBananaLoc())) {
            heuristicValue += 1;
        }

        return heuristicValue;
    }

    private List<Operator> constructSolution(WorldState state) {
        LinkedList<Operator> solution = new LinkedList<Operator>();
        while (state.getParent() != null) {
            solution.addFirst(state.getAction());
            state = state.getParent();
        }
        return solution;
    }

    private List<Operator> getPossibleActions(WorldState state) {
        List<Operator> actions = new ArrayList<>();
        String monkeyLoc = state.getMonkeyLoc();
        String boxLoc = state.getBoxLoc();
        String monkeyHeight = state.getMonkeyHeight();
        String bananaLoc = state.getBananaLoc();

        Arrays.stream(ROOMS).filter(room -> !room.equals(monkeyLoc))
                .forEach(room -> actions.add(new Move(monkeyLoc, room)));

        if ("low".equals(monkeyHeight)) {
            Arrays.stream(ROOMS).filter(room -> !room.equals(boxLoc) && boxLoc.equals(monkeyLoc))
                    .forEach(room -> actions.add(new Push(monkeyLoc, room)));
            actions.add(monkeyLoc.equals(boxLoc) ? new ClimbUp() : new ClimbDown());
        } else if ("high".equals(monkeyHeight) && monkeyLoc.equals(bananaLoc)) {
            actions.add(new Grab());
        }

        return actions;
    }
}