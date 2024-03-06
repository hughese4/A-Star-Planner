import java.util.*;

public class AStarPlanner {

    private static final double MOVE_COST = 1;
    private double costSoFar;
    
    // using priority queue to prioritize states to explore based on cost
    private PriorityQueue<WorldState> openSet;
    // keeps track of visited states
    private Set<WorldState> closedSet;
    
    // We want the monkey to find and grab the bananas as fast as possible
    // We want to minimize the number of moves the monkey makes

    public AStarPlanner() {
        openSet = new PriorityQueue<WorldState>(new Comparator<WorldState>() {
            public int compare(WorldState s1, WorldState s2) {
                return Double.compare(f(s1), f(s2));
            }
        });
        closedSet = new HashSet<WorldState>();
    }


    // A* planning algorithm to find the shortest path to the goal
    public List<Operator> plan(WorldState initialState, WorldState goalState) {
        openSet.add(initialState);

        while (!openSet.isEmpty()) {
            WorldState currentState = openSet.poll();

            // Check if we have reached goal state
            if (currentState.isGoalState()) {
                return constructSolution(currentState);
            }

            closedSet.add(currentState);

            // Iterate through all possible actions and apply them to the current state
            for (Operator action : getPossibleActions()) {
                if (action.applicable(currentState)) {
                    WorldState nextState = action.apply(currentState);

                    // If next state as already been evaluated, skip
                    if (closedSet.contains(nextState)) {
                        continue;
                    }

                    // Add nextState to open set if not present with a lower cost
                    if (!openSet.contains(nextState) || g(nextState) < g(currentState)) {
                        nextState.setParent(currentState); // Set current state as parent
                        nextState.setAction(action); // Set action taken to reach next state
                        nextState.setCostSoFar(g(nextState)); // Set new cost so far
                        openSet.add(nextState);
                    }
                }
            }
        }

        // If no solution is found
        return null;
    }

    // g(state) could just be the cost so far (assume all costs are 1 for simplicity)
    // h(state) is the heuristic function (needs to be implemented)
    public double f(WorldState state) {
        
        return g(state) + h(state);
    }

    // cost so far
    public double g(WorldState state) {
        // for now all costs can be 1 for simplicity


        return 0;
    }

    // heuristic function
    public double h(WorldState state) {
        
        return 0;
    }

    // Method to backtrack from the goal state to the initial state and construct the solution
    private List<Operator> constructSolution(WorldState state) {
        LinkedList<Operator> solution = new LinkedList<Operator>();
        while (state.getParent() != null) {
            solution.addFirst(state.getAction());
            state = state.getParent();
        }
        return solution;
    }

    // Method to retrieve all possible actions
    private List<Operator> getPossibleActions() {
        // Populate this with instances of all possible actions
        return Arrays.asList(new Move(), new Push(), new ClimbUp(), new ClimbDown(), new Grab());
    }


}
