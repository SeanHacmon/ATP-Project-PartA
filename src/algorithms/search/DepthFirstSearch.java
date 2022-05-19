package algorithms.search;

import java.util.ArrayList;
import java.util.Queue;
import java.util.Stack;

public class DepthFirstSearch extends ASearchingAlgorithm
{
    private Stack<AState> stack;
    protected String name;

    public DepthFirstSearch()
    {
        this.name = "DepthFirstSearch";
        this.stack = new Stack<>();
    }

    public AState search(ISearchable s)
    {
        AState start = s.getStartState();
        AState goal = s.getGoalState();
        stack.push(start);
        start.setVisited(true);
        while (!stack.isEmpty())
        {
            AState node = stack.pop();
            ArrayList<AState> neighbors = s.getAllPossibleStates(node);
            for (int i = 0; i < neighbors.size(); i++)
            {
                AState curr = neighbors.get(i);
                curr.setCameFrom(node);
                if (!curr.isVisited())
                {
                    curr.setVisited(true);
                    visitedNodes++;
                    stack.push(curr);
                }

                if (curr.equals(goal))
                    return curr;

                neighbors.remove(curr);
            }
        }
        return null;
    }

    public int getNumberOfNodesEvaluated() {return this.visitedNodes;}
    public String getName() {return this.name;}

    public Stack<AState> getStack() {return stack;}
    public void setStack(Stack<AState> stack) {
        this.stack = stack;
    }
}
