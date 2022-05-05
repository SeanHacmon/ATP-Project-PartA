package algorithms.search;

public abstract class AState
{
    private String state;
    private double cost;
    private AState cameFrom;

    public AState(String s)
    {this.state = s;}

    public int hashCode() {return super.hashCode();}
    public boolean equals(Object obj) {return super.equals(obj);}
}
