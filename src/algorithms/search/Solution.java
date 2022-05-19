package algorithms.search;

import java.util.ArrayList;

public class Solution
{
    protected ArrayList<AState> states;

    public Solution()
    {
        this.states = new ArrayList<>();
    }

    public ArrayList<AState> getSolutionPath() {return this.states;}
}
