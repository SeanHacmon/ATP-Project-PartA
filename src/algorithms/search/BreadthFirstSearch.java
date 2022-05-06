package algorithms.search;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class BreadthFirstSearch extends ASearchingAlgorithm
{
    private Queue<AState> queue;
    protected Solution bfsSol;

    BreadthFirstSearch()
    {
        this.bfsSol = new Solution();
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
            bfsSol.states.add(visitedState);
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
        return bfsSol;
    }

    public int getNumberOfVisitedNodes() {return 0;}

    public Queue<AState> getQueue() {return queue;}
    public void setQueue(Queue<AState> queue) {this.queue = queue;}
}
