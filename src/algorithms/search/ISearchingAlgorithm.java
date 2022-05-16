package algorithms.search;

public interface ISearchingAlgorithm
{
    public Solution solve(ISearchable s);
    public AState search(ISearchable s);
    public int getNumberOfVisitedNodes();

}
