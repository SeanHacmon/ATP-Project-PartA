package algorithms.search;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class BreadthFirstSearch extends ASearchingAlgorithm
{
    private Queue<AState> queue;
    protected Solution BFS_Sol;

    BreadthFirstSearch()
    {
        this.BFS_Sol = new Solution();
        this.queue = new LinkedList<>();
    }
    /// Generic BFS return a Solution.
    public Solution search(ISearchable s)
    {
        AState state = s.getStartState();
        ArrayList<AState> gotNeighbors = s.getAllSuccessors(state);
        queue.add(state);
        while (!queue.isEmpty())
        {
            AState visitedState = queue.remove();
            if (!BFS_Sol.states.contains(visitedState))
                BFS_Sol.states.add(visitedState);
            for (int i = 0; i < gotNeighbors.size(); i++)
            {
                AState myState = gotNeighbors.get(i);
                if (!myState.isVisited() && myState.getState() != null)
                {
                    queue.add(myState);
                    myState.setVisited(true);
                }
            }
        }
        return BFS_Sol;
    }

    public int getNumberOfVisitedNodes() {return BFS_Sol.states.size();}

    public Queue<AState> getQueue() {return queue;}
    public void setQueue(Queue<AState> queue) {this.queue = queue;}
}
