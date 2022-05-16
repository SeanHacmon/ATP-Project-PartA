package algorithms.search;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class BreadthFirstSearch extends ASearchingAlgorithm
{
    private Queue<AState> queue;
    private Solution BFS_Sol;

    BreadthFirstSearch()
    {
        this.BFS_Sol = new Solution();
        this.queue = new LinkedList<>();
    }
    /// Generic BFS return a Solution.
    public AState search(ISearchable s)
    {
        AState start = s.getStartState();
        AState goal = s.getGoalState();
        queue.add(start);
        start.setVisited(true);
        while (!queue.isEmpty() && !goal.isVisited())
        {
            AState visitedState = queue.remove();
//            if (!BFS_Sol.states.contains(visitedState))
//                BFS_Sol.states.add(visitedState);
            ArrayList<AState> neighbors = s.getAllSuccessors(visitedState);
            updateCost(visitedState, neighbors);
            for (int i = 0; i < neighbors.size(); i++)
            {
                AState curr = neighbors.get(i);
                curr.setCameFrom(visitedState);
                if (!curr.isVisited() && curr.getState() != null)
                {
                    queue.add(curr);
                    curr.setVisited(true);
                }

                if (curr.equals(goal))
                    return curr;

                neighbors.remove(curr);
            }
        }

        return null;
    }

    public int getNumberOfVisitedNodes() {return BFS_Sol.states.size();}
    public Queue<AState> getQueue() {return queue;}
    public void setQueue(Queue<AState> queue) {this.queue = queue;}

    public void updateCost(AState s,ArrayList<AState> array)
    {
        for (int i = 0; i < array.size(); i++)
        {
            AState node = array.get(i);
            node.setCost(1);
        }
    }

}
