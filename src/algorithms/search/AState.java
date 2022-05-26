package algorithms.search;

public abstract class AState
{
    private String state;
    private double cost;
    private AState cameFrom;
    protected boolean visited;
    protected boolean cross;
    protected int distance;

    public int hashCode() {return super.hashCode();}
    public boolean equals(Object obj) {return super.equals(obj);}

    public String getState() {return state;}
    public void setState(String state) {this.state = state;}

    public double getCost() {return cost;}
    public void setCost(double cost) {this.cost = cost;}
    public AState getCameFrom() {return cameFrom;}
    public void setCameFrom(AState cameFrom) {this.cameFrom = cameFrom;}
    public abstract boolean isVisited();
    public abstract void setVisited(boolean visited);
    public abstract void updateVisited();

//    public boolean isCross() {return cross;}
//    public void setCross(boolean cross) {this.cross = cross;}
}
