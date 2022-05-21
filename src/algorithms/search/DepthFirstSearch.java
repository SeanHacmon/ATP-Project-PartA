package algorithms.search;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Queue;
import java.util.Stack;

public class DepthFirstSearch extends ASearchingAlgorithm
{
    private Stack<AState> stack;
    private HashMap<String, Boolean> marked;

    public DepthFirstSearch()
    {
        this.name = "DepthFirstSearch";
        this.stack = new Stack<>();
        this.marked = new HashMap<>();
    }

    public AState search(ISearchable s)
    {
        AState start = s.getStartState();
        AState goal = s.getGoalState();
        stack.push(start);
        start.setVisited(true);
        start.updateVisited();
        marked.put(start.getState(), true);
        this.visitedNodes++;
        while (!stack.isEmpty() && !goal.isVisited())
        {
            AState node = stack.pop();
            ArrayList<AState> neighbors = s.getAllPossibleStates(node);
            for (int i = 0; i < neighbors.size(); i++)
            {
                AState curr = neighbors.get(i);
                if (!marked.containsKey(curr.getState()))
                {
                    marked.put(curr.getState(), true);
                    curr.setCameFrom(node);
                    curr.setVisited(true);
                    visitedNodes++;
                    stack.push(curr);
                    curr.updateVisited();
                }

                if (curr.getState().compareTo(goal.getState())==0)
                    return curr;

                neighbors.remove(curr);
            }
        }
        return null;
    }

    public int getNumberOfNodesEvaluated() {return this.visitedNodes;}

    public String getName() {return this.name;}
    public void setName(String name) {this.name = name;}

    public Stack<AState> getStack() {return stack;}
    public void setStack(Stack<AState> stack) {
        this.stack = stack;
    }

    public HashMap<String, Boolean> getMarked() {return marked;}
    public void setMarked(HashMap<String, Boolean> marked) {this.marked = marked;}

    public void updateCost(AState s, ArrayList<AState> array)
    {
        for (int i = 0; i < array.size(); i++)
        {
            AState node = array.get(i);
            node.setCost(1);
        }
    }
}
