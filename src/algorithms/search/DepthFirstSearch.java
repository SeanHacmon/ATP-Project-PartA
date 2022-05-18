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
            AState curr = stack.pop();
            ArrayList<AState> neighbors = s.getAllSuccessors(curr);
            for (int i = 0; i < neighbors.size(); i++)
            {
                AState n = neighbors.get(i);
                if (!n.isVisited())
                {
                    n.setVisited(true);
                    visitedNodes++;
                    stack.push(n);
                }

                if (curr.equals(goal))
                    return curr;

                neighbors.remove(n);
            }
        }
        return null;
    }

    public int getNumberOfVisitedNodes() {return this.visitedNodes;}

    public String getName() {return this.name;}


}
