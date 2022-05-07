package algorithms.search;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;

public class BestFirstSearch extends BreadthFirstSearch
{
    private PriorityQueue<AState> pq;
    private Solution BestSol;
    {
        this.pq = new PriorityQueue<AState>(new Comparator<AState>() {
            public int compare(AState s1, AState s2) {
                if (s1.getCost() > s2.getCost()) return 1;
                return 0;
            }
        });
    }
    public Solution search(ISearchable s)
    {
        AState start = s.getStartState();
        pq.add(start);
        start.setVisited(true);
        while (!pq.isEmpty())
        {
            AState state = pq.remove();
            if (!BestSol.states.contains(state))
                BestSol.states.add(state);
            ArrayList<AState> neighbors = s.getAllSuccessors(state);
            for (int i = 0; i < neighbors.size(); i++)
            {
                AState u = neighbors.get(i);
                if (!u.isVisited())
                {
                    u.setVisited(true);
                    BestSol.states.add(u);
                }
                neighbors.remove(u);
            }
        }
        return BestSol;
    }

    public int getNumberOfVisitedNodes() {return 0;}


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
