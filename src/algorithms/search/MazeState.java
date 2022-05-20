package algorithms.search;

import algorithms.mazeGenerators.Position;

public class MazeState extends AState
{
    protected Position p;
//    boolean visited;
    public MazeState(Position position)
    {
        super();
        this.p=position;
        p.setVisited(this.isVisited());
        this.setState("{" + position.getRowIndex() + ","+ p.getColumnIndex() + "}");
    }
    public void updateVisited()
    {
        if (this.isVisited())
        {
            p.setVisited(true);
        }
    }

    public String toString() {
        return "MazeState{" +
                getState() +
                '}';
    }
    //    public MazeState(String s) {super(s);}
}
