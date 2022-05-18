package algorithms.search;

import java.util.PriorityQueue;

public abstract class ASearchingAlgorithm implements ISearchingAlgorithm
{
    protected PriorityQueue<AState> openList;
    protected int visitedNodes;
    protected String name;

    public ASearchingAlgorithm()
    {
        openList = new PriorityQueue<>();
        visitedNodes = 0;
    }

    protected AState popOpenList()
    {
        visitedNodes++;
        return openList.poll();
    }

    public Solution solve(ISearchable s)
    {
        Solution sol = new Solution();
        AState state = this.search(s) ;
        /// TODO
        return sol;
    }
}
