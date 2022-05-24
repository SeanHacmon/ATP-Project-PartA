package algorithms.search;

import algorithms.mazeGenerators.Position;

public class MazeState extends AState
{
    protected Position p;
    public MazeState(Position position)
    {
        super();
        this.p=position;
        p.setVisited(this.isVisited());
        this.setState("{" + position.getRowIndex() + ","+ p.getColumnIndex() + "}");
        cross = false;
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


    public boolean isVisited()
    {
        return this.visited;
    }
    public void setVisited(boolean visited){this.visited = visited;}
}
