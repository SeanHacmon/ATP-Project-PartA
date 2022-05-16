package algorithms.search;

import java.util.PriorityQueue;

public abstract class ASearchingAlgorithm implements ISearchingAlgorithm
{
    protected PriorityQueue<AState> openList;
    private int visitedNodes;

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
        return null;
    }
}
