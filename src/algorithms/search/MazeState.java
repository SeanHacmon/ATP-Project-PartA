package algorithms.search;

import algorithms.mazeGenerators.Position;

public class MazeState extends AState
{
    protected Position p;
    boolean visited;
    public MazeState(Position position)
    {
        super();
        visited = false;
        this.p=position;
        this.setState("{" + position.getRowIndex() + ","+ p.getColumnIndex() + "}");
    }
//    public MazeState(String s) {super(s);}
}
