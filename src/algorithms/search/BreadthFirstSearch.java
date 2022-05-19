package algorithms.search;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class BreadthFirstSearch extends ASearchingAlgorithm
{
    private Queue<AState> queue;

    public BreadthFirstSearch()
    {
        this.queue = new LinkedList<>();
        this.name = "BreadthFirstSearch";
    }
    /// Generic BFS return a Solution.
    public AState search(ISearchable s)
    {
        AState start = s.getStartState();
        AState goal = s.getGoalState();
        queue.add(start);
        start.setVisited(true);
        this.visitedNodes++;
        while (!queue.isEmpty() && !goal.isVisited())
        {
            AState visitedState = queue.remove();
            ArrayList<AState> neighbors = s.getAllPossibleStates(visitedState);
            updateCost(visitedState, neighbors);
            for (int i = 0; i < neighbors.size(); i++)
            {
                AState curr = neighbors.get(i);
                curr.setCameFrom(visitedState);
                if (!curr.isVisited())
                {
                    queue.add(curr);
                    curr.setVisited(true);
                    this.visitedNodes++;
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
