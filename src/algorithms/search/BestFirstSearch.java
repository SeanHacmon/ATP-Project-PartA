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
            updateCameFrom(neighbors, u);
            updateCost(neighbors);
            updateDistance(neighbors);
            int i = 0;
            while (!neighbors.isEmpty())
            {
                AState curr = neighbors.get(i);
                if (!marked.containsKey(curr.getState())) {
                    marked.put(curr.getState(), true);
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

    public PriorityQueue<AState> getPq() {return pq;}
    public void setPq(PriorityQueue<AState> pq) {this.pq = pq;}
    public HashMap<String, Boolean> getMarked() {return marked;}
    public void setMarked(HashMap<String, Boolean> marked) {this.marked = marked;}

    public void updateCameFrom(ArrayList<AState> array, AState s)
    {
        int i = 0;
        while (i < array.size())
        {
            AState node = array.get(i);
            node.setCameFrom(s);
            i++;
        }
    }

    public void updateCost(ArrayList<AState> array)
    {
        int i = 0;
        while (i < array.size())
        {
            AState node = array.get(i);
            if (node.getCameFrom() != null)
            {
                if (node.cross)
                    node.setCost(1.5 + node.getCameFrom().getCost());
                else
                    node.setCost(1 + node.getCameFrom().getCost());
            }
            else
            {
                if (node.cross)
                    node.setCost(1.5);
                else
                    node.setCost(1);
            }
            i++;
        }
    }

    public void updateDistance(ArrayList<AState> array)
    {
        int i = 0;
        while (i < array.size())
        {
            AState curr = array.get(i);
            if (curr.getCameFrom() == null)
                curr.distance = 0;
            else
                curr.distance = curr.getCameFrom().distance + 1;
            i++;
        }
    }

    public int getNumberOfNodesEvaluated() {return visitedNodes;}

    public String getName() {return this.name;}

    static class theComparator implements Comparator<AState>
    {
        public int compare(AState s1, AState s2)
        {
            if (s1.distance > s2.distance)
                return 1;
            if (s1.distance == s2.distance)
            {
                if (s1.getCost() > s2.getCost())
                    return 1;
                if (s1.getCost() == s2.getCost())
                    return 0;
            }
            return -1;
        }
    }

}
