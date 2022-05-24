package algorithms.search;

import java.util.*;

public class BreadthFirstSearch extends ASearchingAlgorithm
{
    private HashMap<String, Boolean> marked;
    private Queue<AState> queue;

    public BreadthFirstSearch()
    {
        this.queue = new LinkedList<>();
        this.marked = new HashMap<>();
        this.name = "BreadthFirstSearch";
    }
    /// Generic BFS return a Solution.
    public AState search(ISearchable s)
    {
        AState start = s.getStartState();
        AState goal = s.getGoalState();
        queue.add(start);
        start.setVisited(true);
        start.updateVisited();
        marked.put(start.getState(), true);
        this.visitedNodes++;
        while (!queue.isEmpty() && !goal.isVisited())
        {
            AState visitedState = queue.remove();
            ArrayList<AState> neighbors = s.getAllPossibleStates(visitedState);
            updateCost(visitedState, neighbors);
            int i = 0;
            while (!neighbors.isEmpty())
            {
                AState curr = neighbors.get(i);
                if (!marked.containsKey(curr.getState()))
                {
                    marked.put(curr.getState(), true);
                    curr.setCameFrom(visitedState);
                    queue.add(curr);
                    curr.setVisited(true);
                    this.visitedNodes++;
                    curr.updateVisited();
                }
                if (curr.getState().compareTo(goal.getState())==0)
                    return curr;

                neighbors.remove(curr);
            }
        }
        /// TODO to take care of the case we received a null state, should use the hashmap.
        return null;
    }

    public int getNumberOfNodesEvaluated() {return this.visitedNodes;}
    public String getName() {return this.name;}

    public Queue<AState> getQueue() {return queue;}
    public void setQueue(Queue<AState> queue) {this.queue = queue;}

    public HashMap<String, Boolean> getMarked() {return marked;}
    public void setMarked(HashMap<String, Boolean> marked) {this.marked = marked;}

    public void updateCost(AState s, ArrayList<AState> array)
    {
        for (int i = 0; i < array.size(); i++)
        {
            AState node = array.get(i);
            node.setCost(1);
        }
    }

}
//            for (int i = 0; i < neighbors.size(); i++)
//            {
//                AState n = neighbors.get(i);
//                if(n.isVisited())
//                {
//                    neighbors.remove(n);
//                }
//            }