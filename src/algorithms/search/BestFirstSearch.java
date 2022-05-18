package algorithms.search;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;

public class BestFirstSearch extends BreadthFirstSearch
{
    private PriorityQueue<AState> pq;
    protected String name;

    public BestFirstSearch()
    {
        this.pq = new PriorityQueue<>();
        this.name = "BestFirstSearch";
    }
    {
        this.pq = new PriorityQueue<AState>(new Comparator<AState>() {
            public int compare(AState s1, AState s2) {
                if (s1.getCost() > s2.getCost()) return 1;
                return 0;
            }
        });
    }
    public AState search(ISearchable s)
    {
        AState start = s.getStartState();
        AState goal = s.getGoalState();
        pq.add(start);
        start.setVisited(true);
        while (!pq.isEmpty())
        {
            AState curr = pq.remove();
            ArrayList<AState> neighbors = s.getAllSuccessors(curr);
            for (int i = 0; i < neighbors.size(); i++)
            {
                AState u = neighbors.get(i);
                if (!u.isVisited())
                {
                    u.setVisited(true);
                    visitedNodes++;
                    pq.add(u);
                }
                if (curr.equals(goal))
                    return curr;

                neighbors.remove(u);
            }
        }
        return null;
    }

    public int getNumberOfVisitedNodes() {return visitedNodes;}

    public String getName() {return this.name;}

//    public static class functor implements Comparator<AState>
//    {
//        public int compare(AState s1, AState s2)
//        {
//            if (s1.getCost() > s2.getCost())
//                return 1;
//            return 0;
//        }
//    }
}
