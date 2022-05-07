package algorithms.search;

import java.util.ArrayList;
import java.util.Queue;
import java.util.Stack;

public class DepthFirstSearch extends ASearchingAlgorithm
{
    private Stack<AState> stack;
    private Solution DFS_sol;

    public Solution search(ISearchable s)
    {
        AState start = s.getStartState();
        AState goal = s.getGoalState();
        stack.push(start);
        start.setVisited(true);
        while (!stack.isEmpty())
        {
            AState myState = stack.pop();
            if (!DFS_sol.states.contains(myState))
                DFS_sol.states.add(myState);
            ArrayList<AState> neighbors = s.getAllSuccessors(myState);
            for (int i = 0; i < neighbors.size(); i++)
            {
                AState n = neighbors.get(i);
                if (!n.isVisited())
                {
                    n.setVisited(true);
                    stack.push(n);
                }
                neighbors.remove(n);
            }
            DFS_sol.states.add(myState);
        }
        return null;
    }

    public int getNumberOfVisitedNodes() {return DFS_sol.states.size();}


}
