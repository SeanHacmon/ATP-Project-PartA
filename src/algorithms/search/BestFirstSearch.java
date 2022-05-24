package algorithms.search;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.PriorityQueue;

public class BestFirstSearch extends BreadthFirstSearch {
    private PriorityQueue<AState> pq;
    private HashMap<String, Boolean> marked;

    public BestFirstSearch() {
        this.pq = new PriorityQueue<>(new theComparator());
        this.name = "BestFirstSearch";
        this.marked = new HashMap<>();
    }

//    {
//        this.pq = new PriorityQueue<AState>(new Comparator<AState>() {
//            public int compare(AState s1, AState s2) {
//                if (s1.getCost() > s2.getCost()) return 1;
//                return 0;
//            }
//        });
//    }

    public AState search(ISearchable s) {
        AState start = s.getStartState();
        AState goal = s.getGoalState();
        pq.add(start);
        start.setVisited(true);
        start.updateVisited();
        marked.put(start.getState(), true);
        this.visitedNodes++;
        while (!pq.isEmpty()) {
            AState u = pq.remove();
            ArrayList<AState> neighbors = s.getAllPossibleStates(u);
            int i = 0;
            while (!neighbors.isEmpty())
            {
                AState curr = neighbors.get(i);
                if (!marked.containsKey(curr.getState())) {
                    marked.put(curr.getState(), true);
                    curr.setCameFrom(u);
                    pq.add(curr);
                    curr.setVisited(true);
                    visitedNodes++;
                    curr.updateVisited();
                }
                if (curr.getState().compareTo(goal.getState()) == 0)
                    return curr;

                neighbors.remove(curr);
            }
        }
        return null;
    }

    public void updateCost(AState s, ArrayList<AState> array) {
        for (int i = 0; i < array.size(); i++) {
            AState node = array.get(i);
            node.setCost(1);
        }
    }

    public int getNumberOfNodesEvaluated() {return visitedNodes;}

    public String getName() {return this.name;}
}

class theComparator implements Comparator<AState>
{
    public int compare(AState s1, AState s2)
    {
        if (s1.getCost() > s2.getCost()) return 1;
        return 0;
    }
}